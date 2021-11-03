<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer nation_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_nation">Global Shipping Countries</strong>
      <p class="desc_global">Kakao Friends supports international shipping to the following locations.</p>
    </div>
    <div class="layer_body">
      <strong class="screen_out">Global Shipping Countries list</strong>
      <ul class="list_nation">
        <li>
          <em class="emph_nation">Asia Pacific / the Middle East / Africa</em>
          <p class="desc_nation">Australia, Brunei, China, Hong Kong, India, Indonesia, Israel, Japan, kenya, Laos, Macau, Malaysia, Morocco, Myanmar, New Zealand, Philippines, Qatar, Saudi Arabia, Singapore, Taiwan, Thailand, UAE, Uzbekistan, Vietnam</p>
        </li>
        <li>
          <em class="emph_nation">Europe</em>
          <p class="desc_nation">Austria, Belgium, Croatia, Czech, Denmark, Finland, Germany, Ireland, Netherlands, Norway, Poland, Portugal, Romania, Russia, Slovakia, Spain, Sweden, Switzerland, Turkey, United Kingdom</p>
        </li>
        <li>
          <em class="emph_nation">North America / Latin America</em>
          <p class="desc_nation">Argentina, Brazil, Canada, Chile, Peru, Mexico, United States</p>
        </li>
      </ul>
    </div>
    <div class="layer_foot">
      <button type="button" class="btn_verify btn_confirm">OK</button>
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