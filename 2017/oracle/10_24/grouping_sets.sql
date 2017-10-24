---------------------------- GROUPING SETS -------------------------------------
/*
    GROUP BY writer + GROUP BY readnum 각각 GROUP BY를 시켜 더해준 값
*/
 
 select salary, job_id, sum(salary), count(*)
 from employees
 group by GROUPING SETS(salary, job_id)--각각 그룹바이한 결과를 유니온 올 한것과 같다.
 order by salary, job_id;

select salary, sum(salary), count(*)
 from employees
 group by salary
 order by salary;
 --위 아래 결과를 합친것은 GROUPING SETS(salary, job_id) 같다.
 select job_id, sum(salary), count(*)
 from employees
 group by job_id
 order by job_id;


 select salary, job_id, DEPARTMENT_ID, sum(salary), count(*)
 from employees
 group by GROUPING SETS(salary,(job_id, DEPARTMENT_ID))
 order by salary, job_id;
--셀러리로만 그룹바이 한것과 아래것의 결과를 합친(유니온 올)것과 같다
select job_id, DEPARTMENT_ID, sum(salary), count(*)
 from employees
 group by job_id, DEPARTMENT_ID
 order by job_id, DEPARTMENT_ID;
--------------------------------------------------------------------------------