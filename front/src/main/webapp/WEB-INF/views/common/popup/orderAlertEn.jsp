<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="screen_out">order cancellation</strong>
    </div>
    <div class="layer_body">
      <div class="box_desc">
        <p class="desc_layer">Would you like to cancel your order?</p>
      </div>
      <button type="button" class="btn_check btn_confirm">OK</button>
      <button type="button" class="btn_check btn_cancel">Cancel</button>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(".friends_layer").show();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  popupCenter();
  $(".friends_layer").attr("tabindex","0").focus();
  $(".friends_layer").removeAttr("tabindex");
  $(".friends_layer .btn_cancel").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".friends_layer").hide();
    $(".dimmed_layer").hide();
  });
</script>