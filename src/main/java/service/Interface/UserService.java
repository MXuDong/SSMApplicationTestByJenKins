package service.Interface;

import model.UserInfoType;

import java.util.List;

public interface UserService {
//    注册
    public void doRegister(UserInfoType beRegisterdUser);
//    根据用户名查找
    public UserInfoType findByUserName(String userName);
//    根据ID查找用户
    public UserInfoType findByUserId(int userId);
//    修改个人信息
    public boolean doUpdateUserInfo(UserInfoType beUpdataedUser);
//    注销用户
    public boolean deleteUserInfo(UserInfoType userInfoType);
}
