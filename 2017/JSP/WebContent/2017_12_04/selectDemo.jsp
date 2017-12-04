<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.DbInfo" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="jsp_2017_12_04.bean.member" scope="page"></jsp:useBean>
<html>
	<head>
		<title>화면 리스트 출력</title>
	</head>
	<body>
		<table border = "1">
			<tr>
				<th>아이디</th><th>비밀번호</th><th>이름</th><th>가입일자</th>
				<th>주소</th><th>전화번호</th>
			</tr>
			<%
				Connection conn = null;
				PreparedStatement ps = null;
				DbInfo di = new DbInfo();
				ResultSet rs = null;
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(di.getURL(), di.getID(), di.getPW());
					String sql = "select* from member2";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					//포인터의 위치를 다음행으로 이동, 데이터의 존재 있으면 true 없으면 펄스
					while(rs.next()){
						member.setId(rs.getString(1));
						//rs.getString(index)의 인덱스는 데이터베이스당 해당 데이터 순서
						member.setPasswd(rs.getString(2));
						member.setName(rs.getString(3));
						Timestamp reg_date = rs.getTimestamp(4);
						member.setAddr(rs.getString("addr"));
						member.setTel(rs.getString("tel"));
						
						%>
						<tr>
						<td><%=member.getId() %></td>
						<td><%=member.getPasswd() %></td>
						<td><%=member.getName() %></td>
						<td><%=reg_date %></td>
						<td><%=member.getAddr() %></td>
						<td><%=member.getTel() %></td>
						</tr>
					<% }
				}catch(SQLException e){
					out.println("데이터 불러오기 실패");
				}
				finally{
					try{
						if(rs != null){
							rs.close();
						}
					}catch(SQLException e){}
					try{
						if(ps != null){
							ps.close();
						}
					}catch(SQLException e){}
					try{
						if(conn != null){
							conn.close();
						}
					}catch(SQLException e){}					
				}
			%>
		</table>
	</body>
</html>