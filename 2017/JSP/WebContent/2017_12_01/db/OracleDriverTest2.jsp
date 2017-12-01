<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<h1>오라클 연결 테스트</h1>
<%
	Connection conn = null;

	try{
		//@localhost:포트번호 일반적으로 오라클은 1521이지만 작업환경에 따라 다를 수 있다.
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "jsp_user";
		String pw = "1111";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//ojdbc6.jar에 있는 클래스 사용.
		conn = DriverManager.getConnection(url, id, pw);
		//out.println("데이터 베이스 연결 성공!!!!!!!!!!!!!!!");
	    String sql = "insert into member values(2, 'user02', '2222', '안양')";
	    //sql문이 들리면 sql신텍스 에러가 발생하여 catch문으로 간다.
	    PreparedStatement psmt = conn.prepareStatement(sql); 
	    //PreparedStatement sql문을 실행시키기 위한 기능을 제공하는 클래스
	    psmt.executeUpdate();
	    
	    out.println("데이타 삽입 성공!!!!!!!!!!!!!!!");
	}catch(Exception e){
		e.printStackTrace();
	}
%>