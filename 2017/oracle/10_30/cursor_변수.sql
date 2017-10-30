------------------------------------ 커서변수 -----------------------------------
--명시적커서는 사실상 커서 상수에 가깝다.
/*
    강한 커서 데이터 타입,   약한 커서 데이터 타입 두가지가 있다.
    커서 데이터 타입 정의, 선언 형태
    커서 데이터 타입이라는 것은 필요해 의하여 생성해야 한다.
    
    TYPE 커서타입명 IS REF CURSOR; --약한 커서 타입
    변수명 SYS_REFCURSOR; -- 약한 커서 타입
    TYPE 커서타입명 IS REF CURSOR RETURN 테이블명%ROWTYPE; -- 강한 커서 타입
    강한 커서 타입은 적어주는 테이블명에 대한 모든 컬럼타입을 가져온다.
    강한커서 타입을 사용할려면, select문의 컬럼과 데이터 타입이 일치해야 한다.
    즉 강한커서를 사용할 때는 select문에서 모든 컬럼을 다 가져와야한다.
    
    변수 선언하기 : 변수명 커서타입명;
*/
select * from classes; --시작전 테이블 확인
DECLARE
   -- 학생 이름을 받아오기 위한 변수 선언
   vs_st_name classes.st_name%TYPE;
   
   -- 약한 커서타입 선언
   TYPE class_st_curtype IS REF CURSOR;
   -- 커서변수 선언
   class_st_cursor class_st_curtype;
BEGIN
  -- 커서변수를 사용한 커서정의 및 오픈
  OPEN class_st_cursor FOR SELECT st_name
                     FROM classes
                    WHERE dep_code = 10200;
  -- LOOP문
  LOOP
     -- 커서변수를 사용해 학과번호에 맞는 학생을  vs_st_name 변수에 할당 
     FETCH class_st_cursor INTO vs_st_name;
	  -- 더이상 커서안에 데이터가 없다면 루프 탈출
	  EXIT WHEN class_st_cursor%NOTFOUND;	  
	  -- 해당과 학생명을 출력
	  DBMS_OUTPUT.PUT_LINE('모바일 : ' || vs_st_name); 
  END LOOP; 
END;

DECLARE
   -- 학생 이름을 받아오기 위한 변수 선언
   vs_st_name classes.st_name%TYPE;
   
   -- 약한 커서타입 선언 2번째 방법
   class_st_cursor SYS_REFCURSOR;
BEGIN
  -- 커서변수를 사용한 커서정의 및 오픈
  OPEN class_st_cursor FOR SELECT st_name
                     FROM classes
                    WHERE dep_code = 10200;
  -- LOOP문
  LOOP
     -- 커서변수를 사용해 학과번호에 맞는 학생을  vs_st_name 변수에 할당 
     FETCH class_st_cursor INTO vs_st_name;
	  -- 더이상 커서안에 데이터가 없다면 루프 탈출
	  EXIT WHEN class_st_cursor%NOTFOUND;	  
	  -- 해당과 학생명을 출력
	  DBMS_OUTPUT.PUT_LINE('모바일 : ' || vs_st_name); 
  END LOOP; 
END;
-------강한커서 실습
select * from classes;
DECLARE
   -- 강한커서는 모든 컬럼을 받아오기 때문에 전부 선언
   vi_st_code classes.st_code%type;
   vs_st_name classes.st_name%TYPE;
   vs_dep_code classes.dep_code%TYPE;
   vs_st_grade classes.st_grade%TYPE;
   vs_st_gender classes.st_gender%TYPE;
   vs_st_phone classes.st_phone%TYPE;
   vs_st_birth classes.st_birth%TYPE;
   vs_st_addr classes.st_addr%TYPE;
   
   -- 강한 커서타입 선언
   TYPE class_st_curtype IS REF CURSOR RETURN classes%ROWTYPE;
   -- 커서변수 선언
   class_st_cursor class_st_curtype;
BEGIN
  -- 커서변수를 사용한 커서정의 및 오픈
  OPEN class_st_cursor FOR SELECT *
                     FROM classes
                    WHERE dep_code = 10200;
  -- LOOP문
  LOOP
     -- 모든 컬럼을 받아온다. 
     FETCH class_st_cursor INTO vi_st_code, vs_st_name, vs_dep_code,
     vs_st_grade, vs_st_gender, vs_st_phone, vs_st_birth, vs_st_addr;
	  -- 더이상 커서안에 데이터가 없다면 루프 탈출
	  EXIT WHEN class_st_cursor%NOTFOUND;	  
	  -- 해당과 학생명을 출력
	  DBMS_OUTPUT.PUT_LINE('모바일 : ' || vi_st_code || ', ' || vs_st_name
      || ', ' || vs_dep_code || ', ' || vs_st_grade || ', ' || vs_st_gender
      || ', ' || vs_st_phone || ', ' || vs_st_birth || ', ' || vs_st_addr); 
  END LOOP; 
END;
--------------------------------------------------------------------------------