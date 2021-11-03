<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_privacy">개인정보 수집 및 이용안내</strong>
        </div>
        <div class="layer_body">
            <div class="group_privacy">
                <h3 class="screen_out">개인정보 수집 및 이용안내</h3>
                <!-- PC -->
                <div class="rw_show">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">개인정보 수집 및 이용안내표</caption>
                        <colgroup>
                            <col style="width:16%">
                            <col style="width:31%">
                            <col style="width:31%">
                            <col style="width:22%">
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
                            <th class="lst" scope="row" rowspan="2">필수<br>항목</th>
                            <td>이용자 식별, 서비스 이용을 위한 연락, 쿠폰/포인트 관리</td>
                            <td>
                                아이디(이메일 주소), 비밀번호, 이름, 국가, 휴대폰 번호<br>
                                소셜 계정 연결시 : 카카오 계정 또는 페이스북 계정
                            </td>
                            <td class="lst" rowspan="2">회원 탈퇴 후 5일이내 <br class="rw_show">지체없이 삭제</td>
                        </tr>
                        <tr>
                            <td class="lst">서비스 가입을 위한 연령 확인</td>
                            <td class="lst">생년월일</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // PC -->
                <!-- Mobile -->
                <div class="rw_hide">
                    <table class="tbl_privacy">
                        <caption class="ir_caption">개인정보 수집 및 이용안내표</caption>
                        <colgroup>
                            <col style="width:22%">
                            <col style="width:39%">
                            <col style="width:39%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">구분</th>
                            <th scope="col" colspan="2">필수 항목</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">목적</th>
                            <td>이용자 식별, 서비스 이용을 위한 연락, 쿠폰/포인트 관리</td>
                            <td>서비스 가입을 위한 연령 확인</td>
                        </tr>
                        <tr>
                            <th scope="row">항목</th>
                            <td>
                                아이디(이메일 주소), 비밀번호, 이름, 국가, 휴대폰 번호<br>
                                소셜 계정 연결시 : 카카오 계정 또는 페이스북 계정
                            </td>
                            <td>생년월일</td>
                        </tr>
                        <tr>
                            <th class="lst" scope="row">보유 &amp;<br> 이용기간</th>
                            <td class="lst" colspan="2">회원 탈퇴 후 5일이내 <br class="rw_show">지체없이 삭제</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- // Mobile -->
                <p class="desc_privacy"><span class="ico_friends ico_bullet"></span>더 자세한 내용에 대해서는 <a href="/kr/policy/privacy" class="link_privacy" target="_blank">개인정보처리방침</a> 을 참고하시기 바랍니다.</p>
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