<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<div id="status">
</div>
<div id="mArticle">
    <div class="cont_login">
        <button type="button" id="kakaoClose">닫음</button>
    </div>
</div>

<!--// mArticle -->

<script>

    $(function() {
      $('#kakaoClose').on('click', function() {
        document.location.href = "kakaotalk://web/close";
      }).trigger('click')



    })

</script>
