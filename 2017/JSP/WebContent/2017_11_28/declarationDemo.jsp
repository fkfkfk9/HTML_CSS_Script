<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>선언문</title>
</head>
<body>
  <h1>선언문 EX</h1>
  <%-- <%!변수선언 <%= 변수나 메소드의 값을 출력함 <%프로그래밍 코드 --%>
  <% //문자열에 id를 연결하여 str에 저장한다.
  	//프로그래밍 코드
    String str = "ID : " + id;
  %>
   
  <%! //데이터 타입 내용 선언밑 정의
    String id = "fkfkfk9";
  %>
  
    결과 : <%=str %>
   <%--결과 출력 --%>
</body>
</html>