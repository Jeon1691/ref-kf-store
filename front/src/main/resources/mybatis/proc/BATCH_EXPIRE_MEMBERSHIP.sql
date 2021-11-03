create PROCEDURE BATCH_EXPIRE_MEMBERSHIP
    (pDate      IN VARCHAR2 DEFAULT to_char(SYSDATE, 'yyyymmdd')
    , pPeriod   IN NUMERIC  DEFAULT 1)
IS
    TYPE t_gcCode IS TABLE OF giftcard.gc_code%TYPE;
    l_gcCode t_gcCode;
    message VARCHAR2(300);

    EXPIRE_NOT_FOUND_EXCEPTION EXCEPTION ;
BEGIN
    message := 'DATE : ' || pDate || ', PERIOD : ' || pPeriod;

    INSERT INTO TB_KFO_MBS_POINT (
            MP_SEQ,
            MP_USERID,
            MP_CODE,
            MP_OMNUM,
            MP_TITLE,
            MP_ETITLE,
            MP_SDATE,
            MP_EDATE,
            MP_TYPE,
            MP_AMOUNT,
            MP_REST,
            REG_DTTM,
            MP_LINK_SEQ
        ) (SELECT SEQ_POINT_ID.NEXTVAL,
                MP_USERID,
                MP_CODE,
                MP_OMNUM,
                MP_TITLE,
                MP_ETITLE,
                MP_SDATE,
                MP_EDATE,
                'P' MP_TYPE,
                MP_REST * (-1) MP_AMOUNT,
                MP_REST * (-1) MP_REST,
                SYSDATE REG_DTTM,
                MP_SEQ
            FROM TB_KFO_MBS_POINT a
            WHERE MP_TYPE IN ('C', 'G', 'O')
                AND MP_REST != 0
                AND MP_EDATE >= TO_DATE(pDate, 'YYYYMMDD') - pPeriod
                AND MP_EDATE < TO_DATE(pDate, 'YYYYMMDD')
                AND NOT EXISTS(SELECT 'X' FROM TB_KFO_MBS_POINT b WHERE a.mp_seq = b.mp_link_seq));

    -- 만료 포인트 결과 메세지 추가
    message := message || ', POINT_COUNT : ' || SQL%ROWCOUNT;

    UPDATE  giftcard
    SET     gc_use = '5'
    WHERE   gc_use IN (1,4)
        AND gc_edate >= TO_DATE(pDate, 'YYYYMMDD') - pPeriod
        AND gc_edate < TO_DATE(pDate, 'YYYYMMDD')
        AND gc_userid IS NOT NULL
    RETURNING gc_code BULK COLLECT INTO l_gcCode;

    -- 만료 쿠폰 결과 메세지 추가
    message := message || ', COUPON_COUNT :' || SQL%ROWCOUNT;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE EXPIRE_NOT_FOUND_EXCEPTION;
    END IF;

    FOR i IN l_gcCode.first .. l_gcCode.last LOOP
         INSERT INTO TB_KFO_MBS_COUPON_HISTORY (
            CPH_SEQ,
            CPH_GCMCODE,
            CPH_CODE,
            CPH_PRICE,
            CPH_SDATE,
            CPH_EDATE,
            CPH_USE,
            REG_DTTM,
            REG_USER,
            CPH_USERID,
            CPH_TYPE,
            CPH_LEVEL,
            CPH_DUPLICATION,
            CPH_OPTION_TYPE,
            CPH_OPTION_VALUE,
            CPH_NAME,
            CPH_ENAME,
            CPH_OPTION_CATEGORY,
            CPH_USEDATE,
            CPH_REGISTDATE
        ) ( SELECT
                SEQ_COUPON_HISTORY_ID.NEXTVAL,
                GC.GC_GCMCODE,
                GC.GC_CODE,
                GC.GC_PRICE,
                GC.GC_SDATE,
                GC.GC_EDATE,
                '5',
                GC.GC_INDATE,
                GC.GC_INID,
                GC.GC_USERID,
                GCM.GCM_TYPE,
                GCM.GCM_LEVEL,
                GCM.GCM_DUPLICATION,
                GCM.GCM_OPTION_TYPE,
                GCM.GCM_OPTION_VALUE,
                GCM.GCM_GOAL,
                GCM.GCM_EGOAL,
                GCM.GCM_OPTION_CATEGORY,
                GC.GC_USEDATE,
                GC.GC_REGISTDATE
            FROM GIFTCARDMASTER GCM
                LEFT JOIN GIFTCARD GC ON GCM.GCM_CODE = GC.GC_GCMCODE
            WHERE GC.gc_code = l_gcCode(i)
          );
    END LOOP;

    -- 결과 저장
    INSERT INTO BATCH_HISTORY (METHOD, RESULT, MESSAGE) VALUES ('BATCH_EXPIRE_MEMBERSHIP', '1', message);

    EXCEPTION
        -- 만료 쿠폰 없을 때!
        WHEN EXPIRE_NOT_FOUND_EXCEPTION THEN
            COMMIT;
            INSERT INTO BATCH_HISTORY (METHOD, RESULT, MESSAGE) VALUES ('BATCH_EXPIRE_MEMBERSHIP', '1', message);
        -- 그 외 모든 Exception 발생 시!!!
        WHEN OTHERS THEN
            ROLLBACK;
            message := message || ', EXCEPTION : ' || SUBSTR(DBMS_UTILITY.format_error_stack, 0, 250);
            INSERT INTO BATCH_HISTORY (METHOD, RESULT, MESSAGE) VALUES ('BATCH_EXPIRE_MEMBERSHIP', '0', message);

END;