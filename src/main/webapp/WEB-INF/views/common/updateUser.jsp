<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>
<jsp:include page ="/WEB-INF/views/common/header.jsp" flush="false" />

<style>
	body{
		overflow: hidden;
	}
	#header li a{
		color:#3d3d3d;
	}
	
	#header li a:hover{
		color:#adadad;
	}
	
	.wrap{
		text-align: center;
		
		position: absolute;
		top: 120px;
	}
	
	.wrap h2{
		margin: 20px auto;
	}
	
	table{	
		width: 68%;
		margin: 0 auto;
		border-collapse:collapse;
	}
	table, tr, td, th{
		border: 1px solid #3d3d3d;
	}
	
	tbody input{
		width: 45%;
	}
	thead tr{
		height: 40px;
	}
	
	tbody tr{
		height: 34px;
	}
	
	button{
		width:50%;
		text-align: center;
		
		color:#fff;
		background-color: #3d3d3d;
		
		border: 0;
		height: 25px;
	}
	
	tfoot tr{
		height: 36px;
	}
	
	.wrap_table{
		width: 89%;
		overflow:hidden;
		position:absolute;
		top: 160px;
		left:5%;
	}
	
	.text-center{
	
		margin-top:10px;
	}
	.pagination{
		width: 60%;
		margin: 0 auto;
		
		text-align: center;
	}
	.pagination li{
		display: inline-block;
		padding: 10px 5px 0 5px;
	}
	
	.cre{
		float:right;
	
		width: 120px;
		height: 30px;
		
		padding-top:10px;
		margin-right: 10%;
		
		text-align: center;
		border: 1px solid #ededed;
	}
	
	.cre a:hover{
		text-decoration: none;
		color: #aeaeae;
	}
	
	.wrap{
		width: 100%;
	}
	
	#userMail1{
		width: 21.5%;
	}
	
	#userMail2{
		width:21.5%;
	}
	
	tfoot input{
		background-color: #3d3d3d;
		border: 0;
		color: #fff;
		
		height: 30px;
	}
</style>

<script type="text/javascript" src="/js/chkPass.js"></script>
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>

<div class="wrap">
<form action="/user/updateUser" id="actionForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<table>
		<thead>
			<tr>
				<th colspan="2" class="mainName">MY PAGE</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
                    <input type="text" id="userId" name="userId" value="${user.userId}" readonly />
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" id="userPw" name="userPw" />
					<p class="passResult"></p>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="userName" value="${user.userName}" readonly />
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input class="input_txt" type="text" name="userMail1" id="userMail1" value="${user.userMail.split('@')[0]}" />
					@ <input class="input_txt" type="text" id="userMail2" name="userMail2" title="이메일 주소 도메인"  value="${user.userMail.split('@')[1]}" />
					<input type="hidden" value="" name="userMail" id="userMail_check"/>
<%-- 					
<form:select path="usr_email_domain">
					  <form:option value="self" />
				      <form:option value="naver.com" />
				      <form:option value="daum.net"/>
				      <form:option value="gmail.com"/>
				    </form:select> --%>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" id="update" value="회원정보수정" onclick="check()" />
					<input type="button" id="delete" value="회원탈퇴" onclick="userdel()" />
					<input type="reset" value="다시 입력" />
					<p class="error">${error}</p>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</div>