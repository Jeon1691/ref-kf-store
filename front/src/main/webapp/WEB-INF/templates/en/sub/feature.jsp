<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set value="${kakaoWebView}" var="kakaoWebView"/>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath" />
<spring:eval expression="@environment['deploy.version']" var="deployVersion" />
<div id="mFeature">
    <%--<div class="banner_top">--%>
        <%--<div class="banner_top_inner">--%>
            <%--&lt;%&ndash;TODO : !!스크립트 필요!!기본으로 배너를 띄워줄 땐 #kakaoHead의 top 60으로 / x버튼 누르거나 배너가 없어지면 top 0으로 바꿔줘야함&ndash;%&gt;--%>
            <%--<sec:authorize access="isAnonymous()">--%>
                <%--<a href="/kr/promotions/promotion/204">--%>
                    <%--<p class="nomember">--%>
                        <%--<span>지금 구매하고 포인트 2배 6% 적립받자!</span>--%>
                    <%--</p>--%>
                <%--</a>--%>
            <%--</sec:authorize>--%>
            <%--<sec:authorize access="isAuthenticated()">--%>
                <%--<a href="/kr/promotions/promotion/204">--%>
                    <%--<p class="member">--%>
                        <%--<span>지금 구매하고 포인트 2배 6% 적립받자!</span>--%>
                    <%--</p>--%>
                <%--</a>--%>
            <%--</sec:authorize>--%>
            <%--<button class="btn_banner_close">닫기</button>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--&lt;%&ndash;TODO: 배너 닫히면 주석처리된부분 사용!!&ndash;%&gt;--%>
    <%--<script>--%>
      <%--$(function() {--%>
        <%--pcBannerPosition()--%>
        <%--$(window).resize(function() {--%>
          <%--pcBannerPosition()--%>
        <%--})--%>
      <%--})--%>

      <%--function pcBannerPosition() {--%>
        <%--if(window.innerWidth > 768) {--%>
          <%--$("#kakaoHead").css({"top": "60px"})--%>
          <%--$("#kakaoContent").css({"margin-top": "132px"})--%>
        <%--}else{--%>
          <%--var kakaoHeadHeight = Number($("#kakaoHead").height())--%>
          <%--var pageBannerHeight = Number($(".banner_page").height())--%>
          <%--$("#kakaoHead").css({"top": "0"})--%>
          <%--$("#kakaoContent").css({"margin-top": (kakaoHeadHeight + pageBannerHeight) + "px"})--%>
        <%--}--%>
      <%--}--%>
    <%--</script>--%>
    <%--&lt;%&ndash;TODO: 배너 닫히면 주석처리된부분 사용!!&ndash;%&gt;--%>

    <div class="side_menu">
        <div role="navigation">
            <div class="side_login">
                <sec:authorize access="isAnonymous()">
                    <h2 class="screen_out">로그인 및 관련 설정</h2>
                    <div class="profile_user">
                        <a href="/auth/kakao?disable_approval_window=false" class="link_login">Hello. Sign in</a>
                        <a href="javascript:nonMemberPopup();" class="link_tracking">View Guest Orders</a>
                        <span class="banner_membership">
                          <a href="https://store.kakaofriends.com/en/promotions/promotion/204">
                              <img src="http://t1.kakaocdn.net/friends/new_store/banner_gnb_nomember.png" alt="">
                          </a>
                        </span>
                    </div>
                </sec:authorize>
                <!-- 로그인화면일때 -->
                <sec:authorize access="isAuthenticated()">
                    <h2 class="screen_out">내 정보 및 관련 설정</h2>
                    <div class="profile_user">
                        <strong class="tit_username">Hello,<br> <span class="txt_name">${myInfo.myName}</span></strong>
                        <span class="banner_membership">
                          <a href="https://store.kakaofriends.com/en/promotions/promotion/204">
                              <img src="http://t1.kakaocdn.net/friends/new_store/banner_gnb_member.png" alt="">
                          </a>
                        </span>
                    </div>
                </sec:authorize>
                <%--
                <button type="button" class="btn_search">
                    <span class="img_gnb ico_search">Search</span>
                </button>
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
                <a href="${linkLanguage.URI}" class="link_lang">
                    <span class="img_gnb ico_korean">Change to korean language</span>
                </a>
                --%>
                <strong class="screen_out">My Page</strong>
                <ul class="list_personal">
                    <li>
                        <a href="/en/basket/products" class="link_personal">
                            <span class="img_gnb ico_cart"></span>Cart
                            <c:if test="${basketAllCount.count > 0}">
                            <span class="num_total">${basketAllCount.count}</span>
                            </c:if>
                        </a>
                    </li>
                    <li>
                        <a href="/en/mypage/orderlist" class="link_personal">
                            <span class="img_gnb ico_order"></span>Order List
                        </a>
                    </li>
                    <li>
                        <a href="/en/mypage/wishlist" class="link_personal">
                            <span class="img_gnb ico_wish"></span>Wish List
                        </a>
                    </li>
                    <li>
                        <a href="/en/mypage/orderlist" class="link_personal">
                            <span class="img_gnb ico_personal"></span>My Page
                        </a>
                    </li>
                </ul>

                <!-- 로그인화면일때 -->
                <sec:authorize access="isAuthenticated()">
                    <div class="membership_point">
                        <div class="point_section">
                            <strong>멤버십 포인트</strong>
                            <p class="txt_point gotopoint_en">
                                <span class="txt_point_numbers">0</span>
                                <span class="ico_point"></span>
                            </p>
                        </div>
                        <c:if test = "${!fn:startsWith(myInfo.barcode, 'BARCODE') && myInfo.barcode != null}">

                        <div class="barcode_section">
                            <button type="button">바코드보기</button>
                        </div>
                        </c:if>

                    </div>

                    <div class="membership_barcode">
                        <div class="barcode_dim"></div>
                        <div class="barcode_inner">
                            <strong class="tit_user">카카오프렌즈</strong>
                            <p class="txt_info">MEMBERSHIP</p>

                            <div class="article_card">
                                <div class="img_barcode">
                                    <div class="lds-ellipsis">
                                        <div></div>
                                        <div></div>
                                        <div></div>
                                        <div></div>
                                    </div>
                                </div>
                                <div class="article_card_bottom">
                                    <p class="img_gnb">
                                        KAKAO FRIENDS
                                    </p>
                                    <p class="txt_point">
                                        <span class="point"></span>
                                        <span class="ico_point"></span>
                                    </p>
                                </div>
                            </div>

                            <button type="button" class="membership_close">멤버십창 닫기</button>
                            <button type="button" class="membership_x">멤버십창 닫기</button>
                        </div>
                    </div>
                    <%--<dl class="info_mypoint">--%>
                    <%--<dt class="tit_info">멤버십 포인트</dt>--%>
                    <%--<dd class="item_total"><a href="/kr/mypage/pointlist" class="link_point"><em class="num_point"><frm:formatNumber type="number" value="${myInfo.availablePoint}"/></em><span class="img_gnb ico_point">P</span></a></dd>--%>

                    <%--</dl>--%>
                    <script>
                      function numberWithCommas(x) {
                        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                      }

                      var availablePoint = numberWithCommas(parseInt('${myInfo.availablePoint}', 10));
                    </script>
                    <script src="/resources/js/JsBarcode.all.min.js" defer></script>
                    <script src="/resources/js/membership.js" defer></script>
                </sec:authorize>
            </div>
            <!-- 2017-11-01 배너 추가 -->
            <a href="${gnbBandMobile[0].bnLink}" class="link_eventbnr">
                <img src="${kakaoFriendsCdn.banner}/${gnbBandMobile[0].bnImage}" class="thumb_g" alt="${gnbBandMobile[0].bnAlt}">
            </a>
            <!-- 2017-11-01 배너 추가 -->
            <h2 class="screen_out">Friends Menu</h2>
            <ul class="list_menu">
                <!-- 카테고리 -->
                <li class="item_cate">
                    <strong class="screen_out">All Category</strong>
                    <div class="cate_sub">
                        <a href="/en/products/groups/categories/3" class="link_cate">
                            <span class="txt_cate">ALL</span>
                        </a>
                        <c:forEach items="${categoryMenu[3]}" var="menu">
                            <c:if test="${!empty menu.ctChildren and menu.ctSeq ne '87'}">
                                <c:choose>
                                    <c:when test="${menu.ctSeq eq '115'}">
                                        <a href="/en/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}" class="link_cate">
                                            <span class="txt_cate">
                                                <span class="img_gnb txt_niniz">${menu.ctEname}</span>
                                            </span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/en/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}" class="link_cate">
                                            <span class="txt_cate">${menu.ctEname}</span>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                    </div>
                </li>
                <!-- // 카테고리 -->

                <c:if test="${!empty categoryThemeMenu}">
                    <!-- 테마 기획전 -->
                    <li class="item_theme">
                        <a href="/en/products/groups/categories/103?requestCategory=103" class="link_menu">Special Theme<span class="img_gnb ico_arrow"></span></a>
                        <div class="cate_sub">
                            <c:forEach items="${categoryThemeMenu}" var="menu">
                                <a href="/en${menu.ctImage4Link}" class="link_cate">
                                    <img src="${kakaoFriendsCdn.category}/${menu.ctImage4}" class="thumb_g" alt="${menu.ctImage4Alt}">
                                </a>
                            </c:forEach>
                            <c:if test="${(fn:length(categoryThemeMenu))%2 > 0}">
                                <span class="link_cate">
                                    <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_theme_commingSoon_20180605.png" class="thumb_g" alt="Comming Soon">
                                </span>
                            </c:if>
                        </div>
                    </li>
                    <!-- // 테마 기획전 -->
                </c:if>

                <!-- 캐릭터별 상품 -->
                <li class="item_character">
                    <a href="/en/products/groups/characters/23" class="link_menu">All Characters<span class="img_gnb ico_arrow"></span></a>
                    <div class="cate_sub">
                        <a href="/en/products/groups/characters/23" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character1_171129.png" class="thumb_g" alt="Ryan">
                        </a>
                        <a href="/en/products/groups/characters/6" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character2_171129.png" class="thumb_g" alt="Apeach">
                        </a>
                        <a href="/en/products/groups/characters/7" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character3_171129.png" class="thumb_g" alt="Frodo">
                        </a>
                        <a href="/en/products/groups/characters/8" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character4_171129.png" class="thumb_g" alt="Neo">
                        </a>
                        <a href="/en/products/groups/characters/5" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character5_171129.png" class="thumb_g" alt="Muzi">
                        </a>
                        <a href="/en/products/groups/characters/11" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character6_171129.png" class="thumb_g" alt="Con">
                        </a>
                        <a href="/en/products/groups/characters/9" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character7_171129.png" class="thumb_g" alt="Tube">
                        </a>
                        <a href="/en/products/groups/characters/10" class="link_cate">
                            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character8_171129.png" class="thumb_g" alt="Jay-G">
                        </a>
                    </div>
                </li>
                <!-- // 캐릭터별 상품 -->

                <!-- 기타 서비스 링크 -->
                <li class="item_sub">
                    <div class="cate_sub">
                        <a href="/en/brand/home" class="link_menu">
                            <span class="img_gnb ico_brand"></span>
                            Brand Story<span class="img_gnb ico_arrow"></span>
                        </a>
                        <a href="http://www.kfmuseum.com" class="link_menu">
                            <span class="img_gnb ico_museum"></span>
                            Museum<span class="img_gnb ico_arrow"></span>
                        </a>
                        <a href="/en/info/storeInfo" class="link_menu">
                            <span class="img_gnb ico_store"></span>
                            Store<span class="img_gnb ico_arrow"></span>
                        </a>
                        <a href="/en/customcenter/faq" class="link_menu">
                            <span class="img_gnb ico_cc"></span>
                            Help<span class="img_gnb ico_arrow"></span>
                        </a>
                    </div>
                </li>
                <!-- // 기타 서비스 링크 -->
            </ul>
        </div>
        <div class="footer_side">
            <h2 class="screen_out">Privacy Policy</h2>
            <sec:authorize access="isAnonymous()">

                <a href="/en/signin" class="link_info">
                    <span class="img_gnb ico_login"></span>Sign In
                </a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a href="/logout" class="link_info">
                    <span class="img_gnb ico_login"></span>Log Out
                </a>
            </sec:authorize>
            <small class="copyright_info">&copy; KAKAO IX CORP.</small>
        </div>
        <button type="button" class="btn_close"><span class="img_gnb ico_close">Menu Close</span></button>
    </div>
</div>



