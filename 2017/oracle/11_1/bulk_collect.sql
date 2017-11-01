------------------------------- 성능 향상을 위한 다중 로우 처리 ---------------------------------
-- BULK COLLECT INTO를 사용한 정적 SQL
select * from dynamic_ex;
DECLARE
  -- 레코드 선언 
  TYPE rec_dynamic IS RECORD  (
      d_id          dynamic_ex.d_id%TYPE,
      d_name        dynamic_ex.d_name%TYPE,
      d_join_date   dynamic_ex.d_join_date%TYPE );
  -- 레코드를 항목으로 하는 중첩테이블 선언
  TYPE nt_arr_dynamic IS TABLE OF rec_dynamic;
  -- 중첩테이블 변수 선언
  varr_dynamic nt_arr_dynamic;
BEGIN
  -- BULK COLLECT INTO 절 : 모든 로우값을 다 전달한다.
    SELECT * 
    BULK COLLECT INTO varr_dynamic
    FROM dynamic_ex;
   -- 루프를 돌며 출력
   FOR i IN 1..varr_dynamic.count
   LOOP
     DBMS_OUTPUT.PUT_LINE(varr_dynamic(i).d_name);
   END LOOP;
END;

-- BULK COLLECT INTO를 사용한 동적  SQL
DECLARE
  -- 레코드 선언 
  TYPE rec_dynamic IS RECORD  (
      d_id          dynamic_ex.d_id%TYPE,
      d_name        dynamic_ex.d_name%TYPE,
      d_join_date   dynamic_ex.d_join_date%TYPE );
  -- 레코드를 항목으로 하는 중첩테이블 선언
  TYPE nt_arr_dynamic IS TABLE OF rec_dynamic;
  -- 중첩테이블 변수 선언
  varr_dynamic nt_arr_dynamic;
  
  vs_query VARCHAR2(1000);
  vi_id dynamic_ex.d_id%TYPE := 1;
BEGIN
  -- SELECT 구문 
  vs_query := 'SELECT * FROM dynamic_ex WHERE d_id > :a' ;
  -- EXECUTE IMMEDIATE .. BULK COLLECT INTO 구문
  EXECUTE IMMEDIATE vs_query BULK COLLECT INTO varr_dynamic USING vi_id;  
   -- 루프를 돌며 출력
   FOR i IN 1..varr_dynamic.count
   LOOP
     DBMS_OUTPUT.PUT_LINE(varr_dynamic(i).d_name);
   END LOOP;
END;
--------------------------------------------------------------------------------