import com.kakaofriends.core.domain.OrderAddress;
import com.kakaofriends.core.domain.OrderMain;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.DaumMailSenderComponent;
import com.kakaofriends.front.domain.payment.PayResultData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class MailSenderTest {


	@Value("${kakaofriends.cdn.product}")
	String kakaofriendsCdnProduct;

	@Autowired
	private DaumMailSenderComponent daumMailSenderComponent;

	@Test
	public void mailSenderTest() throws Exception {

		Product product = new Product();
		product.setPrImage1("/1C7A9131.jpg");
		product.setPrName("라이언");

		OrderSub orderSub = OrderSub.builder().osSaleMoney(10000).osEa(10).product(product).build();
		OrderSub orderSub2 = OrderSub.builder().osSaleMoney(1000000).osEa(120).product(product).build();

		List<OrderSub> orderSubs = new ArrayList<>();
		orderSubs.add(orderSub);
		orderSubs.add(orderSub2);

		OrderMain orderMain = new OrderMain();
		orderMain.setOmNum("K1234567890");
		orderMain.setOmDeliMoenyUse("Y");
		orderMain.setOmDeliveryMoney(2500);

		OrderAddress orderAddress = new OrderAddress();
		orderAddress.setOaZoneCode("12345");
		orderAddress.setOaAddr1("서울시 강북구 노해로 8가길 13-4");
		orderAddress.setOaAddr2("2층");
		orderAddress.setOaDeliMemo("빠른 배송 부탁드립니다. :)");

		PayResultData payResultData = new PayResultData();
		payResultData.setOrderMail("breeze.hwi@kakaocorp.com");
		payResultData.setOrderName("한태현");
		payResultData.setOrderPhone("01099259717");
		payResultData.setOrderAuthDate("201601011200");
		payResultData.setAmt(10000000);
		payResultData.setOrderMain(orderMain);
		payResultData.setOrderSubs(orderSubs);
		payResultData.setOrderAddress(orderAddress);
		daumMailSenderComponent.sendCompleteMail(payResultData, Locale.KOREA);
	}
}
