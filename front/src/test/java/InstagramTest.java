import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.instagram.Instagram;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class InstagramTest {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${kakaofriends.instagram.url}")
	private String instagramUrl;

	@Value("${kakaofriends.instagram.access_token}")
	private String accessToken;

	@Value("${kakaofriends.instagram.count}")
	private Integer count;

	@Test
	public void InstagramTest() throws Exception {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setBufferRequestBody(false);
		restTemplate.setRequestFactory(requestFactory);
		Instagram instagram = restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(instagramUrl).queryParam("access_token", accessToken).queryParam("count", count).build().encode().toUri(), Instagram.class);
		System.out.println("instagram = " + instagram.getData()[0].getLink());
		System.out.println("instagram = " + instagram.getData()[0].getImages().getStandardResolution().getUrl());
	}
}