package service.Interface;

import java.util.List;
import java.util.Map;

/**
 *
 * 提供日志服务
 *
 */
public interface LogManagerService {
    //产品信息变动日志
    List<String> getOperList();
    List<String> getOperList(int count);
    //收入支出操作数据
    List<String> getObilPicOptionValue();
    List<String> getObilPicOptionValue(int count);
    //产品总量变化数据
    Map<String, String> getProductChangeValue();
    Map<String, String> getProductChangeValue(int count);
    //获取所有日志信息
    List<List<String>> getAllLogInfo();
    //获取价格变动日志信息
    List<List<String>> getAllChangePriceInfo();
    //获取产品数量变动日志
    List<List<String>> getAllChangeCountInfo();
    //获取所有结账信息日志
    List<List<String>> getAllObillInfo();
}
