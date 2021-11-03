<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="tit_order"><spring:message code="popup.delivery.tracking"/></strong>
		</div>
		<div class="layer_body">
			<form action="#">
				<fieldset class="fld_order">
					<legend class="screen_out"><spring:message code="popup.delivery.tracking.product"/></legend>
					<ul class="list_inquiry">
						<li>
							<span class="choice_g choice_radio">
								<input type="radio" id="checkInquiry1" name="chk" class="inp_g" checked="checked">
								<label for="checkInquiry1" class="lab_g">
									<span class="ico_friends ico_radio"></span>
									<span class="txt_inquiry txt_product">후드라이언 60cm 인형</span>
									<span class="txt_inquiry"><span class="txt_number"><spring:message code="popup.order.invoice.num"/> : </span>101810409016</span>
									<span class="txt_inquiry"><span class="txt_number"><spring:message code="popup.order.transport.comp"/> : </span>운송업체명 / 1577-8888</span>
								</label>
							</span>
						</li>
						<li>
							<span class="choice_g choice_radio">
								<input type="radio" id="checkInquiry2" name="chk" class="inp_g">
								<label for="checkInquiry2" class="lab_g">
									<span class="ico_friends ico_radio"></span>
									<span class="txt_inquiry txt_product">프로도 프렌즈팝 범퍼 케이스 외 3개</span>
									<span class="txt_inquiry"><span class="txt_number"><spring:message code="popup.order.invoice.num"/> : </span>101810409016</span>
									<span class="txt_inquiry"><span class="txt_number"><spring:message code="popup.order.transport.comp"/> : </span>운송업체명 / 1577-8888</span>
								</label>
							</span>
						</li>
						<!-- 단독상품에 대한 배송조회시 item_delivery 한개만 노출 -->
						<!-- <li class="item_delivery">
							<span class="choice_g choice_radio">
								<input type="radio" id="checkInquiry3" name="chk" class="inp_g" disabled="disabled">
								<label for="checkInquiry3" class="lab_g">
									<span class="ico_friends ico_radio"></span>
									<span class="txt_inquiry txt_product">프로도 프렌즈팝 범퍼 케이스 외 3개</span>
									<span class="txt_inquiry"><span class="txt_number">송장번호 : </span>101810409016</span>
									<span class="txt_inquiry"><span class="txt_number">운송업체 : </span>운송업체명 / 1577-8888</span>
								</label>
							</span>
						</li> -->
					</ul>
					<button type="submit" class="btn_check btn_confirm"><spring:message code="popup.common.confirm"/></button>
					<button type="button" class="btn_check btn_cancel"><spring:message code="popup.common.cancel"/></button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(".order_layer").show();
	popupCenter();
	$("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
	$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
	$(".order_layer").attr("tabindex","0").focus();
	$(".order_layer").removeAttr("tabindex");
	$(".friends_layer .btn_cancel").on("click",function(){
		$("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
		$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
		$("body").attr("tabindex","0").focus();
		$("body").removeAttr("tabindex");
		$(".order_layer").hide();
		$(".dimmed_layer").hide();
	});
</script>