<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.DbInfo" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="member" class="jsp_2017_12_04.bean.member" scope="page">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
	Connection conn = null;
	PreparedStatement psmt = null;
	try{
		DbInfo di = new DbInfo();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(di.getURL(), di.getID(), di.getPW());
	    
	    String sql = "delete member2 where id = ?";
	    psmt = conn.prepareStatement(sql);	    
	    psmt.setString(1, member.getId());
	    psmt.executeUpdate();	    
	}catch(Exception e){
		e.printStackTrace();
		out.println("데이터 삽입 실패!!!");
	}finally{
		if(psmt != null){
			try{
				psmt.close();
			}catch(SQLException sqle){}
		} 			
 		if(conn != null){
 			try{
 				conn.close();
 			}catch(SQLException sqle){}	
 		} 			
	}
	response.sendRedirect("selectDemo2.jsp");
%>

