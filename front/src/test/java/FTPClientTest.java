import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.FileTransferProtocolComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class FTPClientTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	FileTransferProtocolComponent fileTransferProtocolComponent;

	@Test
	public void uploadTest() throws Exception {
		Resource resource = applicationContext.getResource("classpath:logback.xml");
		MultipartFile multipartFile = new MockMultipartFile(resource.getFilename(), resource.getFile().getName(), "xml", resource.getInputStream());
		fileTransferProtocolComponent.uploadFile("/store", "logback.xml", multipartFile);
	}

	@Test
	public void deleteTest() throws Exception {
		/**
		 * 	 fpt 대신 tenth2이동으로 사용하지 않는 deleteFile 기능 삭제
		 *	 2017-03-30 keany.song
		 */
		//fileTransferProtocolComponent.deleteFile("/store/logback.xml");
	}
}