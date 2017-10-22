----------------------------NUT NULL EX-----------------------------------
--제약조건(Contraint)
--NOT NULL : 컬럼에 데이터를 반드시 입력해야 할 때 사용
CREATE TABLE NNULL_EX (
    NCOL       VARCHAR2(10),
    NNCOL   VARCHAR2(10) NOT NULL
);
--'' 즉 공백문자는 NULL을 의미한다. 오라클에서만
INSERT INTO NNULL_EX VALUES ('int', NULL);
--ORA-01400: cannot insert NULL into ("ORA_USER"."EX2_6"."COL_NOT_NULL")
--COL_NOT_NULL에는 NULL을 넣을 수 없다.
INSERT INTO NNULL_EX VALUES ('int', 'str');
--데이터 삽입 성공
INSERT INTO NNULL_EX VALUES ('', 'num');
--기본값이 NULL이라 삽입 성공

SELECT * FROM NNULL_EX;

--user_constraints: 테이블에 제약조건 정보를 볼때 사용하는 테이블
SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'NNULL_EX';
---------------------------------------------------------------------------