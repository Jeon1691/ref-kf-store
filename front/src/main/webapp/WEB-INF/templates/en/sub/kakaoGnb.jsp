<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set value="${kakaoWebView}" var="kakaoWebView"/>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<c:set value="${kakaoWebView > 0 && requestPath ne '/kr/index'}" var="isKakaoNotMain" />
<c:set value="${kakaoWebView > 0 && requestPath eq '/kr/signup'}" var="isSignup" />
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString" />
<c:set value="${isSync}" var="isSync"/>
<c:set value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}" var="language" />
<spring:eval expression="@environment['sync.plus.friend.url']" var="syncUrl" />

<c:if test="${not isSync}">
<div class="inner_head">
    <h1 class="tit_head">
        <a href="/en/index" id="kakaoServiceLogo" class="img_gnb link_friends">KAKAO FRIENDS</a>
    </h1>
    <a href="#none" class="link_navi"><span class="img_gnb ico_navi">Mobile menu open</span></a>
    <div id="kakaoGnb" role="navigation">
        <h2 class="screen_out">Online Store menu</h2>
        <ul class="gnb_newfriends">
            <li class="${mSubInfo.gnbFriends eq 'categories' ? 'on' : ''}">
                <a href="/en/products/groups/categories/3" class="link_gnb">Category</a>
                <div class="lnb_friends lnb_cate">
                    <div class="box_cate">
                        <strong class="tit_cate">All Categories</strong>
                        <div class="sub_cate sub_cate1 on">
                            <a href="/en/products/groups/categories/3" class="link_cate">
                                All<span class="img_gnb ico_arrow"></span>
                            </a>
                            <div class="layer_sub">
                                <ul class="list_sub">
                                    <li>
                                        <a href="/en/products/groups/categories/3?requestCharacter=&sort=NEW" class="link_sub">Newly Stocked</a>
                                    </li>
                                    <li>
                                        <a href="/en/products/groups/categories/3?requestCharacter=&sort=PRICE_ASC" class="link_sub">Price low to high</a>
                                    </li>
                                    <li>
                                        <a href="/en/products/groups/categories/3?requestCharacter=&sort=PRICE_DESC" class="link_sub">Price high to low</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <c:set var="index" value="1" />
                        <c:forEach items="${categoryMenu[3]}" var="menu" varStatus="status">
                            <c:if test="${!empty menu.ctChildren and menu.ctSeq ne '87'}">
                                <c:set var="index" value="${index + 1}" />
                                <div class="sub_cate sub_cate${index}">
                                    <c:choose>
                                        <c:when test="${menu.ctSeq eq '115'}">
                                            <a href="/en/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}" class="link_cate">
                                                <span class="img_gnb txt_niniz">${menu.ctEname}</span><span class="img_gnb ico_arrow"></span>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/en/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}" class="link_cate">
                                                ${menu.ctEname}<span class="img_gnb ico_arrow"></span>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="layer_sub">
                                        <ul class="list_sub">
                                            <c:forEach items="${categoryMenu[3]}" var="subm"> 
                                                <c:if test="${menu.ctSeq eq subm.ctPcode}"> 
                                                    <li>
                                                        <a href="/en/products/groups/categories/${subm.ctSeq}?requestCategory=${subm.ctSeq}" class="link_sub">${subm.ctEname}</a>
                                                        <c:if test="${!empty subm.ctImage3}">
                                                            <a href="/en${subm.ctImage3Link}" class="link_banner" style="display: none">
                                                                <img src="${kakaoFriendsCdn.category}/${subm.ctImage3}" class="thumb_g" alt="${subm.ctEname}">
                                                            </a>
                                                        </c:if>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="box_cate">
                        <strong class="tit_cate tit_characters">All Characters</strong>
                        <ul class="list_characters">
                            <li>
                                <a href="/en/products/groups/characters/23?requestCharacter=23" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_ryan"></span>
                                    </div>
                                    <strong class="tit_characters">Ryan</strong>
                                    <span class="txt_characters">The lovable lion</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/6?requestCharacter=6" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_apeach"></span>
                                    </div>
                                    <strong class="tit_characters">Apeach</strong>
                                    <span class="txt_characters">A mischievous,<br>silly fruit</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/7?requestCharacter=7" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_frodo"></span>
                                    </div>
                                    <strong class="tit_characters">Frodo</strong>
                                    <span class="txt_characters">The posh city dog</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/8?requestCharacter=8" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_neo"></span>
                                    </div>
                                    <strong class="tit_characters">Neo</strong>
                                    <span class="txt_characters">The feline<br>fashionista</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/5?requestCharacter=5" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_muzi"></span>
                                    </div>
                                    <strong class="tit_characters">Muzi</strong>
                                    <span class="txt_characters">The radish in<br>disguise</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/11?requestCharacter=11" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_con"></span>
                                    </div>
                                    <strong class="tit_characters">Con</strong>
                                    <span class="txt_characters">Muzi’s mysterious<br>companion</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/9?requestCharacter=9" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_tube"></span>
                                    </div>
                                    <strong class="tit_characters">Tube</strong>
                                    <span class="txt_characters">The cowardly duck with<br>an angry alter ego</span>
                                </a>
                            </li>
                            <li>
                                <a href="/en/products/groups/characters/10?requestCharacter=10" class="link_characters">
                                    <div class="frame_characters">
                                        <span class="img_emoticon ico_jayg"></span>
                                    </div>
                                    <strong class="tit_characters">Jay-G</strong>
                                    <span class="txt_characters">A stylish secret<br>agent from the<br>underground</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>
            <li>
                <a href="/en/brand/home" class="link_gnb">Story</a>
            </li>
            <li class="item_gnb">
                <a href="http://www.kfmuseum.com" class="link_gnb">Museum</a>
                <strong class="screen_out">sub menu</strong>
                <div class="lnb_friends lnb_museum">
                    <a href="http://www.kfmuseum.com" class="link_lnb" target="_blank">About</a>
                </div>
            </li>
            <li>
                <a href="/en/info/storeInfo" class="link_gnb">Store</a>
            </li>
            <li class="item_gnb">
                <a href="/en/customcenter/bnotice" class="link_gnb">Help</a>
            </li>
        </ul>
    </div>
    <div class="wrap_util">
        <button type="button" class="btn_search">
            <span class="img_gnb ico_search">product search</span>
        </button>
        <div class="layer_search">
            <h2 class="screen_out">product search</h2>
            <form action="/en/search" method="get">
                <fieldset>
                    <legend class="screen_out">product search form</legend>
                    <input type="text" id="prdSearch" name="keyword" class="inp_search" value="${mSubInfo.subKey eq 'search' ? param.keyword : ''}" placeholder="Search">
                    <button type="submit" class="btn_submit">
                        <span class="img_gnb ico_submit">Search to this keyword</span>
                    </button>
                </fieldset>
            </form>
        </div>
        <div class="box_search ${mSubInfo.subKey eq 'search' ? 'result_on' : ''}">
            <h2 class="screen_out">product search</h2>
            <form action="/en/search" method="get">
                <fieldset>
                    <legend class="screen_out">product search form</legend>
                    <label class="lab_search" for="keyword"><span class="rw_show">Search</span><span class="rw_hide">Search to Keyword</span></label>
                    <input type="text" id="keyword" name="keyword" class="inp_search" value="${mSubInfo.subKey eq 'search' ? param.keyword : ''}">
                    <button type="button" class="rw_hide btn_del"><span class="ico_friends ico_del">keyword remove</span></button>
                    <button type="button" class="rw_hide btn_cancel">Cancel</button>
                    <button type="submit" class="btn_submit">
                        <span class="ico_friends ico_submit">Search to this keyword</span>
                    </button>
                </fieldset>
            </form>
        </div>
        <strong class="screen_out">My page</strong>
        <sec:authorize access="isAnonymous()">
            <a href="/en/signin" class="link_mypage"><span class="img_gnb ico_mypage">My page</span></a><!-- 클릭 시 .wrap_util에 mypage_on 클래스 추가 -->
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="/en/mypage/orderlist" class="link_mypage"><span class="img_gnb ico_mypage">My page</span></a><!-- 클릭 시 .wrap_util에 mypage_on 클래스 추가 -->
        </sec:authorize>
        <div id="layerMyPage" class="layer_mypage">
            <h2 class="screen_out">My page</h2>
            <sec:authorize access="isAnonymous()">
            <!-- 로그인 전 -->
            <ul class="list_mymenu">
                <li><a href="/en/signin" class="link_item link_login">Sign in</a></li>
                <li><a href="javascript:loginPopup();" class="link_item link_disalbed">Order List</a></li>
                <li><a href="javascript:loginPopup();" class="link_item link_disalbed">Wish List</a></li>
                <li><a href="javascript:loginPopup();" class="link_item link_disalbed">Returns</a></li>
                <li><a href="javascript:loginPopup();" class="link_item link_disalbed">Point</a></li>
                <li><a href="javascript:loginPopup();" class="link_item link_disalbed">Coupon</a></li>
                <li><a href="javascript:loginPopup();" class="link_item link_disalbed">Contact Us</a></li>
                <li><a href="javascript:nonMemberPopup();" class="link_item">View Guest Orders</a></li>
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
                    <li><a href="/en/mypage/orderlist" class="link_item">Order List</a></li>
                    <li><a href="/en/mypage/wishlist" class="link_item">Wish List</a></li>
                    <li><a href="/en/mypage/cancellist" class="link_item">Returns</a></li>
                    <li><a href="/en/mypage/pointlist" class="link_item">Point</a></li>
                    <li><a href="/en/mypage/couponlist" class="link_item">Coupon</a></li>
                    <li><a href="/en/mypage/onetoone" class="link_item">Contact Us</a></li>
                    <li><a href="/en/mypage/myinfo" class="link_item">Account</a></li>
                    <li><a href="/logout" class="link_item">Sign out</a></li>
                </ul>
                <!-- // 로그인 후 -->
            </sec:authorize>
        </div>
        <strong class="screen_out">Cart - count</strong>
        <a href="/en/basket/products" class="link_cart">
            <span class="img_gnb ico_cart"></span>
            <c:if test="${basketAllCount.count > 0}">
                <span class="num_total">${basketAllCount.count}</span>
            </c:if>
        </a>
        <strong class="screen_out">Change Language</strong>
        <a href="${linkLanguage.URI}" class="link_lang"><span class="img_gnb ico_korean">change to korean language</span></a>
        <div class="membership_barcode_gnb">
            <button type="button" class="membership_x">close membership card</button>
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

    var isAuthenticated =
      <sec:authorize access="isAuthenticated()">true</sec:authorize>
      <sec:authorize access="isAnonymous()">false</sec:authorize>;
    var _csrfToken = '${_csrf.token}';
    var language = '${language}';
    var syncPlusFriendUrl = '${syncUrl}';
    var isKakao = ${kakaoWebView > 0};
</script>
</c:if>