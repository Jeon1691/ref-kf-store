import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.repository.OrderManageRepository;
import com.kakaofriends.front.service.order.OrderManageService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by erica on 2017-11-24
 */
@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class FriendsScheduleTest {

    @Autowired
    OrderManageRepository orderManageRepository;

    @Autowired
    OrderManageService orderManageService;

    @Test
    public void scheduleForOrderComfirmPoint() throws OrderManageException {
	    System.out.println("yrdy");
        //1 구매확정된 주문건 조회 (주문 번호당 결제된 금액 조회)

        log.info("########## 스케쥴러 scheduleForOrderComfirmPoint getPriceListByAllOrderSubStatus start ##########");
        List<OrderSub> orderSubList = orderManageRepository.getPriceListByAllOrderSubStatus();

        for( OrderSub orderSub : orderSubList ){
            System.out.println(" >>>> scheduleForOrderComfirmPoint "+orderSub.getOsOmNum());
            orderManageService.processCompleteOrderForPoint(orderSub);
        }
        log.info("########## 스케쥴러 scheduleForOrderComfirmPoint getPriceListByAllOrderSubStatus end ##########");
	}
}
