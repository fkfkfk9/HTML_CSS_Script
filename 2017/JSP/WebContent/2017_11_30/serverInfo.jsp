<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>서버 정보</title>
</head>
<body>	
	<% request.setCharacterEncoding("utf-8");%>
	<h1>서버의 정보를 출력</h1>
	<%
		String[] infoName = {"프로토콜명","서버명",
				"Method방식","컨텍스트 경로","URI","접속한 클라이언트의 IP"};
		//리턴방식이 전부 스트링이기 때문에 스트링 배열에 넣어준다.
		String[] infoVal = {request.getProtocol(), request.getServerName(),
				request.getMethod(), request.getContextPath(),
				request.getRequestURI(), request.getRemoteAddr()};
		//리턴타입이 Enumeration<String>이다.
		Enumeration<String> e = request.getHeaderNames();
	    String headerName="";//아래 반복문에서 사용할 변수를 초기화 시켜줌
	    String headerValue="";
	%>
	<h2>웹서버 브라우저 정보</h2>
	<%
	  for(int i=0;i<infoName.length;i++){%>
	    <p><% out.println(infoName[i] + " : " + infoVal[i] +"<br>");%></p><%
	  }
	%>
	<h2>헤더</h2>
	<%
		while (e.hasMoreElements()) {
			headerName = e.nextElement();
			headerValue = request.getHeader(headerName);%>
			<p><%out.println(headerName + " : " + headerValue + "<br>");%></p><%
		}
	%>
	
</body>
</html>
