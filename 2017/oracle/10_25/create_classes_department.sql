drop table classes;
drop table department;

create table department(
	dep_code 	NUMBER primary key,
	dep_name	varchar2(50) NOT NULL,
	dean_name	varchar2(20),
	dep_call	varchar2(20),
	create_date	date NOT NULL
);
create table classes(
	st_code		number primary key,
	st_name		varchar2(20) NOT NULL,
	dep_code	number REFERENCES department(dep_code),
	st_grade	number,
	st_gender	varchar2(20) CHECK ( st_gender IN ('남자', '여자')),	
	st_phone	varchar2(20),
	st_birth	date,
	st_addr		varchar2(50)
);
create table professors(
	pf_code		number primary key,
	pf_name		varchar2(20) NOT NULL,
	dep_code	number REFERENCES department(dep_code),
	pf_rank		varchar2(20),
	pf_phone	varchar2(20),
	pf_birth	date,
	pf_major	varchar2(30)
);
create table subjects(
	sub_code		number primary key,
	sub_name		varchar2(50) NOT NULL,
	dep_code		number REFERENCES department(dep_code),
	pf_code			number REFERENCES professors(pf_code),
	pf_phone		varchar2(20),
	sub_peple		number,
	sub_credit		number check (sub_credit BETWEEN 1 AND 3),
	sub_schedule  	varchar2(50)
);

CREATE SEQUENCE SEQ_ST_CODE_07 --07학번용 시퀀스 
START WITH      20070001 
INCREMENT BY    1;

CREATE SEQUENCE SEQ_ST_CODE_08 --08학번용 시퀀스 
START WITH      20080001 
INCREMENT BY    1;

CREATE SEQUENCE SEQ_ST_CODE_09 --09학번용 시퀀스 
START WITH      20090001 
INCREMENT BY    1;

CREATE SEQUENCE SEQ_ST_CODE_10 --10학번용 시퀀스 
START WITH      20100001 
INCREMENT BY    1;

CREATE SEQUENCE SEQ_ST_CODE_11 --11학번용 시퀀스 
START WITH      20110001 
INCREMENT BY    1;

CREATE SEQUENCE SEQ_DEP_CODE --학과용 시퀀스 
START WITH      10000 
INCREMENT BY    100;

insert into department
values (SEQ_DEP_CODE.nextval, '컴퓨터 공학과', '홍길동', '000-000-0000', '1998-11-03');
insert into department (dep_code, dep_name, dep_call, create_date)
values (SEQ_DEP_CODE.nextval, '모바일 소프트웨어', '010-001-1111', '2007-03-01');
insert into department (dep_code, dep_name, dean_name, create_date)
values (SEQ_DEP_CODE.nextval, '정보보호', '알파고', sysdate);
insert into classes
values (SEQ_ST_CODE_07.nextval, '유종현', 10200, 3.8,'남자', '010-4590-5395','1988-11-03',
'경기도 안양시 동안구');
insert into classes (st_code, st_name, dep_code, st_grade, st_gender)
values (SEQ_ST_CODE_07.nextval, '박지성', 10100, 2, '남자');
insert into classes (st_code, st_name, dep_code, st_grade, st_gender, st_birth, st_addr)
values (SEQ_ST_CODE_07.nextval, '김태희', 10200, 4.5, '여자', '1980-01-01','서울시');

CREATE OR REPLACE PROCEDURE pr_new_department
        ( p_dep_name    IN department.dep_name%TYPE,
          p_dean_name   IN department.dean_name%TYPE,
          p_dep_call    IN department.dep_call%TYPE,
          p_create_date IN department.create_date%TYPE )
IS
BEGIN
    INSERT INTO department
    values(SEQ_DEP_CODE.nextval, p_dep_name, p_dean_name, p_dep_call, p_create_date);
    commit;
end;

exec pr_new_department('게임 공학과', '블리자드', '001-123-4567', '2005-01-01');
exec pr_new_department('VR', '', '011-146-7345', sysdate);
select * from department;