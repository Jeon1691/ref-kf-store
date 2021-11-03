<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="mArticle">
	<div class="cont_board">
		<div class="head_board">
			<ul class="tab_friends">
				<li class="on"><a href="/en/customcenter/bnotice" class="link_tab">Notice</a></li>
				<li><a href="/en/customcenter/faq" class="link_tab">FAQ</a></li>
			</ul>
		</div>
		<h3 class="screen_out">notice</h3>
		<ul class="list_board">
			<c:forEach items="${boardArticles}" var="article" varStatus="status">
			<li>
				<a href="#${article.bdaSeq}" class="link_board">
				<span class="txt_info">
					<span class="txt_cate">[Notice]</span>
					<span class="screen_out">date</span>
					<span class="txt_date"><fmt:formatDate value="${article.bdaIndate}" pattern="yyyy.MM.dd" /></span>
				</span>
					<strong class="tit_board">${article.bdaName}</strong>
					<span class="ico_friends ico_arr">open</span>
				</a>
				<div class="subject_board">
					${article.bdaContent}
				</div>
			</li>
			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
	</div>
</div>
