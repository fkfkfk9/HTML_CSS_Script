----------------- SQLCODE, SQLERRM을 이용한 예외정보 참조 --------------------------
CREATE OR REPLACE PROCEDURE proc_zero_exception 
IS
  vi_num NUMBER := 0;
BEGIN
	vi_num := 8 / 0;	 
	DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
EXCEPTION WHEN OTHERS THEN	 
	DBMS_OUTPUT.PUT_LINE('ERROR!!!!!!!!!!!!!!');			
    DBMS_OUTPUT.PUT_LINE('ERROR CODE : ' || SQLCODE);--exception에서만 사용가능
    --발생한 오류의 코드를 반환, 오류가 없다면 0이 반환된다.
    DBMS_OUTPUT.PUT_LINE('ERROR MESSAGE : ' || SQLERRM);
    --에러메세지가 반환되는대 무슨이유로 오류가 났는지 보내준다.
    DBMS_OUTPUT.PUT_LINE(SQLERRM(SQLCODE));
    --오류메세지에 오류코드를 포함시켜 보여준다.
    DBMS_OUTPUT.PUT_LINE( DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    --DBMS_UTILITY : 시스템 패키지중에 하나
END;	
exec proc_zero_exception;

CREATE OR REPLACE PROCEDURE proc_zero_exception 
IS
  vi_num NUMBER := 0;
BEGIN
	vi_num := 8 / 0;	 
	DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
EXCEPTION WHEN OTHERS THEN	 
	DBMS_OUTPUT.PUT_LINE('ERROR!!!!!!!!!!!!!!');			
    DBMS_OUTPUT.PUT_LINE('ERROR CODE : ' || SQLCODE);
    DBMS_OUTPUT.PUT_LINE('ERROR MESSAGE : ' || SQLERRM);
    DBMS_OUTPUT.PUT_LINE( DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    --DBMS_UTILITY : 시스템 패키지중에 하나 에러가난 라인수를 알 수 있다.
END;
exec proc_zero_exception;
--------------------------------------------------------------------------------