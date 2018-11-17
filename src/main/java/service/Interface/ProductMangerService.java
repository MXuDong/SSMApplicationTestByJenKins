package service.Interface;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface ProductMangerService {
    //库存告急数据
    List<String> getLessProducts();
    List<String> getLessProducts(int count);
    //库存冗余数据
    List<String> getMoreProducts();
    List<String> getMoreProducts(int count);
    //产品总量饼图
    Map<String, String> getProductBingPic();
    Map<String, String> getProductBingPic(int count);
    //获取所有产品列表
    List<List<String>> getProductInfos();
    //获取某个产品的详细信息
    Map<String, String> getProductMoreInfo();
    //获取某产品的绘图需要的信息
    Map<String, String> getProductPicInfo();
    //添加产品信息
    int addProductInfo(String ... str);
    //修改产品图片信息
    int updateProductInfo(int picId);
    //修改产品数量
    int updateProductInfo(int productId, int changeCount);
    //修改产品价格
    int updateProductInfo(int productId, double changePrice);
}
