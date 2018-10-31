package service.Impl;

import dao.ProductInfoTypeMapper;
import model.ProductInfoType;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoTypeMapper productInfoTypeMapper;

    @Override
    public ProductInfoType findProductById(int productId) {
        return null;
    }

    @Override
    public ProductInfoType findProductByName(String productName) {
        return null;
    }

    @Override
    public boolean insertProductInfo(ProductInfoType beInsertedProduct) {
        return false;
    }

    @Override
    public boolean insertProductInfos(List<ProductInfoType> productInfoTypes) {
        return false;
    }

    @Override
    public boolean updataProductInfor(ProductInfoType beUpdataedProduct) {
        return false;
    }

    @Override
    public boolean deleteProductInfo(ProductInfoType beDeletedProduction) {
        return false;
    }
}
