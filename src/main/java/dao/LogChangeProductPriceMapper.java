package dao;

import model.LogChangeProductPrice;

public interface LogChangeProductPriceMapper {
    int insert(LogChangeProductPrice record);
    LogChangeProductPrice selectByPrimaryKey(Integer lcppId);
}