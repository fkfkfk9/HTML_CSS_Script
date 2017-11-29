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
	<%-- request.setCharacterEncoding("utf-8") get방식은 처리가 안된다. --%>
	<h1>if예제 점수 학점 변환</h1>
	<%
		String name = request.getParameter("name");
		int stCode = Integer.parseInt(request.getParameter("stCode"));
		int score = Integer.parseInt(request.getParameter("score"));
		
		String grade = "";//학점 입력할 변수 초기화
		if(score >= 90 && score <= 100) grade = "A";
		else if(score >= 80 && score < 90) grade = "B";
		else if(score >= 70 && score < 80) grade = "C";
		else if(score >= 60 && score < 70) grade = "D";
		else if(score >= 50 && score < 60) grade = "F";
		else grade = "잘못된 입력값";		
	%>
	<p><%=stCode %>학번의 <%=name %>학생의 학점은 <%=grade %>입니다.<p>
</body>
</html>
