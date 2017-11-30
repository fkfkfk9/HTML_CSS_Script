<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h1>로그인</h1>
	<form method="post" action="login_check.jsp">
		<label for="uid">아이디</label>
	    <input name="uid" type="text" autofocus required><br>
	    <label for="pw">비 번</label>
	    <input name="pw" type="password" required>
	    <br>
	    <input type="submit" value="로그인">
    </form>
</body>
</html>
