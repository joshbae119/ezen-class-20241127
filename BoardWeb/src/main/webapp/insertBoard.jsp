<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>새글 등록</title>
</head>
<body>
<center>
<h1>글 등록</h1>
<a href="logout.do">로그아웃</a>
<hr>
<form action="insertBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input type="text" name="title"></td>
	</tr>

	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><input type="text" name="writer"></td>
	</tr>
	
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea rows="10" cols="40" name="content"></textarea></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="새글 등록"></td>
	</tr>
</table>
</form>
<hr>
<a href="getBoardList.do">글 목록가기</a>
</center>
</body>
</html>