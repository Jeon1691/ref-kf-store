<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="language" value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}"/>

<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">View Guest Orders</strong>
    </div>
    <div class="layer_body">
      <form id="nonmemberOrderFrm" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
        <input type="hidden" id="nonMemberName" name="nonMemberName" value=""/>
        <fieldset>
          <legend class="screen_out">Form to View Guest Orders</legend>
          <div class="wrap_order">
            <dl class="list_order">
              <dt>
                <label class="lab_order" for="orderNum">Order number :</label>
              </dt>
              <dd>
                <input type="text" id="orderNum" name="orderNum" class="inp_order" value="">
              </dd>
              <dt>
                <label class="lab_order" for="orderName">Name :</label>
              </dt>
              <dd>
                <input type="text" id="orderName" name="orderName" class="inp_order" value="">
              </dd>
              <dt>
                <label class="lab_order" for="orderMail">Email :</label>
              </dt>
              <dd>
                <input type="text" id="orderMail" name="orderMail" class="inp_order" value="">
              </dd>
            </dl>
            <p class="desc_error" style="display:none"></p> <!-- display:none 주문번호나 이름 입력값 없을 경우 style="display:block" -->
          </div>
          <button type="button" class="btn_check btn_confirm"><spring:message code="popup.order.confirm"/></button>
          <button type="button" class="btn_check btn_cancel"><spring:message code="popup.common.cancel"/></button>
        </fieldset>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript">

  $(function() {
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

    $(".order_layer .btn_confirm").on("click",function(){

      var od_num = $.trim($("#orderNum").val());
      var od_name = $.trim($("#orderName").val());
      var od_mail = $.trim($("#orderMail").val());
      var pattern = /[\s]/g;
      if(od_num.length == 0) {

        $(".desc_error").html("&ldquo; Please enter your order number.  &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }

      if (od_name.length == 0) {
        $(".desc_error").html("&ldquo; Please enter your name. &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }

      if (od_mail.length == 0) {
        $(".desc_error").html("&ldquo; Please enter your E-mail. &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }

      if (pattern.test(od_num) == true){
        $(".desc_error").html("&ldquo; There is a space in the order number."+"<br>"+"Please ensure there are no spaces. &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }
      if (!fn_orderCheck()) {
        $(".desc_error").html("&ldquo; You do not have any orders. &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }

      var url = "/"+"${language}"+"/order/shippingNonmember";
      $("#nonmemberOrderFrm").attr("action", url);
      $("#nonMemberName").val(encodeURIComponent(od_name));
      $("#orderNum").val(od_num);
      $("#orderMail").val(od_mail);
      $("#nonmemberOrderFrm").submit();
    });
  });

  function fn_orderCheck(){

    var orderChk = false;
    var url = "/"+"${language}"+"/order/shippingNnonmember/orderCheck";

    $.ajax({
      headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
      url: url,
      type: "POST",
      dataType: "json",
      data: {orderNum:$.trim($("#nonmemberOrderFrm #orderNum").val()), orderName:$.trim($("#nonmemberOrderFrm #orderName").val()), orderMail:$.trim($("#nonmemberOrderFrm #orderMail").val())},
      async:false,
      error: function () {
        alert('An error has occurred while processing your request.');
        return false;
      },
      success: function (data) {
        orderChk = data;
      }
    });

    return orderChk;

  }

</script>