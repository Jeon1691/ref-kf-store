package com.kakaofriends.core.utils;

import com.daumcorp.commons.useragentutil.UserAgent;
import com.daumcorp.commons.useragentutil.UserAgentParser;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.maxmind.geoip.Country;
import com.maxmind.geoip.LookupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

@Slf4j
public class KakaoFriendsUtil {

    private static UserAgentParser userAgentParser = new UserAgentParser();
    private static Pattern mailPattern = Pattern.compile("(?<=.).(?=[^@]*?.@)");

    public static UserAgent getUserAgent(HttpServletRequest request) {
        UserAgent userAgent = userAgentParser.parse(request.getHeader("User-Agent"));
        return userAgent;
    }

    public static Country getCountry(String ipAddress, File file) {
        try {
            LookupService lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
            return lookup.getCountry(ipAddress);
        } catch (IOException exception) {
            log.error("Stack Trace", exception);
            return null;
        }
    }

    public static PaginationInfo getPaginationInfo(Integer totCnt, int pageIndex, Integer pageUnit, Integer pageSize) {
        PaginationInfo pagination = new PaginationInfo();
        pagination.setTotalRecordCount(totCnt);
        pagination.setCurrentPageNo(pageIndex);
        pagination.setRecordCountPerPage(pageUnit);
        pagination.setPageSize(pageSize);
        return pagination;
    }

    public static String getOrderNumber(String prefix) {
        String nowDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String date = nowDateTime.substring(2, nowDateTime.length());

        // 0001~9999 랜덤 숫자 생성
        int randomValue = new Random().nextInt(9999 - 1) + 1;
        DecimalFormat myFormatter = new DecimalFormat("#0000");
        String result = myFormatter.format(randomValue);

        return prefix + date + result;
    }

    public static String maskPhone(String phoneNum) {
        if (StringUtils.isEmpty(phoneNum)) return null;
        String plainPhoneNum = StringUtils.remove(phoneNum, "-");
        return StringUtils.replaceOnce(plainPhoneNum, StringUtils.substring(plainPhoneNum, 3, 7), "-****-");
    }

    public static String maskMail(String mail) {
        return StringUtils.isEmpty(mail) ? null : mailPattern.matcher(mail).replaceAll("*");
    }

    public static String maskName(String name) {
        if (StringUtils.isEmpty(name)) return null;
        return StringUtils.replaceOnce(name, StringUtils.substring(name, 1, 2), "*");
    }

    public static String httpEntity(HttpServletRequest request, String url, HttpMethod method, MultiValueMap<String, Object> map) throws Exception {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(30000);
        clientHttpRequestFactory.setReadTimeout(30000);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String response = StringUtils.EMPTY;

        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = (String) enums.nextElement();
            String[] parameters = request.getParameterValues(paramName);

            // Parameter가 배열일 경우
            if (parameters.length > 1) {
                map.set(paramName, parameters);
                // Parameter가 배열이 아닌 경우
            } else {
                map.set(paramName, parameters[0]);
            }
        }

        return restTemplate.postForObject(url, map, String.class);
    }

    // pay only - start
    public static Set<Long> getPayOnlyDispCodes() {
        Set<Long> payOnlyDispCodes = new HashSet<>(Arrays.asList(
        ));
        Runnable productsFor14th = () -> {
            payOnlyDispCodes.add(5155L);
        };
        Runnable productsFor15th = () -> {
            payOnlyDispCodes.add(5159L);
        };

        KakaoFriendsUtil.addConditionalPayOnlyItem(productsFor14th, productsFor15th, () -> {
            // 개발용 제품 코드
        });

        return payOnlyDispCodes;
    }

    private static void addConditionalPayOnlyItem(Runnable r1, Runnable r2, Runnable r3) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");

        try {
            Date current = new Date();
            Date startDate1 = sdf.parse("2018-12-14 00:00:00");
            Date endDate1 = sdf.parse("2018-12-15 00:00:00");

            if (current.compareTo(startDate1) > 0 && current.compareTo(endDate1) < 0) {
                if (r1 != null ) {
                    r1.run();
                }
            }

            Date startDate2 = sdf.parse("2018-12-15 00:00:00");
            Date endDate2 = sdf.parse("2028-12-15 00:00:00");

            if (current.compareTo(startDate2) > 0 && current.compareTo(endDate2) < 0) {
                if (r2 != null ) {
                    r2.run();
                }
            }

            // 개발용 타이머
            Date startDate3 = sdf.parse("2018-12-13 22:30:00");
            Date endDate3 = sdf.parse("2018-12-13 23:59:59");

            log.debug( "current = " + current );
            log.debug( "startDate3 = " + startDate3 );
            log.debug( "endDate3 = " + endDate3 );

            if (current.compareTo(startDate3) > 0 && current.compareTo(endDate3) < 0) {
                if (r3 != null ) {
                    r3.run();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPayOnlyDispCode(Long dispcode) {
        Set<Long> payOnlyDispCodes = KakaoFriendsUtil.getPayOnlyDispCodes();

        return payOnlyDispCodes.contains(dispcode);
    }

    public static Set<String> getPayOnlyPrcodes() {
        Set<String> payOnlyPrcodes = new HashSet<>();

        Runnable productsFor14th = () -> {
            payOnlyPrcodes.add("FRPBRYKMC0007");
            payOnlyPrcodes.add("FRPBAPKMC0005");
            payOnlyPrcodes.add("FRPBMZKMC0005");
            payOnlyPrcodes.add("FRPBRYKMC0008");
            payOnlyPrcodes.add("FRPBRYKMC0009");
            payOnlyPrcodes.add("FRPBFRKMC0005");
            payOnlyPrcodes.add("FRPBNEKMC0005");
        };
        Runnable productsFor15th = () -> {
            payOnlyPrcodes.add("FRPBRYKMC0010");
            payOnlyPrcodes.add("FRPBAPKMC0006");
            payOnlyPrcodes.add("FRPBMZKMC0006");
            payOnlyPrcodes.add("FRPBRYKMC0011");
            payOnlyPrcodes.add("FRPBRYKMC0012");
            payOnlyPrcodes.add("FRPBFRKMC0006");
            payOnlyPrcodes.add("FRPBNEKMC0006");
        };

        KakaoFriendsUtil.addConditionalPayOnlyItem(productsFor14th, productsFor15th, () -> {
            // 개발용 제품 코드
        });

        log.debug( "payOnlyPrcodes : " + payOnlyPrcodes );

        return payOnlyPrcodes;
    }

    public static boolean isPayOnlyPrcode(String prcode) {
        Set<String> payOnlyPrcodes = KakaoFriendsUtil.getPayOnlyPrcodes();

        return payOnlyPrcodes.contains(prcode);
    }
    // pay only - end
}
