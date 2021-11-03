<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">Select recent shipping address</strong>
    </div>
    <c:choose>
      <c:when test="${empty deliveryaddress}">
        <div class="layer_body">
          <div class="box_desc">
            <p class="desc_layer"><spring:message code="popup.order.history.empty"/></p>
          </div>
          <button type="button" class="btn_verify btn_confirm" id="btn_confirmEmpty"><spring:message code="popup.common.confirm"/></button>
        </div>
      </c:when>
      <c:otherwise>
        <div class="layer_body">
          <fieldset>
            <legend class="screen_out">Select shipping address</legend>
            <ul class="list_address">
              <c:forEach items="${deliveryaddress}" var="item" varStatus="status">
                <li>
                  <span class="choice_g choice_radio">
                      <input type="radio" id="checkAddress${status.count}" name="chk" class="inp_g" <c:if test="${status.first}">checked="checked"</c:if>>
                      <label for="checkAddress${status.count}" class="lab_g">
                        <span class="ico_friends ico_radio"></span>
                        <span class="txt_name" id="checkAddress${status.count}_name">${item.oaName}</span>
                        <span class="txt_address"><span class="tit_object">Phone : </span><span class="txt_object" id="checkAddress${status.count}_phone">${item.oaPhone}</span></span>
                        <span class="txt_address"><span class="tit_object">Address : </span><span class="txt_object">${item.oaZoneCode}.&nbsp;${item.oaAddr1}&nbsp;${item.oaAddr2}</span></span>
                      </label>
                  </span>
                  <input type="hidden" name="checkAddress${status.count}_email" value="${item.oaEmail}"/>
                  <input type="hidden" name="checkAddress${status.count}_zonecode" value="${item.oaZoneCode}"/>
                  <input type="hidden" name="checkAddress${status.count}_zipcode" value="${item.oaZipCode}"/>
                  <input type="hidden" name="checkAddress${status.count}_address1" value="${item.oaAddr1}"/>
                  <input type="hidden" name="checkAddress${status.count}_address2" value="${item.oaAddr2}"/>
                </li>
              </c:forEach>
            </ul>
            <p class="desc_address"><span class="ico_friends ico_bullet"></span>You can select up to three recently used addresses when entering a shipping address.</p>
            <button type="button" class="btn_check btn_confirm" id="btn_confirm">OK</button>
            <button type="button" class="btn_check btn_cancel">Cancel</button>
          </fieldset>
        </div>
      </c:otherwise>
    </c:choose>
  </div>
</div>
<script type="text/javascript">
  $(".order_layer").show();
  popupCenter();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  $(".order_layer").attr("tabindex","0").focus();
  $(".order_layer").removeAttr("tabindex");
  $(".friends_layer .btn_cancel, .friends_layer #btn_confirmEmpty").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".order_layer").hide();
    $(".dimmed_layer").hide();
  });

  $(".friends_layer #btn_confirm").on("click",function(){

    var chkRadio = $(":input:radio[name='chk']:checked").attr("id");

    var name = $("#"+chkRadio+"_name").text();
    var phone = $("#"+chkRadio+"_phone").text();
    var email = $("input:hidden[name='"+chkRadio+"_email']").val();
    var zonecode = $("input:hidden[name='"+chkRadio+"_zonecode']").val();
    var zipcode = $("input:hidden[name='"+chkRadio+"_zipcode']").val();
    var address1 = $("input:hidden[name='"+chkRadio+"_address1']").val();
    var address2 = $("input:hidden[name='"+chkRadio+"_address2']").val();

    $(".info_delivery .list_delivery #oaName").val(name);
    $(".info_delivery .list_delivery #oaEmail").val(email);
	  $(".info_order .list_inp #oaEmailTemp").val(email.substring(0, email.indexOf('@')));
	  $(".info_order .list_inp #tfDomain2").val(email.substring(email.indexOf('@') + 1, email.length));
    $(".info_delivery .list_delivery #oaPhone").val(phone);
	  $(".info_order .list_inp #oaPhone1").val(phone.substring(phone.indexOf('-') + 1, phone.length));
    $(".info_delivery .list_delivery #orderPostal").val(zonecode);
    $(".info_delivery .list_delivery #oaZoneCode").val(zonecode);
//		$(".info_delivery .list_delivery #oaZipCode").val(zipcode);
    $(".info_delivery .list_delivery #orderAddress1").val(address1);
    $(".info_delivery .list_delivery #oaAddr1").val(address1);
    $(".info_delivery .list_delivery #orderAddress2").val(address2);
    $("#orderPostal, #orderAddress1").addClass("tf_on");
	  $("#inpNew").attr("checked", true);

    $(".order_layer").hide();
    $(".dimmed_layer").hide();
  });
</script>