<%@page import="java_2017_12_12.board.bean.*"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8");%>

<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="/study/2017_12_08/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/Hyundai2/2017_12_08/css/styles.css" />
<link rel="stylesheet" type="text/css" href="/Hyundai2/2017_12_08/css/html_css_styles.css" />

<% 
	String id = (String)session.getAttribute("id"); 
	
	SimpleDateFormat sdf = 
	new SimpleDateFormat("yyyy/MM/dd HH:mm");//날짜데이터 표시형식지정
	
	List<BoardBeanDb> articleList = null;
	
	BoardDAODb bdd = BoardDAODb.getInstance();
	int articleCnt = bdd.getArticleCnt();
	
	try{
		if(articleCnt > 0){
			articleList = bdd.getArticle();
		}
	}catch(Exception e){}
%>
<% if(id.equals("") || id == null){ %>
<script>
	alert("로그인을 하셔야 합니다.");
	window.location.href("index.jsp");
</script>
<% }else{ %>
	<h2>글 목록(전체 글 : <%=articleCnt %>) </h2>
	<img src="/Hyundai2/2017_12_08/img/menu02_write.png">
	<% if (articleCnt == 0){//게시판에 글이 없는 경우%>
	<div id="list_article" class="free_list">
  		<ul><li><p>게시판에 저장된 글이 없습니다.</p></li></ul>
	</div>
	<%}else{ %>
	<div id="list_article" class="free_list">
  		<ul><li><p>게시판에 저장된 글이 없습니다.</p></li></ul>
	</div>	
	<%} %>
<% } %>