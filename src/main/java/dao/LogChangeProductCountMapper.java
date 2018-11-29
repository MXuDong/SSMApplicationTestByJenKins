package dao;

import model.LogChangeProductCount;

import java.util.List;

public interface LogChangeProductCountMapper {
    int insert(LogChangeProductCount record);
    List<LogChangeProductCount> selectAll();
    LogChangeProductCount selectByBaseLogId(Integer logId);
}