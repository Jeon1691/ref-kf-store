<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<c:set value="${kakaoWebView}" var="kakaoWebView" />
<div id="mArticle" <c:if test="${kakaoWebView > 0}">style="padding-bottom:0;"</c:if>>
    <div class="cont_join <c:if test="${kakaoWebView > 0}">kakaotalk</c:if>">
        <form id="frm" name="frm" method="post" autocomplete="true">

            <input type="hidden" name="has_email" value="${(kakaoAccount ne null ? kakaoAccount.has_email : false)}" />
            <input type="hidden" name="kakao_email" value="${(kakaoAccount ne null ? (kakaoAccount.email ne null ? kakaoAccount.email : '') : '')}" />
            <input type="hidden" id="email" name="email">
            <input type="hidden" id="country" name="country" value="kr">
            <input type="hidden" id="providerId" name="providerId" value="${user.providerId}">
            <input type="hidden" id="providerUserId" name="providerUserId" value="${user.providerUserId}">
            <input type="hidden" id="birthyear" name="birthyear">
            <input type="hidden" id="birthday" name="birthday" value="${(kakaoAccount ne null ? (kakaoAccount.has_birthday ? kakaoAccount.birthday : '') : '')}">
            <input type="hidden" id="gender" name="gender"  value="${(kakaoAccount ne null ? (kakaoAccount.has_gender ? kakaoAccount.gender : '') : '')}">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="_csrf_header" value="${_csrf.headerName}" />
            <fieldset>
                <legend class="screen_out">???????????? ?????? ??????</legend>
                <div class="group_join" style="display: none;">
                    <h3 class="tit_join">????????????</h3>
                    <!-- 2017-11-01 ????????? ????????? ?????? -->
                    <dl class="list_inp">
                        <dt><label class="lab_tf screen_out" for="tfId">????????? (?????????) ??????</label></dt><!-- ????????? ????????? screen_out ????????? ?????? -->
                        <dd>
                            <input type="text" class=" tf_id" id="tfId" placeholder="????????? (?????????) ??????"
                                   onkeyup="joinInputLengthCheck(this);"
                                   value="${(kakaoAccount ne null ? fn:substringBefore(kakaoAccount.email, '@') : '')}">
                            <span class="txt_email">@</span>
                            <div class="opt_g opt_email opt_directwhite"><!-- ????????? .opt_on ?????? --><!-- ??????????????? .opt_directwhite ?????? -->
                                <div class="write_domain">
                                    <label class="lab_tf screen_out" for="tfDomain">????????????</label><!-- ??????????????? screen_out ????????? ?????? -->
                                    <input type="text" class=" tf_domain" placeholder="????????????" id="tfDomain" onkeyup="joinInputLengthCheck(this); toggleLabel(this, 'screen_out');"
                                           value="${(kakaoAccount ne null ? fn:substringAfter(kakaoAccount.email, '@') : '')}"><!-- ??????????????? value??? ??? ??????????????? -->
                                </div>
                                <a href="#none" class="link_selected">
                                    <strong class="screen_out">????????? ?????? ??????</strong>
                                    <%--									<span class="txt_opt">daum.net</span>
                                                                        <span class="screen_out">?????????</span>--%>
                                    <span class="ico_newfriends_v1 ico_opt"></span>
                                </a>
                                <div class="box_opt">
                                    <em class="screen_out">?????? ??????</em>
                                    <ul class="list_opt">
                                        <li><a href="javascript:changeMailDomain('daum.net')" class="link_opt">daum.net</a></li>
                                        <li><a href="javascript:changeMailDomain('hanmail.net')" class="link_opt">hanmail.net</a></li>
                                        <li><a href="javascript:changeMailDomain('naver.com')" class="link_opt">naver.com</a></li>
                                        <li><a href="javascript:changeMailDomain('gmail.com')" class="link_opt">gmail.com</a></li>
                                        <li><a href="javascript:changeMailDomain('nate.com')" class="link_opt">nate.com</a></li>
                                        <li><a href="javascript:changeMailDomain('hotmail.com')" class="link_opt">hotmail.com</a></li>
                                        <li><a href="javascript:changeMailDomain('paran.com')" class="link_opt">paran.com</a></li>
                                        <li><a href="javascript:changeMailDomain('chol.com')" class="link_opt">chol.com</a></li>
                                        <li><a href="javascript:changeMailDomain('korea.com')" class="link_opt">korea.com</a></li>
                                        <li><a href="javascript:changeMailDomain('dreamwiz.com')" class="link_opt">dreamwiz.com</a></li>
                                        <li><a href="javascript:changeMailDomain('empal.com')" class="link_opt">empal.com</a></li>
                                        <li><a href="javascript:changeMailDomain('freechal.com')" class="link_opt">freechal.com</a></li>
                                        <li><a href="javascript:changeMailDomain('hanafos.com')" class="link_opt">hanafos.com </a></li>
                                    </ul>
                                </div>
                            </div>
                            <span class="txt_error mailError1" style="display:none;">????????? ????????? ???????????????. ?????? ??? ?????? ????????? ?????????.</span>
                            <span class="txt_error mailError2" style="display:none;">?????? ???????????? ??????????????????. ?????? ???????????? ????????? ?????????.</span>
                        </dd>
                    </dl>
                    <!-- //2017-11-01 ????????? ????????? ?????? -->
                    <dl class="list_inp">
                        <dt class="screen_out">????????????</dt>
                        <dd>
                            <div class="opt_g opt_country"><!-- ????????? .opt_on ?????? -->
                                <strong class="screen_out">?????? ?????? ??????</strong>
                                <a href="#none" class="link_selected">
                                    <span class="txt_opt">??????</span>
                                    <span class="screen_out">?????????</span>
                                    <span class="ico_newfriends_v1 ico_opt"></span>
                                </a>
                                <div class="box_opt">
                                    <em class="screen_out">?????? ??????</em>
                                    <ul class="list_opt">
                                        <li>
                                            <a href="javascript:changeNation('KR', '82', '??????')" class="link_opt">??????</a>
                                        </li>
                                        <c:forEach items="${countryList}" var="country">
                                            <li>
                                                <a href="javascript:changeNation('${country.EC_CODE}', '${country.EC_PHONECODE}', '${country.EC_COUNTRY}')" class="link_opt">${country.EC_COUNTRY}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <input type="hidden" id="globalType" value="">
                                </div>
                            </div>
                        </dd>
                    </dl>
                    <strong class="screen_out">????????? ?????? ??????</strong>
                    <ul class="list_info">
                        <li>??????????????? ??? 14??? ?????? ???????????????.</li>
                    </ul>
                </div>

                <div class="kakaotalk-join-message">
                    <p>????????? ??????????????? ?????? ?????? ???????????????.<br>
                        ????????? ????????? ????????? ?????? ?????? ????????? ????????? ?????????.</p>
                </div>
                <div class="group_join kakaotalk">
                    <h3 class="tit_join">????????????</h3>
                    <ul class="list_agree kakaotalk">
                        <%--
                        <li>
                            <div class="chk_agree">
                                <div class="area_agree">
                                    <input type="checkbox" id="allAgree" name="saveId" class="inp_g" onchange="javascript:agreeAllProvision(this);">
                                    <label for="allAgree" class="lab_g"><span class="ico_newfriends_v1">??????</span></label>
                                </div>
                            </div>
                            <strong class="tit_agree">
                                ?????? ????????? ?????? ???????????????.
                            </strong>
                        </li>
                        --%>
                        <c:forEach items="${provision}" var="item" varStatus="status">
                            <li>
                                <strong class="tit_agree">
                                    <c:choose>
                                        <c:when test="${item.necessary eq false}">
                                            <em>[??????]</em>
                                        </c:when>
                                        <c:when test="${item.necessary eq true}">
                                            <em>[??????]</em>
                                        </c:when>
                                    </c:choose>
                                        ${item.title}
                                    <c:if test="${item.readMore eq true}">
                                        <a class="link_agree link_agree_img" onclick="provisionPopup('${item.code}')" style="font-size:0px;">????????? ??????</a>
                                    </c:if>
                                    <input type="hidden" name="agreeChk" value="${item.necessary}">
                                </strong>
                                <div class="chk_agree" <c:if test="${item.necessary eq true}">style="display: none;" </c:if>>
                                    <div class="area_agree provisions">
                                        <input type="hidden" name="provisionAgreements[${status.index}].provisionCountry" value="${item.country}" />
                                        <input type="hidden" name="provisionAgreements[${status.index}].provisionCode" value="${item.code}" />
                                        <input type="hidden" name="provisionAgreements[${status.index}].provisionVersion" value="${item.version}" />
                                        <input type="checkbox" name="provisionAgreements[${status.index}].agreement" class="inp_g " onchange="javascript:checkProvision(this);" <c:if test="${item.necessary eq true}">checked="checked" </c:if>>
                                        <label class="lab_g"><span class="ico_newfriends_v1">??????</span></label>
                                    </div>
                                </div>


                            </li>
                        </c:forEach>
                    </ul>
                </div>


                <div class="group_btn kakaotalk">
                    <div class="inner_group">
                        <button type="button" class="btn_signup" disabled="disabled">??????</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<!--// mArticle -->

