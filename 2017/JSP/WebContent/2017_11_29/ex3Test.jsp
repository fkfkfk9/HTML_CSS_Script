<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOR문을 이용한 곱하기 결과</title>
</head>
<body>
	<h2>연습문제 3번 결과</h2>
	<% request.setCharacterEncoding("utf-8"); %>
	<%
		int dan = Integer.parseInt(request.getParameter("dan"));
		int num = Integer.parseInt(request.getParameter("num"));	
		int result = 1;
		for(int i = 0; i<num; i++){
			result *= dan;
		}
	%>
	<p><%=dan %>을 <%=num %>번 구한 결과는 : <%=result %></p>
</body>
</html>
