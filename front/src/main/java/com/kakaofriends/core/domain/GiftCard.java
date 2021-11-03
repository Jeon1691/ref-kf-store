package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Deprecated
public class GiftCard implements Serializable {
    private static final long serialVersionUID = -8221464729190164105L;
    private String gcCode;
    private List<String> gcCodeArr;
    private String gcGcmCode;
    private String gcUseFlag;
    private int gcPrice;
    private Date gcSDate;
    private Date gcEDate;
    private String gcPhone;
    private int gcMmsCnt;
    private String gcUse;
    private int gcExtCnt;
    private String gcName;
    private String gcEmail;
    private Date gcUseDate;
    private Date gcInDate;
    private Date gcMoDate;
    private String gcInId;
    private String gcMoId;
    private String gcOmNum;
    private String gcCal;
    private String gcReason;
    private int gcResetCnt;
    private Date gcExtDate;
    private Date gcStopDate;

    /**
     * 사용전
     */
    public static String GC_TYPE_STATE_USE_BEFORE = "1";

    /**
     * 사용 중지
     */
    public static String GC_TYPE_STATE_USE_STOP = "2";

    /**
     * 사용 완료
     */
    public static String GC_TYPE_STATE_USE_COMPLETE = "3";

    /**
     * 온라인 쿠폰 등록 완료(지류 쿠폰)
     */
    public static String GC_TYPE_STATE_USE_REGISTRATION = "4";

    /**
     * 온라인 쿠폰 재적립
     */
    public static String GC_TYPE_STATE_USE_RETURN = "6";
}