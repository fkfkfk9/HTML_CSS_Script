--------------- 조건식 비교조건식 ---------------

SELECT num, writer, title 
  FROM board
WHERE num = ANY (2, 3, 4)
ORDER BY num;
--any를 사용한것과 아래 or을 2번 사용한것은 결과가 같다   
SELECT num, writer, title 
  FROM board
WHERE num = 2
   OR num = 3
   OR num = 4
ORDER BY num;   
 
SELECT num, writer, title 
  FROM board
WHERE num = ALL (2, 3, 4)
ORDER BY num;
--all은 and와 같은 연산이다.
SELECT num, writer, title 
  FROM board
WHERE num = some (2, 3, 4)
ORDER BY num;
--some는 any와 동일하게 사용된다.
---------------------------------------------