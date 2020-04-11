<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$("#UserUpdate_Btn").click(function(){
			$("#frmUserUpdate").submit();
		})
	})
</script>
				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.html" class="logo"><strong>MY PAGE</strong>마이페이지</a>
									<ul class="icons">
										<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
										<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
									</ul>
								</header>
								
												<!-- Form -->
													<h3>회원정보 수정</h3>

													<form method="post" action="UserUpdate" id="frmUserUpdate">
														<div class="row uniform">
															<div class="6u 12u$(xsmall)">
																<h3>아이디</h3>
																<input type="text" name="demo-name" id="demo-name" value="${USER.user_id }" placeholder="Name" />
															</div>
															<div class="mini-posts">
																<article>
																	<div class="circle-img" style="text-align: left; width: 60px; height: 60px;">
																		<img src="images/pic07.jpg" alt="" />
																		<input type="file">
																	</div>
																</article>
															</div>
															<div class="6u$ 12u$(xsmall)">
																<h3>이메일</h3>
																<input type="email" name="demo-email" id="demo-email" value="${USER.user_email }" placeholder="Email" />
															</div>
															<div class="6u 12u$(xsmall)">
																<h3>이름</h3>
																<input type="text" name="demo-name" id="demo-name" value="${USER.user_name }" placeholder="Name" />
															</div>
															<div class="6u$ 12u$(xsmall)">
																<h3>닉네임</h3>
																<input type="email" name="demo-email" id="demo-email" value="${USER.user_nickname }" placeholder="Email" />
															</div>
															<div class="6u 12u$(xsmall)">
																<h3>비밀번호</h3>
																<input type="password" name="demo-name" id="demo-name" value="" placeholder="password" />
																<input type="password" name="demo-name" id="demo-name" value="" placeholder="password_Check" />
															</div>
															<!-- Break -->
															<div class="12u$">
																<ul class="actions">
																	<li><input type="submit" value="정보수정하기" id="UserUpdate_Btn" class="special" /></li>
																	<li><input type="reset" value="회원탈퇴" /></li>
																</ul>
															</div>
														</div>
													</form>
	</div>
</div>

