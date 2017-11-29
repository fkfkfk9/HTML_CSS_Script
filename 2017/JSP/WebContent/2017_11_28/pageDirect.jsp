<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="JSP 문법"%>
<%@ page import="java.sql.Timestamp, java.text.SimpleDateFormat" %> 
<%-- import는 보통 다른 page문하고 같이 써주지 않는다. 여러개를 쓴다면 ,를 사용--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=getServletInfo() %> <%--<%=%>는 안에 변수나 메소드를 출력해줌--%>
	<%
		Timestamp now = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String str = sdf.format(now);
	%>
	<br/>
	오늘 : <%=str %>
</body>
</html>
