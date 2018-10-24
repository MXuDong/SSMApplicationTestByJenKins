package TestEnvironment;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Interface.UserService;

public class TestBaseEnvironment {

    private ApplicationContext ac;
    private UserService us;

    @Before
    public void Before(){
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        us = (UserService) ac.getBean("UserService");
    }

    @Test
    public void testMyBatis(){
        System.out.println(us.findAllUsers());
    }
}
