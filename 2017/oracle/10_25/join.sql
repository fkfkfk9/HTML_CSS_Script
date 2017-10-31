--------------------------------------------------------------------------------
/*
    조인(JOIN)
    테이블을 대상으로 연관성있는 컬럼끼리 데이터를 비교하여 수평적인 하나의
    테이블 출력형태로 뽑을 떄 사용하는 명령어이다.
*/
select * from department;--학과테이블
select * from classes;--학생 테이블

select st_code, st_name, st_grade, dep_name 
from classes, department
where classes.dep_code = department.dep_code;
--select에 dep_code컬럼을 넣고 싶다면 department.dep_code로
--어느 테이블 컬럼인지 명확히 해야한다. 
--두개의 테이블을 불러올때 select에 dep_code넣으면 어느 테이블 데이터인지 몰라 오류가 난다.

--컬럼명은 형식이 테이블명.컬럼명으로 나타낸다. 테이블명은 생략이 가능하다.
--만약 두개 이상의 테이블을 불러올 때 같은 이름을 가진 컬럼명이 존재한다면
--그 컬럼은 테이블명을 생략할 수 없다.
--테이블명이 별칭을 사용하게 되면 테이블명은 사용할수가 없다.
--별칭은 테이블명이 길거나 의미를 주고자 할 때 사용한다.(필수는 아니다)

-- 동등조인
select c.st_code, c.st_name, c.st_grade, d.dep_name 
from classes c, department d
where c.dep_code = d.dep_code; --3개 검색
 
select count(st_code) from classes;--4개 검색
--dep_code가 NULL인 학생이 하나 있었기 때문에 1개 차이가 난다.
select * from classes
where dep_code IS NULL;

--ansi join
select c.st_code, c.st_name, c.st_grade, d.dep_name 
from classes c INNER JOIN department d
on c.dep_code = d.dep_code;
-- 3개 조인 -------------------------------------
select * --일반적인 3개 조인
from classes c, department d, professors p
where e.dep_code = d.dep_code
and d.dep_code = p.dep_code;
select * --ansi로 3개 조인
from 
    classes c 
        inner join department d on c.dep_code = d.dep_code 
        inner join professors p on d.dep_code = p.dep_code;
--------------------------------------------------------------------------------