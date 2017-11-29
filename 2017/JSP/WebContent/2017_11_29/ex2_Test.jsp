<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제 2번</title>
</head>
<body>
	<h2>연습문제 2번 결과</h2>
	<% request.setCharacterEncoding("utf-8"); %>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		
		String str = "";
		if(num >= 10) str = "10보다 크거나 같은 값";
		else str = "10보다 작은 값";		
	%>
	<p>입력한 값에 대한 결과 : <%=str %></p>
</body>
</html>
