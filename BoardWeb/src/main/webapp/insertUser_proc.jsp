<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
String password1 = request.getParameter("password2");
String name = request.getParameter("name");
String role = request.getParameter("role");


UserVO vo = new UserVO();
UserDAO userDAO = new UserDAO();

vo.setId(id);
vo.setPassword(password);
vo.setName(name);
vo.setRole(role);

if(password.equals(password1)){
	response.sendRedirect("NewFile.jsp");
}else{
	response.sendRedirect("insertUser.jsp");
}

userDAO.insertUser(vo);



%>
