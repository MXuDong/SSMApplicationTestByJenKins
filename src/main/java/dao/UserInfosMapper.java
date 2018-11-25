package dao;

import model.UserInfos;

public interface UserInfosMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfos record);

    int insertSelective(UserInfos record);

    UserInfos selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfos record);

    int updateByPrimaryKey(UserInfos record);
}