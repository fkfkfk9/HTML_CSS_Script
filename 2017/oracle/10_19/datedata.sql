--------------------------- 날짜 데이터 타입---------------------------
CREATE TABLE DATE_EX (
    COL_DATE       DATE,
    COL_TIMESTAMP  TIMESTAMP
);
-- SYSDATE, SYSTIMESTAMP 날짜 정보를 읽어오는 함수
INSERT INTO DATE_EX VALUES (SYSDATE, SYSTIMESTAMP);

SELECT *
FROM DATE_EX;

--현재 시스템의 날짜 정보를 읽어온다.
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
--------------------------------------------------------------------------