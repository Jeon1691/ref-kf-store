<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer" style="#if($params.get('delivery_en')) display:block; #end top:50px">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_order">View delivery status</strong> <%--기존 배송조회 팝업과 동일하며 제목만 다름--%>
        </div>
        <div class="layer_body">
            <form action="#">
                <fieldset class="fld_order">
                    <legend class="screen_out">Select product to view delivery status</legend>
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
                          <span class="txt_inquiry"><span class="txt_number">Tracking Number : </span>${orderTracking.hawbNo}</span>
                          <span class="txt_inquiry"><span class="txt_number">Shipping company : </span>우정사업본부</span>
                        </label>
                    </span>
                            </li>
                        </c:forEach>
                    </ul>
                    <button type="button" class="btn_check btn_confirm">OK</button>
                    <button type="button" class="btn_check btn_cancel">Cancel</button>
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