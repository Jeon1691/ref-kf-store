create or replace PROCEDURE PROC_GIVE_POINT
    (pSeq      IN VARCHAR2)
IS
    vOrderNumber VARCHAR2(70);
    vProductCode VARCHAR2(50);
    vMemberId VARCHAR2(40);
    vAmount Number;
    vPoint Number;
    vTotalCount Number;
    vCompleteCount Number;

    EXPIRE_NOT_FOUND_EXCEPTION EXCEPTION ;
BEGIN
    -- ordersub.seq로 주문번호, 상품코드 가져오기.
    SELECT os_omnum, os_prcode, os_ownerid
    INTO vOrderNumber, vProductCode, vMemberId
    FROM ordersub a INNER JOIN kfo_member b ON a.os_ownerid = TO_CHAR(b.id)
    WHERE os_seq = pSeq;

    -- 데이터 없으면 Pass.
    IF vOrderNumber IS NULL OR vProductCode IS NULL OR vMemberId IS NULL THEN
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
        AND os_prcode = vProductCode
        AND os_indate >= to_date('20171201', 'YYYYMMDD');   -- 포인트 정책 시작일

    -- 모든 항목이 완료 처리 되었다면..
    IF vTotalCount - vCompleteCount = 0 THEN
        -- 결제금액 조회
        SELECT SUM(os_totsalemoney) - MAX(os_couponmoney) - MAX(os_pointmoney)
        INTO vAmount
        FROM ordersub
		WHERE os_type = 1
			AND os_originalmoney != 0
			AND os_omnum = vordernumber
			AND os_prcode = vproductcode
    		AND os_status IN (9, 40000, 400000, 50000, 500000);

         IF vAmount > 0 THEN
            -- 결제금액의 3%를 포인트로 부여(반올림)
            vPoint := ROUND(vAmount * 0.03);

            INSERT INTO tb_kfo_mbs_point (mp_seq, mp_userid, mp_omnum, mp_type, mp_amount, mp_rest, mp_sdate, mp_edate, upd_dttm)
            VALUES (SEQ_POINT_ID.NEXTVAL, vMemberId, vOrderNumber, 'O', vPoint, vPoint, SYSDATE, ADD_MONTHS(SYSDATE , 6) - 1, SYSDATE);
         END IF;
    END IF;

    EXCEPTION
        -- 대상 주문이 없을 때!
        WHEN EXPIRE_NOT_FOUND_EXCEPTION THEN
            COMMIT;
END;