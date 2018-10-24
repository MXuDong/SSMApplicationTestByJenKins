package service.Impl;

import dao.UserInfoTypeMapper;
import model.UserInfoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Interface.UserService;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    UserInfoTypeMapper userInfoTypeMapper;

    public UserInfoTypeMapper getUserInfoTypeMapper() {
        return userInfoTypeMapper;
    }

    @Autowired
    public void setUserInfoTypeMapper(UserInfoTypeMapper userInfoTypeMapper) {
        this.userInfoTypeMapper = userInfoTypeMapper;
    }

    @Override
    public UserInfoType findAllUsers() {
        return userInfoTypeMapper.selectByPrimaryKey(1);
    }
}
