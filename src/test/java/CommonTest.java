import com.crawler.Server;
import com.crawler.job.Crawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by admin on 17/2/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Server.class)
@ActiveProfiles("pro")
public class CommonTest {

    @Autowired
    Crawler crawler1;

    @Test
    public void test(){
        crawler1.doCrawl(3);
        while (true){

        }
    }


}
