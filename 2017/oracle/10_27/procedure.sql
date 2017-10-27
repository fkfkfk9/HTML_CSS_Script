--------------------------------- 프로시저 생성 ----------------------------------
/*
    CREATE OR REPLACE PROCEDURE 프로시저명
        (   매개변수 [IN or out or IN OUT] 데이터 타입,   
            매개변수2 [IN or out or IN OUT] 데이터 타입,   
            ......                                  )
            IN은 입력 OUT는 출력 IN OUT는 입출력을 동시에 가능
    IS(AS)
    변수, 상수 선언
    BEGIN
    END;
*/

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
-- 프로시저 실행
exec pr_new_department('게임 공학과', '블리자드', '001-123-4567', '2005-01-01');
exec pr_new_department('VR', '', '011-146-7345', sysdate);
exec pr_new_department('운영체제', '빌 게이츠', '', '1997-01-01');
select * from classes;
select * from department;
select SEQ_ST_CODE_07.currval from dual;

--프로시저에는 함수를 사용할 수 있지만 함수에서는 프로시저를 쓰지 않는다.

--프로시저를 생성할때는 기능을 한개만 구현목적으로 만들어라 
CREATE OR REPLACE PROCEDURE pr_new_department
        ( p_dep_code    IN department.dep_code%TYPE,
          p_dep_name    IN department.dep_name%TYPE,
          p_dean_name   IN department.dean_name%TYPE,
          p_dep_call    IN department.dep_call%TYPE,
          p_create_date IN department.create_date%TYPE := sysdate )--디폴트값을 정할 수 있다.
IS
    vi_check number := 0;--기존에 있는 id인지 체크한다.
BEGIN
    select count(dep_code)--검색된 id 개수
    into vi_check--id개수 삽입
    from department
    where dep_code = p_dep_code;--입력받은 id와 비교
    
    IF vi_check = 0 THEN--일치하는 수치가 없으면 insert
        INSERT INTO department
        values(p_dep_code, p_dep_name, p_dean_name, p_dep_call, p_create_date);
    else
        UPDATE department--있다면 id를 제외한 나머지를 업데이트
	      SET dep_name   = p_dep_name,
	          dean_name  = p_dean_name,
	          dep_call  = p_dep_call,
	          create_date = p_create_date
	    WHERE dep_code = p_dep_code;
    end If;    
    commit;
end;

exec pr_new_department(10100, '스마트폰', '김상기', '001-123-4678', '2010-01-01');
exec pr_new_department(10100, '스마트폰', '홍길동', '001-123-4678');--날짜를 안적어도 sysdate가 들어감
select * from department;
--------------------------------------------------------------------------------