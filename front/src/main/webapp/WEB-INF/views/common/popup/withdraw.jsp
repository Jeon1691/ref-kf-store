<%--
  Created by IntelliJ IDEA.
  User: breeze
  Date: 2017. 11. 15.
  Time: 오후 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer withdraw_layer" style="display:block">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_order">회원 탈퇴</strong>
        </div>
        <div class="layer_body">
            <span class="img_emoticon img_withdraw"></span>
            <p class="txt_desc">탈퇴 시 고객님의 모든 정보가 소멸되며, <br class="rw_hide">이전으로 복구가 불가능 합니다.</p>
            <dl class="info_agree">
                <dt>정보소멸 / 재가입 제한</dt>
                <dd>주문내역</dd>
                <dd>포인트</dd>
                <dd>쿠폰</dd>
                <%--
                <dd class="desc_noti"><em>탈퇴 시 30일간 동일 계정으로 가입이 불가</em></dd>
                --%>
            </dl>
            <div class="agree_check">
                <p class="txt_agree">카카오프렌즈 스토어를 탈퇴 하시겠습니까?</p>
                <div class="choice_g chk_g">
                    <input type="checkbox" id="checkCoupon" class="inp_g">
                    <label for="checkCoupon" class="lab_g"> <span class="ico_newfriends_v1 ico_choice"></span> 동의</label>
                </div>
            </div>
            <div class="option_btns">
                <!-- 회원탈퇴버튼 활성화시 disabled 제거 -->
                <button type="button" class="btn_check btn_confirm" onclick="withdraw();" disabled>회원탈퇴</button>
                <button type="button" class="btn_check btn_cancel">취소</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".withdraw_layer").show();
    $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
    popupCenter();
    $(".friends_layer").attr("tabindex","0").focus();
    $(".friends_layer").removeAttr("tabindex");
    $(".friends_layer .btn_cancel").on("click",function(){
        $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
        $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
        $("body").attr("tabindex","0").focus();
        $("body").removeAttr("tabindex");
        $(".friends_layer").hide();
        $(".dimmed_layer").hide();
    });

    $('.chk_g').on('change', function() {
        $('.option_btns .btn_confirm').prop('disabled', !$('#checkCoupon').prop('checked'));
    });

    function withdraw() {
        console.log('withdraw');

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/mypage/withdraw",
            type: "POST",
            dataType: "json",
            async:false,
            success: function (data) {
                //중복체크 후 결과값을 통해 에러문구 노출
                if (data.statusCode == '0000') {
                    console.log('aaa')
                    location.href = '/logout';
                }
            },
            error: function () {
                alert('처리중 에러가 발생하였습니다.');
            }
        });
    }
</script>