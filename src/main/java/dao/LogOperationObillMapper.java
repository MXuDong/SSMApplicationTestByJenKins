package dao;

import model.LogOperationObill;

public interface LogOperationObillMapper {
    int deleteByPrimaryKey(Integer looId);

    int insert(LogOperationObill record);

    int insertSelective(LogOperationObill record);

    LogOperationObill selectByPrimaryKey(Integer looId);

    int updateByPrimaryKeySelective(LogOperationObill record);

    int updateByPrimaryKey(LogOperationObill record);
}