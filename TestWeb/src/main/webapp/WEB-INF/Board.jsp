<%@page import="beans.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
  
	List<BoardDTO> dto = (List<BoardDTO>)request.getAttribute("bds");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="/TestWeb/Text">���ۼ�</a>
	<div>����������</div>
	<%
		for(BoardDTO b : dto){
			
	%>
	
	<div><%=b.getB_title() %></div>
	<div><%=b.getB_id() %></div>
	<a href="/TestWeb/Detail?b_id=<%=b.getB_id()%>">���������̵�</a>		
	<% 		
		}
	%>
	
</body>
</html>