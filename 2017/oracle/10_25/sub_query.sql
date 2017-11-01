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

select * from classes;
select * from department;
select * from professors;
insert into subjects 
values(101, '안드로이드 프로그래밍', 10100, 10101, '017-365-8794', 40, 3, '화요일 6~9');
insert into subjects 
values(201, 'TCP/IP 소켓 프로그래밍', 10200, 10201, '019-123-7532', 30, 3, '목요일 1~3');

SELECT pf_code, pf_name, dep_code
FROM professors
WHERE (dep_code, pf_code ) IN ( SELECT dep_code, pf_code
                                    FROM subjects);
                                    
UPDATE CLASSES
   SET ST_GRADE = ( SELECT AVG(ST_GRADE)
                    FROM CLASSES );
select * from CLASSES;

DELETE CLASSES
 WHERE ST_GRADE >= ( SELECT AVG(ST_GRADE)
                    FROM CLASSES );                    
ROLLBACK;                    

select st_name, st_grade
from classes
where st_grade > (select st_grade
                    from classes
                    where st_code = 20070002)
order by st_grade;

--특정 학과의 평균학점보다 높은 학과 구하고 평균학점 표시
select dep_code, avg(st_grade)
from classes
group by dep_code
HAVING avg(st_grade) > (select avg(st_grade)--그룹바이는 헤빙으로 조건을 건다.
                    from classes
                    where dep_code = 10100)
order by dep_code;
--조인으로 부서 이름까지 포함
select d.dep_name, round(avg(st_grade), 1) as "평균 학점"
--round로 평균을 소수점 1자리까지만 출력, 평균학점 글자 사이에 공백을 주려면 ""를 사용 ''은 불가
from classes c inner join department d
on c.dep_code = d.dep_code
group by d.dep_name--학과이름을 출력하기 위해선 그룹을 학과이름으로 해야한다.
HAVING avg(st_grade) > (select avg(st_grade)--그룹바이는 헤빙으로 조건을 건다.
                    from classes
                    where dep_code = 10100)
order by d.dep_name;
--------------------------------------------------------------------------------
-------------------------- 연관성 있는 서브쿼리 -----------------------------------  
--서브 쿼리만 돌려도 실행이 된다면 연관성이 없는 서브쿼리이다.
--연관성이 있는 서브쿼리는 혼자서 동작하지 못한다.
select *
from classes;
select c.st_code, c.st_name
from classes c
where exists ( select 1
                    from department d
                    where c.dep_code = d.dep_code); --전공코드가 없다면 제외
--exists를 통해 한행별로 서브쿼리의 조건을 비교하고 일치하면 출력 불일치시 제외
--밖의 테이블의 데이터 한개씩을 서브쿼리에서 비교를 하여 일치가 되면 반환하여 출력해주고
--일치가 하지 않으면 버리게 된다.
--select옆에 1을 주는건 어떤값을 주던 영향이 없기 때문에 의미없는 값을 준것이다.

SELECT s.pf_code 교번,  
       ( SELECT p.pf_name
           FROM professors p
          WHERE s.pf_code = p.pf_code) AS 교수이름,
       s.dep_code 학과코드,
       ( SELECT d.dep_name
           FROM department d
          WHERE s.dep_code = d.dep_code) AS 학과명     
FROM subjects s;
--셀렉트단위에서 서브 쿼리
--조인과 비슷하지만 조인으로 표현하지 못하는걸 작업할 때 사용
