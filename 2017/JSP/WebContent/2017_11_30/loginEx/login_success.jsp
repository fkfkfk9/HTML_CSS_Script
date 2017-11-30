<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공</title>
</head>
<body>
	<%if(session.getAttribute("uid") == null){ %>
		<h1>로그인 정보가 없습니다. 로그아웃 되었습니다.</h1>
		<a href="login.jsp">로그인</a>
	<% } else{ %>
		<h1> <%=session.getAttribute("uid") %>님 로그인 성공!!!!!!!!!!</h1>
		<p>로그인은 <%=session.getMaxInactiveInterval() %>초동안 유지됩니다.</p>
		<form method="post" action="sessionEx.jsp">
			<input type="submit" value="로그아웃">
		</form>
	<% } %>
	
</body>
</html>
