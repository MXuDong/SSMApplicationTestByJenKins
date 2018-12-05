package service.Impl;

import dao.LogBaseInfoMapper;
import dao.LogChangeProductCountMapper;
import dao.LogChangeProductPriceMapper;
import dao.ProductInfoMapper;
import model.LogBaseInfo;
import model.LogChangeProductCount;
import model.LogChangeProductPrice;
import model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Interface.ProductMangerService;
import sun.rmi.runtime.Log;
import util.LogFactory;
import util.StringFormatUtil;

import java.util.*;

@Service("ProductManagerImpl")
public class ProductManagerImpl implements ProductMangerService {

    @Autowired
    ProductInfoMapper productInfoMapper;
    @Autowired
    LogBaseInfoMapper logBaseInfoMapper;
    @Autowired
    LogChangeProductCountMapper logChangeProductCountMapper;
    @Autowired
    LogChangeProductPriceMapper logChangeProductPriceMapper;

    @Override
    public List<String> getLessProducts() {
        List<String> lessProducts = new ArrayList<String>();

        List<List<String>> lessProductInfos = getLessProducts(5);
        for (List<String> L : lessProductInfos) {
            lessProducts.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_LESS, L));
        }

        return lessProducts;
    }


    /**
     * @param count (-1：所有， >0 个数)
     * @return
     */
    @Override
    public List<List<String>> getLessProducts(int count) {
        List<ProductInfo> productInfos = productInfoMapper.selectLessProduct();

        List<List<String>> products = new ArrayList<List<String>>();

        int id = 0;

        if (count == -1) {
            count = productInfos.size() + 1;
        }
        for (ProductInfo info : productInfos) {
            List<String> productInfo = new ArrayList<String>();
            productInfo.add(Integer.toString(info.getProductId()));
            productInfo.add(Integer.toString(id));
            productInfo.add(info.getProductName());
            productInfo.add(info.getProductPrice() + "元（人民币)");
            productInfo.add(Integer.toString(info.getProductCount()));
            productInfo.add("告急");
            String desc = info.getProductDesc() + " ";
            if (desc.length() > 10) {
                desc = desc.substring(0, 10) + "...";
            }

            productInfo.add(desc);
            products.add(productInfo);
            if (id > count) break;
        }
        return products;
    }

    @Override
    public List<String> getMoreProducts() {
        List<String> moreProducts = new ArrayList<String>();

        List<List<String>> moreProductInfos = getMoreProducts(5);
        for (List<String> L : moreProductInfos) {
            moreProducts.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_MORE, L));
        }

        return moreProducts;
    }

    @Override
    public List<List<String>> getMoreProducts(int count) {
        List<ProductInfo> productInfos = productInfoMapper.selectMoreProduct();

        List<List<String>> products = new ArrayList<List<String>>();

        int id = 0;

        if (count == -1) {
            count = productInfos.size() + 1;
        }
        for (ProductInfo info : productInfos) {
            List<String> productInfo = new ArrayList<String>();
            productInfo.add(Integer.toString(info.getProductId()));
            productInfo.add(Integer.toString(id));
            productInfo.add(info.getProductName());
            productInfo.add(info.getProductPrice() + "元（人民币)");
            productInfo.add(Integer.toString(info.getProductCount()));
            productInfo.add("冗余");
            String desc = info.getProductDesc() + " ";
            if (desc.length() > 10) {
                desc = desc.substring(0, 10) + "...";
            }

            productInfo.add(desc);
            products.add(productInfo);
            if (id > count) break;
        }
        return products;
    }

    @Override
    public Map<String, String> getProductBingPic() {
        return null;
    }

    @Override
    public List<List<String>> getProductInfos() {
        List<ProductInfo> productInfos = productInfoMapper.selectAll();

        List<List<String>> products = new ArrayList<List<String>>();

        int id = 0;

        for (ProductInfo info : productInfos) {
            List<String> productInfo = new ArrayList<String>();
            productInfo.add(Integer.toString(info.getProductId()));
            productInfo.add(Integer.toString(id));
            productInfo.add(info.getProductName());
            productInfo.add(info.getProductPrice() + "元（人民币)");
            productInfo.add(Integer.toString(info.getProductCount()));
            productInfo.add(info.isCountIllge());
            String desc = info.getProductDesc() + " ";
            if (desc.length() > 10) {
                desc = "....";
            }
            productInfo.add(desc);
            products.add(productInfo);
        }
        return products;
    }

    @Override
    public Map<String, String> getProductMoreInfo(int productId) {

        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        Map<String, String> productMoreInfo = new HashMap<String, String>();
        if (productInfo != null) {
            productMoreInfo.put("productId", productInfo.getProductId().toString());
            productMoreInfo.put("productName", productInfo.getProductName());
            productMoreInfo.put("productPrice", productInfo.getProductPrice() + "元（人民币）");
            productMoreInfo.put("productCount", productInfo.getProductCount().toString());
            productMoreInfo.put("productPic", productInfo.getPicPaths());
            productMoreInfo.put("productDisc", productInfo.getProductDesc());
            productMoreInfo.put("productMaxCount", productInfo.getProductMaxCount().toString());
            productMoreInfo.put("productMinCount", productInfo.getProductMinCount().toString());
            productMoreInfo.put("productStatus", productInfo.isCountIllge());
        }

        return productMoreInfo;
    }

    @Override
    public Map<String, String> getProductPicInfo(int productId) {

        //获取产品
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        //获取所有产品的数量变化
        List<LogBaseInfo> logBaseInfos = logBaseInfoMapper.selectAllProductCountLogById(productId);
        //创造结果集和
        Map<String, String> productPicInfo = new HashMap<String, String>();
        //日历类
        Calendar calendarBase = Calendar.getInstance();
        Date date = new Date();


        String xAxisData = "";
        String seriesData = "";
        String startValue = "";
        Calendar lastCalendar = Calendar.getInstance();
        Calendar nowCalendar = Calendar.getInstance();
        int count = 0;
        int lastCount = productInfo.getProductCount();
        for (LogBaseInfo L : logBaseInfos) {
            LogChangeProductCount logChangeProductCount = logChangeProductCountMapper.selectByBaseLogId(L.getLogId());

            String DATE = StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA_ONLY_DAY, L.getLogTime());
            int nowCount = logChangeProductCount.getProductNewCount();

            nowCalendar.setTime(L.getLogTime());
            if (count++ == 0) {
                xAxisData = "'" + DATE + "'";
                startValue = xAxisData;
                seriesData = "" + nowCount;
            } else {
                while (lastCalendar.get(Calendar.DAY_OF_YEAR) < nowCalendar.get(Calendar.DAY_OF_YEAR)) {
                    xAxisData = xAxisData + ",'" + StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA_ONLY_DAY, lastCalendar.getTime()) + "'";
                    seriesData = seriesData + "," + lastCount;
                    lastCalendar.add(Calendar.DAY_OF_YEAR, 1);
                }

                if(lastCalendar.get(Calendar.DAY_OF_YEAR) - 1 == nowCalendar.get(Calendar.DAY_OF_YEAR)){
                    int tempLastDoc = xAxisData.lastIndexOf(',');
                    if(tempLastDoc == -1){
                        xAxisData = "'" + DATE + "'";
                    }else{
                        xAxisData = xAxisData.substring(0, tempLastDoc);
                        xAxisData = xAxisData + ",'" + DATE + "'";
                    }

                    tempLastDoc = seriesData.lastIndexOf(',');
                    if(tempLastDoc == -1){
                        seriesData = "" + nowCount;
                    }else{
                        seriesData = seriesData.substring(0, tempLastDoc);
                        seriesData = seriesData + "," + nowCount;
                    }
                }else{
                    xAxisData = xAxisData + ",'" + DATE + "'";
                    seriesData = seriesData + "," + nowCount;
                }
            }

            lastCalendar.setTime(L.getLogTime());
            lastCalendar.add(Calendar.DAY_OF_YEAR,1);
            lastCount = nowCount;
        }

        nowCalendar.setTime(new Date());

        if(count != 0){
            while (lastCalendar.get(Calendar.DAY_OF_YEAR) < nowCalendar.get(Calendar.DAY_OF_YEAR)) {
                xAxisData = xAxisData + ",'" + StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA_ONLY_DAY, lastCalendar.getTime()) + "'";
                seriesData = seriesData + "," + lastCount;
                lastCalendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }

        String productXAxisData = "";
        String productSeriesData = "";
        count = 0;
        double lastPrice = productInfo.getProductPrice();
        logBaseInfos = logBaseInfoMapper.selectAllProductPriceLogById(productId);

        for (LogBaseInfo L : logBaseInfos) {
            LogChangeProductPrice logChangeProductPrice = logChangeProductPriceMapper.selectByBoasLogId(L.getLogId());

            String DATE = StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA_ONLY_DAY, L.getLogTime());
            double nowPrice = logChangeProductPrice.getProductNewPrice();

            nowCalendar.setTime(L.getLogTime());
            if (count++ == 0) {
                productXAxisData = "'" + DATE + "'";
                productSeriesData = "" + nowPrice;
            } else {
                while (lastCalendar.get(Calendar.DAY_OF_YEAR) < nowCalendar.get(Calendar.DAY_OF_YEAR)) {
                    productXAxisData = productXAxisData + ",'" + StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA_ONLY_DAY, lastCalendar.getTime()) + "'";
                    productSeriesData = productSeriesData + "," + lastPrice;
                    lastCalendar.add(Calendar.DAY_OF_YEAR, 1);
                }

                if(lastCalendar.get(Calendar.DAY_OF_YEAR) - 1 == nowCalendar.get(Calendar.DAY_OF_YEAR)){
                    int tempLastDoc = xAxisData.lastIndexOf(',');
                    if(tempLastDoc == -1){
                        productXAxisData = "'" + DATE + "'";
                    }else{
                        productXAxisData = productXAxisData.substring(0, tempLastDoc);
                        productXAxisData = productXAxisData + ",'" + DATE + "'";
                    }

                    tempLastDoc = seriesData.lastIndexOf(',');
                    if(tempLastDoc == -1){
                        productSeriesData = "" + nowPrice;
                    }else{
                        productSeriesData = productSeriesData.substring(0, tempLastDoc);
                        productSeriesData = productSeriesData + "," + nowPrice;
                    }
                }else{
                    productXAxisData = productXAxisData + ",'" + DATE + "'";
                    productSeriesData = productSeriesData + "," + nowPrice;
                }
            }

            lastCalendar.setTime(L.getLogTime());
            lastCalendar.add(Calendar.DAY_OF_YEAR,1);
            lastPrice = nowPrice;
        }

        nowCalendar.setTime(new Date());

        if(count != 0){
            while (lastCalendar.get(Calendar.DAY_OF_YEAR) < nowCalendar.get(Calendar.DAY_OF_YEAR)) {
                productXAxisData = productXAxisData + ",'" + StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA_ONLY_DAY, lastCalendar.getTime()) + "'";
                productSeriesData = productSeriesData + "," + lastPrice;
                lastCalendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }


        //横坐标
        productPicInfo.put("xAxisData", xAxisData);
        //数据
        productPicInfo.put("seriesData", seriesData);
        //横坐标开始数据
        productPicInfo.put("startValue", startValue);
        //最小值
        productPicInfo.put("minValue", Integer.toString(productInfo.getProductMinCount()));
        //最大值
        productPicInfo.put("maxValue", Integer.toString(productInfo.getProductMaxCount()));

        productPicInfo.put("productXAxisData", productXAxisData);
        productPicInfo.put("productSeriesData", productSeriesData);


        return productPicInfo;
    }

    @Override
    public int addProductInfo(ProductInfo productInfo, int userId) {
        productInfo.setProductPic(0);
        int res = productInfoMapper.insert(productInfo);
        if (res == 1) {
            logBaseInfoMapper.insert(LogFactory.makeLogBaseInfo(LogFactory.BaseInformaiton, userId, "添加产品：" + productInfo.getProductName()));
            LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductPrice, userId, productInfo.getProductName() + "产品初次添加入库");
            logBaseInfoMapper.insert(logBaseInfo);
            logChangeProductPriceMapper.insert(LogFactory.makeLogChangeProductPrice(logBaseInfo.getLogId(), productInfo.getProductId(), 0,0, productInfo.getProductPrice()));
            logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductCount, userId, productInfo.getProductName() + "产品初次添加入库");
            logBaseInfoMapper.insert(logBaseInfo);
            logChangeProductCountMapper.insert(LogFactory.makeLogChangeProductCount(logBaseInfo.getLogId(), productInfo.getProductId(), 0,productInfo.getProductPrice(), productInfo.getProductCount()));

        }

        return productInfo.getProductId();
    }

    @Override
    public int updateProductInfo(String picId) {
        int productId = Integer.parseInt(picId);
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductPic(1);
        productInfo.setProductId(productId);
        int res = productInfoMapper.updateByPrimaryKeySelective(productInfo);
        return res;
    }

    @Override
    public int updateProductInfoC(String productId, int changeCount, int userId) {

        int p_id = Integer.parseInt(productId);
        ProductInfo oldProduct = productInfoMapper.selectByPrimaryKey(p_id);
        int oldCount = oldProduct.getProductCount();
        oldProduct.setProductCount(changeCount);

        if (oldCount == oldProduct.getProductCount()) return 0;
        productInfoMapper.updateByPrimaryKey(oldProduct);

        LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductCount, userId, "产品：" + oldProduct.getProductName() + (oldCount > oldProduct.getProductCount() ? "出库" : "入库"));
        logBaseInfoMapper.insert(logBaseInfo);
        logChangeProductCountMapper.insert(LogFactory.makeLogChangeProductCount(logBaseInfo.getLogId(), oldProduct.getProductId(), oldCount, oldProduct.getProductPrice(), changeCount));

        return 0;
    }

    @Override
    public int updateProductInfoP(String productId, double changePrice, int userId) {

        int p_id = Integer.parseInt(productId);
        ProductInfo product = productInfoMapper.selectByPrimaryKey(p_id);
        double oldPrice = product.getProductPrice();
        product.setProductPrice(changePrice);

        if (oldPrice == product.getProductPrice()) return 0;
        productInfoMapper.updateByPrimaryKey(product);

        LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductPrice, userId, "产品：" + product.getProductName() + (oldPrice > product.getProductPrice() ? "价格提高" : "价格减少"));
        logBaseInfoMapper.insert(logBaseInfo);
        logChangeProductPriceMapper.insert(LogFactory.makeLogChangeProductPrice(logBaseInfo.getLogId(), product.getProductId(), product.getProductCount(), oldPrice, product.getProductPrice()));

        return 0;
    }
}
