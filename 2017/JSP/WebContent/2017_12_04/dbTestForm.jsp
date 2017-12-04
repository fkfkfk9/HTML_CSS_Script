<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="dbInsert.jsp">
		<label for="id">아이디</label>
	    <input name="id" type="text" autofocus required><br>
	    <label for="passwd">비 번</label>
	    <input name="passwd" type="password" required>
	    <br>
	    <label for="name">이 름</label>
	    <input name="name" type="text" required><br>
	    <label for="addr">주 소</label>
	    <input name="addr" type="text" required><br>
	    <label for="tel">전화번호</label>
	    <input name="tel" type="text" required><br>
	    <input type="submit" value="로그인">
    </form>
</body>
</html>
