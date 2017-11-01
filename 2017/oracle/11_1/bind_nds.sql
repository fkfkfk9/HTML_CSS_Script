--------------------------------- 바인드 변수 ------------------------------------
DECLARE
  --출력 변수 선언 
  vi_st_code    classes.st_code%TYPE;
  vs_st_name    classes.st_name%TYPE;
  vi_dep_code   classes.dep_code%TYPE;
  
  vs_query VARCHAR2(1000);
BEGIN
	-- SQL문을 변수에 담는다. 
	vs_query := 'select st_code, st_name, dep_code from classes 
                    where dep_code = ''10200'' and st_grade > 4.0';	
  EXECUTE IMMEDIATE vs_query INTO vi_st_code, vs_st_name, vi_dep_code;
  --쿼리를 담은 변수를 동적쿼리 실행명령어로 실행하여 검색된값을 변수에 전달
  DBMS_OUTPUT.PUT_LINE( '학번 : '   || vi_st_code );	          
  DBMS_OUTPUT.PUT_LINE( '학생이름 : ' || vs_st_name );	 
  DBMS_OUTPUT.PUT_LINE( '학과코드 : '   || vi_dep_code );         
END;

-- 바인드변수 2
DECLARE
  --출력 변수 선언 
  vi_st_code    classes.st_code%TYPE;
  vs_st_name    classes.st_name%TYPE;
  vi_dep_code   classes.dep_code%TYPE;
  
  vs_query VARCHAR2(1000);
  
  -- 바인드 변수 선언과 값 설정
  vi_dep      classes.dep_code%TYPE := 10200;
  vi_grade    classes.st_grade%TYPE := 4.0;
  vs_gender   classes.st_gender%TYPE := '여자';
BEGIN
	-- SQL문을 변수에 담는다. (바인드 변수 앞에 : 를 붙인다)
		vs_query := 'select st_code, st_name, dep_code from classes 
                    where dep_code = :a and st_grade > :b and st_gender = :c';	
	-- SQL문에서 선언한 순서대로 USING 다음에 변수를 넣는다. 
  EXECUTE IMMEDIATE vs_query INTO vi_st_code, vs_st_name, vi_dep_code
                           USING vi_dep, vi_grade, vs_gender;
	                  
  DBMS_OUTPUT.PUT_LINE( '학번 : '   || vi_st_code );	          
  DBMS_OUTPUT.PUT_LINE( '학생이름 : ' || vs_st_name );	 
  DBMS_OUTPUT.PUT_LINE( '학과코드 : '   || vi_dep_code );     	         
END;

-- INSERT, UPDATE, DELETE, MERGE

CREATE TABLE dynamic_ex ( 
    d_id            NUMBER, 
    d_name          VARCHAR2(50), 
    d_join_date     DATE 
);
drop table dynamic_ex;
select * from dynamic_ex;          
-- INSERT 문
DECLARE
  vi_d_id    dynamic_ex.d_id%TYPE := 2;
  vs_name    dynamic_ex.d_name%TYPE := '박지성';
  vd_d_join  dynamic_ex.d_join_date%TYPE := sysdate;
  
  vs_query  VARCHAR2(1000);  

BEGIN
	-- INSERT문 작성 
	vs_query := 'INSERT INTO dynamic_ex VALUES (:id, :name, :join)';	
	EXECUTE IMMEDIATE vs_query USING vi_d_id, vs_name, vd_d_join;	
	COMMIT;	
END;                                                  
-- UPDATE와 DELETE
DECLARE
  vi_d_id    dynamic_ex.d_id%TYPE := 1;
  vs_name    dynamic_ex.d_name%TYPE := '홍길동';
  vd_d_join  dynamic_ex.d_join_date%TYPE := '1977-07-07';  
  vs_query  VARCHAR2(1000);     
  vn_check   NUMBER := 0;
BEGIN
	-- UPDATE문
	vs_query := 'UPDATE dynamic_ex 
                SET d_name = :a, d_join_date = :a WHERE d_id = :a ';
	EXECUTE IMMEDIATE vs_query USING vs_name, vd_d_join, vi_d_id;	
	SELECT d_name INTO vs_name FROM dynamic_ex where d_id = 1;	  
	DBMS_OUTPUT.PUT_LINE('UPDATE 후 이름: ' || vs_name);
	-- DELETE 문
    vi_d_id := 2;
	vs_query := 'DELETE dynamic_ex WHERE d_id = :a ';	
	EXECUTE IMMEDIATE vs_query USING vi_d_id;		
  SELECT COUNT(*)
    INTO vn_check
    FROM dynamic_ex;	
	DBMS_OUTPUT.PUT_LINE('행의 갯수는 : ' || vn_check);	
	COMMIT;	
END;  
select * from dynamic_ex;  
-- 바인드 변수처리 2
CREATE OR REPLACE PROCEDURE proc_bind_ex (
        pb_vs IN VARCHAR2, 
        pb_vi IN NUMBER, 
        pb_vd IN DATE  )
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE ('1번째 입력 값 : ' || pb_vs);
	DBMS_OUTPUT.PUT_LINE ('2번째 입력 값 : ' || pb_vi);
	DBMS_OUTPUT.PUT_LINE ('3번째 입력 값 : ' || pb_vd);	
END;
exec proc_bind_ex('Hello bind', 8, sysdate);                                               
--------------------------------------------------------------------------------