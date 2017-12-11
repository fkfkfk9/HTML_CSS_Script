<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="/study/2017_12_08/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/styles.css" />
<script src="/Hyundai2/2017_12_08/js/login.js"></script>
<!-- 학원 /Hyundai2/ 집 /study/ -->

<%
String id ="";
try{
	//id세션 속성의 값을 얻어내서 id변수에 저장
	//인증된 사용자의 경우  id세션 속성의 값 null또는 공백이 아님
	id = (String)session.getAttribute("id");
%>

<%if(id == null || id.equals("")){ //인증되지 않은 사용자 영역%>
  <div class="formlogin">
     <ul>
     	<li><h2>로그인을 하셔야 이용 가능합니다.</h2></li>
        <li><label for="id">아이디</label>
            <input id="id" name="id" type="email" size="20" 
              maxlength="50" placeholder="fkfkfk9@naver.com">
        </li>
        <li><label for="passwd">비밀번호</label>
            <input id="passwd" name="passwd" type="password" 
              size="20" placeholder="6~16자 숫자/문자" maxlength="16">
        </li>
        <li>
            <button id="login">로그인</button>
            <button id="register">회원가입</button>
        </li>
     </ul>
  </div>
  <script>
   $('#customer').hide();
  </script>
<%}else{//인증된 사용자 영역%>
  <h2><%=id %>님 환영합니다. </h2>
  <p>HTML&CSS, JAVASCRIPT&JQUERY, ORACLE, JAVA는 현재 서울현대직업전문학교에서 교육받으며 실습한 코드</p>
  <br /><br />
  <p>HTML&CSS는 웹 표준에 맞는 웹페이지 설계와 기본적인 디자인을 실습</p>
  <br /><br />
  <p>JAVASCRIPT&JQUERY는 웹페이지의 이벤트를 제어할 수 있는 기능 실습</p>
  <br /><br />
  <p>ORACLE은 DB에 대한 기본적인 내용과 SQL구문, PL_SQL구문을 실습</p>
  <br /><br />
  <p>JAVA는 기본적인 자바 문법과 이클립스 사용법, 객체지향 프로그래밍에 대한 내용을 실습</p>
  <script>
   $('#customer').show();
  </script>
<%}}catch(Exception e){e.printStackTrace();}%>
    