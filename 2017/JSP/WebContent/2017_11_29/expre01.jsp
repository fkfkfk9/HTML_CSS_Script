<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식(Expression)</title>
</head>
<body>
	<%!int a = 30; %>
	<%int a = 10; %>
	<h1>표현식 예제</h1>
	<%="a : " + a%><br/>
	<%="this.a : " + this.a %><%-- 표현식에는 ;을 넣지 않는다. --%>
	<br/>
	<%
		out.print(a);
	  	//out.write(this.a);출력되지 않는다.
	%>
</body>
</html>
