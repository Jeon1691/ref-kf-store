package com.kakaofriends.front.utils;

import java.util.Random;

/**
 * Created by Dave on 2017. 7. 5..
 */
public class StringUtils {

    public static String lpad(String str, int length){

        if(str.length() < length){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<length-str.length(); i++){
                stringBuilder.append(0);
            }
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return str;
    }

    /**
     * 난수 생성 2017.10.31 Breeze
     * @param length
     * @return
     */
    public static String generateNumber(int length) {

        String numStr = "1";
        String plusNumStr = "1";

        for (int i = 0; i < length; i++) {
            numStr += "0";

            if (i != length - 1) {
                plusNumStr += "0";
            }
        }

        Random random = new Random();
        int result = random.nextInt(Integer.parseInt(numStr)) + Integer.parseInt(plusNumStr);

        if (result > Integer.parseInt(numStr)) {
            result = result - Integer.parseInt(plusNumStr);
        }

        return String.valueOf(result);
    }

    /**
     * 귀찮아서 org.apache.commons.lang3.StringUtils 에서 가져옴. 2017.11.12 Breeze
     * Check Empty
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    /**
     * 귀찮아서 org.apache.commons.lang3.StringUtils 에서 가져옴. 2017.11.12 Breeze
     * Check Not Empty
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }
}
