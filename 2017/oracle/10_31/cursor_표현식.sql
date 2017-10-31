---------------------------------- 커서 표현식 -----------------------------------
select (select dep_name--단일행이기 때문에 오류가 없다.
        from department d
        where c.dep_code = d.dep_code) dep_name,
        c.st_name
from classes c
where c. dep_code = 10200;

--오류가 나는 이유 서브쿼리 결과값이 다중행이 발생되어 에러가 난다.
select d.dep_name, 
        (select c.st_name
            from classes c
            where c.dep_code = d.dep_code) st_name
from department d
where d.dep_code = 10200;
--서브쿼리는 단일행이어야 한다.

--위에 select문과 동일하지만 cursor이 서브쿼리 앞에 사용되었다.
--cursor은 다중행도 하나의 행으로 가져온다.
 select d.dep_name, 
       cursor (select c.st_name
            from classes c
            where c.dep_code = d.dep_code) st_name
from department d
where d.dep_code = 10200;

DECLARE
-- 커서표현식을 사용한 명시적 커서 선언
    CURSOR dep_st_name_cur IS--커서를 선언한다.
        select d.dep_name, 
        cursor (select c.st_name--서브쿼리를 커서로 만든다.
            from classes c
            where c.dep_code = d.dep_code) st_name
        from department d
        where d.dep_code = 10200;
        
    vs_dep_name DEPARTMENT.DEP_NAME%type;--학과명을 받아온다.
    c_st_name SYS_REFCURSOR;--서브쿼리의 커서를 받아온다.
    vs_st_name classes.st_name%TYPE;--학생이름을 받아온다.
begin
    -- 메인 커서를 오픈한다.
    OPEN dep_st_name_cur;    
    -- 메인커서의 데이터를 받아올 루프문을 만든다.
    LOOP
       -- 패치를 통해 메인커서의 문자열 데이터와 커서 데이터를 변수에 넣어준다.
       FETCH dep_st_name_cur INTO vs_dep_name, c_st_name;
       EXIT WHEN dep_st_name_cur%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE ('학과명 : ' || vs_dep_name);--문자열 데이터 출력       
       -- 서브쿼리 커서를 출력할 루프문
       LOOP
          -- 서브쿼리의 커서를 패치함
          FETCH c_st_name INTO vs_st_name;--서브쿼리속 학생이름을 변수에 넣어준다.
          EXIT WHEN c_st_name%NOTFOUND;          
          DBMS_OUTPUT.PUT_LINE('   학생이름 : ' || vs_st_name);--변수를 출력       
       END LOOP; -- 서브커리의 커서가 더 이상 읽을 데이터가 없다면 종료        
    END LOOP; -- 메인커서의 데이터가 더 이상 없다면 종료
END;
--------------------------------------------------------------------------------