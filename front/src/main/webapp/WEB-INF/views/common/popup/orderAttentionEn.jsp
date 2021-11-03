<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer attention_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_attention">Points and coupons usage note</strong>
        </div>
        <div class="layer_body">
            <div class="group_attention">
                <ul class="list_attention">
                    <li>Points & coupons may be used for orders exceeding the amount of the points/coupons.
                        (Partial use of coupons is prohibited.)
                        </li>
                    <li>Multiple coupons and regular coupons may be used together, but coupons of the same category
                        cannot be used together.
                        </li>
                    <li>Points can only be used for the purchase price of items and cannot be applied toward shipping fees.
                        </li>
                    <li>When using discount coupons, the options for accumulated points and method of payment may
                        change. Please check your method of payment after applying the discount coupon.
                        </li>
                    <li>Some items may be excluded from using points & coupons.
                        </li>
                    <li>Shipping coupons are limited to delivery items and only the shipping fee will be discounted.
                        </li>
                    <li>The final payment amount may differ from the actual payment made in Korean won after applying
                        the exchange rate information of Kakao Friends.
                        </li>
                    <li>When using points/coupons, partial returns and refunds are not possible. (Full purchase returns and
                        refunds are possible.)
                        </li>
                    <li>If the expiration of points & coupons used when making an order are still valid, they may be reused
                        after cancelling or returning the order. (For returns, coupons can be reused after the return has been
                        confirmed.)
                        </li>
                    <li>When an order is cancelled, points and discount coupons are subject to forfeiture in accordance with
                        regulations on cancellations and refunds.
                        </li>
                    <li>Misuse of points & coupons is regularly investigated. Re-sellers will be deprived of their membership
                        and legal action such as claims for damages may be taken.</li>
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