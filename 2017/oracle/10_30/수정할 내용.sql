---------------------------------- 3개 조인 ------------------------------------- 25일
select * --일반적인 3개 조인
from employees e, departments d, job_history j
where e.department_id = d.department_id
and d.department_id = j.department_id;
select * --ansi로 3개 조인
from 
    employees e 
        inner join departments d on e.department_id = d.department_id 
        inner join job_history j on d.department_id = j.department_id;
--------------------------------------------------------------------------------
--특정 부서의 평균연봉보다 높은 부서 구하고 평균연봉 표시 --25일 연관성없는 서브쿼리 추가
select department_id, avg(salary)
from employees
group by department_id
HAVING avg(salary) > (select avg(salary)--그룹바이는 헤빙으로 조건을 건다.
                    from employees
                    where department_id = 20)
order by department_id;
--조인으로 부서 이름까지 포함
select d.DEPARTMENT_NAME, round(avg(SALARY),1) as "연    봉"
--round로 평균을 소수점 1자리까지만 출력, 연봉 글자 사이에 공백을 주려면 ""를 사용 ''은 불가
from employees e inner join departments d
on e.department_id = d.department_id
group by d.DEPARTMENT_NAME--부서이름을 출력하기 위해선 그룹을 부서이름으로 해야한다.
HAVING avg(salary) > (select avg(salary)
                            from employees
                            where department_id = 20)
order by d.DEPARTMENT_NAME;               
-------------------------- 연관성 있는 서브쿼리 -----------------------------------  --25일
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
SELECT a.department_id, a.department_name
 FROM departments a
WHERE EXISTS ( SELECT 1
                 FROM job_history b
                WHERE a.department_id = b.department_id );

select department_id from job_history;

SELECT a.employee_id, 
       ( SELECT b.emp_name
           FROM employees b
          WHERE a.employee_id = b.employee_id) AS emp_name,
       a.department_id,
       ( SELECT b.department_name
           FROM departments b
          WHERE a.department_id = b.department_id) AS dep_name     
FROM job_history a;
--셀렉트단위에서 서브 쿼리
--조인과 비슷하지만 조인으로 표현하지 못하는걸 작업할 때 사용
------------------------------------ 인라인 뷰 ----------------------------------26일
--from절에 사용하는 서브쿼리를 인라인 뷰 라고한다.
-- 인라인뷰

select c.st_code, c.st_name, d.dep_code, d.DEP_NAME--학점이 4.2보다 큰행의 학생정보
from classes c, department d, 
    ( select round(avg(c2.st_grade),1) as avg_grade
        from department d2, classes c2--연관없는 서브쿼리기 때문에 웨어절에 써도 같음
        where d2.dep_code = c2.dep_code and d2.dep_code = 200) e --4.2
    where c.dep_code = d.dep_code and c.st_grade > e.avg_grade;
    --grade가 4.2보다 큰 행
   --서브쿼리를 구성해서 테이블처럼 사용하는것을 인라인 뷰라고 한다.
   --모바일과의 평균학점을 구하고 그걸 테이블화해서 그보다 큰 점수를 받은 학생을 구한다.

--인라인뷰를 대상으로 조인한 형태
SELECT a.* 
  FROM ( SELECT a.sales_month, ROUND(AVG(a.amount_sold)) AS month_avg
           FROM sales a,
                customers b,
                countries c
          WHERE a.sales_month BETWEEN '200001' AND '200012'
            AND a.cust_id = b.CUST_ID
            AND b.COUNTRY_ID = c.COUNTRY_ID
            AND c.COUNTRY_NAME = 'Italy'     
          GROUP BY a.sales_month  
       )  a,
       ( SELECT ROUND(AVG(a.amount_sold)) AS year_avg
           FROM sales a,
                customers b,
                countries c
          WHERE a.sales_month BETWEEN '200001' AND '200012'
            AND a.cust_id = b.CUST_ID
            AND b.COUNTRY_ID = c.COUNTRY_ID
            AND c.COUNTRY_NAME = 'Italy'       
       ) b
 WHERE a.month_avg > b.year_avg ; --sales테이블이 없어서 구동 불가
--------------------------------------------------------------------------------
