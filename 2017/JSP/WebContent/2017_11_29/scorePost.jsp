<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수입력</title>
</head>
<body>
	<h1>점수 입력폼</h1>
	<form method="post" action="scoreTest.jsp">
		<label for="name">이름</label>
      	<input id="name" name="name" type="text"
                 placeholder="홍길동" autofocus required>
        <br>
        <label for="stCode">학번</label>
      	<input id="stCode" name="stCode" type="number"
                 placeholder="20070001">
        <br>
        <label for="score">점수</label>
      	<input id="score" name="score" type="number"
                 placeholder="100">
        <br>
        <input type="submit" value="확인">
	</form>
</body>
</html>
