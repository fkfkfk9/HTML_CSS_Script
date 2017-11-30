<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<h1>Demo 페이지 시작합니다.</h1>
	<% 
		String id = request.getParameter("uid");
	%>
	<p><%=id %>님이 접속하셨습니다.</p>
	<p>Demo 페이지 나갑니다.</p>
	<hr>
</body>
</html>
