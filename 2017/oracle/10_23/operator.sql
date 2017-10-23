------------------------ 연산자 -------------------------
--사칙연산자 +,-,/,*
--컬럼의 데이터형식이 숫자(number)데이타인 경우에 사용 가능
select num * 10, title from board; 
--||은 문자열 연결 연산자, 칼럼이 문자데이터 타입인 경우 사용
--as이후에 두컬럼을 합친 컬럼명을 설정해준다.
SELECT writer || '-' || title AS board_info
  FROM board
 WHERE ROWNUM < 5;
-- 논리 연산자
select * from board where num < 4;  
--------------------------------------------------------