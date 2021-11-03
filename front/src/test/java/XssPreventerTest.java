import com.kakaofriends.front.common.configuration.*;
import com.nhncorp.lucy.security.xss.XssPreventer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class XssPreventerTest {

	@Test
	public void testXssPreventer() {
		String dirty = "\"><script>alert('한글');</script>";
		String clean = XssPreventer.escape(dirty);
		System.out.println(clean);
	}
}
