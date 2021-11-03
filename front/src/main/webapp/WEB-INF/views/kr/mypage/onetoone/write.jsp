<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set value="${kakaoWebView}" var="kakaoWebView"/>


<div id="mArticle">
    <div class="cont_write">
        <h2 id="kakaoBody" class="tit_inquiry">1:1 문의하기</h2>
        <form:form commandName="request" action="/kr/mypage/onetoone/register" method="post" enctype="multipart/form-data">
            <fieldset class="fld_write">
                <legend class="screen_out">문의하기 양식</legend>
                <div class="info_delivery">
                    <h3 class="tit_sub">고객 정보</h3>
                    <dl class="list_delivery">
                        <dt><label for="bdaOwnername">이름</label></dt>
                        <dd>
                            <div class="box_input write_on"><!-- 입력시 write_on클래스 추가 -->
                                <form:input path="bdaOwnername" class="tf_g" placeholder="이름" />
                            </div>
                        </dd>
                        <dt><label for="bdaEmail">이메일</label></dt>
                        <dd>
                            <div class="box_input">
                                <input type="text" id="bdaEmail" name="bdaEmail" class="tf_g" placeholder="이메일" />
                            </div>
                        </dd>
                        <dt><label for="bdaPhone">연락처</label></dt>
                        <dd>
                            <div class="box_input">
                                <input type="text" id="bdaPhone" name="bdaPhone" class="tf_g" placeholder="연락처" />
                            </div>
                        </dd>
                    </dl>
                </div>
                <div class="info_delivery info_inquire">
                    <h3 class="tit_sub">문의 내용</h3>
                    <dl class="list_delivery">
                        <dt class="txt_opt">유형</dt>
                        <dd class="wrap_opt">
                            <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                                <a href="#none" class="link_selected">
                                    <span class="txt_sort">문의 유형을 선택하세요</span>
                                    <span class="screen_out">선택됨</span>
                                    <span class="ico_newfriends_v1 ico_arr"></span><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
                                </a>
                                <div class="box_sort">
                                    <em class="screen_out">선택옵션</em>
                                    <ul class="list_sort">
                                        <c:forEach items="${boardCategories}" var="boardCategory" varStatus="status">
                                            <li class="on"><a href="#none" class="link_sort" data-bdcseq="${boardCategory.bdcSeq}">${boardCategory.bdcName}</a></li>
                                            <!-- 해외배송 항목 추가 필요, '해외배송비' 에서 '글로벌 배송비' 로 변경 -->
                                        </c:forEach>
                                    </ul>
                                    <input type="hidden" id="sortVal" name="bdaBdcseq" class="inp_value" value="">
                                </div>
                            </div>
                        </dd>
                        <dt><label for="bdaTitle">제목</label></dt>
                        <dd>
                            <div class="box_input">
                                <input type="text" id="bdaTitle" name="bdaName" class="tf_g" />
                            </div>
                        </dd>
                        <dt><label for="bdaContent">내용</label></dt>
                        <dd>
                            <div class="box_input box_textarea">
                                <textarea id="bdaContent" name="bdaContent" class="tf_g"></textarea>
                            </div>
                        </dd>
                        <c:if test="${kakaoWebView == 0}">
                        <dt class="tit_file">
                            <label for="fileUpload">첨부파일</label>
                        </dt>
                        <dd class="wrap_file">
                            <div class="box_file">
                                <span id="fileName"></span>
                            </div>
                            <div class="select_file">
                                <input type="file" id="fileUpload" name="bdaFile" class="inp_file">
                                <span class="txt_file">파일선택</span>
                            </div>
                            <button type="button" class="btn_del"><span class="ico_newfriends_v1 ico_del">삭제</span></button><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
                            <ul class="list_mindful">
                                <li><span class="ico_newfriends_v1 ico_bullet"></span>상품 불량 및 오배송의 경우, 해당 제품 사진을 등록 부탁드립니다.</li><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
                                <li><span class="ico_newfriends_v1 ico_bullet"></span>첨부파일은 1개만 등록 가능하며, 최대 10M의 용량 제한이 있습니다.</li><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
                                <li><span class="ico_newfriends_v1 ico_bullet"></span>첨부 파일은 1개만 등록가능합니다.</li><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
                            </ul>
                        </dd>
                        </c:if>
                    </dl>
                    <!-- 2017-10-19 수정 : 마크업 반영 -->
                    <div class="group_join">
                        <strong class="screen_out">약관동의</strong>
                        <ul class="list_agree">
                            <li>
                                <strong class="tit_agree">
                                    개인정보 수집 및 이용에 동의함
                                    <a href="#none" class="link_agree" onclick="javascript:privacyWritePopup();">자세히보기</a>
                                </strong>
                                <div class="chk_agree">
                                    <div class="area_agree">
                                        <input type="checkbox" id="privacyAgree" checked="checked" class="inp_g">
                                        <label for="privacyAgree" class="lab_g"><span class="ico_newfriends_v1">동의</span></label><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--// 2017-10-19 수정 : 마크업 반영 -->

                <div class="order_btn">
                    <button type="submit" class="btn_order btn_payment"><span class="txt_g">등록하기</span></button>
                    <a href="/kr/mypage/onetoone" class="link_cancel"><span class="txt_g">취소</span></a>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>

