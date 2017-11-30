<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate();//모든세션값을 제거한다.
  	response.sendRedirect("login_success.jsp");
%>