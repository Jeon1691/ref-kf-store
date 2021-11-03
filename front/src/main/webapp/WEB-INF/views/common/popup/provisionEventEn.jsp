<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_privacy">Agree to use events and marketing(Optional)</strong>
        </div>
        <div class="layer_body">
            <div class="group_privacy group_privacy3">
                <h3 class="screen_out">Agree to use events and marketing(Optional)</h3>
                <!-- PC -->
                <div class="rw_show">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">Agree to use events and marketing(Optional)</caption>
                        <colgroup>
                            <col style="width:13%">
                            <col style="width:29%">
                            <col style="width:29%">
                            <col style="width:29%">
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
                            <th class="lst" scope="row" rowspan="2">Optional<br>field</th>
                            <td class="lst" rowspan="2">Customized information provision, marketing, event</td>
                            <td class="lst" rowspan="2">e-mail, cellphone number, Date of birth, gender</td>
                            <td>Will suspend using the information immediatly at the time of the agreemnt withdrawl</td>
                        </tr>
                        <tr>
                            <td class="lst">Within five days of cancellation</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // PC -->
                <!-- Mobile -->
                <div class="rw_hide">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">Agree to use events and marketing(Optional)</caption>
                        <colgroup>
                            <col style="width:22%">
                            <col style="width:39%">
                            <col style="width:39%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">Category</th>
                            <th class="lst" scope="col" colspan="2">Optional field</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Purpose</th>
                            <td colspan="2">Customized information provision, marketing, event</td>
                        </tr>
                        <tr>
                            <th scope="row">Items</th>
                            <td colspan="2">e-mail, cellphone number, Date of birth, gender</td>
                        </tr>
                        <tr>
                            <th class="lst" scope="row">Storage<br>period</th>
                            <td class="lst">Will suspend using the information immediatly at the time of the agreemnt withdrawl</td>
                            <td class="lst">Within five days of cancellation</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // Mobile -->
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