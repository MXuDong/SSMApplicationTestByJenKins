package dao;

import model.ProductInfoType;

public interface ProductInfoTypeMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductInfoType record);

    int insertSelective(ProductInfoType record);

    ProductInfoType selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductInfoType record);

    int updateByPrimaryKey(ProductInfoType record);
}