import dao.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBaseEnvironment {

    private ApplicationContext ac;
    private service.Interface.UserService us;

    @Before
    public void Before(){
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        us = (service.Interface.UserService) ac.getBean("UserService");
    }

    @Test
    public void testMyBatis(){
        System.out.println(us.findAllUsers());
    }
}
