package service.Impl;

import org.springframework.stereotype.Service;
import service.Interface.ProductMangerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ProductManagerImpl")
public class ProductManagerImpl implements ProductMangerService {
    @Override
    public List<String> getLessProducts() {
        return null;
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
        return null;
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
    public Map<String, String> getProductMoreInfo() {
        Map<String, String> productMoreInfo = new HashMap<String, String>();

        productMoreInfo.put("productId", "1");
        productMoreInfo.put("productName", "鲸鱼");
        productMoreInfo.put("productPrice", "9.6元（人民币）");
        productMoreInfo.put("productCount", "1000");
        productMoreInfo.put("productPic", "../pic/1.jpg");
        productMoreInfo.put("productDisc", "这里是产品的描述");
        productMoreInfo.put("productMaxCount", "2000");
        productMoreInfo.put("productMinCount", "1");
        productMoreInfo.put("productStatus", "正常");

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
    public int addProductInfo(String... str) {
        return 0;
    }

    @Override
    public int updateProductInfo(String picId) {
        return 0;
    }

    @Override
    public int updateProductInfo(String productId, int changeCount) {
        return 0;
    }

    @Override
    public int updateProductInfo(String productId, double changePrice) {
        return 0;
    }
}
