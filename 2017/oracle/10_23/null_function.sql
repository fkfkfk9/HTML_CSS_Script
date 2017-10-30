---------------------------------- NULL 관련함수 ------------------------------------
--manager_id가 null일때 employee_id값을 반환
ALTER TABLE board drop CONSTRAINT SYS_C007037;--NOT NULL 권한 취소 맨뒤는 제약조건명
--expr1값이 null일때 expr2값을 가져온다.
SELECT NVL(passwd, num || '[보안취약]') as num, title, writer, passwd
  FROM board;
--expr1의 값이 널이 아니면 expr2의 값을 리턴 널이면 expr3을 리턴
SELECT num, NVL2(readnum, title || '[' || readnum || ']' , title || '[0]') as title, writer
  FROM board
  order by num;  
--case를 이용해서도 같은 효과를 줄 수 있다.
 SELECT num, title,readnum,
        case when readnum IS NULL then title
             else title || '[' || readnum || ']' end as title_read
 FROM board
 order by num;
 
/*
    COALESCE(expr1, expr2,.....)매개변수가 무한대로 늘어날 수 있다.
    expr1이 널이면 expr2반환 expr2이 널이면 expr3이 반환.....
*/  
select NULL * 10 from dual;--널과 연산하면 결과는 널이된다.
select COALESCE(NULL,NULL,NULL) from dual;--끝까지 널이면 결국 널
select COALESCE(1,NULL,NULL) from dual;--처음부터 널값이 아니므로 1 리턴
select COALESCE(NULL,NULL,1) from dual;--마지막 값이 1이므로 1리턴
  
SELECT num, readnum
  FROM board
 WHERE readnum IS NOT NULL;
    
SELECT COUNT(*)--출력될 데이터의 개수를 반환
  FROM board
 WHERE NVL(readnum, 0) IS NOT NULL;
 --널을 0으로 바꿔 갯수가 위와다르게 7개가 된다.
SELECT COUNT(*)
  FROM board
 WHERE LNNVL(readnum IS NULL) ;--readnum IS NOT NULL 과 같은의미
 --lnnvl이 사용되면 true가 들어오면 false를 반환 false가 들어오면 true를 반환한다.
 --즉 반대값이 들어온다.
select NULLIF(100,200) FROM DUAL; 
select NULLIF(100,100) FROM DUAL;
--NULLIF는 입력된값 두개가 같으면 NULL을 반환하고 다르면 처음값을 반환한다.
 
--GREATEST큰값을 반환 LEAST작은값을 반환
SELECT GREATEST(8, 4, 0, 15),
       LEAST(8, 4, 0, 15) 
  FROM DUAL;
 --문자 숫자 모두 적용된다. 
SELECT GREATEST('유종현', '박지성', '손흥민'),
       LEAST('유종현', '박지성', '손흥민')
  FROM DUAL;  
  
select num, 
       DECODE(readnum,    50,    '조회수 적음', 
                          100,   '많음',
                          5000,  '폭발함',
                          10000, '전설',
                         'Others')  decodes
from board;
---------------------------------------------------------