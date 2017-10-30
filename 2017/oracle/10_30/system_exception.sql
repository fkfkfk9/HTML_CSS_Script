---------------------------------- 시스템 예외 ----------------------------------- 
CREATE OR REPLACE PROCEDURE proc_zero_exception 
IS
  vi_num NUMBER := 0;
BEGIN
	vi_num := 8 / 0;	 
	DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
EXCEPTION WHEN ZERO_DIVIDE THEN	 
--others는 어떤 오류는 잡아주는것이었고 ZERO_DIVIDE는 0으로 나누는 오류를 말한다.
--when 다음에 어떤 에러명이 나오냐에 따라 해당 오류만 잡는다 전부잡는건 others이다.
	DBMS_OUTPUT.PUT_LINE('ERROR!! 0으로 나누는 것은 불가능 합니다.');			
    DBMS_OUTPUT.PUT_LINE('ERROR CODE : ' || SQLCODE);
    DBMS_OUTPUT.PUT_LINE('ERROR MESSAGE : ' || SQLERRM);
    DBMS_OUTPUT.PUT_LINE( DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    --DBMS_UTILITY : 시스템 패키지중에 하나 에러가난 라인수를 알 수 있다.
END;	

exec proc_zero_exception;

CREATE OR REPLACE PROCEDURE proc_zero_exception 
IS
  vi_num NUMBER := 0;
BEGIN
	vi_num := 8 / 0;	 
	DBMS_OUTPUT.PUT_LINE('숫자는 : ' || vi_num);	
EXCEPTION WHEN ZERO_DIVIDE THEN	 
        DBMS_OUTPUT.PUT_LINE('ERROR!! 0으로 나누는 것은 불가능 합니다.');			
        DBMS_OUTPUT.PUT_LINE('ERROR CODE : ' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('ERROR MESSAGE : ' || SQLERRM);
        DBMS_OUTPUT.PUT_LINE( DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR!! 메세지를 참고해주세요.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM(SQLCODE));
END;	
--일반적으로 시스템예외는 OTHERS만 사용하면 된다.
exec proc_zero_exception;

CREATE OR REPLACE PROCEDURE proc_upd_dep_st_code
                (   p_st_code  classes.st_code%type,
                    p_dep_code classes.dep_code%type)
IS
    vi_check    number := 0;
BEGIN
    select 1
    INTO vi_check --검색되는 데이터가 있으면 넘어가고 없으면 오류가 난다.
    --즉 일치하는 데이터가 없을 때 exception을 내기 위해 필요하다.
    from department
    where dep_code = p_dep_code;

    update classes
    set st_code = p_st_code 
    where dep_code = p_dep_code; --아무 예외가 없다면 업데이트한다.     
   
    COMMIT;
  
    EXCEPTION WHEN NO_DATA_FOUND THEN--데이터가 없을때 나는 오류
                 DBMS_OUTPUT.PUT_LINE(SQLERRM(SQLCODE));
                 DBMS_OUTPUT.PUT_LINE(p_dep_code ||'학과가 없습니다');
            WHEN OTHERS THEN
                 DBMS_OUTPUT.PUT_LINE(SQLERRM(SQLCODE));
END;                   

EXEC proc_upd_dep_st_code (20071888, 10500);
--------------------------------------------------------------------------------