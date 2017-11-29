<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제 2번</title>
</head>
<body>
	<h1>연습문제 2번</h1>
	<form method="post" action="ex2_Test.jsp">
		<label for="num">값 입력</label>
		<!-- name은 겟이나 포스트로 데이터가 넘어갈때 사용되는 변수명 -->
      	<input id="num" name="num" type="number"      	
                 placeholder="10" autofocus required>
        <br>
        <input type="submit" value="확인">
	</form>
</body>
</html>
