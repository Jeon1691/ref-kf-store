<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer payonly_popup">
	<div class="inner_layer">
		<div class="layer_head">
			<strong>카카오페이 결제 전용 상품입니다.</strong>
		</div>
		<div class="layer_body">
			<div class="box_desc">
				<p class="desc_layer">카카오페이 결제 전용 상품은 단독 구매만 가능합니다.</p>
			</div>
			<button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
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
	$(".payonly_popup .btn_verify").on("click", function() {
      $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
      $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
      $("body").attr("tabindex","0").focus();
      $("body").removeAttr("tabindex");
      $(".friends_layer").hide();
      $(".dimmed_layer").hide();
      $(".btn_basket").focus();
	})
</script>