-- (2) 다중로우 처리
-- ① OPEN FOR문
TRUNCATE TABLE dynamic_ex ;
INSERT INTO dynamic_ex VALUES (1, '홍길동', TO_DATE('1888-08-08','YYYY-MM-DD'));
INSERT INTO dynamic_ex VALUES (2, '박지성', TO_DATE('2002-06-01','YYYY-MM-DD'));
INSERT INTO dynamic_ex VALUES (3, '손흥민', TO_DATE('2014-03-30','YYYY-MM-DD'));
INSERT INTO dynamic_ex VALUES (4, '기성용', TO_DATE('2006-11-11','YYYY-MM-DD'));

COMMIT;
   
DECLARE
  -- 커서타입 선언
  TYPE cur_dynamic_type IS REF CURSOR;
  -- 커서 변수 선언
  cur_dynamic cur_dynamic_type;
  -- 반환값을 받을 레코드 선언
  rec_dynamic dynamic_ex%ROWTYPE; 
  vs_query VARCHAR2(1000);
BEGIN
	vs_query := 'SELECT * FROM dynamic_ex';
	-- OPEN FOR문을 사용한 동적 SQL
	OPEN cur_dynamic FOR vs_query;
	--루프를 돌며 커서변수에 담긴 값을 출력한다.
	LOOP
	  FETCH cur_dynamic INTO rec_dynamic;
    EXIT WHEN cur_dynamic%NOTFOUND;	
    DBMS_OUTPUT.PUT_LINE(rec_dynamic.d_name);
  END LOOP;	
	CLOSE cur_dynamic;
END;

-- 바인드 변수    
DECLARE
  -- 커서 변수 선언
  cur_dynamic SYS_REFCURSOR;
  -- 반환값을 받을 레코드 선언
  rec_dynamic dynamic_ex%ROWTYPE; 
  vs_query VARCHAR2(1000);
  vi_id   dynamic_ex.d_id%TYPE    := 1;
  vs_name dynamic_ex.d_name%TYPE  := '기%';
BEGIN
	-- 바인드 변수 사용을 위해 WHERE조건 추가 
	vs_query := 'SELECT * FROM dynamic_ex WHERE d_id > :a AND d_NAME LIKE :b ';
	-- OPEN FOR문을 사용한 동적 SQL
	OPEN cur_dynamic FOR vs_query USING vi_id, vs_name;
	--루프를 돌며 커서변수에 담긴 값을 출력한다.
	LOOP
	  FETCH cur_dynamic INTO rec_dynamic;
    EXIT WHEN cur_dynamic%NOTFOUND;	
    DBMS_OUTPUT.PUT_LINE(rec_dynamic.d_name);
  END LOOP;	
	CLOSE cur_dynamic;
END;
-------------------------------------------------------------------------------------------------
