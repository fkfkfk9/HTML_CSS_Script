<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestEx</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8");%>
	<h2>리퀘스트를 이용하여 POST데이터 받기</h2>
	<%  //request객체에서 파라메터값을 얻어냄
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		
		if(gender.equals("m")) gender = "남자";
		else gender = "여자";
		
		String hobbystr = "";
		for(String str : hobby){
			hobbystr += str + ",";
		}
		hobbystr = hobbystr.substring(0, hobbystr.length()-1);
	%>
	<p>이름 : <%=name %></p>
	<p>나이 : <%=age %></p>
	<p>성별 : <%=gender %></p>
	<p>취미 : <%=hobbystr %></p>
</body>
</html>
