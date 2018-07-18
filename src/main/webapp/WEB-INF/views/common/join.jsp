<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="/js/join.js"></script>

<style>
	#header li a{
		color:#3d3d3d;
	}
	
	#header li a:hover{
		color:#adadad;
	}
</style>
<title>Welcome Join</title>
<body>
<jsp:include page ="/WEB-INF/views/common/header.jsp" flush="false" />
<div id="contents" class="wrap">
	<div class="joinWrap">
	<h1>회원가입</h1>
	<form name="join" class="join" action="/user/joinUser" onsubmit="return toCheckPass();" method="POST">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	<div class="agree">
        <div class="use">
				<h2>사이트 이용약관 동의</h2>
				<p>
					제1조 (목적)<br />
					이 약관은 Web Developer Portfolio용으로 제작된 학업, 취업의 용도로 제작된 사이트 입니다. Rain Chatting Service 이하 "레인 프로젝트" 테스트 및 이용과 관련하여 개발자와 회원("테스터")와의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.<br /><br />

					제2조 (정의)<br />
					① ‘이용자’란 서비스에 접속하여 이 약관에 따라 개발자가 제공하는 서비스를 받는 회원 및 비회원을 말합니다.<br />
					③ ‘회원’이라 함은 서비스에 회원가입을 한 자로서, 서비스 및 웹사이트의 정보를 지속적으로 제공 받으며, 개발자 및 웹사이트가 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.<br />
					④ ‘비회원’이라 함은 회원에 가입하지 않고 개발자가 제공하는 서비스를 이용하는 자를 말합니다.<br />
					⑤ ‘ID’라 함은 일반회원의 경우, 회원의 식별과 서비스 이용을 위하여 회원이 정하고 개발자가 승인하는 영문자와 숫자의 조합을 의미합니다.
					⑥ ‘비밀번호’라 함은 회원이 부여 받은 아이디와 일치되는 회원임을 확인하고 비밀보호를 위해 회원 자신이 정한 영문자 또는 숫자의 조합을 의미합니다.<br />
				</p>
				<input type="checkbox" name="agree_use" id="agree_use" /> <label for="agree_use">사이트 이용약관에 동의합니다.</label>
              </div>
              <div>

				<h2>개인정보 보호정책 동의</h2>
				<p>
					Rain Chatting Service(주)('http://localhost:8088' 이하 '레인 프로젝트')은(는) 개인정보보호법에 따라 이용자의 개인정보 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다.<br /><br />

					'Rain Chatting Service'은(는) 개인정보처리방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.<br /><br />

					○ 본 방침은 2018년 7월 16일부터 시행됩니다.<br /><br />

					1. 수집하는 개인정보 항목<br />
					개발자는 회원가입, 상담, 서비스 신청 등을 위해 아래와 같은 개인정보를 수집하고 있습니다.<br />
					가. 회원가입 필수항목<br />
					개인의 경우 : 이름, 아이디, 이메일<br />

					2. 개인정보의 처리 목적<br />
					'Rain Chatting Service'은(는) 개인정보를 다음의 목적을 위해 처리합니다. 처리한 개인정보는 다음의 목적 이외의 용도로는 사용되지 않으며 임의로 제3자에게 제공하지 않습니다.
				</p>
				<input type="checkbox" name="agree_personal" id="agree_personal" /> <label for="agree_personal">개인정보 보호정책에 동의합니다.</label>
                
                </div>
                
                
             </div><!--agree//-->
             
             <div class="agrall">
                
			<input type="checkbox" name="agree_all" id="agree_all" onclick="agree_chk();" required /> <label for="agree_all" >전체 약관에 동의합니다.</label>
             </div><!--agrall-->

		<dl>
			<dt><label for="userId">아이디</label> <span class="must">(필수)</span></dt>
			<dd><input class="input_txt" type="text" name="userId" id="userId" required /><button id="chk_btn" class="btn_id" type="button">중복 검사</button>
			 <input type="hidden" id="chkOkId" /><!-- 중복검사가 완료된 아이디 -->
                       	<input type="hidden" id="idChk" />
			<dt><label for="userPw">패스워드</label> <span class="must">(필수)</span></dt>
			<dd><input class="input_txt" type="password" name="userPw" id="userPw" required /></dd>
			<dt><label for="userPw2">패스워드 확인</label> <span class="must">(필수)</span></dt>
			<dd><input class="input_txt" type="password" name="userPw2" id="userPw2" required /></dd>
			<dt><label for="userName">이름</label> <span class="must">(필수)</span></dt>
			<dd><input class="input_txt" type="text" name="userName" id="userName" required /></dd>
			<dt><label for="userMail">이메일</label> <span class="must">(필수)</span></dt>
			<dd class="input_size"><input class="input_txt" type="text" name="userMail1" id="userMail" required /> @ <input class="input_txt" type="text" value="" id="userMail2" name="userMail2" title="이메일 주소 도메인" required />
				<select name="usr_email_domain" id="domainSelectBox" title="이메일 주소 도메인 선택">
					<option value="self">직접입력</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gmail.com</option>
				</select>
			</dd>
			<input type="hidden" value="" name="userMail" id="userMail_check"/>
		</dl>
		<div class="join_btn">
        <input type="submit" value="JOIN" />
        <input type="reset" value="RESET" />
        </div><!--join_btn//-->

	</form>
	</div>
</div><!-- //contents, wrap -->
</body>
</html>