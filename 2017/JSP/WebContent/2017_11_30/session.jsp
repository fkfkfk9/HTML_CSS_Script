<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%/*
		클라이언트-서버의 작업시 리퀘스트 리스폰을 통해 데이터를 주고받아도
		비연결성이기 때문에 계속 연결되잇는 상태가 아니어서 로그인상태든 
		어떠한 정보를 유지하고 있어야 할 경우 확인이 불가능하다.
		그런 비연결성 때문에 서버나 클라이언트가 저장공간을 만들어 상태정보를 저장하는대
		클라이언트에 저장하는 방식은 쿠키, 서버에 저장하는 방식은 세션이다.
		클라이언트가 서버에 리퀘스트를 요청하는 순간 서버는 세션아이디를 만들고 
		리스폰에 세션아이디를 같이 보내 메모리를 공유하며 작업이 처리된다.
		세션의 경우 긴시간동안 다시 리퀘스트를 보내지 않는다면 자동소멸된다.
	*/%>
	<%= session.getId() %>
</body>
</html>
