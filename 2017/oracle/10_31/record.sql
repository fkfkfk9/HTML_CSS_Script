------------------------------------ 레코드 -------------------------------------
--테이블에서 여러칼럼으로 구성되어 있는 한개의 데이터 행의 구조를 만들어주는 데이터 타입
-- 강한커서타입에서 한개의 행만 가져오는것과 비슷, 배열과도 비슷한대 여러 데이터 타입이 들어감
--사용자 정의 레코드
DECLARE
  -- 학과레코드 타입선언
   TYPE dep_rect IS RECORD (
         dep_code   department.dep_code%TYPE,
         dep_name   department.dep_name%TYPE, 
         dean_name  department.dean_name%TYPE,
         dep_call   department.dep_call%TYPE
   );
   
  -- 위에서 선언된 타입으로 레코드 변수 선언  
   vr_dep dep_rect;
BEGIN
 …
END;

DECLARE
  -- 학과레코드 타입선언
   TYPE dep_rect IS RECORD (
         dep_code   department.dep_code%TYPE,
         dep_name   department.dep_name%TYPE, 
         dean_name  department.dean_name%TYPE,
         dep_call   department.dep_call%TYPE
   );   
  -- 위에서 선언된 타입으로 레코드 변수 선언  
  vr_dep dep_rect;
  -- 두 번째 변수 선언 
  vr_dep2 dep_rect;
BEGIN
   vr_dep.dep_code := 10000;
   vr_dep.dep_name := '최초의 부서';
   vr_dep.dean_name := '홍길동';
   vr_dep.dep_call := '012-345-6789';
   
   -- 두 번째 변수에 첫 번째 레코드변수 대입
   vr_dep2 := vr_dep;
   
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dep_code :' || vr_dep2.dep_code);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dep_name :' ||  vr_dep2.dep_name);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dean_name :' ||  vr_dep2.dean_name);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dep_call :' ||  vr_dep2.dep_call);
END;

DECLARE
  -- 학과레코드 타입선언
   TYPE dep_rect IS RECORD (
         dep_code   department.dep_code%TYPE,
         dep_name   department.dep_name%TYPE, 
         dean_name  department.dean_name%TYPE,
         dep_call   department.dep_call%TYPE
   );   
  -- 위에서 선언된 타입으로 레코드 변수 선언  
  vr_dep dep_rect;
  -- 두 번째 변수 선언 
  vr_dep2 dep_rect;
BEGIN
   vr_dep.dep_code := 10000;
   vr_dep.dep_name := '최초의 부서';
   vr_dep.dean_name := '홍길동';
   vr_dep.dep_call := '012-345-6789';
   
   -- 두 번째 변수에 첫 번째 레코드변수 대입
   vr_dep2.dep_name := vr_dep.dep_name;--이름만 복사
   
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dep_code :' || vr_dep2.dep_code);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dep_name :' ||  vr_dep2.dep_name);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dean_name :' ||  vr_dep2.dean_name);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.dep_call :' ||  vr_dep2.dep_call);
   --나머지는 NULL값으로 채워지면서 출력된다.
END;

select * from department;

create table dep as 
select dep_code, dep_name, dean_name from department;
truncate table dep;
drop table dep;
select * from dep;

DECLARE
  -- 학과 레코드 타입선언
   TYPE dep_rect IS RECORD (
         dep_code   department.dep_code%TYPE,
         dep_name   department.dep_name%TYPE, 
         dean_name  department.dean_name%TYPE  );    
  -- 위에서 선언된 타입으로 레코드 변수 선언  
   vr_dep dep_rect;
BEGIN
   vr_dep.dep_code := 10000;
   vr_dep.dep_name := '최초의 부서';
   vr_dep.dean_name := '홍길동';   
   -- 레코드 필드를 명시해서 INSERT
   --INSERT INTO dep VALUES ( vr_dep.dep_code, vr_dep.dep_name, vr_dep.dean_name);   
   -- 레코드 필드 순서와 개수, 타입이 같다면 레코드변수명으로만 INSERT 가능
   INSERT INTO dep VALUES vr_dep;   
   COMMIT;
END;

select * from dep;
--------------------------------------------------------------------------------
------------------------------ 테이블형 레코드 -----------------------------------
--레코드는 하나의 행만 가능하기 때문에 테이블형 레코드 또한 하나의 행만 작업가능
create table dep2 as 
select * from department;
truncate table dep2;
select * from department where 1 = 0;--truncate를 안해도 데이터를 빼고 구조만 복사

DECLARE
  -- 테이블형 레코드 변수 선언 
   vr_dep department%ROWTYPE;
BEGIN
   -- 학과 테이블의 모든 정보를 레코드 변수에 넣는다. 
   SELECT *
     INTO vr_dep
     FROM department
    WHERE dep_code = 10200;   
   -- 레코드 변수를 이용해 dep2 테이블에 데이터를 넣는다. 
   INSERT INTO dep2 VALUES vr_dep;   
   COMMIT;
END;

select * from dep2;
--------------------------------------------------------------------------------