<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");

	if(msg != null){
%>
	<div><%=msg %></div>
<% 		
	}
%>
	<form action="/TestWeb/Login" method="post">
	아이디	<input name="u_id" type="text"><p>
	비밀번호 	<input name="pwd" type="password"><P>
	<input type = "submit" value="전송"><p>
	</form>
</body>
</html>