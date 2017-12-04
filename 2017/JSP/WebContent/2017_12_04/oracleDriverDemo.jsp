<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<%@ page import="db.DbInfo" %>
<h1>오라클 연결 테스트</h1>
<%
	Connection conn = null;

	try{
		DbInfo di = new DbInfo();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(di.getURL(), di.getID(), di.getPW());
	    //String sql = "insert into member values(2, 'user02', '2222', '안양')";
	    String sql = "insert into member values(?, ?, ?, ?)";
	    //PreparedStatement사용하면 위처럼 ????를 쓰는 플레이스 홀더 기능을 사용가능
	    /*3가지 방식이 있다.
	    	conn.createStatement();
	    	실부에서 거의 사용안함 간단한 테스트용 처리속도가 가장 느리다.
	    	conn.prepareStatement(sql);
	    	conn.prepareCall(sql);
	    	
	    */
	    //Statment st = conn.createStatement();
	    PreparedStatement psmt = conn.prepareStatement(sql);
	    //CallableStatement cstmt = conn.prepareCall(sql);
	    psmt.setInt(1, 3);psmt.setString(2, "user04");
	    psmt.setInt(3, 4444);psmt.setString(4, "강남");
	    psmt.executeUpdate();
	    
	    out.println("데이타 삽입 성공!!!!!!!!!!!!!!!");
	}catch(Exception e){
		e.printStackTrace();
	}
%>