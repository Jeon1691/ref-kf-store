package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.controller.order.validator.OrderValidator;
import com.kakaofriends.front.domain.GiftCardExpansion;
import com.kakaofriends.front.domain.mypage.MyPointCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.repository.MyPointRepository;
import com.kakaofriends.front.repository.giftcard.GiftCardRepository;
import com.kakaofriends.front.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 마이페이지 포인트 layla.rae 2017.10.20
 */
@Slf4j
@Service
public class MyPointServiceImpl implements MyPointService {

    @Autowired
    private MyPointRepository myPointRepository;

    @Autowired
    private GiftCardRepository giftCardRepository;

    @Autowired
    private OrderValidator orderValidator;

    /**
     * 나의 포인트 내역
     * @param userId
     * @return List<TbKfoMbsPoint>
     */
    @Override
    public List<TbKfoMbsPoint> myPointHistory(String userId, PaginationInfo pagination) {
        List<TbKfoMbsPoint> myPtHistory = myPointRepository.myPointHistory(userId, pagination);
        myPtHistory.forEach(e -> {
            if(e.getMP_OMNUM() != null && !e.getMP_TYPE().equals("G")) {

                try {

                    TbKfoMbsPoint myPointHistoryOrderTitle = myPointRepository.myPointHistoryOrderTitle( e.getMP_OMNUM() );

                    int prcnt = myPointHistoryOrderTitle.getOMCOUNT();
                    String wprname = ((prcnt > 1) ? " 외 " + (prcnt - 1) + "개" : "");
                    String wprename = ((prcnt > 1) ? " and others " + (prcnt - 1) : "");
                    e.setMP_TITLE( myPointHistoryOrderTitle.getMP_TITLE() + wprname );
                    e.setMP_ETITLE( myPointHistoryOrderTitle.getMP_ETITLE() + wprename );
                    e.setTOTALMONEY( myPointHistoryOrderTitle.getTOTALMONEY() );
                    e.setPAYMONEY( myPointHistoryOrderTitle.getPAYMONEY() );
                    e.setCOUPONMONEY( myPointHistoryOrderTitle.getCOUPONMONEY() );
                }   catch ( Exception e1 ){
                    e1.printStackTrace();
                }
            }
        });

        return myPtHistory;
    }

    /**
     * 나의 포인트쿠폰 적립
     * @param couponNum
     * @param userId
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> confirmPointCouponNumber(String couponNum, String userId) {
        GiftCardExpansion giftCardExpansion = giftCardRepository.findOneByGiftPointCardCode(couponNum);

        if (giftCardExpansion != null) {
            if ("1".equals(giftCardExpansion.getGiftcard().getGcUse()) && !giftCardExpansion.getIsUsePeriodAfter() && !giftCardExpansion.getIsUsePeriodBefore()) {
                TbKfoMbsPoint kfoMbsPoint = new TbKfoMbsPoint();
                kfoMbsPoint.setMP_USERID(userId);
                kfoMbsPoint.setMP_CODE(giftCardExpansion.getGiftcard().getGcCode());
                kfoMbsPoint.setMP_SDATE(giftCardExpansion.getGcmSdate());
                kfoMbsPoint.setMP_EDATE(giftCardExpansion.getGcmEdate());
                kfoMbsPoint.setMP_AMOUNT(giftCardExpansion.getGiftcard().getGcPrice());
                kfoMbsPoint.setMP_REST(giftCardExpansion.getGiftcard().getGcPrice());
                myPointRepository.myPointInsert(kfoMbsPoint);

                giftCardRepository.pointCouponUpdateGcUse("", "3", userId, giftCardExpansion.getGiftcard().getGcCode(), userId);
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        String msg = orderValidator.getValidateMessageByMyGiftCard(giftCardExpansion);
        resultMap.put("resultMsg", msg);
        return resultMap;
    }

    /**
     * 나의 포인트 정보 (적립포인트, 소멸예정 포인트, 소멸날짜)
     * @param userId
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> getMyPointInfo(String userId) {
        return myPointRepository.getMyPointInfo(userId);
    }

    /**
     * 나의 포인트내역 전체카운드
     * @param userId
     * @return int
     */
    @Override
    public int myPointHistoryAllCount(String userId) {
        return myPointRepository.myPointHistoryAllCount(userId);
    }

    /**
     * 포인트 적립
     * @param kfoMbsPoint
     * @return int
     */
    @Override
    public int myPointInsert(TbKfoMbsPoint kfoMbsPoint) {
        return myPointRepository.myPointInsert(kfoMbsPoint);
    }

    /**
     * 포인트 총액 조회
     * @param userId
     * @return
     */
    @Override
    public double getAvailablePointByUser(String userId) {
        return myPointRepository.getAvailablePointByUser(userId);
    }

