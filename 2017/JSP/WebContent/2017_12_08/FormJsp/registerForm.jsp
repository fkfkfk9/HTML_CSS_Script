<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="/study/2017_12_08/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/styles.css" />
<!-- Login 페이지에서 사용되는 스크립트를 불러온다. -->
<script src="/study/2017_12_08/js/register.js"></script>

  <div class="formjoin">
     <ul>
     	<li><h2>회원가입</h2></li>
        <li id="id_li">
        	<label for="id">아이디</label>
            <input id="id" name="id" type="email" size="20" 
              maxlength="50" placeholder="fkfkfk9@naver.com">
            <button id="id_check">중복확인</button>
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

    