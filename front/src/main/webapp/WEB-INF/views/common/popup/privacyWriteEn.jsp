<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_privacy">Policy on collection and use of personal information</strong>
    </div>
    <div class="layer_body">
      <strong class="tit_explain"><span class="txt_explain">Required for the provision of basic services</span></strong>
      <table class="tbl_privacy">
        <caption class="screen_out">Policy on collection of personal information</caption>
        <colgroup>
          <col style="width:33%">
          <col style="width:33%">
          <col style="width:34%">
        </colgroup>
        <thead>
        <tr>
          <th scope="col" style="width:33%">Purpose</th>
          <th scope="col" style="width:33%">Items</th>
          <th scope="col" style="width:34%">Storage period</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td class="lst">Personal identification</td>
          <td class="lst">Name, phone number, Address</td>
          <td class="lst">5 years</td>
        </tr>
        </tbody>
      </table>
      <p class="desc_privacy"><span class="ico_friends ico_bullet"></span>This is the minimum of personal information we need to provide you with the following services. Please select &ldquo;Agree&rdquo; to continue.</p>
      <button type="button" class="btn_verify btn_confirm">OK</button>
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