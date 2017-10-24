------------------ 집계함수 --------------------
--집합적인 계산, 컬럼명만 들어가야한다, 컬럼명은 하나만 가능하다
--count 전체 행수를 나타낸다.
SELECT COUNT(*)
  FROM board;

SELECT COUNT(readnum)
  FROM board;--전체보다 하나적게 검색되는대 null값이 있기 때문
  
SELECT COUNT(writer)
  FROM board;
  
SELECT COUNT(DISTINCT writer)
  FROM board;--DISTINCT는 유일한 값만 조회한다(중복데이터 거름)
             --때문에 위의 검색과 다르게 중복된 2개는 제외된다.
             
SELECT SUM(num)--컬럼명의 전체 데이터 합계를 구하는 기능
  FROM board;  
  
SELECT SUM(readnum), SUM(DISTINCT readnum)
  FROM board;--DISTINCT가 있어 중복자료는 하나만 계산하여 구한다.    
  
SELECT AVG(readnum), AVG(DISTINCT readnum)
  FROM board;--평균을 구한다.     
  
SELECT MIN(readnum), MAX(readnum)
  FROM board;--MIN : 최소값 MAX : 최대값    
   
SELECT MIN(DISTINCT readnum), MAX(DISTINCT readnum)
  FROM board;      
  
SELECT VARIANCE(readnum), STDDEV(readnum)
  FROM board;--VARIANCE : 분산 STDDEV : 표준편차
-------------------------------------------------- 