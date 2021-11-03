<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
  .coloringbook_event .bar_buy{display:none;position:fixed;left:0;right:0;bottom:0;z-index:100;width:100%;min-width:1000px;border-top:1px solid #e5e5e5;background-color:rgba(255,255,255,0.97)}
  .coloringbook_event .ico_apeach{position:absolute;left:50%;top:-77px;width:100px;height:86px;margin-left:-50px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_apeach.png) no-repeat 0 0}
  .coloringbook_event .bar_buy .link_buy{display:block;width:100%;height:80px;font-size:33px;line-height:80px;color:#1e1e1e;text-align:center}
  .coloringbook_event .bar_buy .txt_buy{font-weight:normal;color:#ff3341}
  .coloringbook_event .coloringbook_intro{height:1500px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_intro.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_story{height:820px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_story.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_coloring{height:800px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_coloring.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_episode{height:1879px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_episode.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_episode2{height:1250px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_episode2.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_special{height:1250px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_special.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_special2{height:1523px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_special2.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_reservation{height:686px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_reservation.png) no-repeat 50% 0}
  .coloringbook_event .coloringbook_visual{height:716px;background:url(https://t1.daumcdn.net/friends/www/coloringbook_170628/images/pc/coloringbook_visual.png) no-repeat 50% 0}
  @media all and (max-width:768px) {
    .coloringbook_event .rw_hide{width:100%}
    .coloringbook_event .ir_pm{height:auto;background:none}
    .coloringbook_event .bar_buy{min-width:320px}
    .coloringbook_event .ico_apeach{left:auto;top:-44px;right:16px;width:58px;height:49px;margin-left:0}
    .coloringbook_event .bar_buy .link_buy{height:50px;font-size:17px;line-height:50px}
  }
</style>
<div id="mArticle">
  <div class="coloringbook_event">
    <div class="ir_pm coloringbook_intro">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_intro.png" class="rw_hide" alt="">
      <strong>STORY COLORING BOOK</strong>
      <strong>스토리 컬러링북</strong>
    </div>
    <c:if test="${today <= 201707092359}">
      <div class="bar_buy">
        <span class="ir_pm ico_apeach"><img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_apeach.png" class="rw_hide" alt=""></span>
        <a href="/kr/products/9791196121303" class="link_buy">스토리 컬러링북 <strong class="txt_buy">사전예약하기</strong></a>
      </div>
    </c:if>
    <div class="ir_pm coloringbook_story">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_story.png" class="rw_hide" alt="">
      <strong>story</strong>
      <p>프렌즈의 일상 속 이야기를 들여다보는 깨알 재미
      </p>
    </div>
    <div class="ir_pm coloringbook_coloring">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_coloring.png" class="rw_hide" alt="">
      <strong>coloring</strong>
      <p>말랑말랑 상상력을 담아 색칠하며 작품을 완성해나가는 즐거움</p>
    </div>
    <div class="ir_pm coloringbook_episode">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_episode.png" class="rw_hide" alt="">
      <strong>episode</strong>
      <p>무지의 행적을 관찰하는 콘 연구소부터 제이지의 비밀 첩보요원 훈련소까지 -
        히든 에피소드가 잔뜩 담긴 카카오프렌즈 스토리 컬러링북</p>
    </div>
    <div class="ir_pm coloringbook_episode2">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_episode2.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm coloringbook_special">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_special.png" class="rw_hide" alt="">
    </div>
    <div class="ir_pm coloringbook_special2">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_special2.png" class="rw_hide" alt="">
      <strong>특별부록</strong>
      <p>라이언이 어린 시절을 보낸 고향 둥둥섬은 어떻게 생겼을까요?
        컬러링북의 특별부록 빅사이즈 둥둥섬 지도를 놓치지 마세요!</p>
    </div>
    <div class="ir_pm coloringbook_reservation">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_reservation.png" class="rw_hide" alt="">
      <strong>SPECIAL EVENT 사전예약하시면 엽서를 선물로 드려요!</strong>
      <dl>
        <dt>사전예약 기간 :  </dt>
        <dd>6/28 - 7/9</dd>
        <dt>상품발송 시작 :  </dt>
        <dd>7/10</dd>
      </dl>
      <p>*엽서 5종 중 1종 랜덤발송</p>
    </div>
    <div class="ir_pm coloringbook_visual">
      <img src="https://t1.daumcdn.net/friends/www/coloringbook_170628/images/m640/coloringbook_visual.png" class="rw_hide" alt="">
    </div>
  </div>
</div>
<script type="text/javascript">
  $(window).scroll(function(){
    var sTop = $(window).scrollTop();
    if(sTop > 20){
      $(".coloringbook_event .bar_buy").css("display","block");
    }else{
      $(".coloringbook_event .bar_buy").css("display","none");
    };
  });
</script>