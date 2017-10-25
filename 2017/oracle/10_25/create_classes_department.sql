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

insert into department
values (100, '컴퓨터 공학과', '홍길동', '000-000-0000', '1998-11-03');
insert into department (dep_code, dep_name, dep_call, create_date)
values (200, '모바일 소프트웨어', '010-001-1111', '2007-03-01');
insert into department (dep_code, dep_name, dean_name, create_date)
values (300, '정보보호', '알파고', sysdate);
insert into classes
values (20070001, '유종현', '200', '남자', '010-4590-5395','1988-11-03',
'경기도 안양시 동안구');
insert into classes (st_code, st_name, dep_code, st_gender)
values (20070002, '박지성', '100', '남자');
insert into classes (st_code, st_name, dep_code, st_gender, st_birth, st_addr)
values (20070003, '김태희', '200', '여자', '1980-01-01','서울시');