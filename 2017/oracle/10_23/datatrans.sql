------------------------------------ 변환함수 ----------------------------------
SELECT TO_CHAR(800200300, '999,999,999')
  FROM DUAL;--대상을 문자로 변환시켜주는 것이 목적 숫자나 날짜를 문자로 변환해준다.
  --9를 넣어줘야한다.
  
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD')
FROM DUAL;--날짜 데이터를 문자로

SELECT TO_NUMBER('881103')
FROM DUAL;--문자를 숫자로

SELECT TO_DATE('19881103', 'YYYY-MM-DD')
  FROM DUAL;--문자를 날짜 데이터로 -나/는 같은의미
  
SELECT TO_DATE('19881103 13:44:50', 'YYYY-MM-DD HH24:MI:SS')
  FROM DUAL;  
  
select * from board
where regdate = to_date('2017/10/19', 'YYYY-MM-DD');
----------------------------------------------------------------------------- 