package com.kakaofriends.front.service.member.point;

import com.kakaofriends.front.domain.member.point.PointData;
import com.kakaofriends.front.domain.mypage.MyPointCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.repository.MyPointRepository;
import com.kakaofriends.front.repository.member.point.PointRepository;
import com.kakaofriends.front.service.member.point.vo.Point;
import com.kakaofriends.front.service.order.vo.OrderMain;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * PointService : MyPointService 이동 및 수정
 *
 * Author  april
 * Date    2018. 2. 5.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PointService {

    private MyPointRepository myPointRepository;
    private PointRepository pointRepository;

    /**
     * 포인트를 등록한다.
     *
     * @param point 포인트 정보
     */
    @Transactional
    public void add(Point point) {
        pointRepository.insert(this.converts(point));
    }

    /**
     * 포인트를 사용한다.
     *
     * @param memberId 포인트를 사용한 회원
     * @param orderNumber 포인트를 사용한 주문 번호
     * @param point 사용한 포인트 금액
     */
    @Transactional
    public void redeemPoint(long memberId, String orderNumber, BigDecimal point) {
        if (point.compareTo(BigDecimal.ZERO) > 0) {
            log.info("#### PARAM : memberId = {}, orderNumber = {}, point = {}", point);
            this.reduceRestPoint(memberId, point);
            this.addUsedPoint(memberId, orderNumber, point);
        }
    }

    @Transactional
    public void redeemPoint(OrderMain orderMain) {
        try {
            long memberId = Long.valueOf(orderMain.getMemberId());
            this.redeemPoint(memberId, orderMain.getOrderNumber(), orderMain.getPointMoney());
        } catch (NumberFormatException e) {
            log.debug("### memberId is not a number type : cannot use point");
        }
    }

    /**
     * 회원이 가진 남은 포인트를 차감한다.
     *
     * @param memberId 회원 아이디
     * @param point 차감할 포인트
     */
    @Transactional
    public void reduceRestPoint(long memberId, BigDecimal point) {
        BigDecimal usedPoint = point;
        List<TbKfoMbsPoint> pointList = myPointRepository.listAvailablePointByUser(String.valueOf(memberId));

        for (TbKfoMbsPoint one : pointList) {
            BigDecimal ownedPoint = BigDecimal.valueOf(one.getMP_REST());
            if ( usedPoint.compareTo(ownedPoint) > 0 ) { // 사용하는 포인트가 더 많으면
                usedPoint = usedPoint.subtract(ownedPoint);
                one.setMP_REST(0);
            } else { // 사용자가 가진 포인트가 더 많으면
                int rest = ownedPoint.subtract(usedPoint).intValue();
                one.setMP_REST(rest);
                usedPoint = BigDecimal.ZERO;
            }
            myPointRepository.modifyPointByUse(one);
        }
    }

    /**
     * 포인트 사용 내용을 등록한다.
     *
     * @param memberId 포인트를 사용한 회원
     * @param orderNumber 포인트를 사용한 주문 번호
     * @param usedPoint 사용한 포인트 금액
     */
    @Transactional
    public void addUsedPoint(long memberId, String orderNumber, BigDecimal usedPoint) {
        Point point = new Point();
        point.setMemberId(memberId);
        point.setOrderNumber(orderNumber);
        point.setStartDate(LocalDateTime.now());
        point.setEndDate(LocalDateTime.now());
        point.setType(MyPointCode.USE);
        point.setAmount(usedPoint.multiply(BigDecimal.valueOf(-1)));
        point.setRestAmount(BigDecimal.ZERO);
        this.add(point);
    }

    private PointData converts(Point point) {
        PointData data = new PointData();
        data.setMpSeq(point.getSequence());
        data.setMpUserId(point.getMemberId());
        data.setMpCode(point.getPointCode());
        data.setMpOmnum(point.getOrderNumber());
        data.setMpTitle(point.getTitle());
        data.setMpETitle(point.getEnglishTitle());
        data.setMpSDate(point.getStartDate());
        data.setMpEDate(point.getEndDate());
        data.setMpType(point.getType().getCode());
        data.setMpAmount(point.getAmount());
        data.setMpRest(point.getRestAmount());
        data.setMpLinkSeq(point.getSuperSequence());
        data.setRegDttm(point.getRegisteredDate());
        data.setUpdDttm(point.getUpdatedDate());
        return data;
    }

}
