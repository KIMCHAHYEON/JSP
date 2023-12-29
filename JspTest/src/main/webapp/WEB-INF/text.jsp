<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/JspTest/Text" method="post">
	제목		<input name ="b_title" type="text">
	내용		<textarea name="b_text" rows="40" cols="300"></textarea>
	열람 비번	<input name ="b_pwd" type="password">
	<input type ="submit" value="작성">
	</form>
</body>
</html>