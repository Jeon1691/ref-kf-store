<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="mArticle">
    <div class="cont_board">
        <div class="head_board">
            <ul class="tab_friends">
                <li>
                    <a class="link_tab" href="/kr/customcenter/bnotice"> 공지사항 </a>
                </li>
                <li class="on">
                    <a class="link_tab" href="/kr/customcenter/faq"> FAQ </a>
                </li>
            </ul>

            <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                <strong class="screen_out">분류 선택</strong>
                <a class="link_selected" href="#none">
                    <span class="txt_sort">${categoryName}</span>
                    <span class="screen_out">선택됨</span>
                    <span class="ico_friends ico_arr"></span>
                </a>
                <div class="box_sort">
                    <em class="screen_out">선택옵션</em>
                    <ul class="list_sort">
                        <li class="on"><a class="link_sort" href="/kr/customcenter/faq">전체</a></li>
                        <c:forEach items="${boardCategories}" var="boardCategory" varStatus="status">
                            <li class="on"><!-- 선택시 on 클래스 부여 -->	<a class="link_sort" href="/kr/customcenter/faq/${boardCategory.bdcSeq}" data-bdcseq="${boardCategory.bdcSeq}">${boardCategory.bdcName}</a></li>
                        </c:forEach>
                    </ul>
                    <input type="hidden" id="sortVal" name="bdaBdcseq" class="inp_value" value="">
                </div>
            </div>
        </div>
        <h3 class="screen_out">FAQ</h3>
        <ul class="list_board">
            <c:forEach items="${boardArticles}" var="article" varStatus="status">
            <li>
                <a class="link_board" href="#none">
                    <span class="txt_info">
                        <span class="txt_cate">[${article.boardCategory.bdcName}]</span>
                        <span class="screen_out">작성일</span>
                        <%--<span class="txt_date"><fmt:formatDate value="${article.boardArticle.bdaIndate}" pattern="yyyy.MM.dd"/></span>--%>
                    </span>
                    <strong class="tit_board">${article.boardArticle.bdaName}</strong>
                    <span class="ico_friends ico_arr">내용 펼치기</span>
                </a>
                <div class="subject_board">
                    <strong class="tit_answer">답변 :</strong>
                        ${article.boardArticle.bdaContent}
                </div>
            </li>
            </c:forEach>
        </ul>
        <tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
    </div>
</div>