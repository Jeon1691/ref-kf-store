import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import com.kakaofriends.front.domain.kims.ShortMessageServiceDto;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.kakaofriends.front.utils.FriendsUtil.processMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class KIMSRESTfulTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private KakaoIntegratedMessagingComponent kakaoIntegratedMessagingComponent;

	@Autowired
	MessageSource messageSource;

//	@Test
//	public void RESTfulTest() throws Exception {
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
//		request.set("appName", "kakaofriends");
//		request.set("msgJson", objectMapper.writeValueAsString(ShortMessageService.builder().callerNumber("0226321008").receiverNumber("01076669399").message("!!!").type("normal").countryCode("82").build()));
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//		ResponseEntity<String> result = restTemplate.postForEntity("http://kims-api.dev.9rum.cc/api/send_sms", new HttpEntity<>(request, headers), String.class);
//
//		System.out.println(result.getStatusCode());
//	}

	@Test
	public void KakaoIntegratedMessagingComponentTest() throws Exception {
		kakaoIntegratedMessagingComponent.sendShortMessageService(
				ShortMessageServiceDto.builder()
						.callerNumber("0226321008")
						.receiverNumber("01035297530")
						.message(processMessage(messageSource, "sms.order.complete", new Object[]{"O29160920"}))
						.type("normal")
						.countryCode("82")
						.build());
	}
}