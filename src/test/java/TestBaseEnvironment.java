import dao.Interface.UserInterface;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBaseEnvironment {

    @Test
    public void testEnvironment(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testMybatis(){
        UserInterface userInterface =
    }
}
