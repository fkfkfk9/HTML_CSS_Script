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
				<th>아이디</th><th>이름</th><th>비고</th><th>삭제</th>
			</tr>
			<%
				Connection conn = null;
				PreparedStatement ps = null;
				DbInfo di = new DbInfo();
				ResultSet rs = null;
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(di.getURL(), di.getID(), di.getPW());
					//String sql = "select id, name from member2";
					String sql = "select id as \"아이디\", name as \"이름\" from member2";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();					
					
					while(rs.next()){
						//member.setId(rs.getString(1));
						//member.setName(rs.getString(2));
						member.setId(rs.getString("아이디"));
						member.setName(rs.getString("이름"));
						//as콜롬명을 주면 콜롬명으로 검색해야한다.
						%>
						<tr>
						<td><%=member.getId() %></td>						
						<td><a href="selectDetail.jsp?id=<%=member.getId() %>">
						<%=member.getName() %></a></td>	
						<td><a href="updateForm.jsp?id=<%=member.getId() %>">
						수정</a></td>		
						<td><a href="dbdelete.jsp?id=<%=member.getId() %>">
						삭제</a></td>										
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