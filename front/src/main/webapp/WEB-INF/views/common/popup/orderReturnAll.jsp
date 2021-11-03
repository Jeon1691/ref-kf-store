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
        <input type="hidden" name="orderNumber" value="${orderManageRequest.orderNumber}" />
        <input type="hidden" name="ownerName" value="${orderManageRequest.ownerName}" />
        <fieldset class="fld_order">
          <legend class="screen_out"><spring:message code="popup.delivery.tracking.product"/></legend>
          <input type="hidden" id="thisNum" value="">
          <div class="wrap_cause">
            <label class="lab_cause" for="cancelCause"><spring:message code="popup.order.exchange.reason"/></label>
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
</script>
