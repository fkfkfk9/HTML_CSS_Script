실행방법

1. mobilesoftware 이름으로 다이나믹 웹 프로젝트를 생성
2. WebContent, src내용 복사
3. WEB-INF폴더의 lib와 web.xml 꼭 같아야함
4. Server.xml의 Context태그중 mobilesoftware로 되어있는것 아래 내용 추가 
   본인 오라클 계정 정보 추가한다.
<Resource auth="Container" 
	driverClassName="oracle.jdbc.driver.OracleDriver" 
	maxWait="5000" 
	name="jdbc/homepage" 
	password="오라클 계정 암호" 
	type="javax.sql.DataSource" 
	url="jdbc:oracle:thin:@localhost:1521/xe" 
	username="오라클 계정명"/>
5. sql파일의 내용을 해당 오라클 계정에서 실행하여 테이블 추가
6. enc폴더 cryptProcess를 실행하여 admin계정의 암호를 암호화 해준다.
7. 로컬주소에 /mobilesoftware/index.do 입력하여 실행
------------------------------------------------------------------------------------
프로젝트 파일 정보 
---------------------------------------------------------------------------------------
WebContent폴더
*******************************************************************************************
index.jsp : 다른 부분들은 고정되어 있고 section 부분만 
		    매번 컨트롤러가 보내는 페이지를 뿌려줌

sql/mobilesoftware.sql : DB에 사용되는 테이블들의 모든 sql문이 들어가있음

propert/commandmapping.propert : .do로 사용되는 명령어들의 키와 값이 저장되어있다.
								  controller.java파일에서 참조
******************************************************************************************* 				  
WebContent/lib폴더 : 처음 메인페이지를 구성하는대 section부를 제외한 나머지 부분들을 구현

side_menu : 처음 들어가는 index.do에서 section부테 들어가는 내용.
bottom.jsp : 모든 화면에서 맨 아래 들어가는 내용 index.jsp에서 불러온다.
top_login1.jsp : 학교 로고와 로그인 부분이 들아간다. index.jsp에서 불러옴
				 로그인 여부, 사용자 레벨에 따라 달라짐 세멘틱에서 헤더부분
top_menu1.jsp : 세멘틱 태그에서 nav부분으로 메뉴들을 드랍다운으로 처리 index.jsp에서
			    불러와 어느페이지를 가도 매번 보여준다.
main.jsp : 맨처음 index.do를 실행할때 보여주는 페이지로 학교 사진다 위에 side_menu로 구성
*******************************************************************************************
WebContent/login 폴더 : 로그인, 회원가입, 로그아웃등 member DB와 연관된 작업들을 모음

login_form.jsp : 로그인을 하기위한 입력을 받는다.
*******************************************************************************************
WebContent/js폴더 : 모든 js파일들을 모아놓은 폴더
lib/topLogin.js : 헤더부분의 검색
	
----------------------------------------------------------------------------------------
src 폴더
homepage.controller.Controller.java
 모든 작동은 Controller.java파일을 통해 작동 .do명령어를 입력하면 
 Controller가 해당 명령어에 해당하는 객체를 실행 후 index.jsp에 뿌려준다.
