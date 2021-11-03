<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer nation_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_nation">글로벌 배송 국가</strong>
      <p class="desc_global">카카오프렌즈에서는 아래 국가를 대상으로 글로벌 배송을 지원하고 있습니다</p>
    </div>
    <div class="layer_body">
      <strong class="screen_out">글로벌 배송 가능국가</strong>
      <ul class="list_nation">
        <li>
          <em class="emph_nation">아시아 태평양 / 중동 / 아프리카</em>
          <p class="desc_nation">뉴질랜드, 대만, 라오스, 마카오, 말레이시아, 모로코, 미얀마, 베트남, 브루나이, 사우디아라비아, 싱가포르, 아랍에미리트, 우즈베키스탄, 이스라엘, 인도, 인도네시아, 일본, 중국, 카타르, 케냐, 태국, 필리핀, 호주, 홍콩</p>
        </li>
        <li>
          <em class="emph_nation">유럽</em>
          <p class="desc_nation">네델란드, 노르웨이, 독일, 덴마크, 러시아, 루마니아, 벨기에, 스웨덴, 스위스, 스페인, 슬로바키아, 아일랜드, 영국, 오스트리아, 폴란드, 체코, 크로아티아, 포르투칼, 핀란드, 터키</p>
        </li>
        <li>
          <em class="emph_nation">북미 / 남미</em>
          <p class="desc_nation">미국, 맥시코, 브라질, 아르헨티나, 칠레, 페루, 캐나다</p>
        </li>
      </ul>
    </div>
    <div class="layer_foot">
      <button type="button" class="btn_verify btn_confirm">확인</button>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(".nation_layer").show();
  popupCenter();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  $(".nation_layer").attr("tabindex","0").focus();
  $(".nation_layer").removeAttr("tabindex");
  $(".nation_layer .btn_confirm").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".nation_layer").hide();
    $(".dimmed_layer").hide();
  });
</script>