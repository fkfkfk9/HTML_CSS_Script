---------------------------------- 날짜 함수 ------------------------------------
SELECT SYSDATE, SYSTIMESTAMP
  FROM DUAL;    
  
SELECT ADD_MONTHS(SYSDATE, 3), ADD_MONTHS(SYSDATE, -3)
  FROM DUAL;--현재 시각에 n2만큼 개월을 더한다. 음수를 넣으면 빼준다.  
  
SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 3)) mon1, 
       MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 3), SYSDATE) mon2
  FROM DUAL;--일반적으로 mon2처럼 미래의 날짜를 앞에 적어준다.    
  
SELECT LAST_DAY(SYSDATE)
  FROM DUAL;--해당월의 마지막 날짜를 반환  
  
SELECT SYSDATE, ROUND(SYSDATE, 'month'), TRUNC(SYSDATE, 'month')
  FROM DUAL;--round는 날짜에서도 반올림을 한다. trunc는 버림을 해서 1일이 된다.
  --여기서 묵시적 형변환은 적용이 안된다. 16일부터 올림처리되어 다음달이 된다.
  
SELECT NEXT_DAY(SYSDATE, '토요일')
  FROM DUAL;--요일을 적으면 다음에 오는 그 요일의 날짜를 반환한다.
-------------------------------------------------------------------------------  