<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong>This product is for payment of KakaoPay only.</strong>
		</div>
		<div class="layer_body">
			<div class="box_desc">
				<p class="desc_layer">You can purchase products exclusively for paying KakaoPay alone.</p>
			</div>
			<a href="/${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}/basket/products" class="btn_check btn_confirm"><spring:message code="popup.common.confirm"/></a>
			<button type="button" class="btn_check btn_cancel"><spring:message code="popup.common.cancel"/></button>
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