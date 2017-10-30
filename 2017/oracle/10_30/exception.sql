-------------------------------- 예외처리구문 ------------------------------------
select 10 / 0 from dual; --0으로 나누는건 오류가 난다.
DECLARE 
   vi_num NUMBER := 0;
BEGIN	
	 vi_num := 8 / 0;--0으로 나눴기 때문에 오류가 난다.
                    --즉 예외가 발생해 비정상적인 종료가 일어난다.
	 DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	 --앞에서 종료됨으로 실행안됨
END;
--예외처리 : EXCEPTION WHEN 시스템예외명 THEN
DECLARE 
   vi_num NUMBER := 0;
BEGIN	
	 vi_num := 8 / 0;	 
	 DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	 
EXCEPTION WHEN OTHERS THEN--예외처리 구문(예외가 발생하면 실행된다.)	 
--예외가 others이면 아래코드를 실행하라 여기서 others는 구체적인 예외명을 모르는 예외들
	 DBMS_OUTPUT.PUT_LINE('0으로 나누는 것은 불가능 합니다.');	
END;

CREATE OR REPLACE PROCEDURE proc_zero_no_exception
IS
  vi_num NUMBER := 0;
BEGIN
	vi_num := 8 / 0;	 
	DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
END;	
exec proc_zero_no_exception;

CREATE OR REPLACE PROCEDURE proc_zero_exception 
IS
  vi_num NUMBER := 0;
BEGIN
	vi_num := 8 / 0;	 
	DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
EXCEPTION WHEN OTHERS THEN	 
	 DBMS_OUTPUT.PUT_LINE('0으로 나누는 것은 불가능 합니다.');			
END;	
exec proc_zero_exception;

DECLARE 
   vi_num NUMBER := 0;
BEGIN	
	 proc_zero_no_exception;	 	 
	 DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
END;

DECLARE 
   vi_num NUMBER := 0;
BEGIN	
	 proc_zero_exception;--exec생략처리 해야된다. 익명구문에선	 	 
	 DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);
END;
--------------------------------------------------------------------------------