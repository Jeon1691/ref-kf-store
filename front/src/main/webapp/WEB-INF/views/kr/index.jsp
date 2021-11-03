<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set value="${kakaoWebView}" var="kakaoWebView"/>
<div id="mArticle" class="carousel slide" data-interval="false" data-ride="false" data-pause="hover">
    <div class="carousel-inner">
        <div id="tabLayer1" class="carousel-item active">
            <tiles:insertTemplate template="/WEB-INF/templates/kr/home/home.jsp" flush="true"/>
        </div>
        <!-- // 최신 상품 -->
        <div id="tabLayer2" class="carousel-item" style="display:none">
        </div>
        <div id="tabLayer3" class="carousel-item" style="display:none">
        </div>
        <div id="tabLayer4" class="carousel-item" style="display:none">
       </div>
    </div>

</div><!--// mArticle -->
<c:if test="${!empty basketPopup}">
    <c:choose>
        <c:when test="${basketPopup}">
            <script>
              basketPopup();
            </script>
        </c:when>
        <c:otherwise>
            <script>
              alertPopup('alert_alreadyBasket_giftBag_detail');
            </script>
        </c:otherwise>
    </c:choose>
</c:if>

<script type="text/javascript">
  $(document).ready(function () {
    var emptyMessage = '${emptyMessage}';
    if ( emptyMessage != '' ){
        console.log(emptyMessage)
        layerCenter();
        setTimeout(function(){alert(emptyMessage);},100)

      $(".dimmed_layer").hide();
    }
  });
</script>
