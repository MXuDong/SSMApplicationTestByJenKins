package dao;

import model.ObillOUPCType;

public interface ObillOUPCTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ObillOUPCType record);

    int insertSelective(ObillOUPCType record);

    ObillOUPCType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ObillOUPCType record);

    int updateByPrimaryKey(ObillOUPCType record);
}