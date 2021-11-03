create PROCEDURE USP_ORDERCONFIRMJOB (
  p_rdate IN varchar2
) is
  v_cf_value varchar(10);
  v_cf_order_confirm_yn varchar(10);
  v_cf_savemoney_time varchar(10);
  v_cf_savemoney_use varchar(10);
  v_osh_cnt number;
  v_saveMondy_add number;
begin
  -- ???? ???? ??? ?????.
  select cf_value into v_cf_order_confirm_yn from config where cf_id = 'ORDER_CONNFIRM_YN';
  if v_cf_order_confirm_yn = 'Y' then

    -- ????? ????.
    select cf_value into v_cf_value from config where cf_id = 'CALCULATE_DIV';
    DBMS_OUTPUT.PUT_LINE('v_cf_value = ' || v_cf_value);

    -- ??? ????
    select cf_value into v_cf_savemoney_use from config where cf_id = 'SAVEMONEYUSE';

    -- ??? ????(1:???????,2:???????)
    select cf_value into v_cf_savemoney_time from config where cf_id = 'SAVEMONEYTIME';

    /*
    -- ?? ????? ??? ????.
    declare cursor mainCursor is
        select OS_SEQ, OS_OMNUM, OS_SERIAL, OS_NEWSAVEMONEY, OS_NEWPRSAVEMONEY, OS_OWNERID from ORDERSUB WHERE OS_STATUS = 8;
    begin
      for mainRecord in mainCursor loop
        exit when mainCursor%notfound;

        -- ? ??? ????? ??? ?????? 15? ???? ??.
        SELECT COUNT(*) into v_osh_cnt FROM ORDERSUBHISTORY
        WHERE OSH_OMNUM = mainRecord.OS_OMNUM AND OSH_OSSERIAL = mainRecord.OS_SERIAL AND OSH_OSSTATUS = 8 AND TO_CHAR(OSH_INDATE + 15, 'YYYYMMDD') <= p_rdate;
        DBMS_OUTPUT.PUT_LINE('v_osh_cnt = ' || v_osh_cnt);

        -- 15?? ????
        if v_osh_cnt > 0 then

          -- ????? ?????? ?? ?? ?? ??? ???? ???.
          if v_cf_value = '9' then
            insert into sales (
              SS_SEQ, SS_OMNUM, SS_OSSERIAL, SS_SCPCODE, SS_BCPCODE
              , SS_MBID, SS_CARDMONEY, SS_COUPONMONEY, SS_LATERMONEY, SS_BUDGETMONEY
              , SS_SAVEMONEY, SS_POINTMONEY, SS_VIRTUALACCOUNTMONEY, SS_ORIGINALMONEY, SS_SALEMONEY
              , SS_TOTORIGINALMONEY, SS_TOTSALEMONEY, SS_CALCULATEBUSE, SS_CALCULATESUSE, SS_INID
              , SS_INDATE, SS_ACCOUNTMONEY, SS_MONEYUNIT, SS_DPCODE
            )
            select
              (select nvl(max(ss_seq),0)+1 from sales), os_omnum, OS_SERIAL, os_scpcode, os_bcpcode
              , os_ownerid, os_cardmoney, OS_COUPONMONEY, OS_LATERMONEY, OS_BUDGETMONEY
              , os_savemoney, os_pointmoney, OS_VIRTUALACCOUNTMONEY, OS_ORIGINALMONEY, OS_SALEMONEY
              , OS_TOTORIGINALMONEY, OS_TOTSALEMONEY, 'N', 'N', 'System'
              , SYSDATE, OS_ACCOUNTMONEY, 'won', OS_BDPCODE
            from ordersub where os_seq = mainRecord.OS_SEQ;

            -- ???? ????? ???? ??????.
            if v_cf_savemoney_use = '1' then
              v_saveMondy_add := 0;
              if v_cf_savemoney_time = '1' then
                v_saveMondy_add := mainRecord.OS_NEWSAVEMONEY;
              elsif v_cf_savemoney_time = '1' then
                v_saveMondy_add := mainRecord.OS_NEWPRSAVEMONEY;
              end if;

              if v_saveMondy_add > 0 then
                -- ???? ????.
                update member
                set MB_SAVEMONEY = MB_SAVEMONEY + v_saveMondy_add
                where mb_id = mainRecord.OS_OWNERID;

                -- ??? ????.
                insert into CYBERMONEY (
                  CY_SEQ, CY_OWNERID, CY_DESCRIPTION, CY_OMNUM, CY_OSSERIAL
                  , CY_MONEY, CY_USETYPE, CY_TYPE, CY_INID, CY_INDATE
                )
                values (
                  (select nvl(max(CY_SEQ),0)+1 from CYBERMONEY), mainRecord.OS_OWNERID, '??????', mainRecord.OS_OMNUM, mainRecord.OS_SERIAL
                  , v_saveMondy_add, '1', '1', 'System', SYSTIMESTAMP
                );
              end if;
            end if;
          end if;

          -- ??? ????? ????.
          insert into ORDERSUBHISTORY (
            OSH_SEQ, OSH_OMNUM, OSH_OSSERIAL, OSH_MEMO, OSH_OSSTATUS
            , OSH_INID, OSH_INDATE
          )
          values (
            ORDERSUB_HISTORY_SEQ.NEXTVAL, mainRecord.OS_OMNUM, mainRecord.OS_SERIAL, '??? ????', 9
            , 'System', SYSTIMESTAMP
          );

          -- ??? ?????? ???
          update ORDERSUB set OS_STATUS = 9, OS_MOID = 'System', OS_MODATE = SYSTIMESTAMP where os_seq = mainRecord.OS_SEQ;

        end if;
      end loop;
    end;

    commit;
    */
  end if;
end USP_ORDERCONFIRMJOB;