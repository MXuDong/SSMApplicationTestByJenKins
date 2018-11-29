package service.Impl;

import dao.LogBaseInfoMapper;
import dao.LogChangeProductCountMapper;
import dao.LogChangeProductPriceMapper;
import dao.ProductInfoMapper;
import model.LogBaseInfo;
import model.LogChangeProductCount;
import model.LogChangeProductPrice;
import model.ProductInfo;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Interface.ProductMangerService;
import util.LogFactory;
import util.StringFormatUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for(List<String> L : lessProductInfos){
            lessProducts.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_LESS, L));
        }

        return lessProducts;
    }


    /**
     *
     * @param count (-1：所有， >0 个数)
     * @return
     */
    @Override
    public List<List<String>> getLessProducts(int count) {
        List<List<String>> products = new ArrayList<List<String>>();
        List<String> productInfo = new ArrayList<String>();
        //id
        productInfo.add("1");
        //序号
        productInfo.add("1");
        productInfo.add("鲸鱼");
        productInfo.add("9元（人民币）");
        productInfo.add("1000");
        productInfo.add("告急");
        productInfo.add("座头鲸，可以做房子");

        products.add(productInfo);
        return products;
    }

    @Override
    public List<String> getMoreProducts() {
        List<String> moreProducts = new ArrayList<String>();

        List<List<String>> moreProductInfos = getMoreProducts(5);
        for(List<String> L : moreProductInfos){
            moreProducts.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_MORE, L));
        }

        return moreProducts;
    }

    @Override
    public List<List<String>> getMoreProducts(int count) {
        List<List<String>> products = new ArrayList<List<String>>();
        List<String> productInfo = new ArrayList<String>();
        //id
        productInfo.add("1");
        //序号
        productInfo.add("1");
        productInfo.add("鲸鱼");
        productInfo.add("9元（人民币）");
        productInfo.add("1000");
        productInfo.add("告急");
        productInfo.add("座头鲸，可以做房子");

        products.add(productInfo);
        return products;
    }

    @Override
    public Map<String, String> getProductBingPic() {
        return null;
    }

    @Override
    public List<List<String>> getProductInfos() {
        List<List<String>> productInfos = new ArrayList<List<String>>();

        List<String> productInfo = new ArrayList<String>();
        //ID
        productInfo.add("1");
        //序号
        productInfo.add("1");
        productInfo.add("鲸鱼");
        productInfo.add("9元（人民币）");
        productInfo.add("1000");
        productInfo.add("正常");
        productInfo.add("座头鲸，可以 做房子");

        productInfos.add(productInfo);

        return productInfos;
    }

    @Override
    public Map<String, String> getProductMoreInfo(int productId) {

        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        Map<String, String> productMoreInfo = new HashMap<String, String>();
        if(productInfo != null){
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
    public Map<String, String> getProductPicInfo() {

        Map<String, String> productPicInfo = new HashMap<String, String>();

        //横坐标
        String xAxisData = "'2018-9-1', '2018-9-2', '2018-9-3', '2018-9-4'";
        productPicInfo.put("xAxisData", xAxisData);
        //数据
        String seriesData = "1250,4356,724,8985";
        productPicInfo.put("seriesData", seriesData);
        //横坐标开始数据
        String startValue = "'2018-9-2'";
        productPicInfo.put("startValue", startValue);
        //最小值
        String minValue = "1000";
        productPicInfo.put("minValue", minValue);
        //最大值
        String maxValue = "5000";
        productPicInfo.put("maxValue", maxValue);
        String productXAxisData = "'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun', 'A', 'B'";
        String productSeriesData = "820, 932, 901, 934, 1290, 1330, 1320, 540, 7852";
        productPicInfo.put("productXAxisData", productXAxisData);
        productPicInfo.put("productSeriesData", productSeriesData);


        return productPicInfo;
    }

    @Override
    public int addProductInfo(ProductInfo productInfo, int userId) {
        int res = productInfoMapper.insert(productInfo);
        if(res == 1) {
            logBaseInfoMapper.insert(LogFactory.makeLogBaseInfo(LogFactory.BaseInformaiton, userId, "添加产品：" + productInfo.getProductName()));
            LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductCount, userId, productInfo.getProductName() + "产品初次添加入库");
            logBaseInfoMapper.insert(logBaseInfo);
            logChangeProductCountMapper.insert(LogFactory.makeLogChangeProductCount(logBaseInfo.getLogId(),productInfo.getProductId(), 0, productInfo.getProductPrice(), productInfo.getProductCount()));
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

        if(oldCount == oldProduct.getProductCount()) return 0;
        productInfoMapper.updateByPrimaryKey(oldProduct);

        LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductCount, userId, "产品：" + oldProduct.getProductName() + (oldCount > oldProduct.getProductCount() ? "出库" : "入库"));
        logBaseInfoMapper.insert(logBaseInfo);
        logChangeProductCountMapper.insert(LogFactory.makeLogChangeProductCount(logBaseInfo.getLogId(),oldProduct.getProductId(),oldCount, oldProduct.getProductPrice(), changeCount));

        return 0;
    }

    @Override
    public int updateProductInfoP(String productId, double changePrice, int userId) {

        int p_id = Integer.parseInt(productId);
        ProductInfo product = productInfoMapper.selectByPrimaryKey(p_id);
        double oldPrice = product.getProductPrice();
        product.setProductPrice(changePrice);

        if(oldPrice == product.getProductPrice()) return 0;
        productInfoMapper.updateByPrimaryKey(product);

        LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.ChangeProductPrice, userId, "产品：" + product.getProductName() + (oldPrice > product.getProductPrice() ? "价格提高":"价格减少"));
        logBaseInfoMapper.insert(logBaseInfo);
        logChangeProductPriceMapper.insert(LogFactory.makeLogChangeProductPrice(logBaseInfo.getLogId(), product.getProductId(), product.getProductCount(), oldPrice, product.getProductPrice()));

        return 0;
    }
}
