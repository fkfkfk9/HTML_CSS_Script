-------------------------------- ROLLUP과 CUBE ---------------------------------
SELECT writer, readnum, SUM(readnum)
  FROM board
 GROUP BY ROLLUP(writer, readnum)--중간합계, 총합계가 생긴다.
 ORDER BY writer;                --writer가 기준이 된다.
 --writer과 readnum이 다 같은 그룹의 readnum의 합
 --중간계 소계의 합 즉 writer이 중복된 readnum의 합
 --총합계 모든 중간계의 합 즉 모든 readnum의 합
SELECT readnum, writer , SUM(readnum)
  FROM board
 GROUP BY ROLLUP(readnum, writer)--readnum이 기준이 된다.
 ORDER BY readnum;               --즉 합계나 소계는 같지만 중간계가 달라짐
 --readnum과 writer이 다 같은 그룹의 readnum의 합
 --중간계 소계의 합 즉 readnum별 모든 readnum의 합
 --총합계 모든 중간계의 합 즉 모든 readnum의 합 
 SELECT writer, readnum, SUM(readnum)
  FROM board
 GROUP BY writer, ROLLUP(readnum)
 ORDER BY writer;
 --롤업은 매게변수 갯수 +1 의 결과값을 내준다. 매개변수가 한개이므로 총합계가 없음
 --writer기준으로 해서 총합계가 없는거 빼고는 ROLLUP(writer, readnum)과 같은결과
SELECT readnum, writer , SUM(readnum)
  FROM board
 GROUP BY ROLLUP(writer), readnum 
 ORDER BY readnum;-- 총합계를 빼고는 ROLLUP(readnum, writer)과 같은결과
 
 SELECT writer, readnum, SUM(readnum)
  FROM board
 GROUP BY CUBE(writer, readnum)--매개변수가 2개이므로 2의 2승인 4개의 결과값이 나온다.
 ORDER BY writer;              --3개였다면 2의 3승인 8개가 나왔을 것이다.
 --4개의 결과값은 롤업일때의 3개 + readnum기준 값까지 모든 경우의 수를 전부 나타낸다.
 --즉 writer, readnum순서 상관없이 모든 결과를 보여주니 순서가 상관이 없다.
 --소계 + writer기준 중간계 + readnum기준 중간계 + 총계 형태로 나온다.
 
 SELECT writer, readnum, SUM(readnum)
  FROM board
 GROUP BY writer, CUBE(readnum)
 ORDER BY writer;--GROUP BY writer, ROLLUP(readnum) 결과가 같음
 --총합계와 readnum기준 합계가 없어진 2개결과값이 나온다.
 --다만 뒤의 cube의 매개변수가 늘어난다면 롤업과는 결과가 달라진다.
--------------------------------------------------------------------------------