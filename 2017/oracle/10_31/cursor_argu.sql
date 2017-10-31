--------------------------- 커서변수를 매개변수로 전달 -----------------------------
DECLARE
    class_st_cursor SYS_REFCURSOR;--임의의 커서변수를 만든다.
    vs_st_name classes.st_name%type;--데이터 출력을 위한 변수
    
    procedure cursor_ex (p_cursor IN OUT SYS_REFCURSOR)
    IS--커서를 매개변수로 받는 프로시져를 만든다.
        c_s_cursor SYS_REFCURSOR;--작업할 커서를 선언
    begin
        open c_s_cursor for--커서가 기억할 테이블을 할당
            select st_name
            from classes
            where dep_code = 10200;
            
        p_cursor := c_s_cursor;--커서가 기억하는 주소값을 매개변수로 전달
    end;
begin
    cursor_ex(class_st_cursor);--프로시져를 실행해 커서값을 받아옴
    LOOP
        FETCH class_st_cursor INTO vs_st_name;--테이블의 데이터를 변수에 받아온다.
        EXIT WHEN class_st_cursor%NOTFOUND;--테이블이 끝나면 루프탈출
        DBMS_OUTPUT.PUT_LINE(vs_st_name);--변수를 출력
    END LOOP;
END;
--------------------------------------------------------------------------------