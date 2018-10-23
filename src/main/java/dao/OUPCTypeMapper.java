package dao;

import model.OUPCType;

public interface OUPCTypeMapper {
    int deleteByPrimaryKey(Integer operationId);

    int insert(OUPCType record);

    int insertSelective(OUPCType record);

    OUPCType selectByPrimaryKey(Integer operationId);

    int updateByPrimaryKeySelective(OUPCType record);

    int updateByPrimaryKey(OUPCType record);
}