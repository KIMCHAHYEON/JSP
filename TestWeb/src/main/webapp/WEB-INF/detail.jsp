<%@page import="beans.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
BoardDTO dt = (BoardDTO)request.getAttribute("board");
%>
<body>
	<div><%=dt.getB_title() %></div>
	<div><%=dt.getB_text() %></div>
</body>
</html>