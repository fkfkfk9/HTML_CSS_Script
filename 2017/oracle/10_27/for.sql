---------------------------------- FOR 문 --------------------------------------
/*
    반복문은 LOOP ~ END LOOP; 는 전부 들어간다.
    FOR 변수 IN 초기값..최종값
    LOOP
        실행코드;
    END LOOP;
*/
DECLARE   
BEGIN   
   FOR i IN 2..9 --2~9까지 루프
   LOOP
    FOR j IN 1..9 --1~9까지 루프 끝 
    LOOP
      DBMS_OUTPUT.PUT_LINE (i || '*' || j || '= ' || i * j);
    END LOOP;  
   END LOOP;    
END;

DECLARE   
BEGIN    --reverse거꾸로 루프 시킨다.
   FOR i IN reverse 2..9 --9~2까지 루프
   LOOP
    FOR j IN reverse 1..9 --9~1까지 루프 끝 
    LOOP
      DBMS_OUTPUT.PUT_LINE (i || '*' || j || '= ' || i * j);
    END LOOP;  
   END LOOP;    
END;
--------------------------------------------------------------------------------