--------------------------------- 시퀀스 ----------------------------------------
--시퀀스도 데이터베이스 객체이다.
CREATE SEQUENCE seq_ex --pk등 분별하는 자료에서 숫자가 1씩 자동증가 시켜주는 기능
START WITH 20070001 --시작하는 숫자
INCREMENT BY 1 --증가값
MINVALUE 20070001 --최소값
MAXVALUE 20079999 --최대값
NOCYCLE --cycle, nocycle 반복할것인가 안할것인가
NOCACHE; --cache, nocache 

create table student(
    st_num  number primary key,
    st_name varchar2(30)
);
drop table student;
INSERT INTO student (st_num) VALUES ( seq_ex.NEXTVAL);
INSERT INTO student VALUES (seq_ex.NEXTVAL, '홍길동');
INSERT INTO student VALUES (2, '홍길동2');
SELECT * FROM student;
--.nextval 다음 증가값을 가져온다.
SELECT seq_ex.CURRVAL FROM DUAL;
--.currval 현재 시퀀스값이 얼마인지 보여준다.
SELECT seq_ex.NEXTVAL FROM DUAL;    
    
DROP SEQUENCE seq_ex;
--------------------------------------------------------------------------------