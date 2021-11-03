<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="screen_out"><spring:message code="popup.nonpayment.head"/></strong>
    </div>
    <div class="layer_body">
      <div class="box_desc">
        <p class="desc_layer">
          <spring:message code="popup.nonpayment.desc"/>
        </p>
      </div>
      <button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(".friends_layer").show();
  popupCenter();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  $(".friends_layer").attr("tabindex","0").focus();
  $(".friends_layer").removeAttr("tabindex");
  $(".friends_layer .btn_verify").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".friends_layer").hide();
    $(".dimmed_layer").hide();
  });
</script>

