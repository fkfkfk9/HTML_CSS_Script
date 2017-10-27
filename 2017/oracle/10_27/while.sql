--------------------------------- WHILE 문 -------------------------------------
/*  
    WHILE 조건식 --조건식과 일치해야 화일문 진입 루프문의 EXIT와는 반대
    LOOP
    조건식이 false일 경우 LOOP안으로 진입도 하지 않는다.
    EXIT WHEN(선택사항)
*/
DECLARE
   vi_num   NUMBER := 2;
   vi_count NUMBER;
BEGIN
   
   WHILE  vi_num <= 9 
   LOOP
   vi_count := 1;
    WHILE vi_count <= 9
    LOOP
        DBMS_OUTPUT.PUT_LINE (vi_num || '*' || vi_count || '= ' || vi_num * vi_count);
        vi_count := vi_count + 1; 
    END LOOP;
    vi_num := vi_num + 1;
  END LOOP;    
END;

DECLARE
   vi_num   NUMBER := 2;
   vi_count NUMBER;
BEGIN
   
   WHILE  vi_num <= 9 
   LOOP
   vi_count := 1;
    WHILE vi_count <= 9
    LOOP
        DBMS_OUTPUT.PUT_LINE (vi_num || '*' || vi_count || '= ' || vi_num * vi_count);
        EXIT WHEN vi_count = 5;--while문에서도 exit when사용 가능
        vi_count := vi_count + 1; 
    END LOOP;
    EXIT WHEN vi_num = 5;--loop문만 쓸때는 필수지만 while문에선 선택사항
    vi_num := vi_num + 1;
  END LOOP;    
END;
--------------------------------------------------------------------------------