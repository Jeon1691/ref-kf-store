<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
  .thermos_event .thermos_visual{height:640px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_visual.png) no-repeat 50% 0 #000}
  .thermos_event .bar_buy{display:none;position:fixed;left:0;right:0;bottom:0;z-index:100;width:100%;min-width:1000px;border-top:1px solid #e5e5e5;background-color:rgba(255,255,255,0.97)}
  .thermos_event .bar_buy .link_buy{display:block;width:100%;height:80px;font-size:33px;line-height:80px;color:#999;text-align:center}
  .thermos_event .bar_buy .txt_buy{font-weight:normal;color:#000}
  .thermos_event .thermos_intro{height:1479px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_intro.png) no-repeat 50% 0 #fff}
  .thermos_event .thermos_info1{height:1010px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info1.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_info2{height:690px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info2.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_info3{height:368px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info3.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_info4{height:812px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info4.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_info5{height:780px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info5.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_info6{height:1156px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info6.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_info7{height:1276px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info7.png) no-repeat 50% 0 #fff}
  .thermos_event .thermos_info8{height:919px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_info8.png) no-repeat 50% 0 #fff}
  .thermos_event .thermos_limited1{height:779px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_limited1.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_limited2{height:316px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_limited2.png) no-repeat 50% 0 #1e1e1e}
  .thermos_event .thermos_limited3{height:649px;background:url(https://t1.daumcdn.net/friends/www/thermos_161122/images/pc/thermos_limited3.png) no-repeat 50% 0 #1e1e1e}
  @media all and (max-width:768px) {
    .thermos_event .rw_hide{width:100%}
    .thermos_event .ir_pm{height:auto;background:none}
    .thermos_event .thermos_info3, .thermos_event .thermos_limited3{display:none}
    .thermos_event .bar_buy{min-width:320px}
    .thermos_event .bar_buy .link_buy{height:50px;font-size:17px;line-height:50px}
  }
</style>
<div id="mArticle">
  <div class="thermos_event">
    <div class="ir_pm thermos_visual">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_visual.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm thermos_intro">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_intro.png" class="rw_hide" alt="">
      <strong>THERMOS x KAKAO FRIENDS</strong>
      <strong>RYAN TUMBLER SET LIMITED EDITION</strong>
      <p>??????/?????? ???????????? ?????????, ??????????????????, ???????????? ?????? ??????</p>
    </div>
    <div class="bar_buy"><a href="/kr/products/FRPBRYTST0001" class="link_buy">????????? ??????????????????-????????? <strong class="txt_buy">????????????</strong></a></div>
    <div class="ir_pm thermos_info1">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info1.png" class="rw_hide" alt="">
      <strong>11??? 25???</strong>
      <p>????????? ???????????? ?????? ???????????? ????????? ????????? ????????? ??????</p>
    </div>
    <div class="ir_pm thermos_info2">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info2.png" class="rw_hide" alt="">
      <p>????????? ?????? ??????????????? + ????????? ????????? ?????? ??????</p>
    </div>
    <div class="ir_pm thermos_info3"></div>
    <div class="ir_pm thermos_info4">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info3.png" class="rw_hide" alt="">
      <p>RYAN HANGING DOLL</p>
    </div>
    <div class="ir_pm thermos_info5">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info4.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm thermos_info6">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info5.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm thermos_info7">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info6.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm thermos_info8">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_info7.png" class="rw_hide" alt="">
      <strong>????????? ???????????? ?????? JNL ?????? ????????? &middot; ????????? ????????? &middot; ????????? ??????</strong>
      <p>?????? ?????? ??? ?????? ?????????????????? ??????/???????????? ????????? 100?????? ?????? ????????? ?????? ???????????? ????????????????????? ??????!</p>
    </div>
    <div class="ir_pm thermos_limited1">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_limited1.png" class="rw_hide" alt="">
      <strong>RYAN TUMBLER SET LIMITED EDITION</strong>
      <p>11??? 25????????? ???????????? ?????? ?????? ?????????: ??????/?????? ???????????? ?????????, ??????????????????</p>
    </div>
    <div class="ir_pm thermos_limited2">
      <img src="https://t1.daumcdn.net/friends/www/thermos_161122/images/m640/thermos_limited2.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm thermos_limited3"></div>
  </div>
</div>
<script type="text/javascript">
  $(window).scroll(function(){
    var sTop = $(window).scrollTop();
    if(sTop > 20){
      $(".thermos_event .bar_buy").css("display","block");
    }else{
      $(".thermos_event .bar_buy").css("display","none");
    };
  });
</script>