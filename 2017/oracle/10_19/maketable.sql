----------------- 테이블 만들어 보기 --------------------
/*
    문법:
    create table 테이블명
    (
        컬럼명     데이타타입 [NULL OR NOT NULL],
        컬럼명     데이타타입
    );
*/

CREATE TABLE MEMBER2 (
    USERID      VARCHAR2(12)    NOT NULL,
    PASSWD      VARCHAR2(12)    NOT NULL,
    EMAIL       VARCHAR2(50)    NULL,
    ADDR        VARCHAR2(100)   NULL,
    AGE         NUMBER          NOT NULL,
    REGDATE     DATE            NOT NULL
);
-----------------------------------------------------