<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$("#b_insert_btn").click(function(){
			$("#frmInsert").submit();
		})
	})
</script>
				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.html" class="logo"><strong>게시판</strong></a>
									<ul class="icons">
										<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
										<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
									</ul>
								</header>
													<!-- Form -->
													<form method="post" action="fileUpload_post" id="frmInsert" enctype="multipart/form-data">
														<input type="hidden" id="check" name="check" value="1">
														<div class="row uniform">
															<div class="6u 12u$(xsmall)">
																<input type="text" name="b_subject" id="b_subject" value="" placeholder="제목" />
															</div>
															<div class="6u$ 12u$(xsmall)">
																<input type="email" name="user_id" id="user_id" value="${session_id }"  placeholder="작성자" />
															</div>
															<!-- Break -->
															<div class="12u$">
																<div class="select-wrapper">
																	<select name="b_category" id="b_category">
																		<option value="">- Category -</option>
																		<option value="1">Manufacturing</option>
																		<option value="1">Shipping</option>
																		<option value="1">Administration</option>
																		<option value="1">Human Resources</option>
																	</select>
																</div>
															</div>
															<div class="12u$">
																<textarea name="b_content" id="b_content" placeholder="Enter your message" rows="6"></textarea>
															</div>
															<label for="gdsImg">이미지</label>
															<input type="file" id="gdsImg" name="file" />
														 	<div class="select_img"><img src="" /></div>
														</div>
													</form>
													<div style="text-align: right;">
														<input type="button" id="b_insert_btn" value="글쓰기">
													</div>

	</div>
</div>

