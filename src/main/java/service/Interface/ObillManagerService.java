package service.Interface;

import java.util.Date;
import java.util.Map;

public interface ObillManagerService {
    //获取收入支出折线图信息
    Map<String, String> getObillChangeInfo();
    Map<String, String> getObillChangeInfo(Date date);
}