<script>
  $(function () {
    $('.cont_write .btn_payment').off('click');

    $('#request').on('submit', function () {

      var re_id = /^[가-힣a-zA-Z\s]{2,30}$/; // 이름, 주문자명 검사식
      var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 이메일 검사식
      var re_tel = /^[0-9]{1,3}-[0-9\-]{6,15}$/; // 모든전화번호 검사식

      var $name = $('#bdaOwnername');
      var $email = $('#bdaEmail');
      var $phone = $('#bdaPhone');
      var $title = $('#bdaTitle');
      var $content = $('#bdaContent');

      var $seq = $('input[name=bdaBdcseq]');

      var $privacy = $('#privacyAgree');

      if (!$name.val()) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").html('To submit a question, you must enter your name. The name must be from 2 to 30 characters, and in English.');
        } else {
          $(".desc_layer").html('문의를 위해서 이름이 입력되어야 합니다.' + '<br>' + '이름은 2-30자 사이 한글/영문만 가능합니다.');
        }
        return false;
      }

      if (!$email.val() || !re_mail.test($email.val())) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").html('To submit a question, you must enter your email address. Please enter a valid email address.');
        } else {
          $(".desc_layer").html('문의를 위해서 이메일 주소가 입력되어야 합니다.' + '<br>' + '올바른 이메일 주소를 입력해주세요.');
        }
        return false;
      }

      if (!$phone.val() || !re_tel.test($phone.val())) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").html('To submit a question, you must enter a valid phone number.');
        } else {
          $(".desc_layer").html('문의를 위해서 연락처가 입력되어야 합니다.' + '<br>' + '숫자, - 가 포함된 올바른 연락처를 입력해주세요.');
        }
        return false;
      }

      if (!$seq.val()) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").text('Please select the type of question.');
        } else {
          $(".desc_layer").text('문의 유형을 선택해주세요.');
        }
        return false;
      }

      var title = $title.val();
      if (!$.trim(title) || title.length < 2 || title.length > 100) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").html('Questions must be accompanied by a title. The title must be from 2 to 100 characters long.');
        } else {
          $(".desc_layer").html('문의를 위해서 제목이 입력되어야 합니다.' + '<br>' + '제목은 2-100자 사이로 작성해주세요.');
        }
        return false;
      }

      var content = $content.val();
      if (!$.trim(content) || content.length < 2 || content.length > 3000) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").html('To submit a question, there must be text in the corresponding box. The length of the text must be from 2 to 3000 characters long.');
        } else {
          $(".desc_layer").html('문의를 위해서 내용이 입력되어야 합니다.' + '<br>' + '내용은 2-3000자 사이로 작성해주세요.');
        }
        return false;
      }

      if (!$privacy.prop('checked')) {
        layerCenter();
        if ($("body").hasClass("en")) {
          $(".desc_layer").text('Please agree to our privacy policy to continue.');
        } else {
          $(".desc_layer").text('개인정보 수집 및 이용에 동의해주세요.');
        }
        return false;
      }
    });


  });
</script>