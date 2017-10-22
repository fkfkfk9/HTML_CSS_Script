---------------------------- 기본키  -----------------------------------
-- NOTNULL + 데이터 중복방지 + 테이블당 한개만 생성가능
CREATE TABLE primary_ex (
    COL1   VARCHAR2(10) PRIMARY KEY, 
    COL2   VARCHAR2(10) 
); 
CREATE TABLE primary_ex2 (
    COL1   VARCHAR2(10), 
    COL2   VARCHAR2(10),
    CONSTRAINTS PK_EX1_COL1 PRIMARY KEY(COL1)
); 

SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'PRIMARY_EX';--대문자로 검색해야 한다.
 
 SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'PRIMARY_EX2';--테이블수준 제약을 해서 제약조건 이름을 만들수 있다.
 --널값은 PK에 들어가지 않는다.
INSERT INTO primary_ex VALUES ('', 'temp');
--정상 실행
INSERT INTO primary_ex VALUES ('temp', 'temp'); 
--처음 실행은 들어가지만 한번 더 실행한다면 데이터 중복으로 오류가 난다.
select * from PRIMARY_EX;
------------------------------------------------------------------------
------------------2개의 컬럼을 기본키로 하기--------------------------------
CREATE TABLE PK_EXAM(
    NUM1        CHAR(1),
    NUM2        CHAR(1),
    CONSTRAINTS PK_EXAM_NUM1_NUM2 PRIMARY KEY(NUM1, NUM2)
 );--두컬럼에 NULL값은 들어갈 수 없다.
 --두 컬럼 모두 값이 같지만 않으면 값을 넣을 수 있다.
 --기본키로 묶을 수 있는 최대 컬럼수는 32개이다.
 SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'PK_EXAM';
 
INSERT INTO PK_EXAM VALUES('a','a');
--하나의 값이 같아도 삽입된다.
INSERT INTO PK_EXAM VALUES('a','b');

INSERT INTO PK_EXAM VALUES('b','a');
--두 값이 전부 같으면 삽입되지 않는다.
INSERT INTO PK_EXAM VALUES('a','b');
select * from PK_EXAM;
---------------------------------------------------------
-----------------------다중PK 테이블 만들기-----------------------------------
CREATE TABLE PK_TEST01(
    NUM1    NUMBER,
    NUM2    NUMBER,
    NUM3    NUMBER,
    NUM4    NUMBER,
    CONSTRAINTS PK2_TEST01_THREE PRIMARY KEY(NUM1, NUM2, NUM3)
);
INSERT INTO PK_TEST01 VALUES(1,1,1,1);
INSERT INTO PK_TEST01 VALUES(1,0,1,0);
INSERT INTO PK_TEST01 VALUES(0,1,0,1);
--3개가 pk인대 바로위의 3개값과 같아서 4번째 값이 다름에도 오류가 난다.
INSERT INTO PK_TEST01 VALUES(0,1,0,0);
select * from PK_TEST01;
---------------------------------------------------------------------------