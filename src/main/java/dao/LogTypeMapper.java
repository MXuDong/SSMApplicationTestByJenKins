package dao;

import model.LogType;

public interface LogTypeMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(LogType record);

    int insertSelective(LogType record);

    LogType selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(LogType record);

    int updateByPrimaryKeyWithBLOBs(LogType record);

    int updateByPrimaryKey(LogType record);
}