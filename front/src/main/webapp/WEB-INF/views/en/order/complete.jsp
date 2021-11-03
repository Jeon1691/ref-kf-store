<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<spring:eval expression="@environment['kakaofriends.cdn.product']" var="cdn"/>
<spring:eval expression="@environment['deploy.version']" var="deployVersion"/>

<div id="mSub">
	<div class="order_intro intro_complete">
		<div class="inner_intro">
			<h2 id="kakaoBody" class="screen_out">Order Complete</h2>
			<strong class="tit_complete">Order is Complete</strong>
			<p class="txt_complete">You can check your order details on My Page</p>
			<span class="frame_ryan">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/img_ryan1.gif" class="thumb_g rw_show">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/img_ryan1.gif" class="thumb_g rw_hide">
		</span>
		</div>
	</div>
</div> <!--// mSub -->
<div id="mArticle"></div>

<script>
window.LANG = 'en';
window.__INITIAL_STATE__ = ${orderCompleteVo};
window.CSRF_TOKEN = '${_csrf.token}';
window.CSRF_HEADER_NAME = '${_csrf.headerName}';
</script>
<script type="text/javascript" charset="UTF-8" src="//t1.daumcdn.net/adfit/static/kp.js"></script>
<script type="text/javascript" src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/dist/complete.js?${deployVersion}"></script>
<!-- This script is For CTS Start -->
<script type='text/javascript'>
    var AM_CartAP1A417248742=(function(){
        var c={pd:'',pn:'${orderShippingInfo.orderInfo.omNum}',am:'${orderShippingInfo.orderInfo.totalMoney}',qy:'1',ct:''};
        var u=(!AM_CartAP1A417248742)?[]:AM_CartAP1A417248742; u[c.pd]=c;return u;
    })();
    var m_buyAP1A417248742="finish";
</script>
<!-- Script End -->
<script>
  fbq('track', 'Purchase');
</script>