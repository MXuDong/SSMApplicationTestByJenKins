package dao;

import model.ProductInfo;

import java.util.List;

public interface ProductInfoMapper {

    int insert(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    List<ProductInfo> selectAll();
    List<ProductInfo> selectMoreProduct();
    List<ProductInfo> selectLessProduct();
}