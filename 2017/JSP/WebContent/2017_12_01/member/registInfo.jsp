<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="member" class="jsp_2017_12_01.mem.bean.Member" scope="page">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>
<%	 
	member.setReg_date(new Timestamp(System.currentTimeMillis()));
%>

회원번호 : <jsp:getProperty property="idx" name="member"/>	<br>
아이디   : <jsp:getProperty property="userid" name="member"/><br>
암  호   : <jsp:getProperty property="passwd" name="member"/><br>
주  소   : <jsp:getProperty property="addr" name="member"/><br>
가입일   : <jsp:getProperty property="reg_date" name="member"/><br>

<%
	out.println(member.getIdx());
	out.println(member.getAddr());
	out.println(member.getUserid());
//jsp:useBean을 선언할때 썻던 id를 통해 데이터를 가져올수도있다.
%>
