<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.DbInfo" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="member" class="jsp_2017_12_04.bean.member" scope="page">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>
<% Timestamp register = new Timestamp(System.currentTimeMillis()); %>
<%
	Connection conn = null;
	PreparedStatement psmt = null;
	try{
		DbInfo di = new DbInfo();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(di.getURL(), di.getID(), di.getPW());
	    
	    String sql = "insert into member2 values(?, ?, ?, ?, ?, ?)";
	    psmt = conn.prepareStatement(sql);	    
	    psmt.setString(1, member.getId());psmt.setString(2, member.getPasswd());
	    psmt.setString(3, member.getName());psmt.setTimestamp(4, register);
	    psmt.setString(5, member.getAddr());psmt.setString(6, member.getTel());
	    //psmt.execute(); sql문이 select일 경우 사용
	    int result = psmt.executeUpdate();
	    //executeUpdate는 처리된 행의 갯수 리턴	    
	    out.println(result + "개 데이타 삽입 성공!!!!!!!!!!!!!!!");
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

