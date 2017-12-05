<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="db.DbInfo"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="jsp_2017_12_04.bean.member" scope="page"></jsp:useBean>
<jsp:setProperty name="member" property="id" param="id" />

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
<!DOCTYPE html>
<html>
<head>
<script>
	function del_ok(userid){
		location.href = "dbdelete.jsp?id=" + userid;
	}
</script>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
<!-- 
	바뀌기 전 아이디를 보내는 방법
	form태그의 action의 다음 jsp파일명에 ?를 붙여 겟방식으로 데이터를 같이 보냄
	input타입 hidden으로 폼에 숨긴 데이터를 하나 포함시켜 post방식으로 같이 보냄 
	session.setAttribute를 통해 설정하여 세션을 통해 서버에 저장시킨다.
	삭제버튼으로 jsp파일 가는법 : 스크립트 함수를 만들고 onclick에 함수를 넣는다.
-->
	<h1>수정</h1>
	<form method="post" action="dbupdate.jsp<%--?oid=<%=old_id %>--%>">
		<label for="id">아이디</label> 
		<input name="id" type="text" 
		value="<%=member.getId() %>" autofocus required><br> 
		<input type="hidden" name = "oid" value="<%=member.getId() %>">
		<label for="passwd">비 번</label> 
		<input name="passwd" type="password" 
		value="<%=member.getPasswd() %>" required><br>
		<label for="name">이 름</label> 
		<input name="name" type="text" 
		value="<%=member.getName() %>" required><br>
		<label for="addr">주 소</label> 
		<input name="addr" type="text" 
		value="<%=member.getAddr() %>" required><br>
		<label for="tel">전화번호</label> 
		<input name="tel" type="text" 
		value="<%=member.getTel() %>" required><br>
		<input type="submit" value="수정">
		<input type="button" value="삭제" onclick="del_ok('<%=member.getId()%>');">
	</form>
</body>
</html>
