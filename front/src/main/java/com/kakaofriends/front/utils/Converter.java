package com.kakaofriends.front.utils;

/**
 * Converter
 *
 * Author  april
 * Date    2018. 1. 22.
 */
public class Converter {

    /**
     * "Y" 또는 "N" 값을 boolean 타입으로 변환해준다.
     * - "Y"는 true, 그 이외의 값은 false 를 반환한다.
     * - null이 입력되는 경우에는 false 를 반환한다.
     *
     * @param ynString Y 또는 N
     * @return boolean value
     */
    public static boolean convertToBoolean(String ynString) {
        return "Y".equalsIgnoreCase(ynString);
    }

    /**
     * boolean 타입의 값을 "Y" 또는 "N" 문자열로 변환해준다.
     * - true 는 "Y"를 반환한다.
     * - false 는 "N"을 반환한다.
     *
     * @param value boolean value
     * @return String "Y" or "N"
     */
    public static String convertToString(boolean value) {
        if (value) {
            return "Y";
        } else {
            return "N";
        }
    }

    /**
     * boolean 타입의 값을 "Y" 또는 "N" 문자열로 변환해준다.
     * - true 는 "Y"를 반환한다.
     * - false 는 "N"을 반환한다.
     * - null 은 null 을 반환한다.
     *
     * @param value boolean value
     * @return String "Y" or "N"
     */
    public static String convertToString(Boolean value) {
        if (value != null) {
            return convertToString(value.booleanValue());
        } else {
            return null;
        }
    }
}
