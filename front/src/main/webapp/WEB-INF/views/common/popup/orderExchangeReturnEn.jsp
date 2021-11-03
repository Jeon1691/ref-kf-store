<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer order_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">Request an exchange</strong> <%-- 교환신청일 경우 Request an exchange, 반품신청일 경우 Request a return, 구매확정일 경우 Proceed to checkout 로 제목 각각 적용 --%>
    </div>
    <div class="layer_body">
      <form action="#">
        <fieldset class="fld_order">
          <legend class="screen_out">form request</legend>
          <dl class="order_info fst_info">
            <dt><span class="txt_g">Order<br> number</span></dt>
            <dd><span class="txt_g">01028272829202</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g">Payment<br> confirmation<br> time</span></dt>
            <dd><span class="txt_g">2016.10.22</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g">Product<br> name</span></dt>
            <dd><span class="txt_g">Friendspop Bumper Case and other</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g">Quantity</span></dt>
            <dd><span class="txt_g">3</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g">Price</span></dt>
            <dd><span class="txt_g">38,000 KRW</span></dd>
          </dl>
          <dl class="order_info">
            <dt><span class="txt_g">Total price</span></dt>
            <dd><strong class="txt_g">40,500 KRW</strong></dd>
          </dl>
          <%-- wrap_total, wrap_cause 영역은 구매확정일 경우 적용하지 않음 --%>
          <div class="wrap_total">
            <label class="lab_total" for="totalReturn">Quantity</label>
            <div class="box_quantity">
              <input type="text" id="totalReturn" class="inp_quantity" name="" value="1" required>
              <button type="button" class="btn_g btn_minus"><span class="ico_newfriends_v1 ico_minus">Add</span></button>
              <button type="button" class="btn_g btn_plus"><span class="ico_newfriends_v1 ico_plus">Subtract</span></button>
            </div>
          </div>
          <div class="wrap_cause">
            <label class="lab_cause" for="cancelCause"><span class="txt_g">Reason(s)<br class="rw_hide"> for request</span></label>
            <div class="box_input">
              <textarea id="cancelCause" class="tf_g"></textarea>
            </div>
          </div>
          <%-- wrap_total, wrap_cause 영역은 구매확정일 경우 적용하지 않음 --%>
          <div class="request_btn">
            <button type="submit" class="btn_check btn_confirm">Request</button>
            <button type="button" class="btn_check btn_cancel">Cancel</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(".order_layer").show();
  popupCenter();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  $(".order_layer").attr("tabindex","0").focus();
  $(".order_layer").removeAttr("tabindex");
  $(".order_layer .btn_cancel").on("click",function(){
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".order_layer").hide();
    $(".dimmed_layer").hide();
  });
  numCheck();
  var maxNum = parseInt($("#numOrder").text());
  $("#totalReturn").on("keyup change paste",function(){
    if($(this).val() > maxNum){
      $(this).val(maxNum);
    }
  });
  $(".order_layer .btn_g").on("click",function(){
    if($("#totalReturn").val() > maxNum){
      $("#totalReturn").val(maxNum);
    }
  });

</script>
