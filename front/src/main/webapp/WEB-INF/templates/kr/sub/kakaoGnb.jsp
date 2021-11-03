<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />
<c:set value="${pageContext.request.requestURL}" var="URL" />
<c:set value="${pageContext.request.requestURI}" var="URI" />
<c:set value="${fn:replace(URL, URI, '')}" var="domain" />
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath" />
<c:set value="${kakaoWebView > 0 && requestPath ne '/kr/index'}" var="isKakaoNotMain" />
<c:set value="${kakaoWebView > 0 && requestPath eq '/kr/signup'}" var="isSignup" />
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString" />
<c:set value="${isSync}" var="isSync"/>
<c:set value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}" var="language" />
<spring:eval expression="@environment['sync.plus.friend.url']" var="syncUrl" />

<c:if test="${not isSync}">
<div class="inner_head <c:if test="${kakaoWebView > 0}">kakaotalk</c:if> <c:if test="${isSignup}"> signup</c:if>">
    <h1 class="tit_head">
        <a <c:if test="${!isSignup}">href="/kr/index"</c:if> id="kakaoServiceLogo" class="img_gnb link_friends <c:if test="${kakaoWebView > 0}">img_logo</c:if>">KAKAO FRIENDS</a>
    </h1>
    <c:if test="${isKakaoNotMain && !isSignup}">
        <a href="javascript:history.back()" class="link_back"><span class="ico_kakaotalk_header_back ico_back" style="font-size:1px;"></span></a>
    </c:if>
    <a href="#none" class="link_navi <c:if test="${isKakaoNotMain}">kakaotalk</c:if>" <c:if test="${isSignup}">style="display: none;"</c:if> >
        <c:if test="${kakaoWebView == 0}">
            <span class="img_gnb ico_navi">모바일 메뉴열기</span>
        </c:if>
        <c:if test="${kakaoWebView > 0}">
            <span class="ico_kakaotalk_header_navi ico_navi">모바일 메뉴열기</span>
            <c:if test="${basketAllCount.count > 0}">
                <span class="num_total">${basketAllCount.count}</span>
            </c:if>
        </c:if>
    </a>
    <div id="kakaoGnb" role="navigation">
        <h2 class="screen_out">온라인스토어 메인메뉴</h2>
        <ul class="gnb_newfriends" <c:if test="${isSignup}">style="display:none;"</c:if> >
            <li class="${mSubInfo.gnbFriends eq 'categories' ? 'on' : ''}">
                <a href="/kr/products/groups/categories/3" class="link_gnb">카테고리</a>
                <div class="lnb_friends lnb_cate">
                    <div class="box_cate">
                        <strong class="tit_cate">전체 분류</strong>
                        <div class="sub_cate sub_cate1 on">
                            <a href="/kr/products/groups/categories/3" class="link_cate">
                                전체<span class="img_gnb ico_arrow"></span>
                            </a>
                            <div class="layer_sub">
                                <ul class="list_sub">
                                    <li>
                                        <a href="/kr/products/groups/categories/3?requestCharacter=&sort=NEW" class="link_sub">신상품순</a>
                                    </li>
                                    <li>
                                        <a href="/kr/products/groups/categories/3?requestCharacter=&sort=PRICE_ASC" class="link_sub">낮은 가격순</a>
                                    </li>
                                    <li>
                                        <a href="/kr/products/groups/categories/3?requestCharacter=&sort=PRICE_DESC" class="link_sub">높은 가격순</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <%--<a href="#none" class="link_banner" style="display: none">--%>
                            <%--<img src="https://t1.kakaocdn.net/friends/prod/category/20_20171122_gnb_bnr1.png" class="thumb_g" alt="네게 꼭 매달려 있을래. 6cm 피규어 키체인">--%>
                        <%--</a>--%>
                        <c:set var="index" value="1" />
                        <c:forEach items="${categoryMenu[3]}" var="menu" varStatus="status">
                            <c:if test="${!empty menu.ctChildren and menu.ctSeq ne '87'}">
                                <c:set var="index" value="${index + 1}" />
                                <div class="sub_cate sub_cate${index}">
                                    <c:choose>
                                        <c:when test="${menu.ctSeq eq '115'}">
                                            <a href="/kr/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}" class="link_cate">
                                                <span class="img_gnb txt_niniz">${menu.ctName}</span><span class="img_gnb ico_arrow"></span>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/kr/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}" class="link_cate">
                                                ${menu.ctName}<span class="img_gnb ico_arrow"></span>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="layer_sub">
                                        <ul class="list_sub">
                                            <c:forEach items="${categoryMenu[3]}" var="subm"> 
                                                <c:if test="${menu.ctSeq eq subm.ctPcode}"> 
                                                    <li>
                                                        <a href="/kr/products/groups/categories/${subm.ctSeq}?requestCategory=${subm.ctSeq}" class="link_sub">${subm.ctName}</a>
                                                        <%--<c:choose>--%>
                                                            <%--<c:when test="${empty menu.ctImage3}">--%>
                                                                <%--<a href="#none" class="link_banner" style="display: none">--%>
                                                                    <%--<img src="https://t1.kakaocdn.net/friends/prod/category/20_20171122_gnb_bnr1.png" class="thumb_g" alt="네게 꼭 매달려 있을래. 6cm 피규어 키체인"><!-- 배너내용 alt값에 넣어주세요 -->--%>
                                                                <%--</a>--%>
                                                            <%--</c:when>--%>
                                                            <%--<c:otherwise>--%>
                                                                <%--<a href="#none" class="link_banner" style="display: none">--%>
                                                                    <%--<img src="${kakaoFriendsCdn.category}/${menu.ctImage3}" class="thumb_g" alt="${menu.ctName}">--%>
                                                                <%--</a>--%>
                                                            <%--</c:otherwise>--%>
                                                        <%--</c:choose>--%>
                                                        <c:if test="${!empty subm.ctImage3}">
                                                            <a href="/kr${subm.ctImage3Link}" class="link_banner" style="display: none">
                                                                <img src="${kakaoFriendsCdn.category}/${subm.ctImage3}" class="thumb_g" alt="${subm.ctName}">
                                                            </a>
                                                        </c:if>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <%-- 이미지 등록은 되지만 1, 2뎁스 배너 이미지 둘 다 사용 시에 클릭 영역에 문제가 있음 --%>
                                <%--<c:if test="${!empty menu.ctImage3}">--%>
                                    <%--<a href="#none" class="link_banner" style="display: none">--%>
                                        <%--<img src="${kakaoFriendsCdn.category}/${menu.ctImage3}" class="thumb_g" alt="${menu.ctName}">--%>
                                    <%--</a>--%>
                                <%--</c:if>--%>
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="box_cate">
                        <strong class="tit_cate tit_characters">캐릭터별</strong>
                        <ul class="list_characters">
                            <li>
                                <a href="/kr/products/groups/characters/23?requestCharacter=23" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_ryan"></span>
                                    </div>
                                    <strong class="tit_characters">라이언</strong>
                                    <span class="txt_characters">위로의 아이콘,<br>믿음직스러운 조언자</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/6?requestCharacter=6" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_apeach"></span>
                                    </div>
                                    <strong class="tit_characters">어피치</strong>
                                    <span class="txt_characters">뒤태가 매력적인<br>애교만점 어피치</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/7?requestCharacter=7" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_frodo"></span>
                                    </div>
                                    <strong class="tit_characters">프로도</strong>
                                    <span class="txt_characters">부잣집 도시개<br>프로도</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/8?requestCharacter=8" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_neo"></span>
                                    </div>
                                    <strong class="tit_characters">네오</strong>
                                    <span class="txt_characters">새침한 패셔니스타<br>네오</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/5?requestCharacter=5" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_muzi"></span>
                                    </div>
                                    <strong class="tit_characters">무지</strong>
                                    <span class="txt_characters">토끼옷을 입은 무지</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/11?requestCharacter=11" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_con"></span>
                                    </div>
                                    <strong class="tit_characters">콘</strong>
                                    <span class="txt_characters">악어를 닮은<br>정체불명 콘</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/9?requestCharacter=9" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_tube"></span>
                                    </div>
                                    <strong class="tit_characters">튜브</strong>
                                    <span class="txt_characters">화나면 미친오리로<br>변신하는 튜브</span>
                                </a>
                            </li>
                            <li>
                                <a href="/kr/products/groups/characters/10?requestCharacter=10" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_jayg"></span>
                                    </div>
                                    <strong class="tit_characters">제이지</strong>
                                    <span class="txt_characters">힙합을 사랑하는<br>자유로운 영혼</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>
            <li>
                <a href="/kr/brand/home" class="link_gnb">스토리</a>
            </li>
            <c:if test="${kakaoWebView == 0}">
            <li class="item_gnb">
                <a href="http://www.kfmuseum.com" class="link_gnb">뮤지엄</a>
                <strong class="screen_out">서브메뉴</strong>
                <div class="lnb_friends lnb_museum">
                    <a href="http://www.kfmuseum.com" class="link_lnb" target="_blank">뮤지엄 소개</a>
                </div>
            </li>

            <li>
                <a href="/kr/info/storeInfo" class="link_gnb">매장안내</a>
            </li>
            </c:if>
            <li class="item_gnb">
                <a href="/kr/customcenter/bnotice" class="link_gnb">고객센터</a>
            </li>
        </ul>
    </div>
    <div class="wrap_util"><!-- 마이메뉴 오버 시 mypage_on 클래스 추가 -->
        <button type="button" class="btn_search <c:if test="${kakaoWebView > 0}">kakaotalk</c:if>" <c:if test="${isSignup}">style="display: none;"</c:if>>
            <c:if test="${kakaoWebView == 0}">
            <span class="img_gnb ico_search">상품검색하기</span>
            </c:if>
            <c:if test="${kakaoWebView > 0}">
                <span class="img_gnb ico_kakaotalk_header_search ico_search">상품검색하기</span>
            </c:if>

        </button>
        <div class="layer_search">
            <h2 class="screen_out">상품 검색하기</h2>
            <form action="/kr/search" method="get">
                <fieldset>
                    <legend class="screen_out">검색어 입력폼</legend>
                    <input type="text" id="prdSearch" name="keyword" class="inp_search" value="${mSubInfo.subKey eq 'search' ? param.keyword : ''}" placeholder="검색어를 입력하세요">
                    <button type="submit" class="btn_submit">
                        <span class="img_gnb ico_submit">상품검색</span>
                    </button>
                </fieldset>
            </form>
        </div>
        <div class="box_search">
            <h2 class="screen_out">상품 검색하기</h2>
            <form action="/kr/search" method="get">
                <fieldset>
                    <legend class="screen_out">상품검색 입력폼</legend>
                    <label class="lab_search" for="keyword"><span class="rw_show">상품검색</span><span class="rw_hide">검색어를 입력하세요</span></label>
                    <input type="text" id="keyword" name="keyword" class="inp_search" value="">
                    <button type="button" class="rw_hide btn_del"><span class="ico_friends ico_del">검색어 지우기</span></button>
                    <button type="button" class="rw_hide btn_cancel">취소</button>
                    <button type="submit" class="btn_submit">
                        <span class="ico_friends ico_submit">이 단어로 상품찾기</span>
                    </button>
                </fieldset>
            </form>
        </div>
        <strong class="screen_out">마이페이지</strong>
        <sec:authorize access="isAnonymous()">
            <a href="/kr/signin" class="link_mypage" <c:if test="${isSignup}">style="display: none;"</c:if>><span class="img_gnb ico_mypage">마이페이지</span></a><!-- 클릭 시 .wrap_util에 mypage_on 클래스 추가 -->
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="/kr/mypage/orderlist" class="link_mypage" <c:if test="${isSignup}">style="display: none;"</c:if>><span class="img_gnb ico_mypage">마이페이지</span></a><!-- 클릭 시 .wrap_util에 mypage_on 클래스 추가 -->
        </sec:authorize>
        <div id="layerMyPage" class="layer_mypage">
            <h2 class="screen_out">마이페이지</h2>
            <sec:authorize access="isAnonymous()">
            <!-- 로그인 전 -->
            <ul class="list_mymenu">
                <li><a href="/auth/kakao?disable_approval_window=false" class="link_item link_login">로그인</a></li>
                <li><a href="/kr/mypage/orderlist" class="link_item order_list link_disalbed">주문내역</a></li>
                <li><a href="/kr/mypage/wishlist" class="link_item wish_list link_disalbed">찜</a></li>
                <li><a href="/kr/mypage/cancellist" class="link_item cancel_change link_disalbed">취소 및 교환</a></li>
                <li><a href="/kr/mypage/pointlist" class="link_item point link_disalbed">포인트</a></li>
                <li><a href="/kr/mypage/couponlist" class="link_item coupon link_disalbed">쿠폰</a></li>
                <li><a href="/kr/mypage/onetoone" class="link_item cs link_disalbed">1:1 문의</a></li>
                <li><a href="javascript:nonMemberPopup();" class="link_item">비회원 주문조회</a></li>
            </ul>
            <script>
                $('.link_mypage').on('click', function(e) {
                   e.stopPropagation();
                   e.preventDefault();
                   location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                     encodeURIComponent('/${language}/mypage/orderlist');

                   return false;
                });

                $('.list_mymenu .link_item.order_list').on('click', function(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                      encodeURIComponent('/${language}/mypage/orderlist');

                    return false;
                });
                $('.list_mymenu .link_item.wish_list').on('click', function(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                      encodeURIComponent('/${language}/mypage/wishlist');

                    return false;
                });
                $('.list_mymenu .link_item.cancel_change').on('click', function(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                      encodeURIComponent('/${language}/mypage/cancellist');

                    return false;
                });
                $('.list_mymenu .link_item.point').on('click', function(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                      encodeURIComponent('/${language}/mypage/pointlist');

                    return false;
                });
                $('.list_mymenu .link_item.coupon').on('click', function(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                      encodeURIComponent('/${language}/mypage/couponlist');

                    return false;
                });
                $('.list_mymenu .link_item.cs').on('click', function(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
                      encodeURIComponent('/${language}/mypage/onetoone');

                    return false;
                });
            </script>
            <!-- // 로그인 전 -->
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <!-- 로그인 후 -->
            <ul class="list_mymenu">
                <li><a href="/kr/mypage/orderlist" class="link_item">주문내역</a></li>
                <li><a href="/kr/mypage/wishlist" class="link_item">찜</a></li>
                <li><a href="/kr/mypage/cancellist" class="link_item">취소 및 교환</a></li>
                <li><a href="/kr/mypage/pointlist" class="link_item">포인트</a></li>
                <li><a href="/kr/mypage/couponlist" class="link_item">쿠폰</a></li>
                <li><a href="/kr/mypage/onetoone" class="link_item">1:1 문의</a></li>
                <li><a href="/kr/mypage/myinfo" class="link_item">개인정보</a></li>
                <li><a href="/logout" class="link_item">로그아웃</a></li>
            </ul>
            <!-- // 로그인 후 -->
            </sec:authorize>
        </div>
        <c:if test="${kakaoWebView == 0}">
        <strong class="screen_out">장바구니 - 수량</strong>
        <a href="/kr/basket/products" class="link_cart">
            <span class="img_gnb ico_cart"></span>
            <c:if test="${basketAllCount.count > 0}">
                <span class="num_total">${basketAllCount.count}</span>
            </c:if>
        </a>
        </c:if>
        <c:if test="${kakaoWebView == 0}">
        <strong class="screen_out">언어 변경</strong>
        <a href="${linkLanguage.URI}" class="link_lang"><span class="img_gnb ico_global">영어로 언어 변경</span></a>
        </c:if>
        <c:if test="${kakaoWebView > 0}">
            <strong class="screen_out">닫기</strong>
            <a href="kakaotalk://web/close" class="link_close"><span class="ico_kakaotalk_header_close ico_close"  style="font-size:1px;"></span></a>
        </c:if>
        <div class="membership_barcode_gnb">
            <button type="button" class="membership_x">멤버십창 닫기</button>
        </div>
    </div>
