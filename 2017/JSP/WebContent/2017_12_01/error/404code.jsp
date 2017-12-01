<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%--server.xml 에서 설정을 해줘야 한다. --%>
    <% 
    	response.setStatus(HttpServletResponse.SC_OK);
    	//HttpServletResponse.SC_OK는 상수값으로 200과 같다.
    %>
    <title>404에러 페이지</title>
    <h1>죄송합니다. 요청하신 페이지를 찾을 수 없습니다.</h1>