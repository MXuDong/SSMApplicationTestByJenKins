package service.Impl;

import service.Interface.ProductMangerService;

import java.util.List;
import java.util.Map;

public class ProductManagerImpl implements ProductMangerService {
    @Override
    public List<String> getLessProducts() {
        return null;
    }

    @Override
    public List<String> getLessProducts(int count) {
        return null;
    }

    @Override
    public List<String> getMoreProducts() {
        return null;
    }

    @Override
    public List<String> getMoreProducts(int count) {
        return null;
    }

    @Override
    public Map<String, String> getProductBingPic() {
        return null;
    }

    @Override
    public Map<String, String> getProductBingPic(int count) {
        return null;
    }

    @Override
    public List<List<String>> getProductInfos() {
        return null;
    }

    @Override
    public Map<String, String> getProductMoreInfo() {
        return null;
    }

    @Override
    public Map<String, String> getProductPicInfo() {
        return null;
    }

    @Override
    public int addProductInfo(String... str) {
        return 0;
    }

    @Override
    public int updateProductInfo(int picId) {
        return 0;
    }

    @Override
    public int updateProductInfo(int productId, int changeCount) {
        return 0;
    }

    @Override
    public int updateProductInfo(int productId, double changePrice) {
        return 0;
    }
}
