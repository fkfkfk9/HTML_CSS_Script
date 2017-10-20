---------------------------- SELECT ----------------------------------
/* 데이터에는 영향을 주지 않고 데이터를 가져와 보여준다.
    SELECT 컬럼명
    FROM 테이블명
    [WHERE 조건식] 조건이 필요없다면 빼도 된다.
*/
-- *는 테이블의 모든 컬럼을 나타낸다.
select * from employees;--모든검색은 성능이 떨어지므로 사용하지 않음.
--순서는 테이블상 입력한 순서대로 출력된다.

select emp_name, emp_name, employee_id from employees;
--원하는 컬럼만 출력 할 수도 있고 컬럼이 나오는 순서도 배치를 바 꿀수 잇다.
--같은 컬럼을 2번 보여줄수도있다.

--별칭
select emp_name as 사원이름, employee_id as 사원번호 from employees;
select emp_name 사원이름, employee_id 사원번호 from employees;
--as를 붙여(or 공백) 보여주는 컬럼명을 변경 할 수 있다.(DB상 컬럼명에는 영향 안줌)

--연봉이 5000보다 큰 값만 보여달라.
SELECT  employee_id, emp_name, salary
FROM employees
WHERE salary > 5000;
--정렬 order by 컬럼명 asc(오름차순), order by 컬럼명 desc(내림차순) 
--디폴트는 오름차순이다.
SELECT  employee_id, emp_name, salary
FROM employees
WHERE salary > 5000
ORDER BY employee_id asc; --오름차순 생략가능

SELECT  employee_id, emp_name, salary
FROM employees
WHERE salary > 5000
ORDER BY salary desc; -- 내림차순

--사원명으로 오름차순 정렬해서 출력하라.
select employee_id, emp_name
from employees
where salary > 5000
order by emp_name asc;
--사원번호는 오름차순, 사원명도 오름차순으로 정렬해서 출력

select employee_id, emp_name, salary
from employees
where salary > 5000
order by salary asc, emp_name asc;
--앞에 적은 컬럼명으로만 정렬됨 뒤에는 의미가 없다.
--만약 앞에 정렬된 값이 겹치는 데이터가 있다면 
--겹치는 데이터상에서 뒤의 데이터가 오름차순으로 정렬된다

select employee_id, emp_name, salary
from employees
where salary > 5000
order by 3 desc, 2 desc;
--위에 셀렉트 옆에 순서대로 번호로 지정해서 써줘도 사용가능

SELECT  employee_id, emp_name
FROM employees
WHERE salary > 5000
  AND job_id = 'IT_PROG'
ORDER BY employee_id;

SELECT  employee_id, emp_name
FROM employees
WHERE salary > 5000
   OR job_id = 'IT_PROG'
ORDER BY employee_id;
--AND와 OR중에 AND가 우선순위가 높다.

SELECT  employee_id, emp_name, salary, manager_id, job_id
FROM employees
WHERE salary > 10000
   OR job_id = 'IT_PROG'--오라클은 데이터는 대문자로만 검색된다. 데이터는 대소문자 구별
   AND manager_id = 101
ORDER BY employee_id;
--실제로 실행했을때 그냥 연산했을때와 and연산을 ()묶어 강제로 먼저 했을떄가
--결과가 같다.

SELECT a.employee_id, a.emp_name, a.department_id, 
b.department_name AS dep_name
 FROM employees a, 
       departments b
 WHERE a.department_id = b.department_id;
--JOIN을 사용 추후 정리
----------------------------------------------------------