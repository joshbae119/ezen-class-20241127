<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>
<center>
	<h1>ȸ������</h1>
	<hr>
	<!-- ���� �޽��� ��� -->
	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null) { %>
		<div style="color: red;"><%= errorMessage %></div>
	<% } %>

	<!-- �Է� ������ ���� -->
	<% 
	String id = request.getAttribute("id") != null ? (String) request.getAttribute("id") : "";
	String name = request.getAttribute("name") != null ? (String) request.getAttribute("name") : "";
	%>	
	
	<form action="insertUser.do" method="post">
	<table border="1" >
		<tr>
		<td bgcolor="orange" >���̵�</td>
		<td><input type="text" name="id"></td>
		</tr>
		
		<tr>
		<td bgcolor="orange">��й�ȣ</td>	
		<td><input type="text" name="password"></td>
		<td>
		
		<tr>
		<td bgcolor="orange">��й�ȣȮ��</td>	
		<td><input type="text" name="password2"></td>
		<td>
		
		<tr>
		<td bgcolor="orange">�̸�</td>	
		<td><input type="text" name="name"></td>
		<td>
		
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="ȸ������"></td>
		</tr>
	
	</form>
	
</center>






</body>
</html>