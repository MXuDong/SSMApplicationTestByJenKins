package dao;

import model.LogOperationObill;

public interface LogOperationObillMapper {
    int insert(LogOperationObill record);
    LogOperationObill selectByPrimaryKey(Integer looId);
    int updateByPrimaryKey(LogOperationObill record);
}