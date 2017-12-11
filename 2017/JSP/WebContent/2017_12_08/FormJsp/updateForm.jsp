<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="/study/2017_12_08/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/styles.css" />
<!-- Login 페이지에서 사용되는 스크립트를 불러온다. 학원 /Hyundai2/ 집 /study/-->
<script src="/Hyundai2/2017_12_08/js/register.js"></script>

<% String id = (String)session.getAttribute("id");//로그인이 되었는지 확인한다. %>
<%
	
%>
<% if(id.equals("") || id == null) {//로그인이 되어있지 않은경우%>
<script>window.location.href("index.jsp");</script>
<%}else{//로그인이 되어있는경우 %>

  <div class="formupdate">
     <ul>
     	<li><h2><%=id %>님 정보수정</h2></li>
        <li>
        	<label for="id">아이디</label>
            <input id="id" name="id" type="email" size="20" 
              maxlength="50" placeholder="fkfkfk9@naver.com">
        </li>
        <li>
        	<label for="passwd">비밀번호</label>
            <input id="passwd" name="passwd" type="password" 
              size="20" placeholder="6~16자 숫자/문자" maxlength="16">
        </li>
        <li>
        	<label for="name">이름</label>
            <input id="name" name="name" type="text" 
              size="20" placeholder="ex) 홍길동" maxlength="16">
        </li>
        <li>
        	<label for="addr">주소</label>
            <input id="addr" name="addr" type="text" 
              size="30" placeholder="ex) 경기도 안양시 동안구 관양동" maxlength="30">
        </li>
        <li>
        	<label for="tel">전화번호</label>
            <input id="tel" name="tel" type="text" 
              size="20" placeholder="ex) 010-111-2222" maxlength="20">
        </li>
        <li>
            <button id="insertmember">회원가입</button>
     	</li>
     </ul>
  </div>
<% } %>
    