package com.kakaofriends.front.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class RedisController {

    @Value("${redis.host}")
    private String redisHostIP;

    @Value("${redis.password}")
    private String redisHostPassword;

    /**
     * 메인 클릭 수 카운팅
     * @param area
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/area/counting")
    public String mainAreaCounting(String area, String localeVal) {
        /*
        * 예) "newProduct2|2017-06-22T23:39:00.881|en" (영역 | 시간 | 페이지언어)
             "{\"area\":\"rolling1\",\"month\":6,\"hour\":21,\"year\":2017,\"count\":\"1\",\"day\":22,\"key\":2017-06-22T21:24:56.512}"
        * redis 에 저장 되는 키 value
        * rolling : 상단 롤링 배너
        * mainCardNormal : 이벤트배너보통크기
        * mainCardWide : 이벤트배너넓은크기
        * newProduct : 신상품
        * characterNum1 : 라이언배너
        * characterNum2 : 어피치배너
        * characterNum3 : 프로도배너
        * characterNum4 : 네오배너
        * characterNum5 : 무지배너
        * characterNum6 : 콘배너
        * characterNum7 : 튜브배너
        * characterNum8 : 제이지배너
        * bestProduct : 인기상품
        * mainBand : 밴드형배너
        * ryan : 라이언추천
        * apeach : 어피치추천
        * frodo : 프로도추천
        * neo : 네오추천
        * muzi : 무지추천
        * tube : 튜브추천
        * jayg : 제이지추천
        * */
        try {
            Jedis jedis = new Jedis(redisHostIP);
            if(StringUtils.isNotEmpty(redisHostPassword)) {
                jedis.auth(redisHostPassword);
            }
            LocalDateTime dateTime = LocalDateTime.now();
            JSONObject jsonObject = getValue(area, dateTime);
            jedis.set(area + "|" + dateTime.toString() + "|" + localeVal, jsonObject.toJSONString());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 입력값 데이터 정리
     * @param area
     * @param dateTime
     * @return
     */
    private JSONObject getValue(String area, LocalDateTime dateTime) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("area", area);
        jsonObject.put("count", "1");
        jsonObject.put("key", dateTime);
        jsonObject.put("year", dateTime.getYear());
        jsonObject.put("month", dateTime.getMonthValue());
        jsonObject.put("day", dateTime.getDayOfMonth());
        jsonObject.put("hour", dateTime.getHour());
        return  jsonObject;
    }

    /**
     * 메인접속수저장
     * @return
     */
    public String accessCountring() {
        try {
            Jedis jedis = new Jedis(redisHostIP);
            if(StringUtils.isNotEmpty(redisHostPassword)) {
                jedis.auth(redisHostPassword);
            }
            LocalDateTime dateTime = LocalDateTime.now();
            String keyStr = String.valueOf(dateTime.getYear())+"-"+String.valueOf(dateTime.getMonthValue())+"-"+String.valueOf(dateTime.getDayOfMonth());
            String count = (jedis.get(keyStr) == null ? "0" : jedis.get(keyStr));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("accessCount", String.valueOf(Double.parseDouble(count)+1));
            jedis.set(keyStr, String.valueOf(Double.parseDouble(count)+1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
