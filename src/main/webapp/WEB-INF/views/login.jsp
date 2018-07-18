<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page ="/WEB-INF/views/common/header.jsp" flush="false" />

<div id="sub_container">

	<div class="loginwrap">
		<div class="wrap">
			<section>
			${error }
				<form action="/login" method="post" class="login_bg">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<ul>
						<li class="sub_tit">로그인</li>
						<li><input type="text" name="userId" id="userId"
							placeholder="아이디를 입력해주세요." /></li>
						<li><input type="password" name="userPw" id="userPw"
							placeholder="패스워드를 입력해주세요." /></li>
						<li class="submit"><input type="submit" value="LOGIN" /></li>
						<li class="sub_join">가입 하시겠습니까? <a href="/user/joinUser">회원가입</a></li>
					</ul>
					
				</form>
			</section>


		</div>
		<!-- wrap -->
	</div>
	<!-- loginwrap  -->

	</div>
	<!-- sub_container -->

