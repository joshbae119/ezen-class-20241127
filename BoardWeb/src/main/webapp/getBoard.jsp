<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 상세</title>
</head>
<body>

<center>
<h1>글 상세</h1>
<a href="logout.do">로그아웃</a>
<hr>

<form action="updateBoard.do" method="post">
<input name="seq" type="text" value="${board.seq}"/>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange" width="70">제목</td>
	<td align="left"><input name="title" type="text" value="${board.title}"/></td> 
	</tr>
	<tr>
	<td bgcolor="orange">작성자</td>
	<td align="left">${board.writer}</td>
    </tr>
    
    <tr>
    <td bgcolor="orange">내용</td>
    <td align="left"><textarea rows="10" cols="40" name="content">${board.content}</textarea>
	</td>
	
	<tr>
	<td bgcolor="orange">등록일</td>
	<td align="left">${board.regDate}</td>
	</tr>
	
	<tr>
	<td bgcolor="orange">조회수</td>
	<td align="left">${board.cnt}</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="글 수정"></td>
	</tr>
</table>
</form>

<a href="insertBoard.jsp">글 등록</a>&nbsp&nbsp&nbsp;
<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp&nbsp&nbsp;
<a href="getBoardList.do">글 목록</a>

</center>
</body>
</html>