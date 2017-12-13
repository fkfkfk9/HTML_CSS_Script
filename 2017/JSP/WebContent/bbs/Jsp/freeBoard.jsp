<%@page import="bbs.board.bean.*"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8");%>
<!-- js 파일 불러오기 -->
<script src="/Hyundai2/bbs/js/freeboard.js"></script>

<% 
	String id = (String)session.getAttribute("id"); 
	int pageSize = 10;//한페이지에 표시할 글의 수 
	SimpleDateFormat sdf = 
	new SimpleDateFormat("yyyy/MM/dd HH:mm");//날짜데이터 표시형식지정
	String pageNum = request.getParameter("pageNum");//화면에 표시할 페이지번호
	if (pageNum == null) //페이지번호가 없으면 1페이지의 내용이 화면에 표시
	    pageNum = "1";
	int currentPage = Integer.parseInt(pageNum);//페이지의 넘버를 숫자로 파싱
	/*전체 글의 숫자를 불러옴*/
	List<BoardBeanDb> articleList = null;	
	BoardDAODb bdd = BoardDAODb.getInstance();
	int articleCnt = bdd.getArticleCnt();//전체 글의 수를 얻어냄
	/*END--------------*/
	if(articleCnt == (currentPage-1)*pageSize)
   		currentPage -=1;
	int startRow = (currentPage - 1) * pageSize + 1;//현재 페이지에서의 시작글번호
	try{
		if(articleCnt > 0){
			articleList = bdd.getArticle();
		}
		if(articleList.isEmpty())//테이블에 저장된 글이 없으면, 전체글 수 : 0
			articleCnt = 0;
	}catch(Exception e){}
%>
<% if(id.equals("") || id == null){ %>
<script>
	alert("로그인을 하셔야 합니다.");
	window.location.href("index.jsp");
</script>
<% }else{ %>
	<h2>글 목록(전체 글 : <%=articleCnt %>) </h2>
	<img id="write_img_btn" src="/Hyundai2/bbs/img/menu02_write.png">
	<% if (articleCnt == 0){//게시판에 글이 없는 경우%>
	<div id="list_article" class="free_list">
  		<ul><li><p>게시판에 저장된 글이 없습니다.</p></li></ul>
	</div>
	<%}else{ %>
	<div id="list_article" class="free_list">
  	<% 
  	//글목록을 반복처리
  	for (int i = 0 ; i < articleList.size() ; i++) {
     	BoardBeanDb article = articleList.get(i); %>	
	<ul class="article_ul" id="<%="write_ul_id"+i %>">
	<%
		int iw=0; 
		if(article.getRe_level()>0){
	  		iw=2*(article.getRe_level());
	%>	
    <%}//END IF %>
    <%if(iw != 0){ %>
	 	<script>	 	
	 		$('#<%="write_ul_id"+i %>').css('padding-left', '<%=iw*25%>px');	 		
	 	</script>
	<%} %>  
    	<!-- 아이디, 제목, 등록 날짜 출력 -->
		<li class="write_li" ><span class="writer_id"><%String writer = article.getWriter();
	       out.println(writer.substring(0, 4) + "****");%></span>
	       <b><span class="writer_sbuject"><%=article.getSubject()%></span></b>
	       <span class="write_date"><%=sdf.format(article.getReg_date())%></span></li>
	 	<%-- <%if(iw != 0){ %>
	 	<script>	 	
	 		for(var j = 0; j< <%=iw%> ; j++){
		 		$('#<%="write_li_id"+i%>').css('padding-left', '30px');
	 		}
	 	</script>
	 	<%} %>--%>
	    <!-- END 아이디, 제목 출력 -->
	    <!-- 본문 출력 -->
    	<% 
     		int num = article.getNum();
	  		int ref = article.getRef();
	  		int re_step = article.getRe_step();
	   		int re_level = article.getRe_level();
		%>
		<pre class="write_pre"><%=article.getContent()%></pre><br>		     	
     	<!-- END 본문 출력 -->
     	<!-- 버튼 출력 -->     	
   		<%try{
  			id = (String)session.getAttribute("id");
    		}catch(Exception e){}%>
		<%if(id.equals(writer)) {%>
 			<button id=<%="edit"+i %> 
  			name="<%=num+","+pageNum%>" onclick="edit(this)">수정</button>
 			<button id="delete" 
  			name="<%=num+","+pageNum%>" onclick="del(this)">삭제</button></li>
		<%}else{ %>
 			<button id="reply" 
  			name="<%=num+","+ref+","+re_step+","+re_level+","+pageNum%>" 
 			onclick="reply(this)">댓글쓰기</button></li> 			
		<%}//END IF~ELSE 버튼 종류%>     	
     	<!-- END 버튼 출력 -->
     </ul>
	<%}//END FOR %>
	</div>	
	<%}//END 게시판에 글이 있는 경우 ELSE %>
<% }//END 로그인이 되어있을 경우 ELSE %>