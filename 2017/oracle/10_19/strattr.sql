-------------------문자열 속성---------------------
CREATE TABLE VARCHAR2_EX (
    VCCOL    VARCHAR2(3),
    VCBCOL    VARCHAR2(3 byte),
    VCCCOL    VARCHAR2(3 char)
);

INSERT INTO VARCHAR2_EX VALUES ('int', 'str', 'num');

SELECT column1, LENGTH(column1) AS len1, 
       column2, LENGTH(column2) AS len2, 
       column3, LENGTH(column3) AS len3
FROM VARCHAR2_EX;

--ORA-12899: value too large for column "ORA_USER"."EX2_2"."COLUMN1" (actual: 9, maximum: 3)
--3바이트로 크기를 정했는대 한글은 1글자가 3바이트 3글자는 9바이트라 메모리 사이즈를 넘어감
INSERT INTO VARCHAR2_EX VALUES ('유종현', '유종현', '유종현');

INSERT INTO VARCHAR2_EX (column3) VALUES ('유종현');

SELECT column3, LENGTH(column3) AS len3, LENGTHB(column3) AS bytelen
FROM VARCHAR2_EX;
---------------------------------------------------------------------