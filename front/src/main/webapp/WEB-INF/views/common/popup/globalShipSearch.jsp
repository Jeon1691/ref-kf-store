<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">글로벌 배송조회</strong> <%--기존 배송조회 팝업과 동일하며 제목만 다름--%>
    </div>
    <div class="layer_body">
      <form action="#">
        <fieldset class="fld_order">
          <legend class="screen_out">배송 조회 상품선택</legend>
          <ul class="list_inquiry">
              <c:forEach items="${orderTrackingList}" var="orderTracking" varStatus="status">
                <li>
                    <span class="choice_g choice_radio">
                        <c:if test="${status.index == 0}">
                            <input type="radio" id="trackingInfoRadio" name="trackingInfoRadio" class="inp_g" value="${orderTracking.boxPk}" checked>
                        </c:if>
                        <c:if test="${status.index > 0}">
                            <input type="radio" id="trackingInfoRadio" name="trackingInfoRadio" class="inp_g" value="${orderTracking.boxPk}">
                        </c:if>
                        <label for="trackingInfoRadio" class="lab_g">
                          <span class="ico_friends ico_radio"></span>
                          <span class="txt_inquiry txt_product">${orderTracking.itemName}</span>
                          <span class="txt_inquiry"><span class="txt_number">송장번호 : </span>${orderTracking.hawbNo}</span>
                          <span class="txt_inquiry"><span class="txt_number">운송업체 : </span>우정사업본부 / 1577-8888</span>
                        </label>
                    </span>
                </li>
              </c:forEach>
          </ul>
          <button type="button" class="btn_check btn_confirm">확인</button>
          <button type="button" class="btn_check btn_cancel">취소</button>
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

  $(".friends_layer .btn_confirm").on("click",function(){
      $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
      $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
      $("body").attr("tabindex","0").focus();
      $("body").removeAttr("tabindex");
      $(".order_layer").hide();
      $(".dimmed_layer").hide();


      var boxPk = $(':radio[name="trackingInfoRadio"]:checked').val();
      javascript:globalShipTrackingPopup(boxPk);
  });
</script>