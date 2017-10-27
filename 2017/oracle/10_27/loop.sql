---------------------------------- LOOP 문 -------------------------------------
/*
    LOOP
        실행코드1;
        실행코드2;
        실행코드3;
        EXIT WHEN 조건식 --루프 탈출문
    LOOP END;
*/
DECLARE
   vi_num   NUMBER := 2;
   vi_count NUMBER;
BEGIN   
   LOOP
    vi_count := 1;
    LOOP
      DBMS_OUTPUT.PUT_LINE (vi_num || '*' || vi_count || '= ' || vi_num * vi_count);      
      vi_count := vi_count + 1; -- vi_count 값을 1씩 증가      
      EXIT WHEN vi_count >9;  -- vi_count 9보다 크면 루프 종료
    END LOOP;
    vi_num := vi_num + 1;
    EXIT WHEN vi_num > 9;
   END LOOP;    
END;
--------------------------------------------------------------------------------