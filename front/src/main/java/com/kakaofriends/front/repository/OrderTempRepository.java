package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.OrderAddress;
import com.kakaofriends.core.domain.OrderMain;
import com.kakaofriends.core.domain.OrderMainMobileTemp;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.MemberAddress;
import com.kakaofriends.front.domain.payment.PayResultData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface OrderTempRepository {

	void orderMainMobileTempInsert(OrderMain orderMain);

	void orderSubMobileTempInsert(@Param("orderSub") OrderSub orderSub);

	void orderAddressMobileTempInsert(OrderAddress address);

	void orderMemberAddressTempInsert(MemberAddress memberAddress);

	OrderMain orderMainMobileTempSelect(PayResultData payResultData);

	OrderAddress orderAddressMobileTempSelect(PayResultData payResultData);

	List<OrderSub> orderSubMobileTempSelect(PayResultData payResultData);

	MemberAddress orderMemberAddressTempSelect(PayResultData payResultData);

	int orderMainMobileTempTIdUpdate(@Param("tId") String tId, @Param("oId") String oId, @Param("ownerId") String ownerId);

	int orderSubMobileTempTIdUpdate(@Param("tId") String tId, @Param("oId") String oId, @Param("ownerId") String ownerId);

	int updateOrderMobileTemp(@Param("orderMainMobileTemp") OrderMainMobileTemp orderMainMobileTemp);

	@Update("UPDATE ORDERMAINMOBILETEMP SET OMMT_ETC2 = '01', OMMT_ETC3 = #{msg} WHERE OMMT_PGTID = #{tId}")
	int updateOrderMobileTempCancel(@Param("tId") String tId, @Param("msg") String msg);
}
