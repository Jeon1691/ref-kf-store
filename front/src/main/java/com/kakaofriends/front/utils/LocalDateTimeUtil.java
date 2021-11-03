package com.kakaofriends.front.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeUtil : LocalDateTime 과 관련된 도구들
 *
 * Author  april
 * Date    2018. 2. 6.
 */
public class LocalDateTimeUtil {

    private LocalDateTimeUtil() {
    }

    /**
     * 현재시간이 입력된 시간 내에 포함되는지 확인한다.
     * - 시작 시간이나 종료 시간이 입력되지 않았을 경우 무조건 false 를 반환한다.
     *
     * @param startDate 시작 시간
     * @param endDate 종료 시간
     * @return 현재 시간 포함 여부
     */
    public static boolean isTime(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null) {
            return false;
        }
        if (endDate == null) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(startDate) && now.isBefore(endDate);
    }

    /**
     * yyyy-MM-dd 형태의 날짜 정보를 LocalDateTime 으로 변환한다.
     *
     * @param yyyymmdd 날짜 정보 (yyyy-MM-dd)
     * @param maxTime  true = 59:59 / false = 00:00
     * @return 변환된 LocalDateTime 타입의 날짜 정보
     */
    public static LocalDateTime parse(String yyyymmdd, boolean maxTime){
        if(null == yyyymmdd ) return null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localdate = LocalDate.parse(yyyymmdd, dateTimeFormatter);
        LocalTime localTime;
        if (maxTime) {
            localTime = LocalDateTime.MAX.toLocalTime();
        } else {
            localTime = LocalDateTime.MIN.toLocalTime();
        }
        return LocalDateTime.of(localdate, localTime);
    }
}
