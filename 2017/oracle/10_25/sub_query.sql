--------------------------------- 서브쿼리 --------------------------------------
--서브쿼리 라고도 하고 하위 질의 라고도 한다. 주로 select문법에 많이 사용한다.
/*
    서브 쿼리가 문법적으로 사용될 수 있는 위치
    select 서브쿼리
    from 서브쿼리(인라인 뷰)
    where 조건식에서 서브쿼리
*/
-- 연관성 없는 서브쿼리 
select st_name, ST_GRADE--단일행 쿼리 : 결과가 하나의 행만 반환
from CLASSES
where ST_GRADE >= (select avg(st_grade) from classes);

SELECT count(*)--다중행 서브 쿼리 : 결과가 하나 이상의 행이 반환
  FROM CLASSES 
 WHERE dep_code IN ( SELECT dep_code --결과는 = 과 같지만 =은 1개의 항만 연산가능
                            FROM department--IN은 여러개의 항이 와도 모두 비교함
                           WHERE dean_name IS NOT NULL);
                           
-- =, >, <, >=, <=, <>, != 단일행만 비교하는 연산자
--서브 쿼리는 ()묶어져 있어야 한다. 오른쪽에 존재해야 한다.

select st_name, ST_GRADE
from CLASSES
where ST_GRADE > all(1.0, 2.0, 3.0);
--all은 3중에 제일 큰값 결과는 3.0보다 큰값을 구한다
select st_name, ST_GRADE
from CLASSES
where ST_GRADE > any(1.0, 2.0, 3.0);
--any는 3중에 제일 작은값 결과는 1.0보다 큰것을 구한다.
