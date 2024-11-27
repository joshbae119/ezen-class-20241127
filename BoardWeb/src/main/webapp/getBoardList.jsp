<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 목록</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3> 환영합니다 <a href="logout.do">로그아웃</a></h3>

	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
		<th bgcolor="orange" width="100">번호</th>
		<th bgcolor="orange" width="200">제목</th>
		<th bgcolor="orange" width="150">작성자</th>
		<th bgcolor="orange" width="150">등록일</th>
		<th bgcolor="orange" width="100">조회수</th>
		</tr>
	
	<% for(BoardVO board : boardList) { %>
	<tr>
	  <td><%= board.getSeq() %></td>
	  <td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>">
	  <%= board.getTitle() %></a></td>
	  <td><%= board.getWriter() %></td>
	  <td><%= board.getRegDate() %></td>
	  <td><%= board.getCnt() %></td>
	  </tr>
	<%} %>
	</table>
<br>
<a href="insertBoard.jsp">새글 등록</a>

</center>
</body>
</html>