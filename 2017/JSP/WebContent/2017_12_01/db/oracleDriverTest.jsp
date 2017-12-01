<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<h2>오라클 JDBC드라이버 테스트 </h2>

<%
  Connection conn=null;
	//데이텋베이스의 연결기능을 제공하는 클래스 Connection
  try{
	 String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xe";
     String dbId = "jsp_user";
     String dbPass = "1111";
	 //oracle.jdbc.driver.OracleDriver 클래스를 메모리상에 로드 작업
	 //DriverManager 클래스에 등록된다.
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	 out.println("제대로 연결되었습니다.");
  }catch(Exception e){ 
	 e.printStackTrace();
  }
%>