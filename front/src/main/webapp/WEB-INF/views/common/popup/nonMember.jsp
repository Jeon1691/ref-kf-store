<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="language" value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}"/>

<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order"><spring:message code="popup.order.nonmember.inquiry"/></strong>
    </div>
    <div class="layer_body">
      <form id="nonmemberOrderFrm" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
        <input type="hidden" id="nonMemberName" name="nonMemberName" value=""/>
        <fieldset>
          <legend class="screen_out"><spring:message code="popup.order.nonmember.inquiry.form"/></legend>
          <div class="wrap_order">
            <dl class="list_order">
              <dt>
                <label class="lab_order" for="orderNum"><spring:message code="popup.order.num"/> :</label>
              </dt>
              <dd>
                <input type="text" id="orderNum" name="orderNum" class="inp_order" value="">
              </dd>
              <dt>
                <label class="lab_order" for="orderName"><spring:message code="popup.common.name"/><!-- 디자인상 국문은 필드명 '주문자명'이 되어야 함 --> :</label>
              </dt>
              <dd>
                <input type="text" id="orderName" name="orderName" class="inp_order" value="">
              </dd>
              <!-- 이메일 입력필드 추가 -->
              <dt>
                <label class="lab_order" for="orderMail">이메일 :</label>
              </dt>
              <dd>
                <input type="text" id="orderMail" name="orderMail" class="inp_order" value="">
              </dd>
              <!-- // 이메일 입력필드 추가 -->
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

        $(".desc_error").html("&ldquo; 주문번호를 입력해 주세요  &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }

      if (od_name.length == 0) {
        $(".desc_error").html("&ldquo; 이름을 입력해 주세요 &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }

      if (od_mail.length == 0) {
            $(".desc_error").html("&ldquo; 이메일을 입력해 주세요 &rdquo;");
            $(".desc_error").css("display", "block");
            return false;
      }

      if (pattern.test(od_num) == true){
        $(".desc_error").html("&ldquo; 주문번호에 공백이 있습니다. 공백없이 입력해 주세요 &rdquo;");
        $(".desc_error").css("display", "block");
        return false;
      }
      if (!fn_orderCheck()) {
        $(".desc_error").html("&ldquo; 해당 주문내역이 없습니다 &rdquo;");
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
        alert('처리중 에러가 발생하였습니다.');
        return false;
      },
      success: function (data) {
        orderChk = data;
      }
    });

    return orderChk;

  }

</script>