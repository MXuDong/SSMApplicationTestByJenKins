import dao.Service.UserService;
import dao.Service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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