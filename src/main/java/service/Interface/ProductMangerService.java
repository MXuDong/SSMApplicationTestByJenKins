package service.Interface;

import java.util.List;

public interface ProductMangerService {
    //获取告急库存信息
    List<String> getLessProduct();
    List<String> getLessProduct(int needCount);
    //获取冗余库存信息
    List<String> getMoreProduct();
    List<String> getMoreProduct(int needCount);

}
