------------------------- CHECK --------------------------------------
--입력받을 데이터의 조건을 넣고 체크하여 범위 밖의 데이터는 입력받지 않는다.
CREATE TABLE CHECK_EX (
    num     NUMBER 
        CONSTRAINTS check_ex1 CHECK ( num BETWEEN 1 AND 8),
        --제약조건명은 같은 테이블 스페이스상 다른 테이블에서 사용했던 네이밍을 쓸 수 없다.
    gender   VARCHAR2(10) 
        CONSTRAINTS check_ex2 CHECK ( gender IN ('MALE', 'FEMALE'))        
); 
/*
    CONSTRAINTS check1 CHECK ( num BETWEEN 1 AND 8),에서
    CONSTRAINTS check1 부분을 지우고 CHECK ( num BETWEEN 1 AND 8) 만 쓸 수 있다.
    대신 체크 객체에 이름을 못 적는다.
*/

SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'CHECK_EX';
 
INSERT INTO CHECK_EX VALUES (10, 'MAN');

INSERT INTO CHECK_EX VALUES (5, 'FEMALE');

select * from CHECK_EX;
------------------------------------------------------------------------