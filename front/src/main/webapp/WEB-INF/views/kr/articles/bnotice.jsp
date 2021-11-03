<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="mArticle">
	<div class="cont_board">
		<div class="head_board">
			<ul class="tab_friends">
				<li class="on"><a href="/kr/customcenter/bnotice" class="link_tab">공지사항</a></li>
				<li><a href="/kr/customcenter/faq" class="link_tab">FAQ</a></li>
			</ul>
		</div>
		<h3 class="screen_out">공지사항</h3>
		<ul class="list_board">
			<c:forEach items="${boardArticles}" var="article" varStatus="status">
			<li>
				<a href="#${article.bdaSeq}" class="link_board">
				<span class="txt_info">
					<span class="txt_cate">[공지]</span>
					<span class="screen_out">작성일</span>
					<span class="txt_date"><fmt:formatDate value="${article.bdaIndate}" pattern="yyyy.MM.dd" /></span>
				</span>
					<strong class="tit_board">${article.bdaName}</strong>
					<span class="ico_friends ico_arr">내용 펼치기</span>
				</a>
				<div class="subject_board">
					${article.bdaContent}
				</div>
			</li>
			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
	</div>
</div>
