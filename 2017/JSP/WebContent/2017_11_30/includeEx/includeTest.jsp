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
		String pageName = request.getParameter("page");
	%>
	<hr>
	<jsp:include page="<%=pageName %>"></jsp:include>
	<%-- jsp:include를 사용하면 현제 페이지 작업중 해당 페이지로 넘어가 넘어간 페이지의
		 작업이 버퍼에 저장되고 다시 현재페이지에 돌아와 남은 작업을 처리하여 버퍼를 출력시킴
		 즉 현재페이지 처리 - 넘어간 페이지 처리 - 남은 현재 페이지 처리순서로 처리해줌 
		 특징은 Post방식으로 현재페이지에 넘어온 데이터들이 include한 페이지에서도 사용 가능--%>
	<p>Test 페이지 나갑니다.</p>
</body>
</html>
