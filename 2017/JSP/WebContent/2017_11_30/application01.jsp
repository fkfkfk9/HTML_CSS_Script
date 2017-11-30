<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어플리케이션 내장객체 예제</title>
</head>
<body>
	<%
		int count = 0;
		application.setAttribute("count", count++);//모든사용자가 공유함
		
		session.setAttribute("count", 100);//사용자별로 작용함 30분뒤엔 없어짐
		String info = application.getServerInfo();
		String path = application.getRealPath("/");
		application.log("로그 기록 : ");
	%>
	웹 컨테이너의 이름과 버전 : <%=info%><br>
	웹 어플리케이션 폴더의 로컬 시스템 경로 : <%=path%>
</body>
</html>
