<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_privacy">Collection and use of personal information</strong>
        </div>
        <div class="layer_body">
            <div class="group_privacy">
                <h3 class="screen_out">Collection and use of personal information</h3>
                <!-- PC -->
                <div class="rw_show">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">Collection and use of personal information</caption>
                        <colgroup>
                            <col style="width:19%">
                            <col style="width:30%">
                            <col style="width:30%">
                            <col style="width:21%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">Category</th>
                            <th scope="col">Purpose</th>
                            <th scope="col">Items</th>
                            <th scope="col">Storage period</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th class="lst" scope="row" rowspan="2">Required field</th>
                            <td>User ID, contact information to use the service, points management, coupon management.</td>
                            <td>
                                ID (e-mail), password, name, country, cellphone number<br>
                                - When connecting a social account : Kakao account or Facebook account
                            </td>
                            <td class="lst" rowspan="2">Within five days of cancellation</td>
                        </tr>
                        <tr>
                            <td class="lst">Age verification for service subscription</td>
                            <td class="lst">Date of birth</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // PC -->
                <!-- Mobile -->
                <div class="rw_hide">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">Collection and use of personal information</caption>
                        <colgroup>
                            <col style="width:22%">
                            <col style="width:39%">
                            <col style="width:39%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">Category</th>
                            <th scope="col" colspan="2">Required field</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Purpose</th>
                            <td>User ID, contact information to use the service, points management, coupon management.</td>
                            <td>Age verification for service subscription</td>
                        </tr>
                        <tr>
                            <th scope="row">Items</th>
                            <td>
                                ID (e-mail), password, name, country, cellphone number<br>
                                - When connecting a social account : Kakao account or Facebook account
                            </td>
                            <td>Date of birth</td>
                        </tr>
                        <tr>
                            <th class="lst" scope="row">Storage<br>period</th>
                            <td class="lst" colspan="2">Within five days of cancellation</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // Mobile -->
                <p class="desc_privacy"><span class="ico_friends ico_bullet"></span>For details, please refer to the <a href="/en/policy/privacy" class="link_privacy" target="_blank">processing policy of personal information</a>.</p>
            </div>
            <button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".privacy_layer").show();
    popupCenter();
    $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
    $(".privacy_layer").attr("tabindex","0").focus();
    $(".privacy_layer").removeAttr("tabindex");
    $(".privacy_layer .btn_verify").on("click",function(){
        $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
        $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
        $("body").attr("tabindex","0").focus();
        $("body").removeAttr("tabindex");
        $(".dimmed_layer").hide();
        $(".privacy_layer").hide();
    });
</script>