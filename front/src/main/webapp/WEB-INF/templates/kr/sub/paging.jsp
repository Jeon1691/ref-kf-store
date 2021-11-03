<%@ taglib prefix="kf" uri="http://www.kakaofriends.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString"/>
<div class="paging_friends">
	<span class="inner_paging">
		<kf:pagination paginationInfo="${pagination}" servletPath="${pageLink}" queryString="${queryString}" type="Path"/>
	</span>
</div>