<script type="text/javascript" charset="UTF-8" src="//t1.daumcdn.net/adfit/static/kp.js"></script>
<script type="text/javascript">

  $(function () {
    //?????? ?????? ?????? ?????? ??????????????? ?????? ?????? -> style??? ????????? ?????????..?
    $(".txt_error").css("display", "none");

    //???????????? ?????? ??? ??????????????? ?????? ??? ????????????
    $(".joinGo .btn_signup").on("click", function () {
      if (!joinValidationCheck()) {
        return false;
      }

      kakaoPixel('5931839826969542280').pageView();
      kakaoPixel('5931839826969542280').completeRegistration();

      $("#frm").attr("action", "/signup");
      $("#frm").submit();
    });

    $('.group_btn.kakaotalk .btn_signup').on('click', function () {
      if (!joinValidationCheck()) {
        return false;
      }

      kakaoPixel('5931839826969542280').pageView();
      kakaoPixel('5931839826969542280').completeRegistration();

      $("#frm").attr("action", "/signup");
      $("#frm").submit();
    })

    $(".opt_country .link_selected, .opt_email .link_selected, .opt_date .link_selected").click(function (e) {
      resetOptionOn();
      $(this).parent(".opt_g").addClass("opt_on");
      e.stopPropagation();
    });

    $("body").click(function () {
      resetOptionOn();
    });

    joinInputLengthCheck();

  });

  function resetOptionOn () {
    $(".opt_country, .opt_email, .opt_date").removeClass("opt_on");
  }

  //???????????? ?????? ??? length check ??? ?????? ??????????????? ????????? 0??? ????????? ?????? ?????? ??????
  function joinInputLengthCheck (txt) {
    var inputLength = $(".tf_g").length;
    var perfectCnt = 0;
    var agreeChk = true;

    //????????? ???????????? class=tf_g ??? ????????? ??? input??? ????????? ?????? ????????? ???????????? ?????????
    for (var i = 0; i < inputLength; i++) {
      if ($(".tf_g").eq(i).val().length != 0) {
        perfectCnt++;
      }
    }

    //?????? ?????? ??????????????? ??????
    for (var j = 0; j < $('input[name=agreeChk]').length; j++) {
      if ($("input[name=agreeChk]")[j].value == 'true') {
        if (!$(".provisions input[type=checkbox]")[j].checked) {
          agreeChk = false;
          break;
        }
      }
    }

    //????????? for??? ?????? ?????? ???????????? ???????????? ?????? ??????
    if ((perfectCnt == inputLength) && agreeChk) {
      $('.group_btn.kakaotalk .btn_signup').prop('disabled', false);
      $(".joinStop").css("display", "none");
      $(".joinGo").css("display", "block");
    } else {
      $('.group_btn.kakaotalk .btn_signup').prop('disabled', true);
      $(".joinStop").css("display", "block");
      $(".joinGo").css("display", "none");
    }
  }

  // ???????????? validation check
  function joinValidationCheck () {

    if ($('input[name=has_email]').val() === 'false') {
      return true;
    } else {

      if ($('input[name=kakao_email]').val() === '') {
        return true;
      } else {
        if (validationCheck()) {
          return true;
        }
      }

    }

    $(window).scrollTop(0);
    return false;
  }

  // ???????????? validation check
  function validationCheck () {
    var result = true;
    var re_birth = /^[0-9]*$/;
    var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // ????????? ?????????

    $("#email").val($("#tfId").val() + "@" + $("#tfDomain").val());
    $("#userProviderId").val(this.value); //userId

    return result;
  }

  function isExistEmail () {
    var result = false;

    $.ajax({
      headers: { 'X-CSRF-TOKEN': '${_csrf.token}' },
      url: "/uniqueIdCheck",
      type: "POST",
      dataType: "json",
      data: { email: $("#email").val() },
      async: false,
      error: function () {
        alertNoti('error.occurred');
        result = false;
      },
      success: function (data) {
        //???????????? ??? ???????????? ?????? ???????????? ??????
        if (data.statusCode == '0000') {
          $(".mailError2").css("display", "none");
          result = true;
        } else if (data.statusCode == '0001') {
          $(".mailError2").css("display", "block");
          result = false;
        }
      }
    });
    return result;
  }

  // ????????? ????????? ????????? event
  function changeMailDomain (mailDomain) {
    $(".opt_email").removeClass("opt_on");
    $("#tfDomain").val(mailDomain);
    $("#tfDomain").parent().find("label").addClass("screen_out");
  }

  // ???????????? ????????? event
  function changeNation (code, phoneCode, countryName) {
    $(".opt_country").removeClass("opt_on");
    $(".opt_country .txt_opt").text(countryName);
    $("#country").val(code);
  }

  // ?????? ??? ????????? event
  function changeMonth (month) {
    $(".opt_date").removeClass("opt_on");
    $(".opt_date .month").text(month);
  }

  // ?????? ??? ????????? event
  function changeDay (day) {
    $(".opt_date").removeClass("opt_on");
    $(".opt_date .day").text(day);
  }

  // input??? ????????? ????????? ??? ????????? ???
  function onlyNumber () {
    if ((event.keyCode < 48) || (event.keyCode > 57))
      event.returnValue = false;
  }

  /** 2017.11.04 Breeze
   * ?????? ?????? ?????? ???, ?????? ?????? ?????? ??????(?????? ?????? ?????????)
   * @param element
   */
  function agreeAllProvision (element) {
    if ($(element).is(":checked") == true) {
      $(".provisions").find('input[type=checkbox]').each(function () {
        $(this).prop("checked", true);
      });
    } else {
      $(".provisions").find('input[type=checkbox]').each(function () {
        $(this).prop("checked", false);
      });
    }

    //?????? ??????????????? validation?????? -> ????????? ?????? ?????? ??? ???????????? ??????
    joinInputLengthCheck();
  }

  /** 2017.11.04 Breeze
   * ?????? ?????? ?????? ???, ?????? ?????? ?????? ???????????? ??????(?????? ?????????)
   * @param element
   */
  function checkProvision (element) {
    //?????? ??????????????? validation?????? -> ????????? ?????? ?????? ??? ???????????? ??????
    joinInputLengthCheck(element);

    if ($(element).is(":checked") == false) {
      $("#allAgree").prop("checked", false);
    } else {
      $(".provisions").find('input[type=checkbox]').each(function () {
        if ($(this).is(":checked") == false) {
          result = false;
          return false;
        } else {
          result = true;
        }
      });

      if (result == true) {
        $("#allAgree").prop("checked", true);
      }
    }
  }
</script>