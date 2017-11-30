<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>application 내장객체 예제</h2>
<%
    String info = application.getServerInfo();//웹 컨테이너의 이름을 스트링으로 받아옴
	String path = application.getRealPath(",");
    //서버상에 어플리케이션이 현재 존재하는 디렉토리를 확인
	application.log("로그 기록 : ");//콘솔창에 로그기록 확인
%>
   
웹 컨테이너의 이름과 버전 : <%=info%><p>
웹 어플리케이션 폴더의 로컬 시스템 경로 : <%=path%>