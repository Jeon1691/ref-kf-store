<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set value="${kakaoWebView}" var="kakaoWebView"/>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<spring:eval expression="@environment['deploy.version']" var="deployVersion" />
<div id="mFeature">
  <div class="banner_top" style="display: none;">
    <div class="banner_top_inner">
      <%--TODO : !!스크립트 필요!!기본으로 배너를 띄워줄 땐 #kakaoHead의 top 60으로 / x버튼 누르거나 배너가 없어지면 top 0으로 바꿔줘야함--%>
      <sec:authorize access="isAnonymous()">
        <a href="/kr/promotions/promotion/204">
          <p class="nomember">
            <span>지금 구매하고 포인트 2배 6% 적립받자!</span>
          </p>
        </a>
      </sec:authorize>
      <sec:authorize access="isAuthenticated()">
        <a href="/kr/promotions/promotion/204">
          <p class="member">
            <span>지금 구매하고 포인트 2배 6% 적립받자!</span>
          </p>
        </a>
      </sec:authorize>
      <button class="btn_banner_close">닫기</button>
    </div>
  </div>

  <%--TODO: 배너 닫히면 주석처리된부분 사용!!--%>
  <script>
    $(function() {
      pcBannerPosition()
      $(window).resize(function() {
        pcBannerPosition()
      })
    })

    function pcBannerPosition() {
      if(window.innerWidth > 768) {
        var headTop = $('.banner_top').is(':visible') ? $('.banner_top').height() : 0;

        $("#kakaoHead").css({"top": headTop + "px"});
        $("#kakaoContent").css({"margin-top": (headTop + 72) + "px"});
      }else{
        var kakaoHeadHeight = Number($("#kakaoHead").height());
        var pageBannerHeight = $(".banner_page").is(':visible') ? Number($(".banner_page").height()) : 0;

        $("#kakaoHead").css({"top": 0})
        $("#kakaoContent").css({"margin-top": (kakaoHeadHeight + pageBannerHeight) + "px"})

        <c:if test="${kakaoWebView > 0}">
          $("#kakaoHead").css({"height": "50px"})
          $(".banner_page").css({"top": "50px"})
        </c:if>
      }
    }
  </script>
  <%--TODO: 배너 닫히면 주석처리된부분 사용!!--%>

  <div class="side_menu">
    <div role="navigation">
      <div class="side_login">
        <sec:authorize access="isAnonymous()">
          <h2 class="screen_out">로그인 및 관련 설정</h2>
          <div class="profile_user">
              <a href="/auth/kakao?disable_approval_window=false" class="link_login">로그인이 필요해요</a>
            <span class="txt_login">카카오 간편로그인</span>
            <a href="javascript:nonMemberPopup();" class="link_tracking">비회원 주문조회</a>
            <span class="banner_membership">
              <a href="/kr/promotions/promotion/204">
                  <img src="http://t1.kakaocdn.net/friends/new_store/banner_gnb_nomember.png" alt="">
              </a>
            </span>

          </div>
        </sec:authorize>
        <!-- 로그인화면일때 -->
        <sec:authorize access="isAuthenticated()">
          <h2 class="screen_out">내 정보 및 관련 설정</h2>
          <div class="profile_user">
            <strong class="tit_username">
              안녕하세요,<br>
              <c:choose>
                <c:when test="${kakaoWebView> 0 && (myInfo.myName eq '고객' || myInfo.myName eq 'Customer')}">
                  카카오 프렌즈샵입니다.
                </c:when>
                <c:otherwise>
                  <span class="txt_name">${myInfo.myName}</span>님
                </c:otherwise>
              </c:choose>
            </strong>
              <span class="banner_membership">
                    <a href="/kr/promotions/promotion/204">
                        <img src="http://t1.kakaocdn.net/friends/new_store/banner_gnb_member.png" alt="">
                    </a>
                </span>
          </div>
        </sec:authorize>
        <%--
        <button type="button" class="btn_search">
            <span class="img_gnb ico_search">상품검색하기</span>
        </button>
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
        <a href="${linkLanguage.URI}" class="link_lang">
            <span class="img_gnb ico_global">영어로 언어 변경</span>
            <!-- "한글로 언어 변경의 경우"
                <span class="img_gnb ico_korean">한글로 언어 변경</span>
            --
        </a>
        --%>
        <strong class="screen_out">마이 메뉴</strong>
        <ul class="list_personal">
          <li>
            <a href="/kr/basket/products" class="link_personal">
              <span class="img_gnb ico_cart"></span>장바구니
              <c:if test="${basketAllCount.count > 0}">
                <span class="num_total">${basketAllCount.count}</span>
              </c:if>
            </a>
          </li>
          <li>
            <a href="/kr/mypage/orderlist" class="link_personal">
              <span class="img_gnb ico_order"></span>주문조회
            </a>
          </li>
          <li>
            <a href="/kr/mypage/wishlist" class="link_personal">
              <span class="img_gnb ico_wish"></span>찜
            </a>
          </li>
          <li>
            <a href="/kr/mypage/orderlist" class="link_personal">
              <span class="img_gnb ico_personal"></span>마이페이지
            </a>
          </li>
        </ul>

        <!-- 로그인화면일때 -->
        <sec:authorize access="isAuthenticated()">
          <div class="membership_point">
            <div class="point_section">
              <strong>멤버십 포인트</strong>
              <p class="txt_point gotopoint_kr">
                <span class="txt_point_numbers">0</span>
                <span class="ico_point"></span>
              </p>
            </div>
              <div class="barcode_section">
                <button type="button">바코드보기</button>
              </div>
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
      <c:if test="${kakaoWebView == 0}">
        <a href="${gnbBandMobile[0].bnLink}" class="link_eventbnr">
          <img src="${kakaoFriendsCdn.banner}/${gnbBandMobile[0].bnImage}" class="thumb_g"
               alt="${gnbBandMobile[0].bnAlt}">
        </a>
      </c:if>
      <!-- 2017-11-01 배너 추가 -->
      <h2 class="screen_out">온라인스토어 메인메뉴</h2>
      <ul class="list_menu">
        <!-- 카테고리 -->
        <li class="item_cate">
          <strong class="screen_out">카테고리</strong>
          <div class="cate_sub">
            <a href="/kr/products/groups/categories/3" class="link_cate">
              <span class="txt_cate">전체보기</span>
            </a>
            <c:forEach items="${categoryMenu[3]}" var="menu">
              <c:if test="${!empty menu.ctChildren and menu.ctSeq ne '87'}">
                <c:choose>
                  <c:when test="${menu.ctSeq eq '115'}">
                    <a href="/kr/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}"
                       class="link_cate">
                                            <span class="txt_cate">
                                                <span class="img_gnb txt_niniz">${menu.ctName}</span>
                                            </span>
                    </a>
                  </c:when>
                  <c:otherwise>
                    <a href="/kr/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}"
                       class="link_cate">
                      <span class="txt_cate">${menu.ctName}</span>
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
            <a href="/kr/products/groups/categories/103?requestCategory=103" class="link_menu">테마 기획전<span
              class="img_gnb ico_arrow"></span></a>
            <div class="cate_sub">
              <c:forEach items="${categoryThemeMenu}" var="menu">
                <a href="/kr${menu.ctImage4Link}" class="link_cate">
                  <img src="${kakaoFriendsCdn.category}/${menu.ctImage4}" class="thumb_g" alt="${menu.ctImage4Alt}">
                </a>
              </c:forEach>
              <c:if test="${(fn:length(categoryThemeMenu))%2 > 0}">
                            <span class="link_cate">
                                <img
                                  src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_theme_commingSoon_20180605.png"
                                  class="thumb_g" alt="Comming Soon">
                            </span>
              </c:if>
            </div>
          </li>
          <!-- // 테마 기획전 -->
        </c:if>

        <!-- 캐릭터별 상품 -->
        <li class="item_character">
          <a href="/kr/products/groups/characters/23" class="link_menu">캐릭터별 상품<span
            class="img_gnb ico_arrow"></span></a>
          <div class="cate_sub">
            <a href="/kr/products/groups/characters/23" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character1_171129.png" class="thumb_g"
                   alt="라이언 Ryan">
            </a>
            <a href="/kr/products/groups/characters/6" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character2_171129.png" class="thumb_g"
                   alt="어피치 Apeach">
            </a>
            <a href="/kr/products/groups/characters/7" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character3_171129.png" class="thumb_g"
                   alt="프로도 Frodo">
            </a>
            <a href="/kr/products/groups/characters/8" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character4_171129.png" class="thumb_g"
                   alt="네오 Neo">
            </a>
            <a href="/kr/products/groups/characters/5" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character5_171129.png" class="thumb_g"
                   alt="무지 Muzi">
            </a>
            <a href="/kr/products/groups/characters/11" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character6_171129.png" class="thumb_g"
                   alt="콘 Con">
            </a>
            <a href="/kr/products/groups/characters/9" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character7_171129.png" class="thumb_g"
                   alt="튜브 Tube">
            </a>
            <a href="/kr/products/groups/characters/10" class="link_cate">
              <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/side_character8_171129.png" class="thumb_g"
                   alt="제이지 Jay-G">
            </a>
          </div>
        </li>
        <!-- // 캐릭터별 상품 -->

        <!-- 기타 서비스 링크 -->
        <li class="item_sub">
          <div class="cate_sub">
            <c:if test="${kakaoWebView == 0}">
              <a href="/kr/brand/home" class="link_menu">
                <span class="img_gnb ico_brand"></span>
                브랜드 스토리<span class="img_gnb ico_arrow"></span>
              </a>

              <a href="http://www.kfmuseum.com" class="link_menu">
                <span class="img_gnb ico_museum"></span>
                뮤지엄<span class="img_gnb ico_arrow"></span>
              </a>
              <a href="/kr/info/storeInfo" class="link_menu">
                <span class="img_gnb ico_store"></span>
                매장안내<span class="img_gnb ico_arrow"></span>
              </a>
            </c:if>
            <a href="/kr/customcenter/faq" class="link_menu">
              <span class="img_gnb ico_cc"></span>
              고객센터<span class="img_gnb ico_arrow"></span>
            </a>
          </div>
        </li>
        <!-- // 기타 서비스 링크 -->
      </ul>
    </div>
    <div class="footer_side">
      <h2 class="screen_out">서비스 이용정보</h2>
      <sec:authorize access="isAnonymous()">

        <a href="/kr/signin" class="link_info">
          <span class="img_gnb ico_login"></span>로그인 하러가기
        </a>
      </sec:authorize>

      <sec:authorize access="isAuthenticated()">
        <c:if test="${kakaoWebView == 0}">
          <a href="/logout" class="link_info">
            <span class="img_gnb ico_login"></span>로그아웃
          </a>
        </c:if>
      </sec:authorize>
      <small class="copyright_info">&copy; KAKAO IX CORP.</small>
    </div>
    <button type="button" class="btn_close"><span class="img_gnb ico_close">메뉴 닫기</span></button>
  </div>
</div>
