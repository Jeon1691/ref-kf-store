<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<div id="status">
</div>
<div id="mArticle">
    <%--<div class="cont_login">--%>
    <%--<form action="/login/authenticate" method="post" name="auth" onsubmit="checkForm(this)">--%>
    <%--<input type="hidden" name="_csrf" value="${_csrf.token}"/>--%>
    <%--<fieldset>--%>
    <%--<legend class="screen_out">로그인 입력 양식</legend>--%>
    <%--<div class="group_login">--%>
    <%--<div class="inner_group">--%>
    <%--<dl class="list_inp">--%>
    <%--<dt><label class="lab_tf screen_out"  for="tfId">아이디</label></dt>--%>
    <%--<dd>--%>
    <%--<input type="text" name="username" class="tf_g" placeholder="아이디" id="tfId">--%>
    <%--</dd>--%>
    <%--</dl>--%>
    <%--<dl class="list_inp">--%>
    <%--<dt><label class="lab_tf screen_out" for="tfPw">비밀번호</label></dt>--%>
    <%--<dd>--%>
    <%--<input type="password" name="password" placeholder="비밀번호" class="tf_g" id="tfPw">--%>
    <%--</dd>--%>
    <%--</dl>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="group_desc">--%>
    <%--<div class="chk_saveid">--%>
    <%--<input type="checkbox" id="saveId" name="remember-me-param" class="inp_g">--%>
    <%--<label for="saveId" class="lab_g"><span class="ico_newfriends_v1"></span>아이디 저장</label>--%>
    <%--</div>--%>
    <%--<div class="sort_link">--%>
    <%--<a href="/kr/signup?notSocial=true" class="link_login link_signup">회원가입</a>--%>
    <%--<a href="/kr/usr/findid" class="link_login">아이디 &amp; 비밀번호 찾기</a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="group_btn">--%>
    <%--<button type="submit" name="friends" class="btn_signup bg_yellow">로그인</button>--%>
    <%--</div>--%>
    <%--<c:if test="${not empty param.error}">--%>
    <%--<!-- Display error message -->--%>
    <%--<span class="txt_error">--%>
    <%--이메일 또는 비밀번호가 일치하지 않습니다.<br>--%>
    <%--다시 한번 확인해주세요!--%>
    <%--</span>--%>
    <%--</c:if>--%>
    <%--</fieldset>--%>
    <%--</form>--%>

    <%--<!-- /.container -->--%>
    <%--<form action="/auth/facebook" name="facebook">--%>
    <%--<input type="hidden" name="scope" value="email,user_friends"/>--%>
    <%--</form>--%>
    <%--<form action="/auth/linkedin" name="linkedin">--%>
    <%--</form>--%>
    <%--<form action="/auth/twitter" name="twitter">--%>
    <%--<input type="hidden" name="scope" value="email"/>--%>
    <%--</form>--%>
    <%--<form action="/auth/kakao" name="kakao">--%>

    <%--</form>--%>
    <%--<form action="/auth/github" name="github">--%>
    <%--<input type="hidden" name="scope" value="email"/>--%>
    <%--</form>--%>


    <%--<strong class="screen_out">SNS 계정으로 로그인</strong>--%>
    <%--<ul class="list_sns">--%>
    <%--<li><a onclick="loginWithKakao();" style="cursor:pointer" class="link_sns"><span class="ico_newfriends_v1 ico_kakao"></span>카카오--%>
    <%--계정으로 로그인<span class="ico_newfriends_v1 ico_arrow"></span></a></li>--%>
    <%--<li><a onclick="checkLoginState();" style="cursor:pointer" class="link_sns"><span class="ico_newfriends_v1 ico_facebook"></span>페이스북--%>
    <%--계정으로 로그인<span class="ico_newfriends_v1 ico_arrow"></span></a></li>--%>
    <%--</ul>--%>
    <%--</div>--%>
    <div class="cont_login">
        <div class="group_login">
        </div>
        <div class="group_btn">
            <form action="/auth/kakao" name="kakao">
                <fieldset>
                    <legend class="screen_out">카카오 계정으로 로그인</legend>
                    <button type="button" onclick="loginWithKakao();" class="btn_signup bg_yellow"><span class="ico_newfriends_v1 ico_kakao"></span><span class="txt_signup">카카오 계정으로 로그인</span></button>
                </fieldset>
            </form>
        </div>
        <div class="group_attention">
            <strong class="tit_attention">고객님께 안내 드립니다.</strong>
            <ul class="list_attention">
                <li>카카오프렌즈 고객님께 다양한 혜택을 드리고자 카카오프렌즈 회원가입
                    서비스를 도입하게 되었습니다.<br>
                    카카오프렌즈는 회원가입시 최소한의 정보만 수집합니다.</li>
                <li>기존 구매 고객님께서는 카카오 계정 로그인 후 추가정보를 입력 해주시면
                    구매이력과 주문 정보 등의 서비스를 동일하게 이용할 수 있습니다.</li>
            </ul>
        </div>
    </div>
