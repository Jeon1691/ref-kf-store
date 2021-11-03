package com.kakaofriends.front.domain.member.point;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * PointData
 *
 * Author  april
 * Date    2018. 2. 5.
 */
@Data
public class PointData {
    private Long mpSeq;
    private Long mpUserId;
    private String mpCode;
    private String mpOmnum;
    private String mpTitle;
    private String mpETitle;
    private LocalDateTime mpSDate;
    private LocalDateTime mpEDate;
    private String mpType;
    private BigDecimal mpAmount;
    private BigDecimal mpRest;
    private Long mpLinkSeq;
    private LocalDateTime regDttm;
    private LocalDateTime updDttm;
}