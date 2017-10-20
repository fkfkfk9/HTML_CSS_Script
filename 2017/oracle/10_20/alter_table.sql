--------------------------- 테이블 변경 -------------------------
--alter table 테이블
CREATE TABLE DEFAULT_EX (
   id        VARCHAR2(10) NOT NULL, 
   name      VARCHAR2(10) NULL, 
   join_date DATE DEFAULT SYSDATE);
   
--컬럼명을 변경 id -> user_id
ALTER TABLE DEFAULT_EX RENAME COLUMN id TO user_id;
--테이블 구조 확인
DESC DEFAULT_EX;
--name컬럼의 데이터형의 크기를 변경
--데이터가 들어있는대 크기를 줄인다면 오류가 날 수 있다.
ALTER TABLE DEFAULT_EX MODIFY name VARCHAR2(30);

DESC DEFAULT_EX;
--컬럼을 추가
ALTER TABLE DEFAULT_EX ADD hit NUMBER;

DESC DEFAULT_EX;
--컬럼을 삭제
ALTER TABLE DEFAULT_EX DROP COLUMN hit ;

DESC DEFAULT_EX;
--제약조건 추가 현제 입력받은 데이터들이 pk를 지키고 있지 않다면 불가능
ALTER TABLE DEFAULT_EX ADD CONSTRAINTS pk_default_ex PRIMARY KEY (USER_ID);

SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'DEFAULT_EX';
 
ALTER TABLE DEFAULT_EX DROP CONSTRAINTS pk_default_ex;

SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'DEFAULT_EX';
 ---------------------------------------------------------------------