     /**
     * TbKfoMbsPoint.mp_type = 'U' : 구매 후 사용
     * TbKfoMbsPoint.mp_type = 'C' : 구매 취소 후 재적립
     * @param registPoint
     * @return
     */
    @Override
    public void modifyPointProcess(TbKfoMbsPoint registPoint) {
        int useResult = 0;
        log.info(">>> modifyPointProcess type: {}", registPoint.getMP_TYPE());

        //구매했을 경우 포인트 차감
        if(registPoint.getMP_TYPE().equals(MyPointCode.USE.getCode())){
            int usedPoint = registPoint.getMP_AMOUNT();
            List<TbKfoMbsPoint> pointList = myPointRepository.listAvailablePointByUser(registPoint.getMP_USERID());
            int regiPoint = 0;
            for (TbKfoMbsPoint mbsPoint1 : pointList) {
                if( usedPoint > 0 ) {
                    if ( mbsPoint1.getMP_REST() <= usedPoint ) {
                        usedPoint -= mbsPoint1.getMP_REST();
                        regiPoint += mbsPoint1.getMP_REST();
                        mbsPoint1.setMP_REST(0);
                    } else {
                        mbsPoint1.setMP_REST(mbsPoint1.getMP_REST() - usedPoint);
                        regiPoint += usedPoint;
                        usedPoint = 0;
                    }
                    myPointRepository.modifyPointByUse(mbsPoint1);
                }
            }

            //(-) 사용 금액
            if(regiPoint != 0){
                registPoint.setMP_AMOUNT(regiPoint);
                useResult += myPointRepository.registPointByUser(registPoint);
            }
        }

        //구매 취소 재적립 ( 만료일이 가까운 포인트부터 채운다 - rest money 만 수정 )
        if(registPoint.getMP_TYPE().equals(MyPointCode.CANCEL.getCode())){
            //log.info("registPoint.getMP_TYPE() >>> C ");
            //log.info("registPoint.getMP_AMOUNT() >>> {} ", registPoint.getMP_AMOUNT());
            int usedPoint = registPoint.getMP_AMOUNT();
            List<TbKfoMbsPoint> pointList = myPointRepository.listAddablePointByUser(registPoint.getMP_USERID());

            //log.info("pointList.size() >>> {} ", pointList.size());
            for (TbKfoMbsPoint mbsPoint1 : pointList) {
                int listAmount = mbsPoint1.getMP_AMOUNT() - mbsPoint1.getMP_REST();
                //log.info("재적립할 수 있는 금액 >>> {} - {} = {} ", mbsPoint1.getMP_AMOUNT(), mbsPoint1.getMP_REST(), listAmount);

                if (usedPoint > 0) {
                    if (listAmount <= usedPoint) {
                        //log.info(" 재적립 금액 다 채우는 경우 listAmount = {}", listAmount);
                        mbsPoint1.setMP_AMOUNT(listAmount);
                        mbsPoint1.setMP_REST(listAmount);
                        usedPoint -= listAmount;
                    } else {
                        //log.info(" 부분 적립이 되는 경우 usedPoint = {}", usedPoint);
                        mbsPoint1.setMP_AMOUNT(usedPoint);
                        mbsPoint1.setMP_REST(usedPoint);
                        usedPoint -= usedPoint;
                    }
                    mbsPoint1.setMP_OMNUM(registPoint.getMP_OMNUM());
                    mbsPoint1.setMP_TYPE(MyPointCode.CANCEL.getCode());
                    mbsPoint1.setMP_TITLE(null);
                    useResult += myPointRepository.registPointByUser(mbsPoint1);
                }
            }
        }

        /*
        포인트 적립 시 결제가의 5% ( 소수점으로 나올 경우 첫번째 자리에서 반올림 )
         */
        if(registPoint.getMP_TYPE().equals(MyPointCode.ORDER.getCode()) && registPoint.getMP_AMOUNT() > 0){
            log.info("registPoint.getMP_TYPE() >>> O ");
            log.info("MP_CODE >>> {}", registPoint.getMP_CODE());
            log.info("MP_USERID >>> {}", registPoint.getMP_USERID());
            log.info("AMOUNT {} >>> POINT {} ", registPoint.getMP_AMOUNT(), registPoint.getMP_AMOUNT()*0.03);

            int insertPoint = (int)Math.round(registPoint.getMP_AMOUNT()*0.06);
            DateUtil dateUtil = new DateUtil();
            Date edate = dateUtil.getEXPDateyyyyMMddHHmmssAddMonth(dateUtil.getDateyyyyMMdd(), 12);

            registPoint.setMP_AMOUNT(insertPoint);
            registPoint.setMP_REST(insertPoint);
            registPoint.setMP_EDATE(edate);
            useResult += myPointRepository.registPointByUser(registPoint);

        }

        /*
        이벤트인 경우 앞단에서 금액 계산 후 그대로 넣어준다
         */
        if(registPoint.getMP_TYPE().equals(MyPointCode.GIFT.getCode()) && registPoint.getMP_AMOUNT() > 0){
            log.info("registPoint.getMP_TYPE() >>> O ");
            log.info("MP_CODE >>> {}", registPoint.getMP_CODE());
            log.info("MP_USERID >>> {}", registPoint.getMP_USERID());
            log.info("POINT {} >>> ", registPoint.getMP_AMOUNT());
            log.info("TITLE {} >>> ", registPoint.getMP_TITLE());
            log.info("ETITLE {} >>> ", registPoint.getMP_ETITLE());

            DateUtil dateUtil = new DateUtil();
            Date edate = dateUtil.getEXPDateyyyyMMddHHmmssAddMonth(dateUtil.getDateyyyyMMdd(), 6);

            registPoint.setMP_EDATE(edate);
            useResult += myPointRepository.registPointByUser(registPoint);
        }
        //return useResult;
    }

}
