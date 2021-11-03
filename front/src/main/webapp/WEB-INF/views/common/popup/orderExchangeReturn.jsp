<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">${popupMessage}</strong>
    </div>
    <div class="layer_body">
      <form action="${returnUrl}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
        <input type="hidden" name="orderNumber" value="${orderSubShipping.orderSub.osOmNum}" />
        <input type="hidden" name="orderSubSequence" value="${orderSubShipping.orderSub.osSeq}" />
        <input type="hidden" name="ownerName" value="${orderSubShipping.orderSub.osOwnerName}" />
        <fieldset class="fld_order">
          <legend class="screen_out"><spring:message code="popup.delivery.tracking.product"/></legend>
          <dl class="order_info fst_info">
            <dt><span class="txt_g"><spring:message code="popup.order.num"/></span></dt>
            <dd><span class="txt_g">${orderSubShipping.orderSub.osOmNum}</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g"><spring:message code="popup.order.payment.confirm.date"/></span></dt>
            <dd><span class="txt_g"><fmt:formatDate value="${orderSubShipping.orderSub.osInDate}" pattern="yyyy.MM.dd" /></span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g"><spring:message code="popup.common.product.name"/></span></dt>
            <dd><span class="txt_g">${orderSubShipping.prName}</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g"><spring:message code="popup.common.product.qty"/></span></dt>
            <dd><span class="txt_g"><span id="numOrder">${orderSubShipping.orderSub.osOutEa}</span><spring:message code="popup.common.qty.unit"/></span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g"><spring:message code="popup.common.product.price"/></span></dt>
            <dd><span class="txt_g"><fmt:formatNumber value="${orderSubShipping.orderSub.osSaleMoney}" type="number"/> <spring:message code="popup.common.krw"/></span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g"><spring:message code="popup.order.payment.total.price"/></span></dt>
            <dd><strong class="txt_g"><fmt:formatNumber value="${orderSubShipping.orderSub.osSaleMoney * orderSubShipping.orderSub.osOutEa}" type="number"/> <spring:message code="popup.common.krw"/></strong></dd>
          </dl>
          <input type="hidden" id="thisNum" value="">
          <div class="wrap_total">
            <label class="lab_total" for="totalReturn"><spring:message code="popup.common.qty"/></label>
            <div class="box_quantity">
              <input type="text" id="totalReturn" class="inp_quantity" name="requestEa" value="1" required>
              <button type="button" class="btn_g btn_minus"><span class="ico_newfriends_v1 ico_minus"><spring:message code="popup.common.minus"/></span></button>
              <button type="button" class="btn_g btn_plus"><span class="ico_newfriends_v1 ico_plus"><spring:message code="popup.common.plus"/></span></button>
            </div>
          </div>
          <div class="wrap_cause">
            <label class="lab_cause" for="cancelCause"><span class="txt_g"><spring:message code="popup.order.exchange.reason"/></span></label>
            <div class="box_input">
              <textarea id="cancelCause" name="osCancelReason" class="tf_g"></textarea>
            </div>
          </div>
          <div class="request_btn">
            <button type="submit" class="btn_check btn_confirm">${title} <spring:message code="popup.common.apply"/></button>
            <button type="button" class="btn_check btn_cancel"><spring:message code="popup.common.cancel"/></button>
          </div>
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
  $(".order_layer .btn_cancel").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".order_layer").hide();
    $(".dimmed_layer").hide();
  });
  numCheck();
  var maxNum = parseInt($("#numOrder").text());
  $("#totalReturn").on("keyup change paste",function(){
    if($(this).val() > maxNum){
      $(this).val(maxNum);
    }
  });
  $(".order_layer .btn_g").on("click",function(){
    if($("#totalReturn").val() > maxNum){
      $("#totalReturn").val(maxNum);
    }
  });

</script>
