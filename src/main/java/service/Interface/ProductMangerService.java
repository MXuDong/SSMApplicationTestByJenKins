package service.Interface;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProductMangerService {
    //获取告急库存信息
    List<String> getLessProduct();
    List<String> getLessProduct(int needCount);
    //获取冗余库存信息
    List<String> getMoreProduct();
    List<String> getMoreProduct(int needCount);
    //获得产品总量变化统计图信息
    Map<String, String> getProductChangeInfo();
    Map<String, String> getProductChangeInfo(Date date);
}
