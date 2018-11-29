package dao;

import model.LogBaseInfo;

import java.util.List;

public interface LogBaseInfoMapper {
    int insert(LogBaseInfo record);
    List<LogBaseInfo> selectAll();
    LogBaseInfo selectByLogId(int logId);
}