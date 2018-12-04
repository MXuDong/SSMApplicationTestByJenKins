package service.Interface;

import java.util.List;
import java.util.Map;

public interface ObillManagerService {
    //获取结账金额，上一次结账信息
    Map<String, Object> getAccountAttribute();
    //确认结账
    void doSubmitObill(int userId);
}
