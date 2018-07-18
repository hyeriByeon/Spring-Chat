<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<title>Welcome Rain Chat Service</title>
</head>
<body>
<sec:authentication var="user" property="principal" />
<script>
	function logout(){
		document.getElementById("logoutForm").submit();
	}
	
</script>
<header>
<c:url var="logoutUrl" value="/logout" />

<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
 
	<div id="header">
<!-- 		<nav>
			<ul>
				<li class=""><a href="#sub_container">SERVICE</a></li>
				<li><a href=""  class="search">FIND</a></li>
				<li><a href="">CONTACT</a></li>
			</ul>
		</nav> -->
	
		<nav>
			<ul>
				<li><a href="/">HOME</a>
	<sec:authorize access="isAnonymous()"> 
				<li><a href="/login">LOGIN</a></li>
				<li><a href="/user/joinUser">JOIN</a></li>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_DBA')">
				<li><a href="javascript:logout()">LOGOUT</a></li>
				<li><a href="/chat/chatList">SERVICE</a></li>
				<sec:authorize access="hasRole('ROLE_USER')">
				<li><a href="/user/updateUser">MYPAGE</a></li>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_DBA')">
				<li><a href="/user/userList">MANAGEMENT</a></li>
				</sec:authorize>
	</sec:authorize>
			</ul>
		</nav>
	
	</div>
</header>