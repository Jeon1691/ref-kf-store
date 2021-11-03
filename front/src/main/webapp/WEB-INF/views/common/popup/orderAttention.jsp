<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer attention_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_attention">포인트 및 쿠폰 사용 안내</strong>
        </div>
        <div class="layer_body">
            <div class="group_attention">
                <ul class="list_attention">
                    <li>포인트/쿠폰 해당 금액 이상 주문 시 사용 가능합니다.<br class="rw_hide">(쿠폰 금액의 분할 사용은 불가합니다.)</li>
                    <li>중복쿠폰과 일반쿠폰은 함께 사용이 가능하나, 같은 항목의 쿠폰은 함께 사용이 불가합니다.</li>
                    <li>포인트는 상품구매 시에만 사용가능하며 배송료 결제로 사용이 불가합니다.</li>
                    <li>할인 쿠폰 적용 시 포인트, 적립금과 결제수단 설정이 변경될 수 있습니다. 적용 후 설정하신 결제수단 정보를<br class="rw_show">
                        확인해 주세요.</li>
                    <li>일부 상품의 경우, 포인트/쿠폰 적용 대상에서 제외될 수 있습니다.</li>
                    <li>배송비 쿠폰은 배송 상품에 한해 사용이 가능하며, 배송비 만큼만 할인됩니다.</li>
                    <li>적용금액은 최종 결제 완료 금액 기준으로 카카오프렌즈 환율정보를 적용하여 실 결제 원화 금액과는 차이가<br class="rw_show">
                        있을 수 있습니다.</li>
                    <li>포인트/ 쿠폰 사용 시 부분 반품 및 환불이 불가합니다.<br class="rw_hide">(전체 반품 및 환불만 가능합니다.)</li>
                    <li>주문 시 사용한 포인트/쿠폰 사용기한이 유효한 경우, 주문취소 및 반품 후 재사용 가능합니다.<br>
                        (반품의 경우 반품 완료 확인 후 쿠폰이 재사용 가능합니다)</li>
                    <li>구매 취소 시 취소/환불 규정에 따라 포인트 및 할인쿠폰이 회수될 수 도 있습니다.</li>
                    <li>포인트/쿠폰 악용 사례를 주기적으로 조사하고 있으며, 리셀러의 경우 발견 시 회원박탈 및 피해 보상 청구 등<br class="rw_show">
                        법적 조치가 진행될 수도 있습니다.</li>
                </ul>
            </div>
        </div>
        <div class="layer_foot">
            <button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".attention_layer").show();
    popupCenter();
    $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
    $(".attention_layer").attr("tabindex","0").focus();
    $(".attention_layer").removeAttr("tabindex");
    $(".attention_layer .btn_verify").on("click",function(){
        $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
        $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
        $("body").attr("tabindex","0").focus();
        $("body").removeAttr("tabindex");
        $(".dimmed_layer").hide();
        $(".attention_layer").hide();
    });
</script>