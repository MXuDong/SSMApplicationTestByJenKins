package dao;

import model.LogOperationObillRes;

public interface LogOperationObillResMapper {
    int insert(LogOperationObillRes record);
    LogOperationObillRes selectByPrimaryKey(Integer lobrId);
    int updateByPrimaryKey(LogOperationObillRes record);
}