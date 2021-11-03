import com.kakaofriends.front.common.configuration.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class MobileApprovalResultTest {

	@Autowired
	private RestTemplate restTemplateNoHttpMessageConverter;

	@Test
	public void approvalResultTest() throws Exception {
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.set("P_TID", "INIMX_AUTHINIpayTest20161010222704701285");
		multiValueMap.set("P_MID", "INIpayTest");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		restTemplateNoHttpMessageConverter.postForEntity("https://drmobile.inicis.com/smart/pay_req_url.php", new HttpEntity<>(multiValueMap, headers), String.class);
	}
}
