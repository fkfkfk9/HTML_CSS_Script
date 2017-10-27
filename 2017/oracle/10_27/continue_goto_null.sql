----------------------------- CONTINUE 문 --------------------------------------
--조건식이 true면 제어가 다음 for문이 진행된다.
DECLARE   
BEGIN   
   FOR i IN 2..9
   LOOP
    CONTINUE WHEN i=5;--5가되면 +1을 시키고 다음 루프가 진행
    FOR j IN 1..9 
    LOOP
      CONTINUE WHEN j=5; --5가되면 +1을 시키고 다음 루프가 진행
      DBMS_OUTPUT.PUT_LINE (i || '*' || j || '= ' || i * j);
    END LOOP;  
   END LOOP;    
END;
--------------------------------------------------------------------------------
---------------------------------- GOTO문 --------------------------------------
--권장사항이 아님 거의 사용하지 않는다.
DECLARE   
BEGIN   
   FOR i IN 2..9
   LOOP
    FOR j IN 1..9
    LOOP
      if i = 4 THEN
        GOTO gotu_ex; --goto 레이블명을 하면 강제로 레블로 이동한다.
      end if;
      DBMS_OUTPUT.PUT_LINE (i || '*' || j || '= ' || i * j);
    END LOOP;      
   END LOOP;   
   <<gotu_ex>> --레이블: 코드를 제어하기 위해서 특정위치를 가르킴
   DBMS_OUTPUT.PUT_LINE ('3단에서 끝');
END;
--------------------------------------------------------------------------------
--------------------------------- NULL 문 --------------------------------------
IF vi_st_grade = 'A' THEN
   처리로직1;
ELSIF vi_st_grade = 'B' THEN
   처리로직2;
...
ELSE NULL; --아무것도 처리하지 않는 문장 if나 case에서 주로 사용 
END IF;
--조건에 따라 처리 로직은 작성하고 모든조건에 부합하지 않을때 아무것도 처리하고싶지 않을경우

CASE WHEN vi_st_grade = 'A' THEN
          처리로직1;
     WHEN vi_st_grade = 'B' THEN
          처리로직2;      
     ...
     ELSE NULL;
END CASE;     
--------------------------------------------------------------------------------