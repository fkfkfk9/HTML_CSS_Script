<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="registCheck.jsp"  />
	<% int idx = (int)session.getAttribute("memCount"); %>
	<form method="post" action="registInfo.jsp">
		<label for="idx">가입번호</label>
	    <input name="idx" type="text" value="<%=idx %>" ><br>
		<label for="userid">아이디</label>
	    <input name="userid" type="text" autofocus required><br>
	    <label for="passwd">비 번</label>
	    <input name="passwd" type="password" required><br>
	    <label for="addr">주 소</label>
	    <input name="addr" type="text" size="50" required><br>
	    <input type="submit" value="가입">
    </form>
</body>
</html>
