package com.kakaofriends.front.service.member.point.vo;

import com.kakaofriends.front.domain.mypage.MyPointCode;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Point : 포인트 정보를 가진 value object
 *
 * Author  april
 * Date    2018. 2. 5.
 */
@Data
public class Point {
    private Long sequence;
    private Long memberId;
    private String pointCode;
    private String orderNumber;
    private String title;
    private String englishTitle;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private MyPointCode type;
    private BigDecimal amount;
    private BigDecimal restAmount;
    private Long superSequence;
    private LocalDateTime registeredDate;
    private LocalDateTime updatedDate;
}
