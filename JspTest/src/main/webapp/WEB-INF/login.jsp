<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% String msg = (String)request.getAttribute("msg"); %>
	<% if(msg != null){
	%>
		<div><%=msg %></div>
	<%	
	} %>
	<form action="/JspTest/Login" method="post">
	아이디	<input name="u_id" type="text">	<p/>
	비밀번호	<input name="pwd" type="password"><p/>
	<input type="submit" value="로그인">
	<a href="/JspTest/Main">회원가입</a>
	</form>
</body>
</html>