<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="kf" uri="http://www.kakaofriends.com" %>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="servletPath"/>
<div class="opt_cate opt_char">
	<strong class="screen_out">캐릭터별 분류 선택</strong>
	<a href="#none" class="link_selected link_on">
		<span class="ico_friends ico_cate"></span>
		<span class="txt_cate">${kf:findByCategorySeq(categoryMenu[4], productRequest.requestCharacter)}</span>
		<span class="screen_out">선택됨</span>
	</a>
	<div class="box_cate">
		<em class="emph_cate">캐릭터 선택</em>
		<ul class="list_cate">
			<c:forEach items="${categoryMenu[4]}" var="menu">
				<li>
					<a href="/kr/products/groups/characters/${menu.ctSeq}?requestCategory=${productRequest.requestCategory}&requestCharacter=${menu.ctSeq}" class="link_cate">
						<span class="ico_friends ico_${fn:toLowerCase(menu.ctEname)}"></span>
						${menu.ctName}
					</a>
				</li>
			</c:forEach>
		</ul>
		<button type="button" class="btn_close"><span class="ico_friends ico_close">선택옵션 닫기</span></button>
	</div>
</div>
<div class="opt_cate"><!--펼침시 클래스 cate_open 부여-->
	<strong class="screen_out">상품유형 분류 선택</strong>
	<a href="#none" class="link_selected">
		<span class="ico_friends ico_cate"></span>
		<span class="txt_cate">${kf:findByCategorySeq(categoryMenu[3], productRequest.requestCategory)}</span>
		<span class="screen_out">선택됨</span>
	</a>
	<div class="box_cate">
		<em class="emph_cate">카테고리 선택</em>
		<ul class="list_cate">
			<li><a href="/kr/products/groups/characters/${productRequest.requestCharacter}?requestCategory=&requestCharacter=${productRequest.requestCharacter}" class="link_cate">전체</a></li>
			<c:forEach items="${categoryMenu[3]}" var="menu">
				<li><a href="/kr/products/groups/characters/${productRequest.requestCharacter}?requestCategory=${menu.ctSeq}&requestCharacter=${productRequest.requestCharacter}" class="link_cate">${menu.ctName}</a></li>
			</c:forEach>
		</ul>
		<button type="button" class="btn_close"><span class="ico_friends ico_close">선택옵션 닫기</span></button>
	</div>
</div>