</div>

<!--// mArticle -->

<script>
    $(document).on('ready',function(){
          $('#kakaoFoot').hide();
    });
    // This is called with the results from from FB.getLoginStatus().
    function statusChangeCallback(response) {
        console.log('statusChangeCallback');
        console.log(response);
        // The response object is returned with a status field that lets the
        // app know the current login status of the person.
        // Full docs on the response object can be found in the documentation
        // for FB.getLoginStatus().
        if (response.status === 'connected') {
            // Logged into your app and Facebook.
            //testAPI();
            document.facebook.submit();

        } else {
            // The person is not logged into your app or we are unable to tell.
            /* document.getElementById('status').innerHTML = 'Please log ' +
                 'into this app.';*/
            FB.login(function (response) {
                statusChangeCallback(response)
            });

        }
    }

    // This function is called when someone finishes with the Login
    // Button.  See the onlogin handler attached to it in the sample
    // code below.
    function checkLoginState() {
        FB.getLoginStatus(function (response) {
            statusChangeCallback(response);
        });
    }

    window.fbAsyncInit = function () {
        FB.init({
            appId: '331466213929261',
            cookie: true,  // enable cookies to allow the server to access
                           // the session
            xfbml: true,  // parse social plugins on this page
            version: 'v2.10' // use graph api version 2.8
        });

        // Now that we've initialized the JavaScript SDK, we call
        // FB.getLoginStatus().  This function gets the state of the
        // person visiting this page and can return one of three states to
        // the callback you provide.  They can be:
        //
        // 1. Logged into your app ('connected')
        // 2. Logged into Facebook, but not your app ('not_authorized')
        // 3. Not logged into Facebook and can't tell if they are logged into
        //    your app or not.
        //
        // These three cases are handled in the callback function.

        /*  FB.getLoginStatus(function(response) {
              statusChangeCallback(response);
          });*/

    };

    // Load the SDK asynchronously
    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function loginWithKakao() {
      //REST API 로 호출 20181217 charlie
      location.href = "/auth/kakao?disable_approval_window=false";

      // // 로그인 창을 띄웁니다.
        // Kakao.Auth.login({
        //     success: function (authObj) {
        //         //   alert(JSON.stringify(authObj));
        //         document.kakao.submit();
        //     },
        //     fail: function (err) {
        //         console.log(JSON.stringify(err));
        //     }
        // });
    };


    $(function () {
        getid();
        $("#saveId").click(function () {
            saveid();
        }); //#chkuser_id.click
    }); //function(){

    function saveid() {
        var expdate = new Date();
        if ($("#saveId").prop("checked")) {
            expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30); // 30일
        } else {
            expdate.setTime(expdate.getTime() - 1); // 쿠키 삭제조건
        }
        setCookie("saveid", $("#tfId").val(), expdate);


    } //saveid()

    function checkForm(form) // Submit button clicked
    {
        window.auth.friends.disabled = true;
        return true;
    }

    function setCookie(name, value, expires) {
        document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expires.toGMTString();
    } //setCookie(name,value,expires)

    function getCookie(Name) {
        var search = Name + "=";
        if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
            offset = document.cookie.indexOf(search);
            if (offset != -1) { // 쿠키가 존재하면
                offset += search.length;
                // set index of beginning of value
                end = document.cookie.indexOf(";", offset);
                // 쿠키 값의 마지막 위치 인덱스 번호 설정
                if (end == -1)
                    end = document.cookie.length;
                return unescape(document.cookie.substring(offset, end));
            }
        }
        return "";
    } //getCookie(Name)

    function getid() {
        var saveId = getCookie("saveid");
        if (saveId != "") {
            $("#tfId").val(saveId);
            $("#saveId").prop("checked", true);
        }
    } //getid()

</script>
