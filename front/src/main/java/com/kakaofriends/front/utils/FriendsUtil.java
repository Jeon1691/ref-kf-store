package com.kakaofriends.front.utils;

import com.daumcorp.commons.useragentutil.UserAgent;
import com.daumcorp.commons.useragentutil.UserAgentParser;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.domain.CategoryMenu;
import com.kakaofriends.front.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.NONMEMBER;

@Slf4j
public class FriendsUtil {

	public static String findByCategorySeq(List<CategoryMenu> categoryMenus, Long categorySeq) {
		Optional<CategoryMenu> categoryMenu = categoryMenus.stream().filter(e -> e.getCtSeq().equals(categorySeq)).findFirst();
		return categoryMenu.isPresent() ? categoryMenu.get().getCtName() : "전체 캐릭터";
	}

	public static String findByCategorySeqEn(List<CategoryMenu> categoryMenus, Long categorySeq) {
		Optional<CategoryMenu> categoryMenu = categoryMenus.stream().filter(e -> e.getCtSeq().equals(categorySeq)).findFirst();
		return categoryMenu.isPresent() ? categoryMenu.get().getCtEname() : "All Characters";
	}

	public static String processMessage(MessageSource messageSource, String message) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(message, null, currentLocale);
	}

	public static String processMessage(MessageSource messageSource, String message, Object[] objects) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(message, objects, currentLocale);
	}

    /**
     * 해외 문자 발송시 사용
     * countryCode = KR 로 국문//영문 구분을한다.
     * @param countryCode
     * @param messageSource
     * @param message
     * @param objects
     * @return
     */
    public static String processMessageByLocale(String countryCode, MessageSource messageSource, String message, Object[] objects) {
        Locale currentLocale = LocaleContextHolder.getLocale();

	    if(org.apache.commons.lang.StringUtils.isNotEmpty(countryCode) && !countryCode.equalsIgnoreCase("KR")) {
            currentLocale = Locale.ENGLISH;
        }

        return messageSource.getMessage(message, objects, currentLocale);
    }


	public static Member getFriendsMember() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		FrontUserDetail friendsUserDetails;
		friendsUserDetails = getAuthentication(authentication);
		return friendsUserDetails.getUser();
	}

	public static String getFriendsMemberId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			FrontUserDetail friendsUserDetails;
			friendsUserDetails = getAuthentication(authentication);
			if (friendsUserDetails.getUser().getEmail().equals(NONMEMBER)) {
				return RequestContextHolder.currentRequestAttributes().getSessionId();
			} else {
				//return friendsUserDetails.getUser().getEmail();
				return friendsUserDetails.getUser().getId().toString();
			}
		} else {
			return RequestContextHolder.currentRequestAttributes().getSessionId();
		}
	}

	public static Boolean isSocial() {
		return !StringUtils.isEmpty(getFriendsMember().getProviderId());
	}

	public static boolean isAnonymousUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			return true;
		}

		if (getFriendsMember() == null ||
				getFriendsMember().getEmail().equals(NONMEMBER)) {
			return true;
		} else
			return false;
	}

	public static String stringConcatPath(String... strings) {
		List<String> stringList = Arrays.asList(strings);
		return stringList.stream().map(i -> i.toString()).collect(Collectors.joining("/"));
	}

	public static final synchronized String getyyyyMMddHHmmss() {
		SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
		return yyyyMMddHHmmss.format(new Date());
	}

	public static LocalDate getOrderDate(String oId) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate date = LocalDate.parse(oId.replaceAll("[a-z,A-Z]", ""), dateTimeFormatter);
		return date;
	}

	public static String getSHA256Salt(String strData, String salt) {
		String SHA = "";

		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.reset();
			sh.update(salt.getBytes());
			byte byteData[] = sh.digest(strData.getBytes());

			sh.reset();
			byteData = sh.digest(byteData);

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			SHA = sb.toString();
			byte[] raw = SHA.getBytes();
			byte[] encodedBytes = org.apache.commons.codec.binary.Base64.encodeBase64(raw);
			SHA = new String(encodedBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}

		return SHA;
	}

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-DAUM-IP");
		if (ip == null) {
			ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

	public static UserAgent getUserAgent(HttpServletRequest request) {
		UserAgentParser userAgentParser = new UserAgentParser();
		UserAgent userAgent = userAgentParser.parse(request.getHeader("User-Agent"));
		return userAgent;
	}

	// 2018. 01. 11
	public static String getFriendsLocale(HttpServletRequest request) {
		String reqURI = request.getRequestURI();
		String langPath = reqURI.split("/")[1];
		String friendsLocale = (langPath.equalsIgnoreCase("kr") || langPath.equalsIgnoreCase("en") ?  langPath : "kr");

		return friendsLocale;
	}

    /**
     * 1, 3, 5 이벤트
     * 1만원 이상 무료 배송 날짜 체크 2017.08.31일까지 진행
     * @return
     */
	public static boolean getFreeDeliveryFlag() {
        LocalDate current = LocalDate.now();
        LocalDate startDate = LocalDate.of(2017, 9, 30);
        LocalDate endDate = LocalDate.of(2017, 10, 9);

        if((current.isEqual(startDate) || current.isAfter(startDate)) && (current.isEqual(endDate) || current.isBefore(endDate))) {
            return true;
        }
        return false;
    }

	private static FrontUserDetail getAuthentication(Authentication authentication) {
		FrontUserDetail friendsUserDetails = null;
		if (authentication == null) {
			friendsUserDetails = new FrontUserDetail(new Member());
			//friendsUserDetails.setUser(new Member());
			return friendsUserDetails;
		}
		if (authentication.getPrincipal() instanceof FrontUserDetail) {
			friendsUserDetails = (FrontUserDetail) authentication.getPrincipal();
		} else {
			friendsUserDetails = (FrontUserDetail) authentication.getDetails();
		}
		return friendsUserDetails;
	}

	public static Member getFriendsMemberOrderInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		FrontUserDetail friendsUserDetails = getAuthentication(authentication);
		Member reviseMember = new Member();
		reviseMember.setName(friendsUserDetails.getUser().getName());
		reviseMember.setCountry(friendsUserDetails.getUser().getCountry());
		reviseMember.setPhoneNumber(friendsUserDetails.getUser().getPhoneNumber());
		return reviseMember;
	}


	public static String getLanguagePath(Locale locale) {
		String returnUrl = "/kr";
		if (!locale.equals(Locale.KOREA)) {
			returnUrl = "/en";
		}
		return returnUrl;
	}
}