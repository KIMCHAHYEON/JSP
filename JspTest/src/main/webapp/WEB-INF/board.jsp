<%@page import="beans.UsrDTO"%>
<%@page import="beans.Board_DTO"%>
<%@page import="java.util.List"%>
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
HttpSession s = request.getSession();
UsrDTO u = (UsrDTO)s.getAttribute("usr");
if(u != null){
%>
<a href="/JspTest/Text">���ۼ�</a>
<a href="/JspTest/TransUsrs">
	ȸ������
</a>	

<%
}else{
%>
<a href="/JspTest/Login">�α����� ���ּ���</a>

<%
}
%>

<%
	List<Board_DTO> bs = (List<Board_DTO>) request.getAttribute("boards");
	
	for(Board_DTO b : bs){
%>
	<div><%=b.getB_id() %></div>
	
	<a href="/JspTest/Detail?b_id=<%=b.getB_id() %>"><div><%=b.getB_title() %></div></a>
	
<%
	}
%>

	
</body>
</html>