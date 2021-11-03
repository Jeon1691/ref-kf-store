<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set value="${kakaoWebView}" var="kakaoWebView"/>

<div id="mArticle">
  <h2 class="screen_out">글로벌 배송 안내</h2>
  <div class="global_intro">
    <div class="inner_intro">
      <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/global_intro_170428.png" class="rw_hide" alt="">
      <strong>전세계 어디서나 카카오프렌즈!! 글로벌 배송으로 전세계 곳곳 널리널리</strong>
      <p>카카오프렌즈가 지구 반대편에 있는 친구들을 지금 만나러 갑니다!!</p>
    </div>
  </div>
  <div class="global_info">
    <strong class="tit_info">카카오프렌즈 글로벌 배송은?</strong>
    <p class="desc_info">
      카카오프렌즈가 글로벌 배송 서비스를 오픈하게 되었습니다. <br class="rw_hide"><br class="rw_hide">글로벌 배송 대행은 국가기관인 우정사업본부이며 개인이 따로 우체국을 통해<br class="rw_show">
      해외배송 서비스를 받을 때 보다 편리하게 이용하실 수 있습니다. <br class="rw_hide"><br class="rw_hide">EMS는 외국 우편당국과 체결한 특별협정에 따라 취급하며,<br class="rw_show">
      카카오프렌즈는 52개국을 대상 국가로 시작해 점차 확장될 예정이니 많은 이용과 관심 부탁드립니다.
    </p>
  </div>
  <div class="tab_menu">
    <strong class="screen_out">글로벌 배송 안내 메뉴</strong>
    <div class="wrap_scroll">
      <ul class="list_tab">
        <li class="on"><a href="#tabInfo1" class="link_tab">이용방법</a></li>
        <li><a href="#tabInfo2" class="link_tab">배송절차</a></li>
        <li><a href="#tabInfo3" class="link_tab">유의사항</a></li>
        <li><a href="#tabInfo4" class="link_tab">배송비 안내</a></li>
        <li><a href="#tabInfo5" class="link_tab">배송국가</a></li>
      </ul>
    </div>
  </div>
  <div id="tabInfo1" class="tab_cont" style="display:block">
    <h3 class="screen_out">이용방법</h3>
    <div class="use_info use_step1">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step1_170428.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 1 글로벌 배송 제품 확인</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">제품 리스트에서 글로벌 배송 가능 상품 보기를 체크하면 별도로 구분이 가능해요</span>
      </li>
      <li>
        <span class="num_item">2</span><span class="txt_use">글로벌 배송이 가능한 상품의 아이콘을 확인해주세요</span>
      </li>
    </ul>
    <div class="use_info use_step2">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step2_170428.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 2 제품 상세 화면에서 구매하기</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">글로벌 배송 가능 여부를 확인 후 구매하기를 진행해주세요</span>
      </li>
      <li>
        <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_stepsub2_170428.png" class="rw_hide" alt="">
        <span class="num_item">2</span><span class="txt_use">글로벌 배송 국가 가능 알림 영역을 선택하시면 배송 국가에 대한 자세한 정보를 추가로 확인해 보실 수 있어요</span>
      </li>
    </ul>
    <div class="use_info use_step3">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step3_170428.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 3 장바구니에서 구매하기</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">장바구니에서도 배송국가를 선택할 수 있어요</span>
      </li>
      <li>
        <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_stepsub3_170428.png" class="rw_hide" alt="">
        <span class="num_item">2</span><span class="txt_use">글로벌 배송이 불가능한 제품이 포함되어 있으면 구매가 불가능하니 제품 선택시 꼭 확인해주세요</span>
      </li>
    </ul>
    <div class="use_info use_step4">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step4_170428.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 4 주문 및 배송정보 입력하기</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">구매하기 화면에서도 배송국가를 선택할 수 있어요</span>
      </li>
      <li>
        <span class="num_item">2</span><span class="txt_use">해외로 국가를 선택했을시 배송정보 입력란이 변경되며 영문으로 작성 부탁드려요</span>
      </li>
      <li>
        <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_stepsub4_170428.png" class="rw_hide" alt="">
        <span class="num_item">3</span><span class="txt_use">구매하기 화면에서 배송국가를 변경시 글로벌 배송이 불가능한 상품이 포함되어 있으면 결제가 안되니 꼭 확인해주세요</span>
      </li>
      <li>
        <span class="num_item">4</span><span class="txt_use">주문이 완료되면 주문 정보는 입력하신 이메일 주소를 통해서도 확인이 가능합니다</span>
      </li>
    </ul>
  </div>
  <div id="tabInfo2" class="tab_cont">
    <h3 class="screen_out">배송절차</h3>
    <div class="cont_subject">
      <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/global_step_180116.png" class="rw_hide" alt="">
      <strong class="screen_out">배송 순서</strong>
      <ol class="list_step">
        <li>Step. 1 주문접수 (국내 배송단계)</li>
        <li>Step. 2 배송준비 (국내 배송단계)</li>
        <li>Step. 3 해외출고 준비 (국내 배송단계)</li>
        <li>Step. 4 송장입력 (국내 배송단계)</li>
        <li>Step. 5 글로벌 배송중 (글로벌 배송단계)</li>
        <li>Step. 6 배송완료 (글로벌 배송단계)</li>
      </ol>
      <p class="desc_global"><span class="ico_friends ico_bullet"></span>실시간 배송 추적은 <span class="txt_g">&rdquo;</span>
        <sec:authorize access="isAnonymous()">
          <a href="javascript:loginPopup();" class="link_global">마이페이지 &gt; 주문내역</a>
        </sec:authorize>
        <sec:authorize access="isFullyAuthenticated()">
          <a href="/kr/mypage/orderlist" class="link_global">마이페이지 &gt; 주문내역</a>
        </sec:authorize>
        <span class="txt_g">&rdquo;</span> 에서 확인 가능합니다.</p>
    </div>
  </div>

  <div id="tabInfo3" class="tab_cont">
    <h3 class="screen_out">유의사항</h3>
    <div class="cont_subject cont_notice">
      <h4 class="tit_notice">배송부분</h4>
      <ul class="list_notice">
        <li>
          <strong class="tit_item"><span class="num_item">1</span>EMS 유의사항</strong>
          <p class="desc_notice">
            다음 제한 조건에 해당하는 경우 국내배송시 문제가 없더라도 전세계배송사의 판단으로 배송 주문건을 분리하여 여러개로 나누어 포장합니다.<br class="rw_show">
            이 때 고객님께 국내 및 해외 추가배송비를 요청할 수도 있음을 양해하여 주시기 바랍니다.
          </p>
          <em class="emph_notice">
            <span class="ico_friends ico_bullet"></span>무게제한 : 30kg 이하의 물품 <span class="txt_g">(일부 국가 20kg 이하 제한)</span>
          </em>
          <em class="emph_notice">
            <span class="ico_friends ico_bullet"></span>부피제한 : 도착지 국가에 따라 부피 제한이 있습니다.
          </em>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">2</span>관세안내</strong>
          <p class="desc_notice">
            관세 및 세금, 각종 비용은 배송비에 포함되어 있지 않습니다. 상품수령 시 고객님이 추가로 지불하셔야 합니다.
          </p>
          <em class="emph_notice"><span class="ico_friends ico_bullet"></span>가까운 우체국이나 세관에 보다 자세하고 정확한 관세 정보에 대한 문의 부탁드립니다.</em>
            <c:if test="${kakaoWebView == 0}">
          <div class="wrap_btn">
            <a href="http://ems.epost.go.kr/front.EmsDeliveryDelivery02.postal" class="btn_notice" target="_blank">EMS 안내</a>
            <a href="http://post.customs.go.kr/" class="btn_notice" target="_blank">서울 국제 우편 세관</a>
          </div>
            </c:if>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">3</span>배송지연</strong>
          <p class="desc_notice">
            일부 상품이 도착하지 않은 경우, 전체 상품의 글로벌 배송이 지연될 수 있습니다.<br>
            글로벌 배송 관련 문의는 <em class="emph_g">1:1 문의하기</em> 또는 <em class="emph_g">global@kakaofriends.com</em> 으로 문의해주시기 바랍니다.
          </p>
          <sec:authorize access="isAnonymous()">
            <a href="javascript:loginPopup();" class="btn_notice">1:1 문의</a>
          </sec:authorize>
          <sec:authorize access="isFullyAuthenticated()">
            <a href="/kr/mypage/onetoone" class="btn_notice">1:1 문의</a>
          </sec:authorize>
        </li>
      </ul>
      <h4 class="tit_notice">상품관련</h4>
      <ul class="list_notice">
        <li>
          <strong class="tit_item"><span class="num_item">1</span>취소 / 반품 / 교환 안내</strong>
          <p class="desc_notice">
            글로벌 배송의 구매 취소는 국내에서 주문 접수 단계까지 지원하고 있습니다.<br>
            구매 완료 후 국내배송에서 제공하고 있는 구매확정, 반품신청, 교환신청 기능은 별도로 제공하지 않습니다.<br>
            해외에서 상품을 수령한 이후 단순 변심에 의한 교환 및 반품은 지원하지 않고 있으므로 신중한 구매 결정을 부탁드립니다.<br>
            이외에 제품 불량 등으로 인한 교환은 <em class="emph_g">1:1 문의</em> 또는 <em class="emph_g">global@kakaofriends.com</em> 으로 문의해주시기 바랍니다.
          </p>
          <sec:authorize access="isAnonymous()">
            <a href="javascript:loginPopup();" class="btn_notice">1:1 문의</a>
          </sec:authorize>
          <sec:authorize access="isFullyAuthenticated()">
            <a href="/kr/mypage/onetoone" class="btn_notice">1:1 문의</a>
          </sec:authorize>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">2</span>통관 및 관세</strong>
          <p class="desc_notice">
            우리나라에서도 해외에서 배송한 상품을 받을 때에는 일부 상품에 대해 관세법의 기준에 따라 관세와 부가세 및 특별세 등의 세금을 징수합니다.<br>
            해외의 각국들 역시 도착지의 세법에 따라 세금을 징수할 수도 있으며, 그 부담은 상품을 받는 사람이 지게 됩니다.<br>
            하지만 특별한 경우를 제외한다면, 선물용으로 보내는 상품에 대해서는 세금이 없습니다.
          </p>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">3</span>전자 제품 구매시 유의사항</strong>
          <p class="desc_notice">
            전자제품을 구매하실 때는 반드시 판매자 게시판을 통해 전압, 전류 등을 확인한 다음, 배송 국가의 사용환경에 맞는 제품을 구매하시기 바랍니다.<br>
            다른 상품을 구매 또는 사용시 발생할 수 있는 모든 문제의 책임은 고객에게 있습니다.
          </p>
        </li>
      </ul>
      <h4 class="tit_notice">국가별</h4>
      <p class="desc_country">
        전자제품 배송 시 상품별로 반드시 판매자에게 해당 상품의 전압 등 해당 국가의 사용환경을 고려하여 충분히 문의하신 후에 구매해 주시기 바랍니다.<br>
        구매자가 이를 확인하지 않고 글로벌 배송하여 사용하실 수 없게 된 경우, 이로 인해 발생하는 반품비는 구매자가 부담하여야 합니다.<br>
        상품하자/오배송에 의한 반품의 경우, 반드시 해당 지역 우체국을 통해 발송해 주시기 바랍니다. 다른 국제 특송사를 사용해서 보내실 경우, 한국세관에 의해 부과된
        관세가 있을 경우 추가 부담하셔야 합니다.
      </p>
      <ul class="list_notice">
        <li>
          <strong class="tit_item"><span class="num_item">1</span>글로벌 배송 불가 물품 안내</strong>
          <p class="desc_notice">
            부피나 무게가 지나치게 큰 제품<br>
            부패할 수 있는 제품 (음식물 또는 다른 우편물을 오염시키거나 훼손을 줄 수 있는 물품 등)<br>
            배달국가에서 수입이나 유포를 금하는 부적절한 제품 (모조품, 반입금지물품, 위험물, 귀금속 등. 국가별 기준 상이)<br>
            폭발성, 가연성 또는 기타 위험한 물질 (스프레이로 된 제품이나 버너 등)
          </p>
          <em class="emph_notice">
            <span class="ico_friends ico_bullet"></span>보다 자세한 내용은 아래 국가별 통관 정보 또는 가까운 우체국이나 세관에 문의 부탁 드립니다.
          </em>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">2</span>국가별 유의사항</strong>
          <p class="desc_notice">각 국가별 금지 및 제한 품목에 대한 자세한 안내는 아래 국가별 통관 정보를 통해 확인 부탁드립니다.</p>
            <c:if test="${kakaoWebView == 0}">
          <a href="http://ems.epost.go.kr/front.EmsSurveySurvey01.postal" class="btn_notice" target="_blank">국가별 통관 정보</a>
            </c:if>
        </li>
      </ul>
    </div>
  </div>

  <div id="tabInfo4" class="tab_cont">
    <h3 class="screen_out">배송비 안내</h3>
    <div class="cont_subject cont_fare">
      <h4 class="tit_item"><span class="num_item">1</span> EMS 국제 특송 서비스</h4>
      <p class="desc_notice">
        <span class="txt_notice">글로벌 배송 - 최대 30kg까지 가능<br class="rw_show"></span>
        <span class="txt_notice">EMS 배송비는 상품 무게와 배송 상자 무게를 합산하여 책정됩니다.<br class="rw_show"></span>
        <span class="txt_notice">EMS로 배송되는 상품은 발송 후
          <sec:authorize access="isAnonymous()">
            <a href="javascript:loginPopup();" class="link_global">&lsquo; 마이페이지 &gt; 주문내역 &rsquo;</a>
          </sec:authorize>
          <sec:authorize access="isFullyAuthenticated()">
            <a href="/kr/mypage/orderlist" class="link_global">&lsquo; 마이페이지 &gt; 주문내역 &rsquo;</a>
          </sec:authorize>
          에서도 배송 조회 등 확인이 가능합니다.</span>
      </p>
        <c:if test="${kakaoWebView == 0}">
      <a href="http://ems.epost.go.kr/front.EmsDeliveryDelivery02.postal" class="btn_notice" target="_blank">EMS 안내</a>
        </c:if>
      <h4 class="tit_item"><span class="num_item">2</span> 지역별 배송 가능 국가</h4>
      <!-- 2017-07-10 수정 -->
      <dl class="list_item">
        <dt>특정지역 :</dt>
        <dd>뉴질랜드, 독일, 대만, 러시아, 말레이시아, 미국, 브라질, 베트남, 스페인, 싱가포르, 영국, 인도네시아, 일본, 중국, 캐나다, 태국, 필리핀, 호주, 홍콩</dd>
        <dt>1지역 :</dt>
        <dd>라오스, 마카오, 미얀마</dd>
        <dt>2지역 :</dt>
        <dd>브루나이, 인도</dd>
        <dt>3지역 :</dt>
        <dd>네델란드, 노르웨이, 덴마크, 루마니아, 벨기에, 사우디 아라비아, 스웨덴, 스위스, 슬로바키아, 아랍에미리트, 아일랜드, 오스트리아, 우즈베키스탄, 이스라엘, 체코, 포르투칼, 폴란드, 핀란드, 카타르, 크로아티아, 터키</dd>
        <dt>4지역 :</dt>
        <dd>멕시코, 모로코, 아르헨티나, 칠레, 케냐, 페루</dd>
      </dl>
      <!-- // 2017-07-10 수정 -->
      <h4 class="tit_item"><span class="num_item">3</span> 무게 및 지역별 배송 요금</h4>
      <div class="wrap_table">
        <div id="tableItem1" class="table_item item_type1">
          <table class="tbl_global">
            <caption class="ir_caption">호주, 브라질, 캐나다, 중국 배송요금표</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">중량(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">호주</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">브라질</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">캐나다</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">중국</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>23,000<span class="screen_out">원</span></td><td>32,000<span class="screen_out">원</span></td><td>29,000<span class="screen_out">원</span></td><td>23,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>26,000<span class="screen_out">원</span></td><td>35,000<span class="screen_out">원</span></td><td>31,000<span class="screen_out">원</span></td><td>25,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>29,000<span class="screen_out">원</span></td><td>38,000<span class="screen_out">원</span></td><td>33,000<span class="screen_out">원</span></td><td>26,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>32,000<span class="screen_out">원</span></td><td>41,000<span class="screen_out">원</span></td><td>35,000<span class="screen_out">원</span></td><td>28,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>35,000<span class="screen_out">원</span></td><td>44,500<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td><td>30,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>38,500<span class="screen_out">원</span></td><td>47,500<span class="screen_out">원</span></td><td>39,500<span class="screen_out">원</span></td><td>31,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>41,500<span class="screen_out">원</span></td><td>50,500<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td><td>32,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>46,500<span class="screen_out">원</span></td><td>56,500<span class="screen_out">원</span></td><td>45,500<span class="screen_out">원</span></td><td>34,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>51,000<span class="screen_out">원</span></td><td>62,000<span class="screen_out">원</span></td><td>49,000<span class="screen_out">원</span></td><td>35,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>56,000<span class="screen_out">원</span></td><td>68,000<span class="screen_out">원</span></td><td>53,000<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>60,500<span class="screen_out">원</span></td><td>74,000<span class="screen_out">원</span></td><td>57,000<span class="screen_out">원</span></td><td>39,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>65,500<span class="screen_out">원</span></td><td>79,500<span class="screen_out">원</span></td><td>60,500<span class="screen_out">원</span></td><td>40,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>70,000<span class="screen_out">원</span></td><td>87,500<span class="screen_out">원</span></td><td>64,500<span class="screen_out">원</span></td><td>42,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>75,000<span class="screen_out">원</span></td><td>95,500<span class="screen_out">원</span></td><td>68,500<span class="screen_out">원</span></td><td>44,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>80,000<span class="screen_out">원</span></td><td>103,500<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td><td>45,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>84,500<span class="screen_out">원</span></td><td>111,500<span class="screen_out">원</span></td><td>76,500<span class="screen_out">원</span></td><td>47,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>89,500<span class="screen_out">원</span></td><td>119,500<span class="screen_out">원</span></td><td>80,500<span class="screen_out">원</span></td><td>48,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>94,000<span class="screen_out">원</span></td><td>128,000<span class="screen_out">원</span></td><td>84,500<span class="screen_out">원</span></td><td>50,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>99,000<span class="screen_out">원</span></td><td>136,000<span class="screen_out">원</span></td><td>89,000<span class="screen_out">원</span></td><td>52,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>104,000<span class="screen_out">원</span></td><td>144,000<span class="screen_out">원</span></td><td>93,000<span class="screen_out">원</span></td><td>53,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>108,500<span class="screen_out">원</span></td><td>152,000<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>55,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>113,500<span class="screen_out">원</span></td><td>160,000<span class="screen_out">원</span></td><td>101,500<span class="screen_out">원</span></td><td>57,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>118,000<span class="screen_out">원</span></td><td>168,000<span class="screen_out">원</span></td><td>105,500<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>123,000<span class="screen_out">원</span></td><td>176,000<span class="screen_out">원</span></td><td>110,000<span class="screen_out">원</span></td><td>60,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>127,500<span class="screen_out">원</span></td><td>184,000<span class="screen_out">원</span></td><td>114,000<span class="screen_out">원</span></td><td>62,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>132,500<span class="screen_out">원</span></td><td>192,000<span class="screen_out">원</span></td><td>118,500<span class="screen_out">원</span></td><td>63,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>137,500<span class="screen_out">원</span></td><td>200,000<span class="screen_out">원</span></td><td>122,500<span class="screen_out">원</span></td><td>65,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>142,000<span class="screen_out">원</span></td><td>208,000<span class="screen_out">원</span></td><td>126,500<span class="screen_out">원</span></td><td>67,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>147,000<span class="screen_out">원</span></td><td>216,000<span class="screen_out">원</span></td><td>131,000<span class="screen_out">원</span></td><td>68,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>151,500<span class="screen_out">원</span></td><td>224,000<span class="screen_out">원</span></td><td>135,000<span class="screen_out">원</span></td><td>70,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>156,500<span class="screen_out">원</span></td><td>232,000<span class="screen_out">원</span></td><td>139,500<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>161,500<span class="screen_out">원</span></td><td>240,000<span class="screen_out">원</span></td><td>143,500<span class="screen_out">원</span></td><td>73,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>166,000<span class="screen_out">원</span></td><td>248,000<span class="screen_out">원</span></td><td>148,000<span class="screen_out">원</span></td><td>75,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>171,000<span class="screen_out">원</span></td><td>256,000<span class="screen_out">원</span></td><td>152,000<span class="screen_out">원</span></td><td>76,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>175,500<span class="screen_out">원</span></td><td>264,000<span class="screen_out">원</span></td><td>156,000<span class="screen_out">원</span></td><td>78,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>180,500<span class="screen_out">원</span></td><td>272,000<span class="screen_out">원</span></td><td>160,500<span class="screen_out">원</span></td><td>80,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>185,000<span class="screen_out">원</span></td><td>280,000<span class="screen_out">원</span></td><td>164,500<span class="screen_out">원</span></td><td>82,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>190,000<span class="screen_out">원</span></td><td>288,000<span class="screen_out">원</span></td><td>169,000<span class="screen_out">원</span></td><td>84,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>195,000<span class="screen_out">원</span></td><td>296,000<span class="screen_out">원</span></td><td>173,000<span class="screen_out">원</span></td><td>86,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>199,500<span class="screen_out">원</span></td><td>304,500<span class="screen_out">원</span></td><td>177,000<span class="screen_out">원</span></td><td>88,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>204,500<span class="screen_out">원</span></td><td>312,500<span class="screen_out">원</span></td><td>181,500<span class="screen_out">원</span></td><td>90,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>209,000<span class="screen_out">원</span></td><td>320,500<span class="screen_out">원</span></td><td>185,500<span class="screen_out">원</span></td><td>92,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>214,000<span class="screen_out">원</span></td><td>328,500<span class="screen_out">원</span></td><td>190,000<span class="screen_out">원</span></td><td>94,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>219,000<span class="screen_out">원</span></td><td>336,500<span class="screen_out">원</span></td><td>194,000<span class="screen_out">원</span></td><td>96,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>223,500<span class="screen_out">원</span></td><td>344,500<span class="screen_out">원</span></td><td>198,000<span class="screen_out">원</span></td><td>98,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>228,500<span class="screen_out">원</span></td><td>352,500<span class="screen_out">원</span></td><td>202,500<span class="screen_out">원</span></td><td>100,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>233,000<span class="screen_out">원</span></td><td>360,500<span class="screen_out">원</span></td><td>206,500<span class="screen_out">원</span></td><td>102,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>238,000<span class="screen_out">원</span></td><td>368,500<span class="screen_out">원</span></td><td>211,000<span class="screen_out">원</span></td><td>103,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>243,000<span class="screen_out">원</span></td><td>376,500<span class="screen_out">원</span></td><td>215,000<span class="screen_out">원</span></td><td>105,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>247,500<span class="screen_out">원</span></td><td>384,500<span class="screen_out">원</span></td><td>219,000<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>252,500<span class="screen_out">원</span></td><td>392,500<span class="screen_out">원</span></td><td>223,500<span class="screen_out">원</span></td><td>109,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>257,000<span class="screen_out">원</span></td><td>400,500<span class="screen_out">원</span></td><td>227,500<span class="screen_out">원</span></td><td>111,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>262,000<span class="screen_out">원</span></td><td>408,500<span class="screen_out">원</span></td><td>232,000<span class="screen_out">원</span></td><td>113,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>266,500<span class="screen_out">원</span></td><td>416,500<span class="screen_out">원</span></td><td>236,000<span class="screen_out">원</span></td><td>115,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>271,500<span class="screen_out">원</span></td><td>424,500<span class="screen_out">원</span></td><td>240,000<span class="screen_out">원</span></td><td>117,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>276,500<span class="screen_out">원</span></td><td>432,500<span class="screen_out">원</span></td><td>244,500<span class="screen_out">원</span></td><td>119,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>281,000<span class="screen_out">원</span></td><td>440,500<span class="screen_out">원</span></td><td>248,500<span class="screen_out">원</span></td><td>121,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>286,000<span class="screen_out">원</span></td><td>448,500<span class="screen_out">원</span></td><td>253,000<span class="screen_out">원</span></td><td>123,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>290,500<span class="screen_out">원</span></td><td>456,500<span class="screen_out">원</span></td><td>257,000<span class="screen_out">원</span></td><td>125,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>295,500<span class="screen_out">원</span></td><td>464,500<span class="screen_out">원</span></td><td>261,500<span class="screen_out">원</span></td><td>127,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>300,500<span class="screen_out">원</span></td><td>472,500<span class="screen_out">원</span></td><td>265,500<span class="screen_out">원</span></td><td>129,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>305,000<span class="screen_out">원</span></td><td>481,000<span class="screen_out">원</span></td><td>269,500<span class="screen_out">원</span></td><td>130,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>310,000<span class="screen_out">원</span></td><td>489,000<span class="screen_out">원</span></td><td>274,000<span class="screen_out">원</span></td><td>132,500<span class="screen_out">원</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem1" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
        </div>

        <div id="tableItem2" class="table_item item_type2">
          <table class="tbl_global">
            <caption class="ir_caption">독일, 홍콩, 인도네시아, 미국 배송요금표</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">중량(Kg)</th>
              <%--<th class="col_type2" scope="col"><span class="txt_region">프랑스</span></th>--%>
              <th class="col_type2" scope="col"><span class="txt_region">독일</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">홍콩</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">인도네시아</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">미국</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td> 30,500<span class="screen_out">원</span></td><td>22,500<span class="screen_out">원</span></td><td>19,000<span class="screen_out">원</span></td><td>26,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td> 33,000<span class="screen_out">원</span></td><td>23,500<span class="screen_out">원</span></td><td>20,000<span class="screen_out">원</span></td><td>30,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td> 35,000<span class="screen_out">원</span></td><td>24,500<span class="screen_out">원</span></td><td>21,000<span class="screen_out">원</span></td><td>33,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td> 37,000<span class="screen_out">원</span></td><td>25,500<span class="screen_out">원</span></td><td>22,500<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td> 39,000<span class="screen_out">원</span></td><td>26,500<span class="screen_out">원</span></td><td>23,500<span class="screen_out">원</span></td><td>40,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td> 41,000<span class="screen_out">원</span></td><td>27,500<span class="screen_out">원</span></td><td>24,500<span class="screen_out">원</span></td><td>44,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td> 43,500<span class="screen_out">원</span></td><td>28,500<span class="screen_out">원</span></td><td>25,500<span class="screen_out">원</span></td><td>47,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td> 47,000<span class="screen_out">원</span></td><td>30,000<span class="screen_out">원</span></td><td>27,500<span class="screen_out">원</span></td><td>54,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td> 50,500<span class="screen_out">원</span></td><td>31,500<span class="screen_out">원</span></td><td>30,000<span class="screen_out">원</span></td><td>61,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td> 54,000<span class="screen_out">원</span></td><td>33,000<span class="screen_out">원</span></td><td>32,000<span class="screen_out">원</span></td><td>68,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td> 58,000<span class="screen_out">원</span></td><td>34,500<span class="screen_out">원</span></td><td>34,000<span class="screen_out">원</span></td><td>74,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td> 61,500<span class="screen_out">원</span></td><td>35,500<span class="screen_out">원</span></td><td>36,000<span class="screen_out">원</span></td><td>81,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td> 65,000<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td><td>38,000<span class="screen_out">원</span></td><td>88,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td> 68,500<span class="screen_out">원</span></td><td>38,500<span class="screen_out">원</span></td><td>40,000<span class="screen_out">원</span></td><td>95,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td> 72,500<span class="screen_out">원</span></td><td>40,000<span class="screen_out">원</span></td><td>42,000<span class="screen_out">원</span></td><td>102,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td> 76,000<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td><td>44,000<span class="screen_out">원</span></td><td>108,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td> 80,000<span class="screen_out">원</span></td><td>43,000<span class="screen_out">원</span></td><td>46,000<span class="screen_out">원</span></td><td>115,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td> 84,500<span class="screen_out">원</span></td><td>44,500<span class="screen_out">원</span></td><td>48,000<span class="screen_out">원</span></td><td>122,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td> 88,500<span class="screen_out">원</span></td><td>46,000<span class="screen_out">원</span></td><td>50,000<span class="screen_out">원</span></td><td>129,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td> 93,000<span class="screen_out">원</span></td><td>48,000<span class="screen_out">원</span></td><td>52,000<span class="screen_out">원</span></td><td>135,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td> 97,000<span class="screen_out">원</span></td><td>50,000<span class="screen_out">원</span></td><td>54,000<span class="screen_out">원</span></td><td>142,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td> 101,000<span class="screen_out">원</span></td><td>52,000<span class="screen_out">원</span></td><td>56,000<span class="screen_out">원</span></td><td>149,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td> 105,500<span class="screen_out">원</span></td><td>54,000<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td><td>156,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td> 109,500<span class="screen_out">원</span></td><td>56,000<span class="screen_out">원</span></td><td>61,500<span class="screen_out">원</span></td><td>163,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td> 114,000<span class="screen_out">원</span></td><td>58,000<span class="screen_out">원</span></td><td>64,000<span class="screen_out">원</span></td><td>169,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td> 118,000<span class="screen_out">원</span></td><td>60,000<span class="screen_out">원</span></td><td>67,000<span class="screen_out">원</span></td><td>176,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td> 122,500<span class="screen_out">원</span></td><td>62,000<span class="screen_out">원</span></td><td>69,500<span class="screen_out">원</span></td><td>183,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td> 126,500<span class="screen_out">원</span></td><td>64,000<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td><td>190,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td> 130,500<span class="screen_out">원</span></td><td>66,000<span class="screen_out">원</span></td><td>75,000<span class="screen_out">원</span></td><td>197,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td> 135,000<span class="screen_out">원</span></td><td>68,000<span class="screen_out">원</span></td><td>77,500<span class="screen_out">원</span></td><td>203,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td> 139,000<span class="screen_out">원</span></td><td>70,000<span class="screen_out">원</span></td><td>80,500<span class="screen_out">원</span></td><td>210,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td> 143,500<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td><td>83,000<span class="screen_out">원</span></td><td>217,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td> 147,500<span class="screen_out">원</span></td><td>74,000<span class="screen_out">원</span></td><td>86,000<span class="screen_out">원</span></td><td>224,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td> 152,000<span class="screen_out">원</span></td><td>76,000<span class="screen_out">원</span></td><td>88,500<span class="screen_out">원</span></td><td>231,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td> 156,000<span class="screen_out">원</span></td><td>77,500<span class="screen_out">원</span></td><td>91,500<span class="screen_out">원</span></td><td>237,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td> 160,500<span class="screen_out">원</span></td><td>79,500<span class="screen_out">원</span></td><td>94,000<span class="screen_out">원</span></td><td>244,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td> 164,500<span class="screen_out">원</span></td><td>81,500<span class="screen_out">원</span></td><td>97,000<span class="screen_out">원</span></td><td>251,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td> 168,500<span class="screen_out">원</span></td><td>83,500<span class="screen_out">원</span></td><td>99,500<span class="screen_out">원</span></td><td>258,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td> 173,000<span class="screen_out">원</span></td><td>85,500<span class="screen_out">원</span></td><td>102,000<span class="screen_out">원</span></td><td>264,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td> 177,000<span class="screen_out">원</span></td><td>87,500<span class="screen_out">원</span></td><td>105,000<span class="screen_out">원</span></td><td>271,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td> 181,500<span class="screen_out">원</span></td><td>89,500<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td><td>278,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td> 185,500<span class="screen_out">원</span></td><td>91,500<span class="screen_out">원</span></td><td>110,500<span class="screen_out">원</span></td><td>285,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td> 190,000<span class="screen_out">원</span></td><td>93,500<span class="screen_out">원</span></td><td>113,000<span class="screen_out">원</span></td><td>292,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td> 194,000<span class="screen_out">원</span></td><td>95,500<span class="screen_out">원</span></td><td>116,000<span class="screen_out">원</span></td><td>298,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td> 198,000<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>118,500<span class="screen_out">원</span></td><td>305,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td> 202,500<span class="screen_out">원</span></td><td>99,500<span class="screen_out">원</span></td><td>121,500<span class="screen_out">원</span></td><td>312,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td> 206,500<span class="screen_out">원</span></td><td>101,500<span class="screen_out">원</span></td><td>124,000<span class="screen_out">원</span></td><td>319,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td> 211,000<span class="screen_out">원</span></td><td>103,500<span class="screen_out">원</span></td><td>126,500<span class="screen_out">원</span></td><td>326,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td> 215,000<span class="screen_out">원</span></td><td>105,500<span class="screen_out">원</span></td><td>129,500<span class="screen_out">원</span></td><td>332,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td> 219,500<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td><td>132,000<span class="screen_out">원</span></td><td>339,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td> 223,500<span class="screen_out">원</span></td><td>109,500<span class="screen_out">원</span></td><td>135,000<span class="screen_out">원</span></td><td>346,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td> 228,000<span class="screen_out">원</span></td><td>111,500<span class="screen_out">원</span></td><td>137,500<span class="screen_out">원</span></td><td>353,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td> 232,000<span class="screen_out">원</span></td><td>113,500<span class="screen_out">원</span></td><td>140,500<span class="screen_out">원</span></td><td>360,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td> 236,000<span class="screen_out">원</span></td><td>115,500<span class="screen_out">원</span></td><td>143,000<span class="screen_out">원</span></td><td>366,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td> 240,500<span class="screen_out">원</span></td><td>117,000<span class="screen_out">원</span></td><td>146,000<span class="screen_out">원</span></td><td>373,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td> 244,500<span class="screen_out">원</span></td><td>119,000<span class="screen_out">원</span></td><td>148,500<span class="screen_out">원</span></td><td>380,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td> 249,000<span class="screen_out">원</span></td><td>121,000<span class="screen_out">원</span></td><td>151,500<span class="screen_out">원</span></td><td>387,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td> 253,000<span class="screen_out">원</span></td><td>123,000<span class="screen_out">원</span></td><td>154,000<span class="screen_out">원</span></td><td>393,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td> 257,500<span class="screen_out">원</span></td><td>125,000<span class="screen_out">원</span></td><td>156,500<span class="screen_out">원</span></td><td>400,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td> 261,500<span class="screen_out">원</span></td><td>127,000<span class="screen_out">원</span></td><td>159,500<span class="screen_out">원</span></td><td>407,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td> 265,500<span class="screen_out">원</span></td><td>129,000<span class="screen_out">원</span></td><td>162,000<span class="screen_out">원</span></td><td>414,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td> 270,000<span class="screen_out">원</span></td><td>131,000<span class="screen_out">원</span></td><td>165,000<span class="screen_out">원</span></td><td>421,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td> 274,000<span class="screen_out">원</span></td><td>133,000<span class="screen_out">원</span></td><td>167,500<span class="screen_out">원</span></td><td>427,500<span class="screen_out">원</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem2" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
        </div>
        <a href="#none" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
      </div>

      <div class="wrap_table">
        <div id="tableItem3" class="table_item item_type1">
          <table class="tbl_global">
            <caption class="ir_caption">일본, 말레이시아, 뉴질랜드, 필리핀 배송요금표</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">중량(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">일본</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">말레이시아</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">뉴질랜드</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">필리핀</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>23,500<span class="screen_out">원</span></td><td>17,500<span class="screen_out">원</span></td><td>23,500<span class="screen_out">원</span></td><td>18,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>24,500<span class="screen_out">원</span></td><td>19,000<span class="screen_out">원</span></td><td>26,000<span class="screen_out">원</span></td><td>19,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>25,500<span class="screen_out">원</span></td><td>20,500<span class="screen_out">원</span></td><td>28,000<span class="screen_out">원</span></td><td>20,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>27,500<span class="screen_out">원</span></td><td>22,000<span class="screen_out">원</span></td><td>30,500<span class="screen_out">원</span></td><td>21,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>28,500<span class="screen_out">원</span></td><td>23,500<span class="screen_out">원</span></td><td>32,500<span class="screen_out">원</span></td><td>23,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>31,000<span class="screen_out">원</span></td><td>25,000<span class="screen_out">원</span></td><td>35,000<span class="screen_out">원</span></td><td>24,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>33,000<span class="screen_out">원</span></td><td>26,500<span class="screen_out">원</span></td><td>37,500<span class="screen_out">원</span></td><td>25,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>34,500<span class="screen_out">원</span></td><td>29,000<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td><td>26,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>36,500<span class="screen_out">원</span></td><td>31,500<span class="screen_out">원</span></td><td>45,500<span class="screen_out">원</span></td><td>28,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>38,000<span class="screen_out">원</span></td><td>34,000<span class="screen_out">원</span></td><td>50,000<span class="screen_out">원</span></td><td>30,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>40,000<span class="screen_out">원</span></td><td>36,500<span class="screen_out">원</span></td><td>54,000<span class="screen_out">원</span></td><td>32,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>41,500<span class="screen_out">원</span></td><td>39,000<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td><td>33,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>43,000<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td><td>62,500<span class="screen_out">원</span></td><td>35,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>45,000<span class="screen_out">원</span></td><td>44,000<span class="screen_out">원</span></td><td>67,000<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>46,500<span class="screen_out">원</span></td><td>46,500<span class="screen_out">원</span></td><td>71,000<span class="screen_out">원</span></td><td>39,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>48,500<span class="screen_out">원</span></td><td>49,000<span class="screen_out">원</span></td><td>75,500<span class="screen_out">원</span></td><td>40,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>50,000<span class="screen_out">원</span></td><td>51,500<span class="screen_out">원</span></td><td>80,000<span class="screen_out">원</span></td><td>42,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>51,500<span class="screen_out">원</span></td><td>54,500<span class="screen_out">원</span></td><td>84,000<span class="screen_out">원</span></td><td>44,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>53,500<span class="screen_out">원</span></td><td>57,000<span class="screen_out">원</span></td><td>88,500<span class="screen_out">원</span></td><td>46,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>55,000<span class="screen_out">원</span></td><td>60,000<span class="screen_out">원</span></td><td>93,000<span class="screen_out">원</span></td><td>48,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>57,000<span class="screen_out">원</span></td><td>63,000<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>50,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>58,500<span class="screen_out">원</span></td><td>66,000<span class="screen_out">원</span></td><td>101,500<span class="screen_out">원</span></td><td>53,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>60,000<span class="screen_out">원</span></td><td>68,500<span class="screen_out">원</span></td><td>106,000<span class="screen_out">원</span></td><td>55,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>62,000<span class="screen_out">원</span></td><td>71,500<span class="screen_out">원</span></td><td>110,500<span class="screen_out">원</span></td><td>57,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>63,500<span class="screen_out">원</span></td><td>74,500<span class="screen_out">원</span></td><td>115,000<span class="screen_out">원</span></td><td>59,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>65,500<span class="screen_out">원</span></td><td>77,500<span class="screen_out">원</span></td><td>119,000<span class="screen_out">원</span></td><td>61,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>67,000<span class="screen_out">원</span></td><td>80,000<span class="screen_out">원</span></td><td>123,500<span class="screen_out">원</span></td><td>63,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>69,000<span class="screen_out">원</span></td><td>83,000<span class="screen_out">원</span></td><td>128,000<span class="screen_out">원</span></td><td>65,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>70,500<span class="screen_out">원</span></td><td>86,000<span class="screen_out">원</span></td><td>132,000<span class="screen_out">원</span></td><td>67,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>71,500<span class="screen_out">원</span></td><td>89,000<span class="screen_out">원</span></td><td>136,500<span class="screen_out">원</span></td><td>69,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>73,500<span class="screen_out">원</span></td><td>92,000<span class="screen_out">원</span></td><td>141,000<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>75,000<span class="screen_out">원</span></td><td>94,500<span class="screen_out">원</span></td><td>145,500<span class="screen_out">원</span></td><td>74,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>76,500<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>149,500<span class="screen_out">원</span></td><td>76,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>78,000<span class="screen_out">원</span></td><td>100,500<span class="screen_out">원</span></td><td>154,000<span class="screen_out">원</span></td><td>78,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>79,500<span class="screen_out">원</span></td><td>103,500<span class="screen_out">원</span></td><td>158,500<span class="screen_out">원</span></td><td>80,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>81,000<span class="screen_out">원</span></td><td>106,000<span class="screen_out">원</span></td><td>163,000<span class="screen_out">원</span></td><td>82,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>82,500<span class="screen_out">원</span></td><td>109,000<span class="screen_out">원</span></td><td>167,000<span class="screen_out">원</span></td><td>84,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>84,000<span class="screen_out">원</span></td><td>112,000<span class="screen_out">원</span></td><td>171,500<span class="screen_out">원</span></td><td>86,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>85,500<span class="screen_out">원</span></td><td>115,000<span class="screen_out">원</span></td><td>176,000<span class="screen_out">원</span></td><td>88,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>87,000<span class="screen_out">원</span></td><td>117,500<span class="screen_out">원</span></td><td>180,500<span class="screen_out">원</span></td><td>91,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>88,500<span class="screen_out">원</span></td><td>120,500<span class="screen_out">원</span></td><td>184,500<span class="screen_out">원</span></td><td>93,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>90,000<span class="screen_out">원</span></td><td>123,500<span class="screen_out">원</span></td><td>189,000<span class="screen_out">원</span></td><td>95,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>91,500<span class="screen_out">원</span></td><td>126,500<span class="screen_out">원</span></td><td>193,500<span class="screen_out">원</span></td><td>97,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>93,000<span class="screen_out">원</span></td><td>129,500<span class="screen_out">원</span></td><td>197,500<span class="screen_out">원</span></td><td>99,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>94,500<span class="screen_out">원</span></td><td>132,000<span class="screen_out">원</span></td><td>202,000<span class="screen_out">원</span></td><td>101,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>96,000<span class="screen_out">원</span></td><td>135,000<span class="screen_out">원</span></td><td>206,500<span class="screen_out">원</span></td><td>103,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>97,500<span class="screen_out">원</span></td><td>138,000<span class="screen_out">원</span></td><td>211,000<span class="screen_out">원</span></td><td>105,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>99,000<span class="screen_out">원</span></td><td>141,000<span class="screen_out">원</span></td><td>215,000<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>100,500<span class="screen_out">원</span></td><td>143,500<span class="screen_out">원</span></td><td>219,500<span class="screen_out">원</span></td><td>110,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>102,000<span class="screen_out">원</span></td><td>146,500<span class="screen_out">원</span></td><td>224,000<span class="screen_out">원</span></td><td>112,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>103,500<span class="screen_out">원</span></td><td>149,500<span class="screen_out">원</span></td><td>228,500<span class="screen_out">원</span></td><td>114,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>105,000<span class="screen_out">원</span></td><td>152,500<span class="screen_out">원</span></td><td>232,500<span class="screen_out">원</span></td><td>116,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>106,500<span class="screen_out">원</span></td><td>155,000<span class="screen_out">원</span></td><td>237,000<span class="screen_out">원</span></td><td>118,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>108,000<span class="screen_out">원</span></td><td>158,000<span class="screen_out">원</span></td><td>241,500<span class="screen_out">원</span></td><td>120,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>109,500<span class="screen_out">원</span></td><td>161,000<span class="screen_out">원</span></td><td>246,000<span class="screen_out">원</span></td><td>122,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>111,000<span class="screen_out">원</span></td><td>164,000<span class="screen_out">원</span></td><td>250,000<span class="screen_out">원</span></td><td>124,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>112,500<span class="screen_out">원</span></td><td>167,000<span class="screen_out">원</span></td><td>254,500<span class="screen_out">원</span></td><td>126,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>114,000<span class="screen_out">원</span></td><td>169,500<span class="screen_out">원</span></td><td>259,000<span class="screen_out">원</span></td><td>129,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>115,500<span class="screen_out">원</span></td><td>172,500<span class="screen_out">원</span></td><td>263,000<span class="screen_out">원</span></td><td>131,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>117,000<span class="screen_out">원</span></td><td>175,500<span class="screen_out">원</span></td><td>267,500<span class="screen_out">원</span></td><td>133,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>118,500<span class="screen_out">원</span></td><td>178,500<span class="screen_out">원</span></td><td>272,000<span class="screen_out">원</span></td><td>135,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>120,000<span class="screen_out">원</span></td><td>181,000<span class="screen_out">원</span></td><td>276,500<span class="screen_out">원</span></td><td>137,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>121,500<span class="screen_out">원</span></td><td>184,000<span class="screen_out">원</span></td><td>280,500<span class="screen_out">원</span></td><td>139,500<span class="screen_out">원</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem3" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
        </div>

        <div id="tableItem4" class="table_item item_type2">
          <table class="tbl_global">
            <caption class="ir_caption">러시아, 싱가포르, 스페인, 대만 배송요금표</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">중량(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">러시아</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">싱가포르</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">스페인</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">대만</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>32,500<span class="screen_out">원</span></td><td>15,000<span class="screen_out">원</span></td><td>28,500<span class="screen_out">원</span></td><td>17,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>35,500<span class="screen_out">원</span></td><td>16,500<span class="screen_out">원</span></td><td>30,500<span class="screen_out">원</span></td><td>18,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>38,500<span class="screen_out">원</span></td><td>18,000<span class="screen_out">원</span></td><td>32,500<span class="screen_out">원</span></td><td>19,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>41,500<span class="screen_out">원</span></td><td>19,500<span class="screen_out">원</span></td><td>35,000<span class="screen_out">원</span></td><td>20,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>44,500<span class="screen_out">원</span></td><td>21,000<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td><td>21,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>48,000<span class="screen_out">원</span></td><td>22,500<span class="screen_out">원</span></td><td>39,500<span class="screen_out">원</span></td><td>21,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>51,000<span class="screen_out">원</span></td><td>24,000<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td><td>22,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>56,000<span class="screen_out">원</span></td><td>26,000<span class="screen_out">원</span></td><td>45,500<span class="screen_out">원</span></td><td>24,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>60,500<span class="screen_out">원</span></td><td>28,500<span class="screen_out">원</span></td><td>49,500<span class="screen_out">원</span></td><td>25,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>65,500<span class="screen_out">원</span></td><td>30,500<span class="screen_out">원</span></td><td>53,500<span class="screen_out">원</span></td><td>27,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>70,500<span class="screen_out">원</span></td><td>33,000<span class="screen_out">원</span></td><td>57,500<span class="screen_out">원</span></td><td>28,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>75,500<span class="screen_out">원</span></td><td>35,500<span class="screen_out">원</span></td><td>62,000<span class="screen_out">원</span></td><td>29,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>80,500<span class="screen_out">원</span></td><td>37,500<span class="screen_out">원</span></td><td>66,500<span class="screen_out">원</span></td><td>31,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>85,000<span class="screen_out">원</span></td><td>40,000<span class="screen_out">원</span></td><td>71,000<span class="screen_out">원</span></td><td>32,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>90,000<span class="screen_out">원</span></td><td>42,500<span class="screen_out">원</span></td><td>75,500<span class="screen_out">원</span></td><td>34,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>95,000<span class="screen_out">원</span></td><td>44,500<span class="screen_out">원</span></td><td>80,000<span class="screen_out">원</span></td><td>36,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>100,000<span class="screen_out">원</span></td><td>47,000<span class="screen_out">원</span></td><td>84,500<span class="screen_out">원</span></td><td>37,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>104,500<span class="screen_out">원</span></td><td>49,500<span class="screen_out">원</span></td><td>88,500<span class="screen_out">원</span></td><td>39,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>109,500<span class="screen_out">원</span></td><td>51,500<span class="screen_out">원</span></td><td>93,000<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>114,500<span class="screen_out">원</span></td><td>54,000<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>43,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>119,500<span class="screen_out">원</span></td><td>56,500<span class="screen_out">원</span></td><td>102,000<span class="screen_out">원</span></td><td>45,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>124,500<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td><td>106,500<span class="screen_out">원</span></td><td>47,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>128,500<span class="screen_out">원</span></td><td>61,000<span class="screen_out">원</span></td><td>111,000<span class="screen_out">원</span></td><td>49,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>132,500<span class="screen_out">원</span></td><td>63,500<span class="screen_out">원</span></td><td>115,000<span class="screen_out">원</span></td><td>51,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>137,000<span class="screen_out">원</span></td><td>65,500<span class="screen_out">원</span></td><td>119,500<span class="screen_out">원</span></td><td>53,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>141,000<span class="screen_out">원</span></td><td>68,000<span class="screen_out">원</span></td><td>124,000<span class="screen_out">원</span></td><td>54,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>145,000<span class="screen_out">원</span></td><td>70,500<span class="screen_out">원</span></td><td>128,500<span class="screen_out">원</span></td><td>56,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>149,500<span class="screen_out">원</span></td><td>72,500<span class="screen_out">원</span></td><td>133,000<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>153,500<span class="screen_out">원</span></td><td>75,000<span class="screen_out">원</span></td><td>137,500<span class="screen_out">원</span></td><td>60,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>157,500<span class="screen_out">원</span></td><td>77,500<span class="screen_out">원</span></td><td>142,000<span class="screen_out">원</span></td><td>62,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>161,500<span class="screen_out">원</span></td><td>79,500<span class="screen_out">원</span></td><td>146,000<span class="screen_out">원</span></td><td>64,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>166,000<span class="screen_out">원</span></td><td>82,000<span class="screen_out">원</span></td><td>150,500<span class="screen_out">원</span></td><td>66,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>170,000<span class="screen_out">원</span></td><td>84,500<span class="screen_out">원</span></td><td>155,000<span class="screen_out">원</span></td><td>68,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>174,000<span class="screen_out">원</span></td><td>86,500<span class="screen_out">원</span></td><td>159,500<span class="screen_out">원</span></td><td>70,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>178,500<span class="screen_out">원</span></td><td>89,000<span class="screen_out">원</span></td><td>164,000<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>182,500<span class="screen_out">원</span></td><td>91,000<span class="screen_out">원</span></td><td>168,500<span class="screen_out">원</span></td><td>73,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>186,500<span class="screen_out">원</span></td><td>93,500<span class="screen_out">원</span></td><td>172,500<span class="screen_out">원</span></td><td>75,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>191,000<span class="screen_out">원</span></td><td>96,000<span class="screen_out">원</span></td><td>177,000<span class="screen_out">원</span></td><td>77,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>195,000<span class="screen_out">원</span></td><td>98,000<span class="screen_out">원</span></td><td>181,500<span class="screen_out">원</span></td><td>79,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>199,000<span class="screen_out">원</span></td><td>100,500<span class="screen_out">원</span></td><td>186,000<span class="screen_out">원</span></td><td>81,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>203,500<span class="screen_out">원</span></td><td>103,000<span class="screen_out">원</span></td><td>190,500<span class="screen_out">원</span></td><td>83,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>207,500<span class="screen_out">원</span></td><td>105,000<span class="screen_out">원</span></td><td>195,000<span class="screen_out">원</span></td><td>85,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>211,500<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td><td>199,500<span class="screen_out">원</span></td><td>87,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>215,500<span class="screen_out">원</span></td><td>110,000<span class="screen_out">원</span></td><td>203,500<span class="screen_out">원</span></td><td>89,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>220,000<span class="screen_out">원</span></td><td>112,000<span class="screen_out">원</span></td><td>208,000<span class="screen_out">원</span></td><td>91,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>224,000<span class="screen_out">원</span></td><td>114,500<span class="screen_out">원</span></td><td>212,500<span class="screen_out">원</span></td><td>92,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>228,000<span class="screen_out">원</span></td><td>117,000<span class="screen_out">원</span></td><td>217,000<span class="screen_out">원</span></td><td>94,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>232,500<span class="screen_out">원</span></td><td>119,000<span class="screen_out">원</span></td><td>221,500<span class="screen_out">원</span></td><td>96,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>236,500<span class="screen_out">원</span></td><td>121,500<span class="screen_out">원</span></td><td>226,000<span class="screen_out">원</span></td><td>98,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>240,500<span class="screen_out">원</span></td><td>124,000<span class="screen_out">원</span></td><td>230,000<span class="screen_out">원</span></td><td>100,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>245,000<span class="screen_out">원</span></td><td>126,000<span class="screen_out">원</span></td><td>234,500<span class="screen_out">원</span></td><td>102,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>249,000<span class="screen_out">원</span></td><td>128,500<span class="screen_out">원</span></td><td>239,000<span class="screen_out">원</span></td><td>104,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>253,000<span class="screen_out">원</span></td><td>131,000<span class="screen_out">원</span></td><td>243,500<span class="screen_out">원</span></td><td>106,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>257,500<span class="screen_out">원</span></td><td>133,000<span class="screen_out">원</span></td><td>248,000<span class="screen_out">원</span></td><td>108,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>261,500<span class="screen_out">원</span></td><td>135,500<span class="screen_out">원</span></td><td>252,500<span class="screen_out">원</span></td><td>109,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>265,500<span class="screen_out">원</span></td><td>138,000<span class="screen_out">원</span></td><td>257,000<span class="screen_out">원</span></td><td>111,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>269,500<span class="screen_out">원</span></td><td>140,000<span class="screen_out">원</span></td><td>261,000<span class="screen_out">원</span></td><td>113,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>274,000<span class="screen_out">원</span></td><td>142,500<span class="screen_out">원</span></td><td>265,500<span class="screen_out">원</span></td><td>115,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>278,000<span class="screen_out">원</span></td><td>145,000<span class="screen_out">원</span></td><td>270,000<span class="screen_out">원</span></td><td>117,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>282,000<span class="screen_out">원</span></td><td>147,000<span class="screen_out">원</span></td><td>274,500<span class="screen_out">원</span></td><td>119,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>286,500<span class="screen_out">원</span></td><td>149,500<span class="screen_out">원</span></td><td>279,000<span class="screen_out">원</span></td><td>121,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>290,500<span class="screen_out">원</span></td><td>151,500<span class="screen_out">원</span></td><td>283,500<span class="screen_out">원</span></td><td>123,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>294,500<span class="screen_out">원</span></td><td>154,000<span class="screen_out">원</span></td><td>287,500<span class="screen_out">원</span></td><td>125,000<span class="screen_out">원</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem4" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
        </div>
        <a href="#none" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
      </div>

      <div class="wrap_table">

        <div id="tableItem5" class="table_item item_type1">
          <table class="tbl_global">
            <caption class="ir_caption">태국, 영국, 미국, 베트남 배송요금표</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">중량(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">태국</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">영국</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">베트남</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">-</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>18,500<span class="screen_out">원</span></td><td>33,000<span class="screen_out">원</span></td><td>17,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>20,000<span class="screen_out">원</span></td><td>35,000<span class="screen_out">원</span></td><td>18,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>21,000<span class="screen_out">원</span></td><td>37,000<span class="screen_out">원</span></td><td>19,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>22,000<span class="screen_out">원</span></td><td>39,000<span class="screen_out">원</span></td><td>20,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>23,000<span class="screen_out">원</span></td><td>41,000<span class="screen_out">원</span></td><td>21,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>24,000<span class="screen_out">원</span></td><td>42,500<span class="screen_out">원</span></td><td>21,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>25,000<span class="screen_out">원</span></td><td>44,500<span class="screen_out">원</span></td><td>22,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>27,000<span class="screen_out">원</span></td><td>48,000<span class="screen_out">원</span></td><td>24,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>29,000<span class="screen_out">원</span></td><td>51,500<span class="screen_out">원</span></td><td>25,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>31,000<span class="screen_out">원</span></td><td>55,000<span class="screen_out">원</span></td><td>27,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>33,000<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td><td>28,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>34,500<span class="screen_out">원</span></td><td>62,000<span class="screen_out">원</span></td><td>29,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>36,500<span class="screen_out">원</span></td><td>65,500<span class="screen_out">원</span></td><td>31,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>38,500<span class="screen_out">원</span></td><td>68,500<span class="screen_out">원</span></td><td>32,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>40,500<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td><td>34,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>42,500<span class="screen_out">원</span></td><td>76,500<span class="screen_out">원</span></td><td>36,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>44,000<span class="screen_out">원</span></td><td>80,500<span class="screen_out">원</span></td><td>37,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>46,000<span class="screen_out">원</span></td><td>84,500<span class="screen_out">원</span></td><td>39,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>48,500<span class="screen_out">원</span></td><td>89,000<span class="screen_out">원</span></td><td>41,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>51,000<span class="screen_out">원</span></td><td>93,000<span class="screen_out">원</span></td><td>43,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>53,000<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>45,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>55,500<span class="screen_out">원</span></td><td>101,500<span class="screen_out">원</span></td><td>47,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>58,000<span class="screen_out">원</span></td><td>105,500<span class="screen_out">원</span></td><td>49,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>60,500<span class="screen_out">원</span></td><td>110,000<span class="screen_out">원</span></td><td>51,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>63,000<span class="screen_out">원</span></td><td>114,000<span class="screen_out">원</span></td><td>53,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>65,000<span class="screen_out">원</span></td><td>118,000<span class="screen_out">원</span></td><td>54,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>67,500<span class="screen_out">원</span></td><td>122,500<span class="screen_out">원</span></td><td>56,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>70,000<span class="screen_out">원</span></td><td>126,500<span class="screen_out">원</span></td><td>58,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>72,500<span class="screen_out">원</span></td><td>131,000<span class="screen_out">원</span></td><td>60,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>74,500<span class="screen_out">원</span></td><td>135,000<span class="screen_out">원</span></td><td>62,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>77,000<span class="screen_out">원</span></td><td>139,000<span class="screen_out">원</span></td><td>64,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>79,500<span class="screen_out">원</span></td><td>143,500<span class="screen_out">원</span></td><td>66,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>82,000<span class="screen_out">원</span></td><td>147,500<span class="screen_out">원</span></td><td>68,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>84,000<span class="screen_out">원</span></td><td>151,500<span class="screen_out">원</span></td><td>70,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>86,500<span class="screen_out">원</span></td><td>156,000<span class="screen_out">원</span></td><td>72,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>89,000<span class="screen_out">원</span></td><td>160,000<span class="screen_out">원</span></td><td>73,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>91,500<span class="screen_out">원</span></td><td>164,500<span class="screen_out">원</span></td><td>75,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>94,000<span class="screen_out">원</span></td><td>168,500<span class="screen_out">원</span></td><td>77,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>96,000<span class="screen_out">원</span></td><td>172,500<span class="screen_out">원</span></td><td>79,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>98,500<span class="screen_out">원</span></td><td>177,000<span class="screen_out">원</span></td><td>81,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>101,000<span class="screen_out">원</span></td><td>181,000<span class="screen_out">원</span></td><td>83,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>103,500<span class="screen_out">원</span></td><td>185,000<span class="screen_out">원</span></td><td>85,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>105,500<span class="screen_out">원</span></td><td>189,500<span class="screen_out">원</span></td><td>87,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>108,000<span class="screen_out">원</span></td><td>193,500<span class="screen_out">원</span></td><td>89,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>110,500<span class="screen_out">원</span></td><td>198,000<span class="screen_out">원</span></td><td>91,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>113,000<span class="screen_out">원</span></td><td>202,000<span class="screen_out">원</span></td><td>92,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>115,500<span class="screen_out">원</span></td><td>206,000<span class="screen_out">원</span></td><td>94,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>117,500<span class="screen_out">원</span></td><td>210,500<span class="screen_out">원</span></td><td>96,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>120,000<span class="screen_out">원</span></td><td>214,500<span class="screen_out">원</span></td><td>98,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>122,500<span class="screen_out">원</span></td><td>218,500<span class="screen_out">원</span></td><td>100,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>125,000<span class="screen_out">원</span></td><td>223,000<span class="screen_out">원</span></td><td>102,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>127,000<span class="screen_out">원</span></td><td>227,000<span class="screen_out">원</span></td><td>104,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>129,500<span class="screen_out">원</span></td><td>231,500<span class="screen_out">원</span></td><td>106,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>132,000<span class="screen_out">원</span></td><td>235,500<span class="screen_out">원</span></td><td>108,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>134,500<span class="screen_out">원</span></td><td>239,500<span class="screen_out">원</span></td><td>109,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>136,500<span class="screen_out">원</span></td><td>244,000<span class="screen_out">원</span></td><td>111,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>139,000<span class="screen_out">원</span></td><td>248,000<span class="screen_out">원</span></td><td>113,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>141,500<span class="screen_out">원</span></td><td>252,000<span class="screen_out">원</span></td><td>115,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>144,000<span class="screen_out">원</span></td><td>256,500<span class="screen_out">원</span></td><td>117,500<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>146,500<span class="screen_out">원</span></td><td>260,500<span class="screen_out">원</span></td><td>119,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>148,500<span class="screen_out">원</span></td><td>265,000<span class="screen_out">원</span></td><td>121,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>151,000<span class="screen_out">원</span></td><td>269,000<span class="screen_out">원</span></td><td>123,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>153,500<span class="screen_out">원</span></td><td>273,000<span class="screen_out">원</span></td><td>125,000<span class="screen_out">원</span></td><td>-<span class="screen_out">원</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem5" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
        </div>

        <div id="tableItem6" class="table_item item_type2">
          <table class="tbl_global">
            <caption class="ir_caption">1지역, 2지역, 3지역, 4지역 배송요금표</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">중량(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">1지역</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">2지역</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">3지역</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">4지역</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>20,500<span class="screen_out">원</span></td><td> 20,500<span class="screen_out">원</span></td><td>30,500<span class="screen_out">원</span></td><td>33,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>21,500<span class="screen_out">원</span></td><td> 22,000<span class="screen_out">원</span></td><td>32,500<span class="screen_out">원</span></td><td>36,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>22,500<span class="screen_out">원</span></td><td> 23,500<span class="screen_out">원</span></td><td>34,500<span class="screen_out">원</span></td><td>39,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>23,500<span class="screen_out">원</span></td><td> 25,000<span class="screen_out">원</span></td><td>36,500<span class="screen_out">원</span></td><td>42,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>24,500<span class="screen_out">원</span></td><td> 26,500<span class="screen_out">원</span></td><td>38,500<span class="screen_out">원</span></td><td>45,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>25,500<span class="screen_out">원</span></td><td> 28,000<span class="screen_out">원</span></td><td>40,500<span class="screen_out">원</span></td><td>48,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>26,500<span class="screen_out">원</span></td><td> 29,500<span class="screen_out">원</span></td><td>42,500<span class="screen_out">원</span></td><td>51,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>28,500<span class="screen_out">원</span></td><td> 32,000<span class="screen_out">원</span></td><td>46,500<span class="screen_out">원</span></td><td>56,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>30,500<span class="screen_out">원</span></td><td> 35,000<span class="screen_out">원</span></td><td>50,000<span class="screen_out">원</span></td><td>62,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>32,000<span class="screen_out">원</span></td><td> 37,500<span class="screen_out">원</span></td><td>54,000<span class="screen_out">원</span></td><td>69,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>34,000<span class="screen_out">원</span></td><td> 40,500<span class="screen_out">원</span></td><td>58,000<span class="screen_out">원</span></td><td>77,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>36,000<span class="screen_out">원</span></td><td> 43,000<span class="screen_out">원</span></td><td>61,500<span class="screen_out">원</span></td><td>85,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>38,000<span class="screen_out">원</span></td><td> 46,000<span class="screen_out">원</span></td><td>65,500<span class="screen_out">원</span></td><td>92,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>39,500<span class="screen_out">원</span></td><td> 48,500<span class="screen_out">원</span></td><td>69,000<span class="screen_out">원</span></td><td>100,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>41,500<span class="screen_out">원</span></td><td> 51,000<span class="screen_out">원</span></td><td>73,000<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>43,500<span class="screen_out">원</span></td><td> 54,000<span class="screen_out">원</span></td><td>78,000<span class="screen_out">원</span></td><td>115,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>45,500<span class="screen_out">원</span></td><td> 56,500<span class="screen_out">원</span></td><td>83,000<span class="screen_out">원</span></td><td>123,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>48,000<span class="screen_out">원</span></td><td> 59,500<span class="screen_out">원</span></td><td>88,000<span class="screen_out">원</span></td><td>130,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>50,500<span class="screen_out">원</span></td><td> 61,000<span class="screen_out">원</span></td><td>93,000<span class="screen_out">원</span></td><td>138,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>52,500<span class="screen_out">원</span></td><td> 66,000<span class="screen_out">원</span></td><td>97,500<span class="screen_out">원</span></td><td>145,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>55,000<span class="screen_out">원</span></td><td> 70,500<span class="screen_out">원</span></td><td>102,500<span class="screen_out">원</span></td><td>153,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>57,500<span class="screen_out">원</span></td><td> 75,500<span class="screen_out">원</span></td><td>107,500<span class="screen_out">원</span></td><td>160,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>60,000<span class="screen_out">원</span></td><td> 80,500<span class="screen_out">원</span></td><td>112,500<span class="screen_out">원</span></td><td>168,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>62,000<span class="screen_out">원</span></td><td> 85,000<span class="screen_out">원</span></td><td>117,500<span class="screen_out">원</span></td><td>176,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>64,500<span class="screen_out">원</span></td><td> 90,000<span class="screen_out">원</span></td><td>122,500<span class="screen_out">원</span></td><td>183,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>67,000<span class="screen_out">원</span></td><td> 95,000<span class="screen_out">원</span></td><td>127,500<span class="screen_out">원</span></td><td>191,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>69,000<span class="screen_out">원</span></td><td> 99,500<span class="screen_out">원</span></td><td>132,500<span class="screen_out">원</span></td><td>198,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>71,500<span class="screen_out">원</span></td><td> 104,500<span class="screen_out">원</span></td><td>137,500<span class="screen_out">원</span></td><td>206,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>74,000<span class="screen_out">원</span></td><td> 109,000<span class="screen_out">원</span></td><td>142,500<span class="screen_out">원</span></td><td>214,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>76,000<span class="screen_out">원</span></td><td> 114,000<span class="screen_out">원</span></td><td>147,500<span class="screen_out">원</span></td><td>221,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>78,500<span class="screen_out">원</span></td><td> 119,000<span class="screen_out">원</span></td><td>152,500<span class="screen_out">원</span></td><td>229,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>81,000<span class="screen_out">원</span></td><td> 123,500<span class="screen_out">원</span></td><td>157,500<span class="screen_out">원</span></td><td>236,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>83,000<span class="screen_out">원</span></td><td> 128,500<span class="screen_out">원</span></td><td>162,000<span class="screen_out">원</span></td><td>244,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>85,500<span class="screen_out">원</span></td><td> 133,500<span class="screen_out">원</span></td><td>167,000<span class="screen_out">원</span></td><td>252,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>88,000<span class="screen_out">원</span></td><td> 138,000<span class="screen_out">원</span></td><td>172,000<span class="screen_out">원</span></td><td>259,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>90,000<span class="screen_out">원</span></td><td> 143,000<span class="screen_out">원</span></td><td>177,000<span class="screen_out">원</span></td><td>267,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>92,500<span class="screen_out">원</span></td><td> 148,000<span class="screen_out">원</span></td><td>182,000<span class="screen_out">원</span></td><td>274,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>95,000<span class="screen_out">원</span></td><td> 152,500<span class="screen_out">원</span></td><td>187,000<span class="screen_out">원</span></td><td>282,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>97,000<span class="screen_out">원</span></td><td> 157,500<span class="screen_out">원</span></td><td>192,000<span class="screen_out">원</span></td><td>289,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>99,500<span class="screen_out">원</span></td><td> 162,000<span class="screen_out">원</span></td><td>197,000<span class="screen_out">원</span></td><td>297,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>102,000<span class="screen_out">원</span></td><td> 167,000<span class="screen_out">원</span></td><td>202,000<span class="screen_out">원</span></td><td>305,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>104,500<span class="screen_out">원</span></td><td> 172,000<span class="screen_out">원</span></td><td>207,000<span class="screen_out">원</span></td><td>312,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>106,500<span class="screen_out">원</span></td><td> 176,500<span class="screen_out">원</span></td><td>212,000<span class="screen_out">원</span></td><td>320,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>109,000<span class="screen_out">원</span></td><td> 181,500<span class="screen_out">원</span></td><td>217,000<span class="screen_out">원</span></td><td>327,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>111,500<span class="screen_out">원</span></td><td> 186,500<span class="screen_out">원</span></td><td>221,500<span class="screen_out">원</span></td><td>335,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>113,500<span class="screen_out">원</span></td><td> 191,000<span class="screen_out">원</span></td><td>226,500<span class="screen_out">원</span></td><td>343,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>116,000<span class="screen_out">원</span></td><td> 196,000<span class="screen_out">원</span></td><td>231,500<span class="screen_out">원</span></td><td>350,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>118,500<span class="screen_out">원</span></td><td> 200,500<span class="screen_out">원</span></td><td>236,500<span class="screen_out">원</span></td><td>358,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>120,500<span class="screen_out">원</span></td><td> 205,500<span class="screen_out">원</span></td><td>241,500<span class="screen_out">원</span></td><td>365,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>123,000<span class="screen_out">원</span></td><td> 210,500<span class="screen_out">원</span></td><td>246,500<span class="screen_out">원</span></td><td>373,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>125,500<span class="screen_out">원</span></td><td> 215,000<span class="screen_out">원</span></td><td>251,500<span class="screen_out">원</span></td><td>381,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>127,500<span class="screen_out">원</span></td><td> 220,000<span class="screen_out">원</span></td><td>256,500<span class="screen_out">원</span></td><td>388,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>130,000<span class="screen_out">원</span></td><td> 225,000<span class="screen_out">원</span></td><td>261,500<span class="screen_out">원</span></td><td>396,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>132,500<span class="screen_out">원</span></td><td> 229,500<span class="screen_out">원</span></td><td>266,500<span class="screen_out">원</span></td><td>403,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>134,500<span class="screen_out">원</span></td><td> 234,500<span class="screen_out">원</span></td><td>271,500<span class="screen_out">원</span></td><td>411,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>137,000<span class="screen_out">원</span></td><td> 239,500<span class="screen_out">원</span></td><td>276,500<span class="screen_out">원</span></td><td>418,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>139,500<span class="screen_out">원</span></td><td> 244,000<span class="screen_out">원</span></td><td>281,500<span class="screen_out">원</span></td><td>426,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>141,500<span class="screen_out">원</span></td><td> 249,000<span class="screen_out">원</span></td><td>286,000<span class="screen_out">원</span></td><td>434,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>144,000<span class="screen_out">원</span></td><td> 253,500<span class="screen_out">원</span></td><td>291,000<span class="screen_out">원</span></td><td>441,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>146,500<span class="screen_out">원</span></td><td> 258,500<span class="screen_out">원</span></td><td>296,000<span class="screen_out">원</span></td><td>449,000<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>149,000<span class="screen_out">원</span></td><td> 263,500<span class="screen_out">원</span></td><td>301,000<span class="screen_out">원</span></td><td>456,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>151,000<span class="screen_out">원</span></td><td> 268,000<span class="screen_out">원</span></td><td>306,000<span class="screen_out">원</span></td><td>464,500<span class="screen_out">원</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>153,500<span class="screen_out">원</span></td><td> 273,000<span class="screen_out">원</span></td><td>311,000<span class="screen_out">원</span></td><td>472,000<span class="screen_out">원</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem6" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
        </div>
        <a href="#none" class="btn_view"><span class="ico_friends ico_arr">내용 펼치기</span></a>
      </div>
    </div>
  </div>

  <div id="tabInfo5" class="tab_cont">
    <h3 class="screen_out">배송국가</h3>
    <div class="cont_subject cont_country">
      <h4 class="tit_country">아시아 태평양 / 중동 / 아프리카</h4><!-- 2017-06-14 수정 -->
      <ul class="list_country">
        <li><span class="img_flag flag_nzl"></span>뉴질랜드</li>
        <li><span class="img_flag flag_twn"></span>대만</li>
        <li><span class="img_flag flag_lao"></span>라오스</li>
        <li><span class="img_flag flag_mac"></span>마카오</li>
        <li><span class="img_flag flag_mas"></span>말레이시아</li>
        <li><span class="img_flag flag_mar"></span>모로코</li>
        <li><span class="img_flag flag_mya"></span>미얀마</li>
        <li><span class="img_flag flag_vie"></span>베트남</li>
        <li><span class="img_flag flag_bru"></span>브루나이</li>
        <li><span class="img_flag flag_ksa"></span>사우디아라비아</li>
        <li><span class="img_flag flag_sin"></span>싱가포르</li>
        <li><span class="img_flag flag_uae"></span>아랍에미리트</li>
        <li><span class="img_flag flag_uzb"></span>우즈베키스탄</li>
        <li><span class="img_flag flag_isr"></span>이스라엘</li>
        <li><span class="img_flag flag_ind"></span>인도</li>
        <li><span class="img_flag flag_ina"></span>인도네시아</li>
        <li><span class="img_flag flag_jpn"></span>일본</li>
        <li><span class="img_flag flag_chn"></span>중국</li>
        <li><span class="img_flag flag_qat"></span>카타르</li>
        <li><span class="img_flag flag_ken"></span>케냐</li>
        <li><span class="img_flag flag_tha"></span>태국</li>
        <li><span class="img_flag flag_phi"></span>필리핀</li>
        <li><span class="img_flag flag_aus"></span>호주</li>
        <li><span class="img_flag flag_hkg"></span>홍콩</li>
      </ul>
      <h4 class="tit_country">유럽</h4>
      <ul class="list_country">
        <li><span class="img_flag flag_ned"></span>네덜란드</li>
        <li><span class="img_flag flag_nor"></span>노르웨이</li>
        <li><span class="img_flag flag_ger"></span>독일</li>
        <li><span class="img_flag flag_den"></span>덴마크</li>
        <li><span class="img_flag flag_rus"></span>러시아</li>
        <li><span class="img_flag flag_rou"></span>루마니아</li>
        <li><span class="img_flag flag_bel"></span>벨기에</li>
        <li><span class="img_flag flag_swe"></span>스웨덴</li>
        <li><span class="img_flag flag_sui"></span>스위스</li>
        <li><span class="img_flag flag_esp"></span>스페인</li>
        <li><span class="img_flag flag_svk"></span>슬로바키아</li>
        <li><span class="img_flag flag_irl"></span>아일랜드</li>
        <li><span class="img_flag flag_gbr"></span>영국</li>
        <li><span class="img_flag flag_aut"></span>오스트리아</li>
        <li><span class="img_flag flag_pol"></span>폴란드</li>
        <li><span class="img_flag flag_cze"></span>체코</li>
        <li><span class="img_flag flag_cro"></span>크로아티아</li>
        <li><span class="img_flag flag_por"></span>포르투칼</li>
        <%--<li><span class="img_flag flag_fra"></span>프랑스</li>--%>
        <li><span class="img_flag flag_fin"></span>핀란드</li>
        <li><span class="img_flag flag_tur"></span>터키</li>
      </ul>
      <h4 class="tit_country">북미 / 남미</h4>
      <ul class="list_country">
        <li><span class="img_flag flag_usa"></span>미국</li>
        <li><span class="img_flag flag_mex"></span>멕시코</li>
        <li><span class="img_flag flag_bra"></span>브라질</li>
        <li><span class="img_flag flag_arg"></span>아르헨티나</li>
        <li><span class="img_flag flag_chi"></span>칠레</li>
        <li><span class="img_flag flag_per"></span>페루</li>
        <%--<li><span class="img_flag flag_can"></span>캐나다</li>--%>
      </ul>

      <strong class="tit_item">국가별 유의사항</strong>
      <p class="desc_notice">각 국가별 금지 및 제한 품목에 대한 자세한 안내는 아래 국가별 통관 정보를 통해 확인 부탁드립니다.</p>
        <c:if test="${kakaoWebView ==0}">
      <a href="http://ems.epost.go.kr/front.EmsSurveySurvey01.postal" class="btn_notice" target="_blank">국가별 통관 정보</a>
        </c:if>
    </div>
  </div>
</div>