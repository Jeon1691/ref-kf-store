package com.kakaofriends.front.common.schedule;

import com.kakaofriends.front.common.cache.FriendsCacheBuilder;
import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import com.kakaofriends.front.repository.MyCouponRepository;
import com.kakaofriends.front.repository.MyPointRepository;
import com.kakaofriends.front.repository.OrderManageRepository;
import com.kakaofriends.front.repository.order.OrderSubRepository;
import com.kakaofriends.front.service.order.OrderManageService;
import com.kakaofriends.front.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Component
public class FriendsSchedule {

	@Autowired
	FriendsCacheBuilder friendsCacheBuilder;

	@Autowired
    OrderSubRepository orderSubRepository;

	@Autowired
	KakaoIntegratedMessagingComponent kakaoIntegratedMessagingComponent;

	@Autowired
	private MyPointRepository myPointRepository;

	@Autowired
	private MyCouponRepository myCouponRepository;

	@Autowired
	OrderManageRepository orderManageRepository;

	@Autowired
	OrderManageService orderManageService;

	@Value("${active}")
	private String active;

    @Value("${redis.host}")
    private String redisHostIP;

    @Value("${redis.password}")
    private String redisHostPassword;

	@Value("${sales.scheduler.host}")
	private String schedulerHost;

	@Scheduled(cron = "0 0/5 * * * *")
	public void scheduleForFiveMinutes() {
		log.info("scheduleForFiveMinutes Start");
		friendsCacheBuilder.buildCategoryMenuCache(Instant.now());
		friendsCacheBuilder.buildCategoryMenuCache(Instant.now().plus(10, ChronoUnit.MINUTES));
	}

	/**
	 *
	 * 작성자 : dave
	 * 날짜 : 2017. 7. 6.
	 *
	 * 9~24시 까지 당일 매출 현황 mms로 전송
	 */

	@Scheduled(cron = "0 0 9-23,0 * * *")
	public void scheduleSandMmsSalesData(){

		String localhost = null;

		try {
			localhost = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException var9) {
			var9.printStackTrace();
		}

		if(localhost != null )
			localhost = localhost.split("/")[1];

		// 1번 서버일때만 mms 전송
		if(localhost == null || !schedulerHost.equals(localhost))
			return;

		SimpleDateFormat format = new SimpleDateFormat("HH");
		long time = Long.parseLong(format.format(new Date()));

		StringBuilder date = new StringBuilder();
		Calendar calendar = new GregorianCalendar();
		if(time == 0){
			calendar.add(Calendar.DATE, -1);
		}
		date.append(calendar.get(Calendar.YEAR)).append("-").append(String.valueOf(calendar.get(Calendar.MONTH) + 1)).append("-").append(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));

		log.info("########## 스케줄러ip : {}, 날짜 : {}", localhost, date.toString());

		List<Map<String, Object>> salesData = orderSubRepository.getOrderSalesData(date.toString());
		if (active.equals("production")) {
			kakaoIntegratedMessagingComponent.sendSalesDataMms("010-5494-8135".replace("-", ""), getSaleDataMessage(salesData, date.toString()));
			kakaoIntegratedMessagingComponent.sendSalesDataMms("010-4633-8272".replace("-", ""), getSaleDataMessage(salesData, date.toString()));
			kakaoIntegratedMessagingComponent.sendSalesDataMms("010-8928-2162".replace("-", ""), getSaleDataMessage(salesData, date.toString()));
		}
	}

	public String getSaleDataMessage(List<Map<String, Object>> saleDatas, String date){

		DecimalFormat df = new DecimalFormat("#,###");

		long countValue =  ((BigDecimal) saleDatas.get(0).get("COUNTVALUE")).longValue();
		long totalMoney =  ((BigDecimal) saleDatas.get(0).get("TOTALMONEY")).longValue();

		// 객단가 : 매출 / 총주문건수
		long customerTransaction = countValue > 0 ? Math.round(totalMoney / countValue) : 0;

		StringBuilder messageStr = new StringBuilder();

		messageStr.append("총 주문건수 : " + df.format(countValue) + " 건\n")
				.append("매출 : " + df.format(totalMoney) + " 원 \n")
				.append("객단가 : " + df.format(customerTransaction) + " 원\n");

		try {
			Jedis jedis = new Jedis(redisHostIP);
            if(StringUtils.isNotEmpty(redisHostPassword)) {
                jedis.auth(redisHostPassword);
            }
			String count = jedis.get(date);

			if(count != null && Double.parseDouble(count) > 0){
				DecimalFormat df2 = new DecimalFormat("#,###.##");

				// 구매전환률 : (총주문건수 / 유입자) * 100
				double purchaseChangeRate = countValue / Double.parseDouble(count) * 100;
				messageStr.append("유입자 수  : " + df.format(Math.round(Double.parseDouble(count))) + " 건 \n")
						.append("구매전환률  : " + df2.format(purchaseChangeRate) + " % \n");
			}
		}catch (Exception e){
			log.info("redis 접속자수 조회 오류 ");
		}

		return messageStr.toString();

	}


//	@Scheduled(cron = "0 0/30 * * * *")
//	public void scheduleForThirtyMinutes() {
//		log.info("scheduleForThirtyMinutes Start"
//		friendsCacheBuilder.buildInstagramCache(Instant.now());
//		friendsCacheBuilder.buildInstagramCache(Instant.now().plus(1, ChronoUnit.HOURS));
//	}

	/**
	 *
	 * 작성자 : erica
	 * 날짜 : 2017. 11. 9.
	 *
	 * 이벤트 기간 중 구매확정된 주문건 포인트 지급
	 */
//	@Scheduled(cron = "0 10 2 * * ?")
//	public void scheduleForOrderComfirmPoint() throws OrderManageException {
//		//1 구매확정된 주문건 조회 (주문 번호당 결제된 금액 조회)
//
//		log.info("########## 스케쥴러 scheduleForOrderComfirmPoint getPriceListByAllOrderSubStatus start ##########");
//		List<OrderSub> orderSubList = orderManageRepository.getPriceListByAllOrderSubStatus();
//
//		for( OrderSub orderSub : orderSubList ){
//			orderManageService.processCompleteOrderForPoint(orderSub);
//		}
//		log.info("########## 스케쥴러 scheduleForOrderComfirmPoint getPriceListByAllOrderSubStatus end ##########");
//	}
}