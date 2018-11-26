import dao.UserInfosMapper;
import model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.Interface.ProductMangerService;

@RunWith(SpringJUnit4ClassRunner.class)
//配置文件的位置
//若当前配置文件名=当前测试类名-context.xml 就可以在当前目录中查找@ContextConfiguration()
@ContextConfiguration("classpath:testApplicationContext.xml")
public class TestMappers {

    @Autowired
    UserInfosMapper userInfosMapper;
    @Autowired
    ProductMangerService productMangerService;

    @Test
    public void testMapper(){
        System.out.println(userInfosMapper.findUserByName("Admin"));
    }

    @Test
    public void testService(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("测试");
        productInfo.setProductDesc("描述");
        productInfo.setProductCount(50);
        productInfo.setProductMinCount(0);
        productInfo.setProductMaxCount(100);
        productInfo.setProductPrice(56.0);
        productMangerService.addProductInfo(productInfo, 1);
    }
}
