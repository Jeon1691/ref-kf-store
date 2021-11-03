<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div id="mSub">
		<div class="box_visual detail_visual">
			<c:if test="${!empty(displayGoodsDetail.displayGoods.image1)}">
				<div class="item_visual" style="background-image:url('${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}')">
					<img src="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}" class="thumb_g" alt="제품 상세사진">
				</div>
			</c:if>
			<c:if test="${!empty(displayGoodsDetail.displayGoods.image1)}">
				<div class="item_visual" style="background-image:url('${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image2}')">
					<img src="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image2}" class="thumb_g" alt="제품 상세사진">
				</div>
			</c:if>
			<c:if test="${!empty(displayGoodsDetail.displayGoods.image3)}">
				<div class="item_visual" style="background-image:url('${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image3}')">
					<img src="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image3}" class="thumb_g" alt="제품 상세사진">
				</div>
			</c:if>
			<c:if test="${!empty(displayGoodsDetail.displayGoods.image4)}">
				<div class="item_visual" style="background-image:url('${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image4}')">
					<img src="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image4}" class="thumb_g" alt="제품 상세사진">
				</div>
			</c:if>
			<c:if test="${!empty(displayGoodsDetail.displayGoods.image5)}">
				<div class="item_visual" style="background-image:url('${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image5}')">
					<img src="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image5}" class="thumb_g" alt="제품 상세사진">
				</div>
			</c:if>
		</div>
	</div>
