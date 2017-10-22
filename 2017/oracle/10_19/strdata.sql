-------------------문자열 데이터타입--------------------
CREATE TABLE CHAR_EX (
    CCOL    CHAR(10), --NULL이 생략됨 기본값
    VCCOL    VARCHAR2(10),
    NVCCOL    NVARCHAR2(10),
    NUM    NUMBER
);

-- 데이터 타입
-- 데이타 크기: 영문 1문자 1바이트, 한글은 1문자 2바이트 또는 3바이트(설정에따라)
INSERT INTO CHAR_EX ( column1, column2 ) VALUES ('str', 'str');

SELECT column1, LENGTH(column1) as len1,
 column2, LENGTH (column2) as len2
FROM CHAR_EX;
-------------------------------------------------