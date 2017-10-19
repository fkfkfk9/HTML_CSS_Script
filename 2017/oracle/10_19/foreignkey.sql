------------------------- FOREIGN KEY(외래키) ------------------------------
--참조키 다른 테이블의 데이터를 참조하여 데이터의 유효성을 확인한다.

--부서테이블(DEPT)
CREATE TABLE DEPT(
    B_CODE  NUMBER          PRIMARY KEY,
    B_NAME  VARCHAR2(20)    NOT NULL
);
--사원 테이블
CREATE TABLE EMPLOYEE(
    S_ID    NUMBER          PRIMARY KEY,
    S_NAME  VARCHAR2(15)    NOT NULL,
    B_CODE  NUMBER          REFERENCES DEPT(B_CODE) --컬럼별 수준 제약
    /*테이블 수준 제약
    B_CODE  NUMBER          NOT NULL,
    CONSTRAINT  FK_DEPT_B_CODE  FOREIGN KEY(B_CODE)
    REFERENCES DEPT(B_CODE)*/
);
SELECT constraint_name, constraint_type, table_name, search_condition
  FROM user_constraints
 WHERE table_name = 'EMPLOYEE';
 
 drop table EMPLOYEE;--테이블 삭제
 --DB는 데이터입력시 ''작은따옴표를 써준다.
 
INSERT INTO DEPT VALUES(100,'총무부');
INSERT INTO DEPT VALUES(101,'인사부');
INSERT INTO DEPT VALUES(102,'마케팅부');
INSERT INTO DEPT VALUES(103,'홍보부');

select * from dept;

INSERT INTO EMPLOYEE VALUES(1,'홍길동', 100);
INSERT INTO EMPLOYEE VALUES(2,'유종현', '');
--NOT NULL을 하지 않았기 때문에 NULL값도 된다. 보통 신입이 부서가 없는경우 사용
INSERT INTO EMPLOYEE VALUES(3,'박지성', 105);
--105번은 부서에 없는 데이터기 때문에 오류 발생한다.
select * from EMPLOYEE;
---------------------------------------------------------------------------