package dao;

import model.OperBillType;

public interface OperBillTypeMapper {
    int deleteByPrimaryKey(Integer billId);

    int insert(OperBillType record);

    int insertSelective(OperBillType record);

    OperBillType selectByPrimaryKey(Integer billId);

    int updateByPrimaryKeySelective(OperBillType record);

    int updateByPrimaryKey(OperBillType record);
}