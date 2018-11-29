package dao;

import model.UserInfos;

public interface UserInfosMapper {
    UserInfos findUserByName(String userName);
    UserInfos findUserById(int userId);
}