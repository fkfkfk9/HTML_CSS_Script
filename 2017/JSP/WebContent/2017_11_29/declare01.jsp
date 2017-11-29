<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>declare</title>
</head>
<body>
	선언문 : 변수또는 메서드를 작성하는 영역(클래스의 전역변수, 클래스의 메소드)
	<%!	
		String name = "홍길동";
		int age = 100;
		public String getInfo(){//메소드는 반듯이 선언문에 작성해준다 스크립트릿에선 에러
			return name + ", " + age;
		}
	%>
	<h1>표현식 연습</h1>
	<p>이름 : <%=name%></p>
	<p>나이 : <%=age%></p>
</body>
</html>
