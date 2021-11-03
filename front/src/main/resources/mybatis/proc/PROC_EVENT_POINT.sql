create PROCEDURE PROC_EVENT_POINT
    (pOrderNumber      IN VARCHAR2)
IS
    vOrderNumber VARCHAR2(70);
    vType CHAR(1);
    vPaymentDate DATE;
    vMemberId VARCHAR2(40);
    vAmount NUMBER;
    vPoint NUMBER;
    vTitle VARCHAR2(100);
    vTitleEn VARCHAR2(100);
    vTotalCount NUMBER;
    vCompleteCount NUMBER;

    EXPIRE_NOT_FOUND_EXCEPTION EXCEPTION ;
BEGIN
    -- ordersub.seq로 주문번호, 상품코드 가져오기.
    SELECT om_num, om_deliinouttype, om_ownerid, om_indate
    INTO vOrderNumber, vType, vMemberId, vPaymentDate
    FROM ordermain a INNER JOIN kfo_member b ON a.om_ownerid = TO_CHAR(b.id)
    WHERE om_num = pOrderNumber;

    -- 데이터 없으면 Pass.
    IF vOrderNumber IS NULL OR vType IS NULL OR vMemberId IS NULL OR vPaymentDate IS NULL THEN
        RAISE EXPIRE_NOT_FOUND_EXCEPTION;
    END IF;

    -- 해당 주문건의 전체 세부항목 건수와 완료 처리된 건수 가져오기
    SELECT COUNT(1)
        , NVL(SUM(CASE WHEN OS_STATUS IN (9, 40000, 400000, 50000, 500000) THEN 1 ELSE 0 END), 0)
    INTO   vTotalCount
        , vCompleteCount
    FROM ordersub
    WHERE os_type = 1                                       -- 1:주문 (2:배송)
        AND os_originalmoney != 0
        AND os_omnum = vOrderNumber
        AND os_indate >= to_date('20171201', 'YYYYMMDD');   -- 포인트 정책 시작일

    -- 모든 항목이 완료 처리 되었다면..
    IF vTotalCount - vCompleteCount = 0 THEN
        -- 결제금액 조회
        SELECT SUM(os_totsalemoney) - MAX(os_couponmoney) - MAX(os_pointmoney)
        INTO vAmount
        FROM ordersub
		WHERE os_type = 1
			AND os_originalmoney != 0
			AND os_omnum = vOrderNumber
    		AND os_status IN (9, 40000, 400000, 50000, 500000);

        -- 대상 이벤트 조회
        SELECT payment_price, event_title, event_title_en
        INTO vPoint, vTitle, vTitleEn
        FROM TB_KFO_ORD_EVENT
        WHERE use_yn = 'Y'
            AND event_type = 'P'
            AND order_type = vType
            AND over_price <= vAmount
            AND below_price >= vAmount
            AND event_start_date <= vPaymentDate
            AND event_end_date >= vPaymentDate;

         IF vPoint > 0 THEN
            INSERT INTO tb_kfo_mbs_point (mp_seq, mp_userid, mp_omnum, mp_type, mp_title, mp_etitle, mp_amount, mp_rest, mp_sdate, mp_edate)
            VALUES (SEQ_POINT_ID.NEXTVAL, vMemberId, vOrderNumber, 'G', vTitle, vTitleEn, vPoint, vPoint, SYSDATE, ADD_MONTHS(SYSDATE , 6) - 1);
         END IF;
    END IF;

    EXCEPTION
        -- 대상 주문이 없을 때!
        WHEN EXPIRE_NOT_FOUND_EXCEPTION THEN
            COMMIT;
END;