</div>
<script type="text/javascript">
	function loginWithKakao() {
		Kakao.Auth.login({
			success: function(authObj) {
				getKakaotalkUserProfile(authObj);
			},
			fail: function(err) {
 	          alert(JSON.stringify(err));
			}
		});
	}

	function getKakaotalkUserProfile(authObj){
		Kakao.API.request({
			url: '/v1/user/me',
			success: function(res) {
				var param = new Object();
				param.kid = encodeURIComponent(res.id);
				param.kname = encodeURIComponent(res.properties.nickname);
				param.profileImage = res.properties.profile_image;
				param.accessToken = authObj.access_token;
				loginKakao(param);
			},
			fail: function(error) {
				alert("카카오 인증 장애 " + error);
			}
		});
	}

	function loginKakao(param){
		$.ajax({
			headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
			url : '/kakao/auth',
			type: "POST",
			data : $.param(param),
			async : false,
			error : function() {
				alert("로그인 장애");
				return false;
			},
			success : function(){
				$(location).attr('href', '${requestPath}?${queryString}');
			}
		});
	}

	function back() {
      document.referrer && -1 != document.referrer.indexOf('${domain}') ? history.back() : location.href= "/kr/index";
    }

    var isAuthenticated =
      <sec:authorize access="isAuthenticated()">true</sec:authorize>
      <sec:authorize access="isAnonymous()">false</sec:authorize>;
    var _csrfToken = '${_csrf.token}';
    var language = '${language}';
    var syncPlusFriendUrl = '${syncUrl}';
    var isKakao = ${kakaoWebView > 0};
</script>
</c:if>