-------------------- 학과테이블 만들어보기 --------------------
create table department(
	dep_code	NUMBER	PRIMARY KEY,
	subject     VARCHAR2(50)
    /*테이블 수준 제약
    dep_code	NUMBER NOT NULL,
    CONSTRAINTS PK_DEP_CODE PRIMARY KEY(dep_code)
    */
);

create table classes(
	student_num		NUMBER PRIMARY KEY,
	student_name	VARCHAR2(20),
	dep_code REFERENCES department(dep_code)
     /*테이블 수준 제약 
     dep_code  NUMBER          NOT NULL, 
     CONSTRAINT  FK_DEP_CODE  FOREIGN KEY(dep_code) 
     REFERENCES department(dep_code)*/ 

);

insert into department values(100, '자바');
insert into department values(200, '스프링 프레임웍');
insert into department values(300, '오라클');
insert into department values(400, '자바스크립트');
select * from department;
insert into classes values(2017001, '홍길동', 100);
insert into classes values(2017002, '이순신', 200);
insert into classes values(2017003, '박찬호', 100);
insert into classes values(2017004, '이승엽', 400);
select * from classes;
---------------------------------------------------------------