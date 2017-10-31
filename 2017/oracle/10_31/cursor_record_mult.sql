-------------------------------- 커서형 레코드 ----------------------------------- 
DECLARE
  -- 커서 선언
   CURSOR dep_cur IS
       SELECT dep_code, dep_name, dean_name
         FROM department;       
   -- 커서형 레코드변수 선언  
   vr_dep dep_cur%ROWTYPE;
BEGIN
   --테이블의 기존 데이터 삭제 
   DELETE dep; 
   -- 커서 오픈 
   OPEN dep_cur;   
   -- 루프를 돌며 vr_dep 레코드 변수에 값을 넣고, dep에 INSERT
   LOOP
     FETCH dep_cur INTO vr_dep;     
     EXIT WHEN dep_cur%NOTFOUND;
     -- 레코드 변수를 이용해 ch11_dep2 테이블에 데이터를 넣는다. 
     INSERT INTO dep VALUES vr_dep;   
   END LOOP;   
   COMMIT;
END;

select * from dep;

DECLARE
   -- 레코드 변수 선언 
   vr_dep dep%ROWTYPE;
BEGIN 
   vr_dep.dep_code := 10200;
   vr_dep.dep_name := '정보통신';
   vr_dep.dean_name := '김석동';     
   UPDATE dep
      SET ROW = vr_dep --ROW를 사용하면 행전체가 수정된다.
      WHERE dep_code = vr_dep.dep_code;    
   COMMIT;
END;

select * from dep;
--------------------------------------------------------------------------------
------------------------------------ 중첩 레코드 ---------------------------------

DECLARE
  -- 학과코드 학과이름을 필드로 가진 dep_rec 레코드 타입 선언 
  TYPE dep_rec IS RECORD (
        dep_code    department.dep_code%TYPE,
        dep_name    department.dep_name%TYPE );        
  --학번, 학생이름 그리고 dep_rec(학과코드, 학과명) 타입의 레코드 선언 
  TYPE class_rec IS RECORD (
        st_code     classes.st_code%TYPE,
        st_name     classes.st_name%TYPE,
        dep          dep_rec                          );        
   --class_rec 타입의 레코드 변수 선언 
   vr_class class_rec;
BEGIN
   -- 20070002 학번의 학생의 학생이름, 학과코드, 학과이름을 가져온다. 
   select c.st_code, c.st_name, c.dep_code, d.dep_name
   into vr_class.st_code, vr_class.st_name, vr_class.dep.dep_code, vr_class.dep.dep_name
   from classes c INNER JOIN department d
   on c.dep_code = d.dep_code
   and c.st_code = 20070002;
    -- 레코드 변수 값 출력    
    DBMS_OUTPUT.PUT_LINE('st_code : ' ||  vr_class.st_code);
    DBMS_OUTPUT.PUT_LINE('st_name : ' ||  vr_class.st_name);
    DBMS_OUTPUT.PUT_LINE('dep_code : ' ||  vr_class.dep.dep_code);
    DBMS_OUTPUT.PUT_LINE('dep_name : ' ||  vr_class.dep.dep_name);
END;
--------------------------------------------------------------------------------