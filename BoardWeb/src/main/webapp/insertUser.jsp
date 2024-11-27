<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
<center>
	<h1>회원가입</h1>
	<hr>
	<!-- 에러 메시지 출력 -->
	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null) { %>
		<div style="color: red;"><%= errorMessage %></div>
	<% } %>

	<!-- 입력 데이터 유지 -->
	<% 
	String id = request.getAttribute("id") != null ? (String) request.getAttribute("id") : "";
	String name = request.getAttribute("name") != null ? (String) request.getAttribute("name") : "";
	%>	
	
	<form action="insertUser.do" method="post">
	<table border="1" >
		<tr>
		<td bgcolor="orange" >아이디</td>
		<td><input type="text" name="id"></td>
		</tr>
		
		<tr>
		<td bgcolor="orange">비밀번호</td>	
		<td><input type="text" name="password"></td>
		<td>
		
		<tr>
		<td bgcolor="orange">비밀번호확인</td>	
		<td><input type="text" name="password2"></td>
		<td>
		
		<tr>
		<td bgcolor="orange">이름</td>	
		<td><input type="text" name="name"></td>
		<td>
		
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="회원가입"></td>
		</tr>
	
	</form>
	
</center>






</body>
</html>