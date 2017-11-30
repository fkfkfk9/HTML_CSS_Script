<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>

<%
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");	
	
	if(uid.equals("admin") && pw.equals("1234")){
		session.setMaxInactiveInterval(60*20);//세션연결시간을 30분이 디폴트인대 20분으로
		//바꿈
		session.setAttribute("uid", uid);
		response.sendRedirect("login_success.jsp");
	}else {
		response.sendRedirect("login_fail.jsp");
	}
%>