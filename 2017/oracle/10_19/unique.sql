------------------------------ UNIQUE -------------------------------------  
--컬럼에 고유한 값을 지정할 때, 동일한 데이터가 중복이 불가능하다.
CREATE TABLE unique_ex (
    UQCOL   VARCHAR2(10) UNIQUE, --컬럼별 수준 제약
    UQNNCOL2   VARCHAR2(10) UNIQUE NOT NULL, 
    COL3   VARCHAR2(10), 
    CONSTRAINTS unique_num1 UNIQUE ( COL3)--테이블 수준 제약
-- 제약조건 키워드| 제약조건 객체명 | 제약명령어(컬럼)
-- 제약조건 객체명은 직접 만드는것 컬럼별 수준 제약을 넣을 경우 임의의 값이 들어감
-- 제약조건을 관리하고 싶다면 테이블 수준 제약을 넣어야 한다.
); 
--제약조건도 데이터 베이스 객체이다.
--테이블에 대한 제약조건 정보를 본다.
SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'UNIQUE_EX';
 
INSERT INTO unique_ex VALUES ('num', 'num', 'num');

INSERT INTO unique_ex VALUES ('num', 'num', 'num');

INSERT INTO unique_ex VALUES ('', 'int', 'int');

INSERT INTO unique_ex VALUES ('', 'str', 'str');
--NULL은 계속 넣을 수 있다.
select * from unique_ex;
------------------------------------------------------------------------