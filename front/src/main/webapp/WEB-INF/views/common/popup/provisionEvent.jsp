<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_privacy">이벤트 및 마케팅 활용 동의(선택)</strong>
        </div>
        <div class="layer_body">
            <div class="group_privacy group_privacy3">
                <h3 class="screen_out">이벤트 및 마케팅 활용 동의(선택)</h3>
                <!-- PC -->
                <div class="rw_show">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">이벤트 및 마케팅 활용 안내표</caption>
                        <colgroup>
                            <col style="width:13%">
                            <col style="width:29%">
                            <col style="width:29%">
                            <col style="width:29%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">구분</th>
                            <th scope="col">목적</th>
                            <th scope="col">항목</th>
                            <th scope="col">보유 &amp; 이용기간</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th class="lst" scope="row" rowspan="2">선택<br>항목</th>
                            <td class="lst" rowspan="2">맞춤 정보제공, 마케팅, <br class="rw_show">이벤트 활용</td>
                            <td class="lst" rowspan="2">이메일 주소, 휴대폰번호, <br class="rw_show">생년월일, 성별</td>
                            <td>동의 철회 시 즉시 활용 중지</td>
                        </tr>
                        <tr>
                            <td class="lst">회원 탈퇴 시 지체 없이 <br class="rw_show">5일 이내 삭제</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // PC -->
                <!-- Mobile -->
                <div class="rw_hide">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">이벤트 및 마케팅 활용 안내표</caption>
                        <colgroup>
                            <col style="width:22%">
                            <col style="width:39%">
                            <col style="width:39%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">구분</th>
                            <th scope="col" class="lst" colspan="2">선택 항목</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">목적</th>
                            <td colspan="2">맞춤 정보제공, 마케팅, 이벤트 활용</td>
                        </tr>
                        <tr>
                            <th scope="row">항목</th>
                            <td colspan="2">이메일 주소, 휴대폰번호, 생년월일, 성별</td>
                        </tr>
                        <tr>
                            <th class="lst" scope="row">보유 &amp;<br> 이용기간</th>
                            <td class="lst">동의 철회 시 즉시 활용 중지</td>
                            <td class="lst">회원 탈퇴 시 지체 없이 5일 이내 삭제</td>
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