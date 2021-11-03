/*
import org.json.simple.JSONObject;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;

public class RedisTest {

    public static void main(String[] arg) {
        Jedis jedis = new Jedis("localhost");
        LocalDateTime dateTime = LocalDateTime.now();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("area", "1");
        jsonObject.put("count", "1");
        jsonObject.put("key", dateTime);
        jsonObject.put("year", dateTime.getYear());
        jsonObject.put("month", dateTime.getMonthValue());
        jsonObject.put("day", dateTime.getDayOfMonth());
        jsonObject.put("hour", dateTime.getHour());
        System.out.println(jsonObject.toJSONString());
        jedis.set("testkey", "testvalue");
        String value = jedis.get("testkey");
        System.out.println(value);
    }

}
*/
