---------------- 논리조건식 -------------------
SELECT num, writer, title  
  FROM board
WHERE NOT ( num >= 3) -- num < 3
ORDER BY num;
---------------------------------------------
------BETWEEN AND 조건식---------------
SELECT num, writer, title  
  FROM board
WHERE num BETWEEN 2 AND 5 -- 2<=num<=5
ORDER BY num;
-- between a and b 는 a이상 b이하까지 검색
--------------------------------------
------------- IN 조건식 ---------------
--or와 동일하다
SELECT num, writer, title 
  FROM board
WHERE num in (2, 3, 4)
ORDER BY num;

SELECT num, writer, title 
  FROM board
WHERE num not in (2, 3, 4)
ORDER BY num;
--------------------------------------