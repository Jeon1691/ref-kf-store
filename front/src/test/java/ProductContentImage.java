import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Commit
public class ProductContentImage {

	@Autowired
	private ProductService productService;

	@Test
	public void ProductContentImageReplace() throws Exception {
		productService.updateProductForContentImageSrc();
	}
}