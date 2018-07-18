<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
	
	.table{	
		width: 80%;
		margin: 0 auto;
		text-align: center;
	}
	.table, tr, td, th{
		border: 1px solid #3d3d3d;
		border-collapse:collapse;
		
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
</style>
</head>
<body>
	
		<div class="wrap_table">
			<table class="table">
			   <tr>
			      <th>회원 아이디</th>
			      <th>회원 이름</th>
			      <th>이메일</th>
			      <th>회원 권한</th>
			   </tr>
			   
			   <c:forEach items="${userList}" var="userList">
			      <tr>
			         <td>${userList.userId}</td>
			         <td>${userList.userName}</td>
			         <td>${userList.userMail}</td>
			         <td>${userList.authority}</td>
			      </tr>
			   </c:forEach><!-- 룸 리스트 -->
			</table>
	
	
		
			<div class="text-center">
				<ul class="pagination">	
					<c:if test="${pageMaker.prev}">
						<li><a href="/chat/chatList?page=${pageMaker.startPage - 1}&perPageNum=${pageMaker.cri.perPageNum}">&laquo;</a></li>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
						<li class="page-item" <c:out value="${pageMaker.cri.page == idx ? 'class=active' : ''}"/>>
							<a href="/chat/chatList?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a>
						</li>
					</c:forEach>
			
					<c:if test="${pageMaker.next}">
						<li><a href="/chat/chatList?page=${pageMaker.endPage + 1}&perPageNum=${pageMaker.cri.perPageNum}">&raquo;</a></li>
					</c:if>
				</ul>
		</div><!-- text-center꺼 -->
		
  		
	</div>
</body>
</html>