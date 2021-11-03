<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_privacy">개인 정보 수집 및 이용안내</strong>
        </div>
        <div class="layer_body">
            <strong class="tit_explain"><span class="txt_explain">[필수]</span> 서비스 기본 기능의 제공</strong>
            <table class="tbl_privacy">
                <caption class="screen_out">개인 정보 수집 안내</caption>
                <colgroup>
                    <col style="width:33%">
                    <col style="width:33%">
                    <col style="width:34%">
                </colgroup>
                <thead>
                <tr>
                    <th scope="col" style="width:33%">목 적</th>
                    <th scope="col" style="width:33%">항 목</th>
                    <th scope="col" style="width:34%">보유기간</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="lst">개인 식별, 본인 확인</td>
                    <td class="lst">이름, 휴대폰 번호, 주소</td>
                    <td class="lst">5년</td>
                </tr>
                </tbody>
            </table>
            <p class="desc_privacy"><span class="ico_friends ico_bullet"></span>서비스 제공을 위해 필요한 최소한의 개인정보이므로 동의를 해주셔야 서비스 이용이 가능합니다.</p>
            <button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".privacy_layer").show();
    popupCenter(".privacy_layer");
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