<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 include</title>
</head>
<body>
	<h1>include 테스트 폼 </h1>
	<form method="post" action="includeTest.jsp">
		<label for="uid">아이디</label>
	    <input name="uid" type="text" autofocus required><br>
	    <label for="page">page</label>
	    <input name="page" type="text" value="includeDemo.jsp" required>
	    <br>
	    <input type="submit" value="전송">
    </form>
</body>
</html>
