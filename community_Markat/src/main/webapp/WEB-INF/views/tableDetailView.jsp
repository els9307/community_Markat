<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#up_btn{
		cursor: pointer;
	}
	#down_btn{
		cursor: pointer;
	}
</style>
<script>

	$(document).ready(function(){
		$("#report_btn").click(function(){
			alert("신고하시겠습니까?");
			$("#frm_report").submit();
		})
		$("#b_update_btn").click(function(){
			$("#frm_UpdateView").submit();
		})
		$("#up_btn").click(function(){
			alert("이 게시물을 추천하시겠습니까?");
			$("#U_check").val("2");
			$("#frmPopular").submit();
		})
		$("#down_btn").click(function(){
			alert("이 게시물을 비추천하시겠습니까?");
			$("#U_check").val("3");
			$("#frmPopular").submit();
		})
	})
</script>
<form action="fileUpload_post" method="post" id="frm_report">
	<input type="hidden" id="b_num" name="b_num" value="${board.b_num }"> 
	<input type="hidden" id="check" name="check" value="3"> 
</form>
<form action="tableUpdateView" method="post" id="frm_UpdateView">
	<input type="hidden" id="b_num" name="b_num" value="${board.b_num }">
</form>
<form action="tableDetailView" method="post" id="frmPopular">
	<input type="hidden" id="b_num" name="b_num" value="${board.b_num }">
	<input type="hidden" id="U_check" name="U_check" > 
</form>

				<!-- Main -->
					<div id="main">
						<div class="inner">

<!-- Header -->
	<header id="header">
		<strong>게시판</strong>

	</header>
		<!-- Form -->
			<div class="row uniform">
				<div class="6u 12u$(xsmall)">
					<input type="text" name="b_subject" id="b_subject" value="${board.b_subject}" placeholder="제목"  disabled="disabled"/>
				</div>
				<div class="6u$ 12u$(xsmall)">
					<input type="email" name="user_id" id="user_id" value="${board.user_id }"  placeholder="작성자" disabled="disabled" />
				</div>
				<!-- Break -->
				<div class="12u$">
					<div class="select-wrapper">
						<select name="b_category" id="b_category" disabled="disabled">
							<option value="">- Category -</option>
							<option value="1">Manufacturing</option>
							<option value="1">Shipping</option>
							<option value="1">Administration</option>
							<option value="1">Human Resources</option>
						</select>
					</div>
				</div>
				<div class="12u$">
					<textarea name="b_content" id="b_content" placeholder="Enter your message" rows="6" disabled="disabled">${board.b_content}</textarea>
				</div>
				<div class="mini-posts">
				<label for="gdsImg">이미지</label>
	 			<div class="select_img"><img src="${pageContext.request.contextPath}${board.b_thumbimg }" /></div>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="icons">
					<li><i class="fas fa-thumbs-up" id="up_btn"><span class="label">좋아요</span></i></li>
					<li><i class="fas fa-thumbs-down" id="down_btn"><span class="label">싫어요</span></i></li>
				</ul>
			</div>
			<c:if test="${session_id != board.user_id && session_id != null}">
				<div style="text-align: right;">
					<a href="#"><input type="button"  id="report_btn" value="신고하기"></a>
				</div>
			</c:if>
			<c:if test="${session_id == board.user_id }">
				<div style="text-align: right;">
					<input type="button"  id="b_update_btn" value="글수정">
					<input type="button"  id="b_delete_btn" value="삭제">
				</div>
			</c:if>
	</div>
</div>

