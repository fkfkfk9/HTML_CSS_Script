---------------- LIKE 조건식 ------------------
--문자열의 패턴을 검색할 때 사용하는 조건식
--특수문자 %, _ 사용
--where 컬럼명 like '패턴문자열'

select num, writer, title
from board
where title like '%U%'
order by num;
--문자열에 q가 있는 데이터 처음, 중간, 끝 모두 포함
select num, writer, title
from board
where title like '%KEY'
order by num;
--key로 끝나는 데이터

SELECT *
  FROM board
 WHERE writer LIKE '유%';
 --%는 그뒤에 모든 문자열을 애기함
 SELECT *
  FROM board
 WHERE writer LIKE '유__'; 
 --_는 하나 표시하면 그 뒤의 바로 한글자만 가능하다.
 --%처럼 유_로 하면 검색되지 않지만 유__는 검색가능
 --아니면 유종_로 검색해야 한다.
 ---------------------------------------------