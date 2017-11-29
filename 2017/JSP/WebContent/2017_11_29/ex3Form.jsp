<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOR문을 이용한 곱하기 폼</title>
</head>
<body>
	<h1>연습문제 3번</h1>
	<form method="post" action="ex3Test.jsp">
		<label for="dan">제곱할 숫자선택</label>
      	<select id="dan" name="dan" required>
        	<option value="2" selected>2
        	<option value="3">3
        	<option value="4">4
        	<option value="5">5
        	<option value="6">6
        	<option value="7">7
        	<option value="8">8
        	<option value="9">9
     	</select>
		<br>
		<label for="num">몇번 제곱할 것인지 입력</label>
		<!-- name은 겟이나 포스트로 데이터가 넘어갈때 사용되는 변수명 -->
      	<input id="num" name="num" type="number"      	
                 placeholder="2" required>
        <br>
        <input type="submit" value="확인">
	</form>
</body>
</html>
