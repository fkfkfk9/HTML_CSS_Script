<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%-- isErrorPage 에러페이지로 사용할 것인지 디폴트값은 false --%>
<%response.setStatus(200); %>
<%--에러코드 200은 에러없다는 설정으로 200을 넣어줌으로서 에러를 없에고 원하는걸 출력 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error02</title>
</head>
<body>
	<h2>error01에러페이지 예외처리 용도</h2>
</body>
</html>
