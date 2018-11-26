package dao;

import model.LogChangeProductCount;

public interface LogChangeProductCountMapper {
    int insert(LogChangeProductCount record);
    LogChangeProductCount selectByPrimaryKey(Integer lcpcId);
}