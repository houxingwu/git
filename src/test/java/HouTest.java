import com.SApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 测试
 * @Author
 * @Date 2019-10-08 10:11
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SApplication.class)
public class HouTest {
    @Autowired
    Environment env;
    @Test
    public void Get(){
        System.out.println(env.getProperty("img.rootPath"));
    }

}
