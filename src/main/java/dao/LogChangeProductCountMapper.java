package dao;

import model.LogChangeProductCount;

public interface LogChangeProductCountMapper {
    int deleteByPrimaryKey(Integer lcpcId);

    int insert(LogChangeProductCount record);

    int insertSelective(LogChangeProductCount record);

    LogChangeProductCount selectByPrimaryKey(Integer lcpcId);

    int updateByPrimaryKeySelective(LogChangeProductCount record);

    int updateByPrimaryKey(LogChangeProductCount record);
}