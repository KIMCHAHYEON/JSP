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
	���̵�	<input name="u_id" type="text">	<p/>
	��й�ȣ	<input name="pwd" type="password"><p/>
	<input type="submit" value="�α���">
	<a href="/JspTest/Main">ȸ������</a>
	</form>
</body>
</html>