package com.kakaofriends.front.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dave on 2017. 6. 29..
 */

@Slf4j
public class DateUtil {

    public String getDateyyyyMMddHHmm(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return dateFormat.format(new Date(System.currentTimeMillis()));
    }

    public String getDateyyyyMMddHH(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        return dateFormat.format(new Date(System.currentTimeMillis()));
    }

    public String getDateyyyyMMdd(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date(System.currentTimeMillis()));
    }

    public String getDateHH(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        return dateFormat.format(new Date(System.currentTimeMillis()));
    }

    /*
    만료날짜 구하기 (MONTH)
    indate : 20171109
    month: 2

    return 20180108 23:59:59
     */
    public Date getEXPDateyyyyMMddHHmmssAddMonth(String indate, int month){
        SimpleDateFormat yyyyMMddFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat returnFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = new Date();
        try {
//            LocalDateTime localDate = LocalDateTime.parse("indate", DateTimeFormatter.BASIC_ISO_DATE);
//            localDate.plusMonths(month);
//            localDate.minusDays(1);
            date = yyyyMMddFormat.parse(indate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, month);
            cal.add(Calendar.DATE, -1);
            date = returnFormat.parse(yyyyMMddFormat.format(cal.getTime()) + " 23:59:59");
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
