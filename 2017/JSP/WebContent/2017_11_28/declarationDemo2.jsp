<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>선언부와 프로그래밍부의 차이</title>
</head>
<body>
  <h1>어디서나 선언가능한 변수를 왜 선언부에서 정의해야 하는가</h1>
  
  <%!
     String str1 = "선언부에서 선언";//멤버변수
  %>
   
  <%
     String str2 = "프로그래밍부(스크립트릿)에서 선언";//지역변수
  %>
  <%-- 하나의 자바파일상에서 <%!에서 선언한건 한 클래스의 멤버변수로
  	   <%안에서 선언된 변수는 void _jspService메소드의 지역변수로 정으된다.
  	   실제로 jsp파일 실행후 생성된 java파일을 들어가면 확인가능 --%>
</body>
</html>