package dao;

import model.LogChangeProductPrice;

import java.util.List;

public interface LogChangeProductPriceMapper {
    int insert(LogChangeProductPrice record);
    List<LogChangeProductPrice> selectAll();
    LogChangeProductPrice selectByBoasLogId(int logId);
}