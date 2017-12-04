<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.DbInfo" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="jsp_2017_12_04.bean.member" scope="page"></jsp:useBean>
<jsp:setProperty name="member" property="id" param="id"/>
<%! Timestamp reg_date; %>
<html>
	<head>
		<title>상세 정보</title>
	</head>
	<body>
		<table border = "1">
			<tr>
				<th>아이디</th><th>비밀번호</th><th>이름</th><th>가입일자</th>
				<th>주소</th><th>전화번호</th>
			</tr>
			<%
				Connection conn = null;//DB연결
				PreparedStatement ps = null;//SQL문을 DB서버에게 실행 요청
				DbInfo di = new DbInfo();//db접속할때 정보
				ResultSet rs = null;//SQL이 select문이었을 경우 실행이 되었을때 결과를 참조
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(di.getURL(), di.getID(), di.getPW());
					String sql = "select * from member2 where id =?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, member.getId());
					rs = ps.executeQuery();
					
					if(rs.next()){//pk로 검색했기 때문에 반복 불필요
						//혹시모를 자료가 삭제될 경우가 있기 때문에 if로 확인 필요				
						member.setPasswd(rs.getString(2));
						member.setName(rs.getString(3));
						reg_date = rs.getTimestamp(4);
						member.setAddr(rs.getString("addr"));
						member.setTel(rs.getString("tel"));						
					 }else{
						out.println("찾으시는 데이터는 없습니다.");
					}
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
			<tr>
				<td><%=member.getId() %></td>
				<td><%=member.getPasswd() %></td>
				<td><%=member.getName() %></td>
				<td><%=reg_date %></td>
				<td><%=member.getAddr() %></td>
				<td><%=member.getTel() %></td>
			</tr>
		</table>
	</body>
</html>
