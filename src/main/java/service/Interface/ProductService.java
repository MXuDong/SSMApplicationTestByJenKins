package service.Interface;

import model.ProductInfoType;

import java.util.List;

public interface ProductService {
//    根据产品ID查找产品
    public ProductInfoType findProductById(int productId);
//    根据产品名查找产品
    public ProductInfoType findProductByName(String productName);
//    添加产品
    public boolean insertProductInfo(ProductInfoType beInsertedProduct);
//    批量添加产品
    public boolean insertProductInfos(List<ProductInfoType> productInfoTypes);
//    修改产品信息
    public boolean updataProductInfor(ProductInfoType beUpdataedProduct);
//    通过名字删除产品信息
    public boolean deleteProductInfo(ProductInfoType beDeletedProduction);
}


