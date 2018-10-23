package dao;

import model.OUPPType;

public interface OUPPTypeMapper {
    int deleteByPrimaryKey(Integer operationId);

    int insert(OUPPType record);

    int insertSelective(OUPPType record);

    OUPPType selectByPrimaryKey(Integer operationId);

    int updateByPrimaryKeySelective(OUPPType record);

    int updateByPrimaryKey(OUPPType record);
}