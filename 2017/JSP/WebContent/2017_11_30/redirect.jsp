<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sendRedirect()메소드를 사용하는 페이지 입니다.</h2>
 	<p>지금 있는 페이지는 <b>responseRedirect.jsp</b> 페이지입니다.</p>
 	<p>이제 서버정보를 확인할 <b>serverInfo.jap</b> 페이지로 이동하겠습니다.</p>
	<%response.sendRedirect("serverInfo.jsp");%>
	<%-- sendRedirect()가 실행되는순간 출력 버퍼가 비워지면서 지금까지 입력된게 날라가고
	      다음페이지로 넘어간다. --%>
	<%--sendRedirect는 주로 내부작업을 처리하는 JSP에서 사용한다.
	    예를 들면 로그인 작업을 할 때 DB와 연동하여 작업을 확인을 하고 
	    작업이 끝나면 다른페이지로 보내준다. --%>
</body>
</html>
