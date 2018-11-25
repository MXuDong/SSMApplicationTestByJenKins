package dao;

import model.LogOperationObillRes;

public interface LogOperationObillResMapper {
    int deleteByPrimaryKey(Integer lobrId);

    int insert(LogOperationObillRes record);

    int insertSelective(LogOperationObillRes record);

    LogOperationObillRes selectByPrimaryKey(Integer lobrId);

    int updateByPrimaryKeySelective(LogOperationObillRes record);

    int updateByPrimaryKey(LogOperationObillRes record);
}