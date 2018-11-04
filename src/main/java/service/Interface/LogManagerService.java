package service.Interface;

import java.util.List;

public interface LogManagerService {
    //获取操作日志历史列表
    List<String> getLogHistory();
    List<String> getLogHistory(int needCount);
}
