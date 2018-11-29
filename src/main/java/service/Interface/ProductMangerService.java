package service.Interface;

import model.ProductInfo;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface ProductMangerService {
    //库存告急数据
    List<String> getLessProducts();
    List<List<String>> getLessProducts(int count);
    //库存冗余数据
    List<String> getMoreProducts();
    List<List<String>> getMoreProducts(int count);
    //产品总量饼图
    Map<String, String> getProductBingPic();
    //获取所有产品列表
    List<List<String>> getProductInfos();
    //获取某个产品的详细信息
    Map<String, String> getProductMoreInfo(int productId);
    //获取某产品的绘图需要的信息
    Map<String, String> getProductPicInfo();
    //添加产品信息
    int addProductInfo(ProductInfo productInfo, int userId);
    //修改产品图片信息
    int updateProductInfo(String picId);
    //修改产品数量
    int updateProductInfoC(String productId, int changeCount, int userId);
    //修改产品价格
    int updateProductInfoP(String productId, double changePrice, int userId);
}
