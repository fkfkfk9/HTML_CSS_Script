---------------------------- GROUP BY 와 HAVING 절 ------------------------------
--GROUP BY에서 사용한 컬럼을 SELECT에서 사용해야한다.
--그룹으로 묶이기 때문에 집계함수만 같이 쓸 수 있다.
--집합되있는 데이터이기 때문에 다른 일반 컬럼은 사용할 수 없다.
SELECT max(num), writer, SUM(readnum)--작성자별 조회수의 합
  FROM board
 GROUP BY writer
 ORDER BY writer;  

SELECT writer, readnum, count(*)--두가지 값이 다 같은것들만 그룹화 된다.
  FROM board
 GROUP BY writer, readnum
 ORDER BY writer, readnum;   
 
 SELECT count(*), writer, SUM(readnum)
  FROM board
 WHERE readnum >= 100 --조건을 추가 할 수 있다.
 GROUP BY writer
 ORDER BY writer;
 
 SELECT count(*), writer, SUM(readnum)--작성자별 조회수의 합
  FROM board
 GROUP BY writer
 HAVING SUM(readnum) > 1000 --그룹 다음에도 조건을 넣을 수 있다.
 ORDER BY writer;           --HAVING에서 조심해야 할건 이미 그룹화 되어있기 때문에
                            --SELECT의 집계함수가 그대로 와야한다. 그냥 컬럼은 X
--------------------------------------------------------------------------------