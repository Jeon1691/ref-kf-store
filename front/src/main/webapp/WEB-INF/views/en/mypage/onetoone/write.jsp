<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="mArticle">
	<div class="cont_write">
		<h2 id="kakaoBody" class="tit_inquiry">Contact Us</h2>
		<form:form commandName="request" action="/en/mypage/onetoone/register" method="post" enctype="multipart/form-data">
			<fieldset class="fld_write">
				<legend class="screen_out">Contact Us form</legend>
				<div class="info_delivery">
					<h3 class="tit_sub">Customer Information</h3>
					<dl class="list_delivery">
						<dt><label for="bdaOwnername">Name</label></dt>
						<dd>
							<div class="box_input write_on"><!-- 입력시 write_on클래스 추가 -->
								<form:input path="bdaOwnername" class="tf_g" placeholder="Name" />
							</div>
						</dd>
						<dt><label for="bdaEmail">Email</label></dt>
						<dd>
							<div class="box_input">
								<input type="text" id="bdaEmail" name="bdaEmail" class="tf_g" placeholder="Email"/>
							</div>
						</dd>
						<dt><label for="bdaPhone">Phone</label></dt>
						<dd>
							<div class="box_input">
								<input type="text" id="bdaPhone" name="bdaPhone" class="tf_g" placeholder="Phone Number"/>
							</div>
						</dd>
					</dl>
				</div>
				<div class="info_delivery info_inquire">
					<h3 class="tit_sub">Contents of inquiry</h3>
					<dl class="list_delivery">
						<dt class="txt_opt">My Question</dt>
						<dd class="wrap_opt">
							<div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
								<a href="#none" class="link_selected">
									<span class="txt_sort">Please select the contents of the inquiry</span>
									<span class="screen_out">selected</span>
									<span class="ico_newfriends_v1 ico_arr"></span>
								</a>
								<div class="box_sort">
									<em class="screen_out">select option</em>
									<ul class="list_sort">
										<c:forEach items="${boardCategories}" var="boardCategory" varStatus="status">
											<li class="on"><a href="#none" class="link_sort" data-bdcseq="${boardCategory.bdcSeq}">${boardCategory.bdcEname}</a></li>
											<!-- 해외배송 항목 추가 필요, '해외배송비' 에서 '글로벌 배송비' 로 변경 -->
										</c:forEach>
									</ul>
									<input type="hidden" id="sortVal" name="bdaBdcseq" class="inp_value" value="">
								</div>
							</div>
						</dd>
						<dt><label for="bdaTitle">Title</label></dt>
						<dd>
							<div class="box_input">
								<input type="text" id="bdaTitle" name="bdaName" class="tf_g"/>
							</div>
						</dd>
						<dt><label for="bdaContent">Comment</label></dt>
						<dd>
							<div class="box_input box_textarea">
								<textarea id="bdaContent" name="bdaContent" class="tf_g"></textarea>
							</div>
						</dd>
						<dt class="tit_flow tit_file">
							<label class="lab_flow" for="fileUpload">Attach<br class="rw_hide"> Files</label>
						</dt>
						<dd class="wrap_file">
							<div class="box_file">
								<span id="fileName"></span>
							</div>
							<div class="select_file">
								<input type="file" id="fileUpload" name="bdaFile" class="inp_file">
								<span class="txt_file">Choose Photo</span>
							</div>
							<button type="button" class="btn_del"><span class="ico_newfriends_v1 ico_del">delete</span></button>
							<ul class="list_mindful">
								<li><span class="ico_newfriends_v1 ico_bullet"></span>In the case of product defect or misdelivery, register a photo of the product Please.</li>
								<li><span class="ico_newfriends_v1 ico_bullet"></span>Only one attachable file can be registered, with a maximum capacity of 10 MB There is a limit.</li>
								<li><span class="ico_newfriends_v1 ico_bullet"></span>Only image files (jpg, png, gif) can be registered.</li>
							</ul>
						</dd>
					</dl>

					<div class="group_join">
						<strong class="screen_out">Agree</strong>
						<ul class="list_agree">
							<li>
								<strong class="tit_agree">
									Agree to the collection and use of personal<br class="br_win"> information
									<a href="#none" class="link_agree" onclick="javascript:privacyWritePopup();">details</a>
								</strong>
								<div class="chk_agree">
									<div class="area_agree">
										<input type="checkbox" id="privacyAgree" checked="checked" class="inp_g">
										<label for="privacyAgree" class="lab_g"><span class="ico_newfriends_v1">Agree</span></label><!-- 2017-10-19 수정 : 아이콘 클래스 변경 -->
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>

				<div class="order_btn">
					<button type="submit" class="btn_order btn_payment"><span class="txt_g">Register</span></button>
					<a href="/en/mypage/onetoone" class="link_cancel"><span class="txt_g">Cancel</span></a>
				</div>
			</fieldset>
		</form:form>
	</div>
</div>