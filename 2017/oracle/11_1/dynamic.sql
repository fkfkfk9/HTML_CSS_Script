--------------------------- 동적 SQL로 프로시저 실행 ------------------------------
DECLARE
  vs VARCHAR2(20) := '박지성';
  vi NUMBER := 88;
  vd DATE   := '2002-06-01';
  vs_query   VARCHAR2(1000);
BEGIN
  -- 프로시저 실행
  proc_bind_ex ( vs, vi, vd);  
  DBMS_OUTPUT.PUT_LINE('-----------------------------------');
  vs := '손흥민'; vi := 13; vd := sysdate;  
  vs_query := 'BEGIN proc_bind_ex (:a, :b, :c); END;';  
  --다른구문과는 다르게 프로시저 안에서는 바인드 변수명이 :a, :a식으로 같으면 오류가 난다.
  EXECUTE IMMEDIATE vs_query USING vs, vi, vd;  
END;
  

CREATE OR REPLACE PROCEDURE proc_bind_ex2 ( 
                pb_vs1 IN     VARCHAR2, 
                pb_vs2 OUT    VARCHAR2,
                pb_vs3 IN OUT VARCHAR2  )                                              
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE ('첫번째 값 : ' || pb_vs1);	
	pb_vs2 := '두 번째 값';
	pb_vs3 := '세 번째 값';	
END;

--매개변수의 성격이 다른 프로시저를 동적쿼리로 실행하는 구문
DECLARE
  vs1 VARCHAR2(30) := '홍명보';
  vs2 VARCHAR2(30);
  vs3 VARCHAR2(30);

  vs_query   VARCHAR2(1000);
BEGIN
  -- 바인드 변수  
  vs_query := 'BEGIN proc_bind_ex2 (:a, :b, :c); END;';  
  EXECUTE IMMEDIATE vs_query USING vs1, OUT vs2, IN OUT vs3;  
  DBMS_OUTPUT.PUT_LINE ('vs2 = ' || vs2);
  DBMS_OUTPUT.PUT_LINE ('vs3 = ' || vs3);
END;
--------------------------------------------------------------------------------