package TestMyBatis;

import TestUtiles.TestUtil;
import model.UserInfoType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Interface.UserService;

public class TestUserMapper {

    UserService us;

//    @Before
    public void doSomeBefore() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        us = (UserService) ac.getBean("UserService");
    }

    public void doTestRegister() {
        TestUtil.PrintTestTag("doTestRegister BEGIN");
        UserInfoType userInfoType = new UserInfoType();
        userInfoType.setUserName("孟旭东");
        userInfoType.setUserPassword("mengxudong@1997");
        userInfoType.setContactWay("18698631603");
        userInfoType.setUserPower(0);
        TestUtil.PrintTestRes(Boolean.toString(us.doRegister(userInfoType)));
        TestUtil.PrintTestTag("doTestRegister END");
    }

    public void doTestFindByUserName() {
        TestUtil.PrintTestTag("doTestFindByUserName BEGIN");
        UserInfoType userInfoType = us.findByUserName("孟旭东");
        TestUtil.PrintTestRes(userInfoType.toString());
        TestUtil.PrintTestTag("doTestFindByUserName END");
    }

    public void doTestFindByUserId() {
        TestUtil.PrintTestTag("doTestFindByUserId BEGIN");
        UserInfoType userInfoType = us.findByUserName("孟旭东");
        int id = userInfoType.getUserId();
        userInfoType = us.findByUserId(id);
        TestUtil.PrintTestRes(userInfoType.toString());
        TestUtil.PrintTestTag("doTestFindByUserId  END");

    }

    public void doTestDoUpdataUserInfo() {
        TestUtil.PrintTestTag("doTestDoUpdataUserInfo BEGIN");

        UserInfoType userInfoType = us.findByUserName("孟旭东");
        userInfoType.setUserPassword("zhaobenshan");
        TestUtil.PrintTestRes(Boolean.toString(us.doUpdateUserInfo(userInfoType)));

        TestUtil.PrintTestTag("doTestDoUpdataUserInfo  END");
    }

    public void doTestDeleteUserInfo() {
        TestUtil.PrintTestTag("doTestDeleteUserInfo BEGIN");
        UserInfoType userInfoType = us.findByUserName("孟旭东");
        TestUtil.PrintTestRes(Boolean.toString(us.deleteUserInfo(userInfoType)));
        TestUtil.PrintTestTag("doTestDeleteUserInfo  END");
    }

//    @Test
    public void MainTest() {
        doTestRegister();
        doTestFindByUserId();
        doTestFindByUserName();
        doTestDoUpdataUserInfo();
        doTestDeleteUserInfo();
    }

}
