package com.kakaofriends.core.utils;

import java.util.Arrays;
import java.util.List;

public class KakaoFriendsConstants {

    public static int pageIndex = 1;
    public static int pageUnit = 40;
    public static int pageUnitForArticle = 5;
    public static int pageUnitForOrders = 5;
    public static int pageUnitForCoupons = 3;
    public static int pageSize = 5;

    public static final String X_DAUM_IP = "X-Daum-IP";

    public static final long FRIENDS_CATEGORY_MENU_CACHE_EXPIRE_DURATION = 30L;
    public static final long FRIENDS_CATEGORY_MENU_CACHE_PERIOD = 10L;

    public static final long FRIENDS_INSTAGRAM_CACHE_EXPIRE_DURATION = 3L;
    public static final long FRIENDS_INSTAGRAM_CACHE_PERIOD = 1L;

    public static final String FRIENDS_CATEGORY_CACHE_NAME = "categoryMenu";
    public static final String FRIENDS_OFFICIAL_INSTAGRAM_CACHE_NAME = "friendsOfficialInstagram";
    public static final String FRIENDS_LAB_INSTAGRAM_CACHE_NAME = "friendsLabInstagram";
    public static final String FRIENDS_INSTAGRAM_DEFAULT_IMAGE_URL = "friendsLabInstagram";

    public static final long FRIENDS_CATEGORY_THEME_CODE = 103;

    public static final int HTTP_WAITING_TIME = 1000;

    public static final String CTA_OWNER_ID = "nonb2c";

    public static final String B2CGROUP = "b2cgroup";
    public static final String B2CPART = "b2cpart";

    public static final String NONB2C = "nonb2c";
    public static final String NONB2CPART = "nonb2cpart";
    public static final String NONMEMBER = "nonmember";

    // 4탭 대응을 위해서 추가 : E-mail 향식 체크 때문에 다음과 같이 함.
    public static final String KAKAOMEMBER = "@kakao.com";

    public static final String SUPPLY_COMPANY_CODE = "kakaologic";

    public static final int BASKET_MAX_COUNT = 99;
    public static final int BASKET_MAX_COUNT_GIFT_BAG = 3;

    public static final String KAKAO_FRIENDS_ORDER_NUMBER_PREFIX = "K";
    public static final String KAKAO_FRIENDS_ORDER_ADD_DELI_NUMBER_PREFIX = "A";
    public static final long KAKAO_FRIENDS_ORDER_PAYMENT_PERIOD = 7;

    public static final String BASKET_DIRECT_YES = "Y";
    public static final String BASKET_DIRECT_NO = "N";

    public static final String RECENT_PRODUCTS_COOKIE_NAME = "recentProducts";
    public static final long RECENT_PRODUCTS_COOKIE_LIMIT = 4L;

    public static final String KAKAO_FRIENDS_ENCODING = "UTF-8";

    public static final long RECENT_ORDER_ADDRESS_LIMIT = 3L;

    public static final long CATEGORY_MENU_NODE = 3L;

    public static final long MAIN_BESTNEW_DISPLAY_CNT = 8L;
    public static final long MAIN_BEST_DISPLAY_CNT = 8L; //노출갯수수정(요청) 2018.09.27 layla
    public static final long MAIN_THEME_DISPLAY_CNT = 8L;

    public static final Float KAKAO_HELLO_IE_VERSION = 9F;
    public static final String KAKAO_BYE_IE_PATH = "/common/ie8";

    public static final List<String> ENCODING_IGNORE_PATH = Arrays.asList( "/kr/order/inimobile/preturnurl", "/kr/order/inimobile/pnotiurl", "/kr/mypage/inimobile/preturnurladd", "/kr/mypage/inimobile/pnotiurladd", "/en/order/inimobile/preturnurl", "/en/order/inimobile/pnotiurl", "/en/mypage/inimobile/preturnurladd", "/en/mypage/inimobile/pnotiurladd" );

    public static final String KAKAOFRIENDS_ONLINESTORE_SESSION_COUNT = "kakaofriendsOnlineStoreSessionCount";

    public static final List<String> PAYMENT_ALLOW_IP = Arrays.asList( "118.129.210.57", "211.219.96.166", "175.126.74.136", "211.219.96.165", "118.129.210.25" );

    public static final String PRODUCT_TYPE_CUSTOM_PRODUCT = "7";
    public static final String PRODUCT_TYPE_GIFT_BAG = "8";
    public static final String PRODUCT_TYPE_EVENT_PRODUCT = "9";

    public static final String ORDER_SESSION_CHECK_KEY = "order";
    public static final String ORDER_SESSION_CHECK_VALUE = "order_session_check";


    public static final String KAKAO_AGENT_KEY = "kakaotalk-agent";
    public static final String KAKAO_USER_AGENT_KEY = "kakaotalk";
    public static final String KAKAO_WEB_VIEW = "kakaoWebView";

    public static final int KAKAO_WEB_VIEW_NONE = 0;
    public static final int KAKAO_WEB_VIEW_COMMON = 1;
    public static final int KAKAO_WEB_VIEW_4TAB = 2;

    public static final String KAKAO_REDIRECT_URL = "kakaoRedirectUrl";

    public static final String KAKAO_ERROR = "error";
    public static final String KAKAO_ERROR_DESC = "error_description";
    public static final String KAKAO_DISABLE_APPROVAL_WINDOW = "disable_approval_window";
    public static final String KAKAO_NOT_CONNECTED_USER = "NOT_CONNECTED_USER";

    public static final String KAKAO_AUTH_AFTER_REDIRECT_URL = "kakao_auth_after_redirect_url";

    public static final String KAKAO_SSO_MODE = "kakao_sso_mode";

    public static final int KAKAO_SSO_MODE_WITHDRAW_PERIOD_REMAIN = 111;
    public static final int KAKAO_SSO_MODE_NOT_CONNECTED_USER = 222;


}
