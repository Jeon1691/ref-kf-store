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
                    <a class="link_tab" href="/en/customcenter/bnotice"> Notice </a>
                </li>
                <li class="on">
                    <a class="link_tab" href="/en/customcenter/faq"> FAQ </a>
                </li>
            </ul>

            <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                <strong class="screen_out">select type</strong>
                <a class="link_selected" href="#none">
                    <span class="txt_sort">${categoryEname}</span>
                    <span class="screen_out">selected</span>
                    <span class="ico_friends ico_arr"></span>
                </a>
                <div class="box_sort">
                    <em class="screen_out">select option</em>
                    <ul class="list_sort">
                        <li class="on"><a class="link_sort" href="/en/customcenter/faq">All</a></li>
                        <c:forEach items="${boardCategories}" var="boardCategory" varStatus="status">
                            <li class="on"><!-- 선택시 on 클래스 부여 -->	<a class="link_sort" href="/en/customcenter/faq/${boardCategory.bdcSeq}" data-bdcseq="${boardCategory.bdcSeq}" >${boardCategory.bdcEname}</a></li>
                        </c:forEach>
                    </ul>
                    <input type="hidden" id="sortVal" name="bdaBdcseq" class="inp_value" value="">
                </div>
            </div>
        </div>
        <h3 class="screen_out">FAQ</h3>
        <ul class="list_board">
            <c:forEach items="${boardArticles}" var="article" varStatus="status">
                <li><a class="link_board" href="#none">
                            <span class="txt_info">
                                <span class="txt_cate">[${article.boardCategory.bdcEname}]</span>
                                <span class="screen_out">date</span>
                                <%--<span class="txt_date"><fmt:formatDate value="${article.boardArticle.bdaIndate}" pattern="yyyy.MM.dd"/></span>--%>
                            </span>
                    <strong class="tit_board">${article.boardArticle.bdaName}</strong>
                    <span class="ico_friends ico_arr">open</span>
                </a>
                    <div class="subject_board">
                        <strong class="tit_answer">Answer :</strong>
                            ${article.boardArticle.bdaContent}
                    </div>
                </li>
            </c:forEach>
        </ul>
        <tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
    </div>
</div>