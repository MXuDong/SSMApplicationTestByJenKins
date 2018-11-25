package dao;

import model.LogChangeProductPrice;

public interface LogChangeProductPriceMapper {
    int deleteByPrimaryKey(Integer lcppId);

    int insert(LogChangeProductPrice record);

    int insertSelective(LogChangeProductPrice record);

    LogChangeProductPrice selectByPrimaryKey(Integer lcppId);

    int updateByPrimaryKeySelective(LogChangeProductPrice record);

    int updateByPrimaryKey(LogChangeProductPrice record);
}