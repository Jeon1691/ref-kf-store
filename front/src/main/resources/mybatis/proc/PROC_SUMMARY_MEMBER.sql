create PROCEDURE PROC_SUMMARY_POINT
    (pDate      IN VARCHAR2 DEFAULT to_char(SYSDATE, 'yyyymmdd')
    , pCur OUT SYS_REFCURSOR)
IS
    vTotal NUMBER;      -- 전체
    vUse NUMBER;        -- 사용
    vRe NUMBER;         -- 재적립
    vEarn NUMBER;       -- 주문 적립
    vGift NUMBER;       -- 이벤트 적립
    vPassing NUMBER;    -- 소멸

    vUseYesterday NUMBER;        -- 사용
    vReYesterday NUMBER;         -- 재적립
    vEarnYesterday NUMBER;       -- 주문 적립
    vGiftYesterday NUMBER;       -- 이벤트 적립
    vPassingYesterday NUMBER;    -- 소멸

BEGIN

    SELECT NVL(SUM(DECODE(mp_type, 'U', ABS(MP_AMOUNT), 0)), 0) AS use_point
        , NVL(SUM(DECODE(mp_type, 'C', ABS(MP_AMOUNT), 0)), 0) AS re_point
        , NVL(SUM(DECODE(mp_type, 'O', ABS(MP_AMOUNT), 0)), 0) AS earn_point
        , NVL(SUM(DECODE(mp_type, 'G', ABS(MP_AMOUNT), 0)), 0) AS gift_point
        , NVL(SUM(DECODE(mp_type, 'P', ABS(MP_AMOUNT), 0)), 0) AS passing_point
    INTO vUse, vRe, vEarn, vGift, vPassing
    FROM tb_kfo_mbs_point
    WHERE REG_DTTM < to_date(pDate, 'yyyymmdd') + 1;

    SELECT NVL(SUM(DECODE(mp_type, 'U', ABS(MP_AMOUNT), 0)), 0) AS use_point
        , NVL(SUM(DECODE(mp_type, 'C', ABS(MP_AMOUNT), 0)), 0) AS re_point
        , NVL(SUM(DECODE(mp_type, 'O', ABS(MP_AMOUNT), 0)), 0) AS earn_point
        , NVL(SUM(DECODE(mp_type, 'G', ABS(MP_AMOUNT), 0)), 0) AS gift_point
        , NVL(SUM(DECODE(mp_type, 'P', ABS(MP_AMOUNT), 0)), 0) AS passing_point
    INTO vUseYesterday, vReYesterday, vEarnYesterday, vGiftYesterday, vPassingYesterday
    FROM tb_kfo_mbs_point
    WHERE REG_DTTM >= to_date(pDate, 'yyyymmdd') - 1
        AND REG_DTTM < to_date(pDate, 'yyyymmdd');

    -- 결과 출력
    OPEN pCur FOR
        SELECT pDate || ' ' || SUM(vEarn + vGift) || ' ' || vEarn || ' ' || vEarnYesterday ||' ' || vGift || ' ' || vGiftYesterday || ' ' ||
            SUM(vUse - vRe) || ' ' || SUM(vUseYesterday - vReYesterday) ||' ' || vPassing ||' ' || vPassingYesterday
        FROM DUAL;
END;