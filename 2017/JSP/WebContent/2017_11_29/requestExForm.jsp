<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리퀘스트 폼</title>
</head>
<body>
	<form method="post" action="requestEx.jsp">
		<label for="name">이름</label>
      	<input name="name" type="text"
                 placeholder="유종현" autofocus required>
        <br>
        <label for="age">나이</label>
      	<input id="age" name="age" type="number"
                 min="20" max="150" value="20" required>
        <br>
        <fieldset>
      		<legend>성별</legend>
     		<input id="male" name="gender" type="radio" value="m" checked>
      		<label for="male">남자</label>
      		<input id="female" name="gender" type="radio" value="f">
      		<label for="female">여자</label>
    	</fieldset>
    	<br>
    	<label for="hobby">취미</label>
    	<input type="checkbox" name="hobby"  value="독서" checked>독서
    	<input type="checkbox" name="hobby"  value="게임" >게임
    	<input type="checkbox" name="hobby"  value="드라이브" >드라이브
    	<input type="checkbox" name="hobby"  value="운동" >운동	 
    	<br>
        <input type="submit" value="확인">     
	</form>
</body>
</html>
