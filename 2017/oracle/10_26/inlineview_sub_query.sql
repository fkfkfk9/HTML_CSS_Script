------------------------------------ 인라인 뷰 ----------------------------------
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
