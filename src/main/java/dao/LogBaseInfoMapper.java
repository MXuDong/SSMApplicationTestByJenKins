package dao;

import model.LogBaseInfo;

public interface LogBaseInfoMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(LogBaseInfo record);

    int insertSelective(LogBaseInfo record);

    LogBaseInfo selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(LogBaseInfo record);

    int updateByPrimaryKey(LogBaseInfo record);
}