package service.Impl;


import dao.UserInfoTypeMapper;
import model.UserInfoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Interface.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private UserInfoTypeMapper userInfoTypeMapper;

    public UserInfoTypeMapper getUserInfoTypeMapper() {
        return userInfoTypeMapper;
    }

    @Autowired
    public void setUserInfoTypeMapper(UserInfoTypeMapper userInfoTypeMapper) {
        this.userInfoTypeMapper = userInfoTypeMapper;
    }



    @Override
    public boolean doRegister(UserInfoType beRegisterdUser) {
        int beInserUserCounts = userInfoTypeMapper.insert(beRegisterdUser);

        return beInserUserCounts == 1;
    }

    @Override
    public UserInfoType findByUserName(String userName) {
        UserInfoType userInfoType = userInfoTypeMapper.selectByUserName(userName);

        return userInfoType;
    }

    @Override
    public UserInfoType findByUserId(int userId) {
        UserInfoType userInfoType = userInfoTypeMapper.selectByPrimaryKey(userId);

        return userInfoType;
    }

    @Override
    public boolean doUpdateUserInfo(UserInfoType beUpdataedUser) {
        int beUpdataedUserCount = userInfoTypeMapper.updateByPrimaryKeySelective(beUpdataedUser);

        return beUpdataedUserCount == 1;
    }

    @Override
    public boolean deleteUserInfo(UserInfoType userInfoType) {
        int beDeleteUserCount = userInfoTypeMapper.deleteByPrimaryKey(userInfoType.getUserId());

        return beDeleteUserCount == 1;
    }
}
