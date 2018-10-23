package dao;

import model.UserInfoType;

public interface UserInfoTypeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfoType record);

    int insertSelective(UserInfoType record);

    UserInfoType selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfoType record);

    int updateByPrimaryKey(UserInfoType record);
}