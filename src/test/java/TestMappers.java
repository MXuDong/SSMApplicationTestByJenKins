import dao.UserInfosMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//配置文件的位置
//若当前配置文件名=当前测试类名-context.xml 就可以在当前目录中查找@ContextConfiguration()
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMappers {

    @Autowired
    UserInfosMapper userInfosMapper;

    @Test
    public void testMapper(){
        System.out.println(userInfosMapper.findUserByName("Admin"));
    }
}
