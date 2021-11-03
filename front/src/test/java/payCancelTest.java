import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.payment.PayComponent;
import com.kakaofriends.front.repository.MyOrderedRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class payCancelTest {

    @Autowired
    private List<PayComponent> payComponents;

    @Autowired
    MyOrderedRepository myOrderedRepository;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Test
    public void pahCancelTest() {
//        OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByNonmemberNameAndOrderNumber("서주완", "K20161024110102242");
//        System.out.println("@@@@"+orderShippingInfo);
//
//        CnsPayComponent cnsPayComponent = new CnsPayComponent();
//        cnsPayComponent.cancelProcessing(httpServletRequest, PayCancel.builder().tid(orderShippingInfo.getOrderInfo().getOmPgtId()).cancelAmt(String.valueOf(orderShippingInfo.getOrderInfo().getOmKakaoMoney())).partialCancelCode(PartialCancelCode.ALL_CANCEL).message("사용자 취소 테스트").build());
    }

}
