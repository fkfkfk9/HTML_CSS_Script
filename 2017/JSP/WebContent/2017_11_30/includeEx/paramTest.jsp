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
	<h1>Test 페이지 시작합니다.</h1>
	<%
		String pageName = "paramDemo.jsp";
		String id = "fkfkfk9";
	%>
	<hr>
	<%-- 파라메타는 인클루드에 포함시켜야한다. --%>
	<jsp:include page="<%=pageName %>" >
		<jsp:param name="id" value="<%=id %>" />
		<jsp:param name="pageName" value="<%=pageName %>" />
	</jsp:include>
	<p>Test 페이지 나갑니다.</p>
</body>
</html>
