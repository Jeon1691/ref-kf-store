<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/en/ohmyfriends/layoutHeader.jsp" flush="true"/>
</head>
<body class="en">
<div id="kakaoIndex">
	<a href="#kakaoBody">Content Shortcuts</a>
	<a href="#kakaoGnb">Menu Shortcuts</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div class="scroll_body">
		<div id="kakaoContent" class="cont_omf" role="main">
			<div id="cMain">
				<tiles:insertTemplate template="/WEB-INF/templates/en/sub/feature.jsp" flush="true"/>
				<tiles:insertAttribute name="article" flush="true"/>
			</div>
		</div>
		<hr class="hide">
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/footer.jsp" flush="true"/>
	</div>
</div>
<div class="dimmed_layer"></div>
<script type="text/javascript" src="/resources/js/skrollr.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.lazyload.min.js"></script>
<script type="text/javascript">
	/* 오마이프렌즈 */
	var newArray = [];
	var ohMyFriends = {
		addClassAnimation : function() { // 로딩 후 첫 애니메이션 동작을 위한 클래스 추가(애니메이션 효과는 css animation사용)
			$(window).load(function() {
				$('#kakaoWrap').addClass('animation');
			});
		},
		mCheck: function(){
			if(!(/Android|iPhone|iPad|iPod|BlackBerry|Windows Phone/i).test(navigator.userAgent || navigator.vendor || window.opera)){
				skrollr.init();
			}
		},
		lazyLoad: function() {       // pc 이미지 지연 로드(mobile 적용 안함)
			$('.landing_pc .thumb_g').lazyload({
				threshold : 200
			});
		},
		lnbCheck: function() {
			var st = $(window).scrollTop();
			var currentScrollTop = st + 120;
			var divIndex = newArray.length;
			for (var i = 0; i < divIndex; i++) {
				if (newArray[i] > currentScrollTop || newArray[i + 1] < currentScrollTop) {
				}else {
					$('#omfLnb li').not(i).removeClass('on');
					$('#omfLnb li').eq(i).addClass('on');
				};
			};
		},
		scrollCheck: function() {
			var st = $(window).scrollTop();
			if(st > 20){
				$('body').addClass('scroll_on');
			}else{
				$('body').removeClass('scroll_on');
			};
		},
		scrollReset: function() {
			$(document).ready(function() {
				ohMyFriends.lnbCheck();
				ohMyFriends.scrollCheck();
			});
		},
		scrollTopTarget: function() { // 로딩 후 omf_wrap 클래스가 있는 div의 .offset().top을 저장/푸쉬 함
			var target = $('.landing_pc .omf_wrap');
			$(target).each(function(){
				var thisScrollTop = $(this).offset().top;
				newArray.push(thisScrollTop);
			});
		},
		scrollUserMove: function() {  // 스크롤 이동 시 현재 스크롤 위치와 omf_wrap 영역을 비교하여 lnb의 클래스를 추가/삭제 함
			$(window).on('scroll',function () {
				ohMyFriends.lnbCheck();
				ohMyFriends.scrollCheck();
			});
		},
		scrollTopMove: function(top, speed) { // 스크롤 이동 시 위치, 속도에 맞춰 animate 실행
			$('html,body').animate({
				scrollTop : top
			}, speed ? speed : 'slow',function () { // speed가 없을 경우 slow가 default
				ohMyFriends.scrollUserMove();
			});
		},
		lnbMove: function() { // lnb 에니메이션
			$('#omfLnb .link_lnb').each(function(index, el) {
				$(this).on('click', function(e) {
					e.preventDefault();
					var scrollTopChange = newArray[index] - 120
					$(window).off('scroll');
					$('#omfLnb li').removeClass('on');
					$(this).parent().addClass('on');
					ohMyFriends.scrollTopMove(scrollTopChange);
					ohMyFriends.lazyLoad();
					if(scrollTopChange > -100){
						$('body').addClass('scroll_on');
					}else{
						$('body').removeClass('scroll_on');
					};
				});
			});
		},
		imgRollover: function() { // 상품 리스트 썸네일 롤오버 효과
			$('.landing_pc .link_product').hover(
				function () {
					var obj = $(this).children('span').children('img');
					var src = obj.attr('src').replace('.png', '_on.png');
					obj.attr('src', src);
				}, function () {
					var obj = $(this).children('span').children('img');
					var src = obj.attr('src').replace('_on.png', '.png');
					obj.attr('src', src);
				}
			);
		},
		pageLoad: function() {
			this.addClassAnimation();
			this.mCheck();
			this.lazyLoad();
			this.scrollReset();
			this.scrollTopTarget();
			this.scrollUserMove();
			this.lnbMove();
			this.imgRollover();
		}
	};
	ohMyFriends.pageLoad();
</script>
</body>
</html>