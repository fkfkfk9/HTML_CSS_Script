-------------------- UPDATE ------------------------
/*
    update 테이블명 
    set 컬럼명 = 변경값, 컬럼명 = 변경값.......
    where 조건식;
*/
SELECT * FROM insert_test;

UPDATE insert_test
   SET itcol2 = 50;--해당 컬럼의 모든값을 바꾼다.
   
SELECT * FROM insert_test;
--조건식에 널 사용시(매우 중요)
UPDATE insert_test
   SET itcol3 = SYSTIMESTAMP
WHERE itcol3 = '';--적용이 되지 않는다.

UPDATE insert_test
   SET itcol3 = SYSTIMESTAMP
WHERE itcol3 IS NULL;--널 검색 방법 = NULL도 안된다.
--IS NULL VS IS NOT NULL
SELECT * FROM insert_test;
-------------------------------------------------------   