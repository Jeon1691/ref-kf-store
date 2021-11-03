package com.kakaofriends.front.repository.order;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderSubData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@PrimaryMapper
public interface OrderSubRepository {

	int orderSubToSales(Map map);

	List<Map<String, Object>> getOrderSalesData(@Param("today") String today);

	@Select("SELECT SUM(OS_NEWSAVEMONEY) SUMSAVEMONEY1, SUM(OS_NEWPRSAVEMONEY) SUMSAVEMONEY2 FROM ORDERSUB WHERE OS_OMNUM = #{omNum}")
	Map findByOmNumForCyberMoney(String omNum);

	/**
	 * 주문 상세 내역을 조회한다.
	 *
	 * @param sequence 주문 상세 시퀀스
	 * @return 주문 상세 정보
	 */
	OrderSubData select(@Param("sequence") long sequence);

	/**
	 * 주문 산세 내역을 조회한다.
	 *
	 * @param orderNumber 주문번호
	 * @param serial 주문의 시리얼
	 * @return 주문 상세 정보
	 */
	OrderSubData selectByOrderNumber(@Param("orderNumber") String orderNumber, @Param("serial") int serial);

	/**
	 * 주문 상세 목록을 조회한다.
	 *
	 * @param data 조회할 주문 상세 정보
	 * @return 주문 상세 목록
	 */
	List<OrderSubData> selectList(OrderSubData data);

	/**
	 * 주문 상세 내역을 입력한다.
	 *
	 * @param data 주문 상세 내역
	 */
	void insert(@Param("orderSub") OrderSubData data);
}