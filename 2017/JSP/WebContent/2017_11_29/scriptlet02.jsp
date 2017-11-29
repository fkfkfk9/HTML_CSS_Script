<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 예제</title>
</head>
<body>
	<h2>스크립트릿 예제</h2>
	<%
		int iv = 10;
		int iv2 = 20;
		if(iv > iv2){		
	%>
	iv가 iv2보다 크다.
	<%}
		else if(iv < iv2){			
	%>
	iv가 iv2보다 작다.
	<%} %>
</body>
</html>
