---------------- 테이블 삭제 -------------------
/*
    drop table 테이블명;
*/
DROP TABLE DEFAULT_EX;

---------------------------------------------------------------------
---------------------------- 테이블 복사 -------------------------------
CREATE TABLE CHECK_EX_TEST AS
SELECT *
FROM CHECK_EX;
desc CHECK_EX_TEST;
select * from CHECK_EX_TEST;
--복사해온 테이블의 구조와 데이터까지 복사한다.
SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'CHECK_EX_TEST';
 --제약조건까지 복사하지는 못한다.
--------------------------------------------------------------------------