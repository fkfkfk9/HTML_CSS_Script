<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="testbean" class="jsp_2017_12_01.bean.TestBean" scope="page">
		<jsp:setProperty name="testbean" property="id" param="uid"/>
		<%--property가 만약 form상의 name과 달라도 property는 빈클래스와 같아야 하기
			때문에 수정을 할 수가 없다 이럴때 param을 추가해서 넣어준다. --%>
		<%-- 
			<jsp:setProperty name="testbean" property="*" />
			만약 클래스에 멈박 수십개가 된다든지 너무 많다면 *로 한줄로 모두 추가 가능
		--%>	
	</jsp:useBean>
	<%-- 
		java Resources의 src에 있는 자바빈 java파일의 객체를 생성하는 작업 
		id는 파일명을 직접 주는거고 class는 해당 파일의 패키지명.클래스명으로 한다.
		scope는  내장객체이 종류를 정해주는걸로 page는 현재 페이지 리퀘스트는
		현재 페이지 + 엑션테그를 이용한 페이지까지 가능 쎄션은 연결된것 내에서
		어플리케이션은 전체에서 사용가능한 것이다.
	--%>
	아이디 : <jsp:getProperty property="id" name="testbean"/>
</body>
</html>
