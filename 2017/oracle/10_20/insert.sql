----------------------- INSERT ---------------------------
--입력문 INSERT INTO 테이블명(컬럼명,컬럼명....) VALUES(값, 값,....);
--컬럼명 갯수와 값의 갯수는 동일해야 한다. 순서도 동일해야 한다.
CREATE TABLE insert_test (
    itcol1   VARCHAR2(10), --NULL은 생략
    itcol2   NUMBER,
    itcol3   DATE    );
--컬럼명이 생략된 경우 모든 컬럼을 입력하는 경우이다.    
INSERT INTO insert_test (itcol1, itcol2, itcol3)
VALUES ('test', 8, SYSDATE);  
INSERT INTO insert_test
VALUES ('test', 8, SYSDATE);  
select * from insert_test;
--컬럼순서를 바꾸면 값도 순서를 바꾸면 오류가 안생긴다.
INSERT INTO insert_test (itcol3, itcol1, itcol2)
VALUES (SYSDATE, 'temp', 13);  
select * from insert_test;
--컬럼의 순서가 맞다고 해도 값이 컬럼과 데이터형이 다르면 오류
INSERT INTO insert_test (itcol1, itcol2, itcol3)
VALUES ('EX', 33, 28);  --마지막 값은 date형식이 와야한다.
--'2017-10-20'문자열 데이터가 date형에 맞게 내부적으로 변환이 되었다.
--이렇게 알아서 형변환되어 삽입되는걸 묵시적 형변환이라 한다.
INSERT INTO insert_test (itcol1, itcol2, itcol3)
VALUES ('EX', 33, '2017-10-20');
--컬럼명 생략
INSERT INTO insert_test 
VALUES ('GHI', 10, SYSDATE);  
--itcol3 컬럼명이 null이거나 default명령어가 있다면 생략가능
INSERT INTO insert_test  (itcol1, itcol2 )
VALUES ('yjh', 22);
--값을 모두 넣지 않는다면 컬럼명 생략은 안된다.
INSERT INTO insert_test  
VALUES ('str', 33);

CREATE TABLE insert_employee (
       ie_id    NUMBER,
       ie_name  VARCHAR2(100));
--insert~select 반드시 테이블이 존재해야함
INSERT INTO insert_employee ( ie_id, ie_name )
SELECT employee_id, emp_name--셀렉트문이 values역할을 한다.
 FROM employees--셀렉트한 데이터와 입력할 데이터의 형이 같아야한다.
WHERE salary > 8800;
select * from insert_employee;    
/*위의것과 결과가 같다.
    create table employee_copy as
    SELECT employee_id, emp_name
    FROM employees
    WHERE salary > 8800;    
*/
desc insert_test;--테이블 정보를 보는 명령어
INSERT INTO insert_test (itcol1, itcol2, itcol3)
VALUES (10, '77', '1988-11-03');
--값의 형이 틀리지만 묵시적 형 변환이 일어난다.
select * from insert_test;
----------------------------------------------------