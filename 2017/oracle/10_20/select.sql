---------------------------- SELECT ----------------------------------
/* 데이터에는 영향을 주지 않고 데이터를 가져와 보여준다.
    SELECT 컬럼명
    FROM 테이블명
    [WHERE 조건식] 조건이 필요없다면 빼도 된다.
*/
-- *는 테이블의 모든 컬럼을 나타낸다.
select * from board;--모든검색은 성능이 떨어지므로 사용하지 않음.
--순서는 테이블상 입력한 순서대로 출력된다.

select writer, title, num from board;
--원하는 컬럼만 출력 할 수도 있고 컬럼이 나오는 순서도 배치를 바 꿀수 잇다.
--같은 컬럼을 2번 보여줄수도있다.

--별칭
select writer as 글쓴이, num as 글넘버 from board;
select writer 글쓴이, num 글넘버 from board;
--as를 붙여(or 공백) 보여주는 컬럼명을 변경 할 수 있다.(DB상 컬럼명에는 영향 안줌)

--글넘버가 3보다 큰 것만 불러온다.
SELECT  num, writer, title
FROM board
WHERE num > 3;
--정렬 order by 컬럼명 asc(오름차순), order by 컬럼명 desc(내림차순) 
--디폴트는 오름차순이다.
SELECT  num, writer, title
FROM board
ORDER BY num asc; --오름차순 생략가능

SELECT  num, writer, title
FROM board
ORDER BY num desc; -- 내림차순

--글쓴이로 오름차순 정렬해서 출력하라.
SELECT  num, writer, title
FROM board
ORDER BY writer asc;
--사원번호는 오름차순, 사원명도 오름차순으로 정렬해서 출력

select num, writer, title, regdate
from board
where num > 2
order by regdate asc, writer asc;
--앞에 적은 컬럼이 PK면 앞에컬럼으로만 정렬됨 뒤에는 의미가 없다.
--만약 앞에 정렬된 값이 겹치는 데이터가 있다면 
--겹치는 데이터상에서 뒤의 데이터가 오름차순으로 정렬된다

select num, writer, title, regdate
from board
where num > 2
order by 4 asc, 2 asc;
--위에 셀렉트 옆에 순서대로 번호로 지정해서 써줘도 사용가능

SELECT  num, writer
FROM board
WHERE num > 2
  AND writer = '유종현'
ORDER BY num;

SELECT  num, writer
FROM board
WHERE num > 3
  OR writer = '유종현'
ORDER BY num;
--AND와 OR중에 AND가 우선순위가 높다.

SELECT  num, writer, title, regdate
FROM board
WHERE num > 2
   OR writer = '유종현'--오라클은 데이터는 대문자로만 검색된다. 데이터는 대소문자 구별
   AND regdate = sysdate
ORDER BY num;
--실제로 실행했을때 그냥 연산했을때와 and연산을 ()묶어 강제로 먼저 했을떄가
--결과가 같다.
----------------------------------------------------------