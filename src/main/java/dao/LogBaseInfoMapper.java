package dao;

import model.LogBaseInfo;

public interface LogBaseInfoMapper {
    int insert(LogBaseInfo record);
    LogBaseInfo selectByPrimaryKey(Integer logId);
}