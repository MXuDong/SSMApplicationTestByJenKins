package service.Interface;

import java.util.List;
import java.util.Map;

public interface ObillManagerService {
    //获取结账金额，上一次结账信息
    Map<String, String> getAccountAttribute();
    //获取结账详细信息列表
    List<Map<String, String>> getAccountInfos();
}
