<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer login_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="screen_out"><spring:message code="popup.common.head"/></strong>
		</div>
		<div class="layer_body">
			<div class="box_desc">
				<p class="desc_layer"><spring:message code="popup.login.desc"/></p>
			</div>
			<a href="/signin" class="btn_check btn_confirm"><spring:message code="popup.common.yes"/></a>
			<button type="button" class="btn_check btn_cancel"><spring:message code="popup.common.no"/></button>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(".login_layer").show();
	$("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
	$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
	$(".login_layer").show();
	popupCenter();
	$(".login_layer").attr("tabindex","0").focus();
	$(".login_layer").removeAttr("tabindex");
	$(".login_layer .btn_cancel").on("click",function(){
		$("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
		$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
		$("body").attr("tabindex","0").focus();
		$("body").removeAttr("tabindex");
		$(".login_layer").hide();
		$(".dimmed_layer").hide();
	});
</script>