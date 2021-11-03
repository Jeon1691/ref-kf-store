package com.kakaofriends.front.repository.giftcard;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.GiftCardExpansion;
import com.kakaofriends.front.domain.giftcard.GiftCardData;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dominic.lee on 2016. 10. 23..
 */
@Repository
@PrimaryMapper
public interface GiftCardRepository {

    GiftCardExpansion findOneByGiftCardCode(String gcCode);

    GiftCardExpansion findOneByGiftPointCardCode(String gcCode); // 마이페이지 포인트 쿠폰 유효체크 2017.10.23

    TbKfoMbsCouponHistory findOneByOnlineCouponCode(String gcCode); // 마이페이지 온라인 지류 쿠폰 유효체크 2017.10.30

    @Update("UPDATE GIFTCARD SET GC_USE = #{gcUse} ,GC_USEDATE = sysdate, GC_MODATE = sysdate, GC_MOID = #{ownerId}, GC_OMNUM = #{omNum}, GC_USERID = #{gcUserId} WHERE GC_CODE = #{gcCode}")
    int giftCardUpdateGcUse(@Param("omNum") String omNum, @Param("gcUse") String gcUse, @Param("ownerId") String ownerId, @Param("gcCode") String gcCode, @Param("gcUserId") String gcUserId); //주문 시 쿠폰 상태 업데이트

    @Update("UPDATE GIFTCARD SET GC_USE = #{gcUse} ,GC_REGISTDATE = sysdate, GC_MODATE = sysdate, GC_MOID = #{ownerId}, GC_USERID = #{gcUserId} WHERE GC_CODE = #{gcCode} AND GC_USERID IS NULL")
    int onlineCouponUpdateGcUse(@Param("gcUse") String gcUse, @Param("ownerId") String ownerId, @Param("gcCode") String gcCode, @Param("gcUserId") String gcUserId); //온라인 지류쿠폰 상태 업데이트

    @Update("UPDATE GIFTCARD SET GC_USE = #{gcUse} ,GC_USEDATE = sysdate, GC_MODATE = sysdate, GC_MOID = #{ownerId}, GC_OMNUM = #{omNum}, GC_USERID = #{gcUserId} WHERE GC_CODE = #{gcCode} AND GC_USERID IS NULL")
    int pointCouponUpdateGcUse(@Param("omNum") String omNum, @Param("gcUse") String gcUse, @Param("ownerId") String ownerId, @Param("gcCode") String gcCode, @Param("gcUserId") String gcUserId); //포인트 지류쿠폰 상태 업데이트

    List<TbKfoMbsCouponHistory> findCouonListByOmnum(String gcOmnum);

    GiftCardData select(@Param("giftCardCode") String giftCardCode);

    void update(@Param("giftCard") GiftCardData giftCardData);
}
