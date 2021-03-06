<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="language" value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}"/>

<div class="friends_layer salecoupon_layer" style="display:block">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_order">Select a discount coupon</strong>
    </div>
    <div class="layer_body">
      <form action="#">
        <fieldset class="order_coupon">
          <legend class="screen_out">Select a discount coupon</legend>
          <div class="group_salecoupon" id="coupou_list">
            <dl class="info_schoice" id="dupl_coupon">
              <dt>Overlap discount</dt>
              <dd class="item_type1">
                <div class="choice_g choice_sale">
                  <label for="inpCoupon1" class="lab_g">Not applicable</label>
                  <input type="radio" id="inpCoupon1" name="coupon1" class="inp_g">
                  <span class="ico_newfriends_v1 ico_choice"></span>
                </div>
              </dd>
              <c:set value="0" var="cp_id"/>
              <c:forEach items="${myAvailableCouponList}" var="coupon" varStatus="cstatus">
                <c:if test="${coupon.CPH_DUPLICATION eq 'Y'}">
                  <c:set value="${cp_id + 1}" var="cp_id"/>
                <dd id="coup_${cp_id}">
                  <div class="choice_g choice_sale">
                    <label for="dulinpCoupon${cstatus.index}" class="lab_g">
                      <c:if test="${coupon.CPH_OPTION_TYPE eq 'D'}">
                        ${coupon.CPH_OPTION_TYPE_NM}
                      </c:if>
                      <c:if test="${coupon.CPH_OPTION_TYPE ne 'D'}">
                        <span class="usd_check usd_show">
                          <fmt:formatNumber value="${coupon.CPH_PRICE}" type="number"/> KRW
                        </span>
                        <span class="usd_check">
                          <fmt:formatNumber value="${coupon.CPH_PRICE_EXCHANGE}" type="number"/> USD
                        </span>
                        discount coupon
                      </c:if>
                      <em class="txt_info">${!empty coupon.CT_ENAME ? coupon.CT_ENAME : 'All'}<c:if test="${!empty coupon.CT_ENAME}"> Category</c:if>
                        / ${coupon.CPH_TERM} </em>
                    </label>
                    <input type="radio" id="dulinpCoupon${cstatus.index}" name="coupon1" class="inp_g">
                    <span class="ico_newfriends_v1 ico_choice"></span>
                    <input type="hidden" name="coupon_id" value="dulinpCoupon${cstatus.index}"/>
                    <input type="hidden" class="coupon_code" value="${coupon.CPH_CODE}"/>
                    <input type="hidden" name="coupon_price" value="${coupon.CPH_PRICE}"/>
                    <input type="hidden" name="coupon_price_exchange" value="${coupon.CPH_PRICE_EXCHANGE}"/>
                    <input type="hidden" name="coupon_type_nm" value="${coupon.CPH_TYPE_NM}"/>
                    <input type="hidden" name="option_type" value="${coupon.CPH_OPTION_TYPE}"/>
                    <input type="hidden" name="option_value" value="${coupon.CPH_OPTION_VALUE}"/>
                    <input type="hidden" name="ct_name" value="${coupon.CT_NAME}"/>
                    <input type="hidden" name="ct_ename" value="${coupon.CT_ENAME}"/>
                    <input type="hidden" name="optionTypeNm" value="${coupon.CPH_OPTION_TYPE_NM}"/>
                    <input type="hidden" name="cphTerm" value="${coupon.CPH_TERM}"/>
                      <input type="hidden" name="cphOptionCategory" value="${coupon.CPH_OPTION_CATEGORY}">
                  </div>
                </dd>
                </c:if>
              </c:forEach>
            </dl>
            <dl class="info_schoice">
              <dt>Regular discount</dt>
              <dd class="item_type1">
                <div class="choice_g choice_sale">
                  <label for="inpCoupon3" class="lab_g">Not applicable</label>
                  <input type="radio" id="inpCoupon3" name="coupon2" class="inp_g">
                  <span class="ico_newfriends_v1 ico_choice"></span>
                </div>
              </dd>
              <c:forEach items="${myAvailableCouponList}" var="coupon" varStatus="cstatus">
                <c:if test="${coupon.CPH_DUPLICATION eq 'N'}">
                  <c:set value="${cp_id + 1}" var="cp_id"/>
                  <dd id="coup_${cp_id}">
                    <div class="choice_g choice_sale">
                      <label for="nomCoupon${cstatus.step}" class="lab_g">
                        <c:if test="${coupon.CPH_OPTION_TYPE eq '????????????'}">
                          ${coupon.CPH_OPTION_TYPE}
                        </c:if>
                        <c:if test="${coupon.CPH_OPTION_TYPE ne 'D'}">
                          <span class="usd_check usd_show">
                            <fmt:formatNumber value="${coupon.CPH_PRICE}" type="number"/> KRW
                          </span>
                          <span class="usd_check">
                            <fmt:formatNumber value="${coupon.CPH_PRICE_EXCHANGE}" type="number"/> USD
                          </span>
                          discount coupon
                        </c:if>
                        <em class="txt_info">${!empty coupon.CT_ENAME ? coupon.CT_ENAME : 'All'}<c:if test="${!empty coupon.CT_ENAME}"> Category</c:if>
                          / ${coupon.CPH_TERM} </em>
                      </label>
                      <input type="radio" id="nomCoupon${cstatus.index}" name="coupon2" class="inp_g">
                      <span class="ico_newfriends_v1 ico_choice"></span>
                      <input type="hidden" name="coupon_id" value="nomCoupon${cstatus.index}"/>
                      <input type="hidden" class="coupon_code" value="${coupon.CPH_CODE}"/>
                      <input type="hidden" name="coupon_price" value="${coupon.CPH_PRICE}"/>
                      <input type="hidden" name="coupon_price_exchange" value="${coupon.CPH_PRICE_EXCHANGE}"/>
                      <input type="hidden" name="coupon_type_nm" value="${coupon.CPH_TYPE_NM}"/>
                      <input type="hidden" name="option_type" value="${coupon.CPH_OPTION_TYPE}"/>
                      <input type="hidden" name="option_value" value="${coupon.CPH_OPTION_VALUE}"/>
                      <input type="hidden" name="ct_name" value="${coupon.CT_NAME}"/>
                      <input type="hidden" name="ct_ename" value="${coupon.CT_ENAME}"/>
                      <input type="hidden" name="optionTypeNm" value="${coupon.CPH_OPTION_TYPE_NM}"/>
                      <input type="hidden" name="cphTerm" value="${coupon.CPH_TERM}"/>
                        <input type="hidden" name="cphOptionCategory" value="${coupon.CPH_OPTION_CATEGORY}">
                    </div>
                  </dd>
                </c:if>
              </c:forEach>
            </dl>
            <dl class="info_sprice">
              <dt>Discounted pirce</dt>
              <dd class="usd_check usd_show"><em class="num_price" id="tot_coupon_price">0 KRW</em> <span>0 USD</span></dd>
              <dd class="usd_check"><em class="num_price" id="tot_coupon_price">0 USD</em></dd>
            </dl>
          </div>
          <div class="option_btns">
            <button type="button" class="btn_check btn_confirm" id="btn_confirm">OK</button>
            <button type="button" class="btn_check btn_cancel">Cancel</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript">

  $(function() {
      $(".salecoupon_layer").show();
      popupCenter();
      $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
      $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
      $(".salecoupon_layer").attr("tabindex","0").focus();
      $(".salecoupon_layer").removeAttr("tabindex");
      $(".salecoupon_layer .btn_cancel").on("click",function(){
        $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
        $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
        $("body").attr("tabindex","0").focus();
        $("body").removeAttr("tabindex");
        $(".salecoupon_layer").hide();
        $(".dimmed_layer").hide();
      })

      $(".friends_layer #btn_confirm").on("click",function(){
          var coupon_price = 0;
	      var freeDeli = false;

          //sheet ????????? ????????? (s)
          $(".group_coupon div").remove();
          for(var i = 1 ; i < 3 ; i++){
              var price = parseFloat($("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='coupon_price']").val());
              var html ='';
              if(!isNaN(price)){
	              var type_nm = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='coupon_type_nm']").val();
	              var option_value = parseFloat($("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='option_value']").val());
	              var ct_ename = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='ct_ename']").val();
	              var coupon_id = $("input:radio[name='coupon"+i+"']:checked").parent().parent().attr("id");
	              var option_value_dr = changeRate(option_value);
	              var price_dr = changeRate(price);
	              var option_type = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='option_type']").val();
	              var cph_name = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='cph_name']").val();
	              var optionTypeNm = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='optionTypeNm']").val();
	              var cphTerm = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='cphTerm']").val();
	              var cphOptionCategory = $("input:radio[name='coupon"+i+"']:checked").parent().find("input[name='cphOptionCategory']").val();
	              var _couponName = ct_ename == "" ? optionTypeNm : ct_ename;
	              var _coupon = [];

	              _coupon.push('<div class="card_coupon">');
                      _coupon.push('<div class="head_coupon" style="' + (cphOptionCategory == "0" ? "background-color:#1fd080" : "background-color:#ffcd00") + '">');
                        _coupon.push('<div class="coupon_tit">');
                            _coupon.push('<strong class="tit_coupon">'+ (option_type == "D" ? "FREE</br>SHIPPING" : _couponName)+'<br>' + (option_type == "D" ? "" : "discount") + '</strong>');
                        _coupon.push('</div>');
                      _coupon.push('</div>');
                      _coupon.push('<div class="body_coupon">');
                          _coupon.push('<dl class="info_name">');
                          _coupon.push('<dt class="screen_out">Coupon name : </dt>');
                          _coupon.push('<dd>');

                          if(option_value > 0){
                              _coupon.push('<span class="txt_name usd_check usd_show">Purchase over '+option_value+'</span>');
                              _coupon.push('<span class="txt_name usd_check">Purchase over '+option_value_dr+'</span>');
                          } else {
                              _coupon.push('<span class="txt_name">No limit on amount</span>');
                          }

                          if(price > 0) {
                              _coupon.push('<span class="txt_price usd_check usd_show"><span class="num_price">'+price+'</span> KRW</span>');
                              _coupon.push('<span class="txt_price usd_check"><span class="num_price">'+price_dr+'</span> USD</span>');
                          } else {
                              _coupon.push('<span class="txt_price"><span class="num_price">FREESHIPPING</span>');
                          }
                          _coupon.push('</dd>');
                          _coupon.push('</dl>');

                          _coupon.push('<dl class="info_desc">');
                          _coupon.push('<dt>Purchase over : </dt>');
                          _coupon.push('<dd>' + _couponName + (ct_ename == "" ? '' : ' Category') + ' </dd>');
                          _coupon.push('<dt>Expiration date : </dt>');
                          _coupon.push('<dd>' + cphTerm + '</dd>');
                          _coupon.push('</dl>');
                      _coupon.push('</div>');
                      _coupon.push('<button type="button" class="btn_del" onclick="coupondel(this)"><span class="ico_newfriends_v1 ico_del">?????? ??????</span></button>');
                      _coupon.push('<div class="screen_out coupon_info"></div>');
	              _coupon.push('</div>');

                  coupon_price += price;
	              if(option_type == 'D') {
		              freeDeli = true;
	              }
                  $(".group_coupon").append(_coupon.join(""));
                  $(".group_coupon .coupon_info").last().html($("#"+coupon_id).find("input[type='hidden']"));
              }
          }
          //sheet ????????? ????????? (e)

          calculateSheet(coupon_price, freeDeli);

          $(".order_layer").hide();
          $(".dimmed_layer").hide();

          //??????: ?????? ?????? ??? ?????? ?????? ?????? ??????
          $(".salecoupon_layer").remove();
      });

      //?????? ?????? ???
      $('.info_schoice dd').click(function(){
          var tot_price = getTotalCoupon();

          if($('input:radio[name="payType"]:checked').val() == 'paypal'){
              $("#tot_coupon_price").html((changeRate(tot_price)).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;USD");
          } else {
              $("#tot_coupon_price").html((tot_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;KRW");
              $("#tot_coupon_price").parent().find("span").html((changeRate(tot_price)).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;USD");
          }
      })
  });

  $(document).ready(function(){

      if($("#dupl_coupon dd").length == 1){
          $("#dupl_coupon").remove();
      }

      if($('input:radio[name="payType"]:checked').val() == 'paypal'){
          $(".order_coupon .usd_show").remove();
          $(".order_coupon").addClass("usd_on");
      }

      $(".coupon_info input[name='coupon_id']").each(function(){
          $("#"+$(this).val()).prop('checked', true);
          $("#"+$(this).val()).click();
      });

  })

  function coupondel(delBtn){
      $(delBtn).parent().remove();
      //?????? ????????? ????????? ?????? ?????? 0???

      var coupon_price = $(".coupon_info").find("input[name='coupon_price']").val();
      coupon_price = isNaN(coupon_price) ? 0 : parseFloat(coupon_price);
      calculateSheet(coupon_price, false);
  }

  function changeRate(price){
	  var ech_rate = parseFloat($("#exchangerate").val());

	  if(isNaN(ech_rate) || ech_rate == 0) {
		  return 0;
	  }

	  return Math.round(price / ech_rate * 100) /100
  }

  //#btn_confirm").on("click" ???
  //deletecoupon ?????? ?????? ??????
  function calculateSheet(coupon_price, freeDeli){
      var prd_amt = parseFloat($('input[name="paymentAccountNotDeli"]').val());
	  var deli_price = freeDeli ? 0 : parseFloat($('input[name="ordDeliveryCharge"]').val());
      var point_price = isNaN($("#point_price").text()) ? parseFloat($("#point_price").text().replace(/[^0-9]/g, '')) : 0;
      var tot_prd_amt = prd_amt - coupon_price - point_price;
      var fnl_amt = prd_amt + deli_price - coupon_price - point_price;

	  if(tot_prd_amt < 0) {
		  $(".card_coupon").remove();
		  return false;
	  }

      $($("#coupon_price").parent().find("dd")[0]).html((coupon_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;KRW");
      $("#total_product_price").html((tot_prd_amt).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;KRW");
      $("#discount_price span").html((coupon_price+point_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
      $("#discount_price").siblings().html(changeRate(coupon_price+point_price)+" USD");
      $("#total_price").html((fnl_amt).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;KRW");
      $("#total_price").siblings().html(changeRate(fnl_amt)+" USD");

      var tot_price = getTotalCoupon();
      $("#tot_coupon_price").html((changeRate(tot_price)).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "&nbsp;USD");
      $($("#coupon_price").parent().find("dd")[1]).html(changeRate(coupon_price)+" USD");
      $($("#total_product_price").parent().find("dd")[1]).html(changeRate(tot_prd_amt).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;USD");
      $($("#discount_price").parent().siblings()[1]).find("strong").html(changeRate(coupon_price+point_price)+"&nbsp;USD");
      $($("#total_price").parent().siblings().find(".num_price")).html(changeRate(fnl_amt).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));


	  $("#deliveryCharge").val(deli_price);
	  $("#delivery_price").html((deli_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;???");
	  $(".deliveryPrice").html(changeRate(deli_price)+" USD");

	  $("#totalDeliPrice").html((deli_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"&nbsp;???");
	  $(".totalDeliPriceEn").html(changeRate(deli_price)+" USD");

	  if(freeDeli) { $("#osDeliMoenyUse").val("N"); }
	  else { $("#osDeliMoenyUse").val("Y"); }
  }

  function getTotalCoupon(){
      var price01 = parseFloat($("input:radio[name='coupon1']:checked").parent().find("input[name='coupon_price']").val());
      var price02 = parseFloat($("input:radio[name='coupon2']:checked").parent().find("input[name='coupon_price']").val());

      price01 = isNaN(price01) ? 0 : price01;
      price02 = isNaN(price02) ? 0 : price02;

      return (price01+price02);
  }
</script>