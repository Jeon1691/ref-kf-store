<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer ordercancel_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="screen_out"><spring:message code="popup.common.head"/></strong>
		</div>
		<div class="layer_body">
			<div class="box_desc">
				<p class="desc_layer">${popupMessage}</p>
			</div>
			<form action="<c:url value="${returnUrl}"/>" method="POST" id="cancelForm">
				<input type="hidden" name="_csrf" value="${_csrf.token}"/>
				<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
				<input type="hidden" name="orderNumber" value="${orderManageRequest.orderNumber}" />
				<input type="hidden" name="orderSubSequence" value="${orderManageRequest.orderSubSequence}" />
				<input type="hidden" name="ownerName" value="${orderManageRequest.ownerName}" />
				<button type="button" class="btn_check btn_confirm" onclick="submitCancel()"><spring:message code="popup.common.confirm"/></button>
			</form>
			<button type="button" class="btn_check btn_cancel"><spring:message code="popup.common.cancel"/></button>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(".ordercancel_layer").show();
	popupCenter();
	$("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
	$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
	$(".ordercancel_layer").attr("tabindex","0").focus();
	$(".ordercancel_layer").removeAttr("tabindex");
	$(".ordercancel_layer .btn_cancel").on("click",function(){
		$("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
		$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
		$("body").attr("tabindex","0").focus();
		$("body").removeAttr("tabindex");
		$(".ordercancel_layer").hide();
		$(".dimmed_layer").hide();
	});

    function submitCancel() {
	    var $form = $("#cancelForm");
        var $confirmButton = $form.find(".btn_confirm");
        $form.submit();
        $confirmButton.attr("disabled", "disabled");
    }
</script>