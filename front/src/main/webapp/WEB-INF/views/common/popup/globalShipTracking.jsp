<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">글로벌 배송조회 추적 결과</strong>
    </div>
    <div class="layer_body">
      <div class="tracking_info">
        <c:forEach items="${orderTrackingDetailList}" var="orderTrackingDetail">
          <strong class="tit_date">${orderTrackingDetail.titleDate}</strong>
          <ul class="list_tracking">
            <c:forEach items="${orderTrackingDetail.orderTrackingList}" var="orderTracking">
              <li>
                <span class="screen_out">배송시간</span>
                <span class="txt_date">${orderTracking.trackingTime}</span>
                <span class="screen_out">배송상태</span>
                <span class="txt_state current_state">${orderTracking.trackingStatusKr}</span> <!-- 제일 최신인 배송상태에 current_state 클래스 추가 -->
              </li>
            </c:forEach>
          </ul>
        </c:forEach>

      </div>
      <button type="button" class="btn_verify btn_confirm">확인</button>
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
  $(".friends_layer .btn_confirm").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".order_layer").hide();
    $(".dimmed_layer").hide();
  });

</script>