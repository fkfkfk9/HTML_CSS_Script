----------------------- OUT, IN OUT 매개변수 사용 --------------------------------
create table meminfo(
    m_no            number primary key,
    m_name          varchar2(30) NOT NULL,
    m_job           varchar2(30) NULL,
    m_create_date   date NOT NULL,
    m_update_date   date NOT NULL
);

CREATE SEQUENCE SEQ_MEMINFO_M_NO 
START WITH      1
INCREMENT BY    1;

insert into meminfo 
values(SEQ_MEMINFO_M_NO.nextval, '홍길동', '가수', sysdate, sysdate);
select * from meminfo;

CREATE OR REPLACE PROCEDURE udp_meminfo_ins
        ( p_m_name          IN meminfo.m_name%TYPE,
          p_m_job           IN meminfo.m_job%TYPE)
          --직접 사이즈를 잡아줄 때는 vachar2만 적고 사이즈를 적지 않는다.
IS
BEGIN
    INSERT INTO meminfo
    values(SEQ_MEMINFO_M_NO.nextval, p_m_name, p_m_job, sysdate, sysdate);
    commit;
end;

exec udp_meminfo_ins('유종현', '백수', sysdate, sysdate);
exec udp_meminfo_ins( p_m_job => '축구 행정가', p_m_name => '박지성');
--직접 변수명을 선택해서 값을 넣어줄수도 있다.
select * from meminfo;

desc meminfo;
CREATE OR REPLACE PROCEDURE udp_meminfo_ins
        ( p_m_name  IN  meminfo.m_name%TYPE,
          p_m_job   IN  meminfo.m_job%TYPE,
          p_m_date  out meminfo.m_update_date%type,  
          p_m_no    IN OUT meminfo.m_no%type )
      
IS
    vd_m_date meminfo.m_update_date%TYPE := sysdate;
BEGIN
    INSERT INTO meminfo
    values(SEQ_MEMINFO_M_NO.nextval, p_m_name, p_m_job, vd_m_date, vd_m_date);
    p_m_date := vd_m_date;
    dbms_output.put_line('입력매개 용도의 번호? ' || TO_CHAR(p_m_no));
    p_m_no := SEQ_MEMINFO_M_NO.currval;
    commit;
end;
--out 매개변수 사용시 프로시저 실행구문
DECLARE--익명구문
   vd_m_date meminfo.m_update_date%TYPE;
   vd_m_no  meminfo.m_no%type := 1;
BEGIN
	 udp_meminfo_ins('마동석', '배우', vd_m_date, vd_m_no);
	 --익명함수에서 프로시저 실행시 exec를 제외하고 한다.
	 DBMS_OUTPUT.PUT_LINE('가입날짜 :' || vd_m_date);
     DBMS_OUTPUT.PUT_LINE('현재 시퀀스 :' || vd_m_no);
END;

CREATE OR REPLACE PROCEDURE p_in_out_test (
               p_in            VARCHAR2, --생략하면 디폴트는 in
               p_out    OUT    VARCHAR2,
               p_in_out IN OUT VARCHAR2 ) --두가지 기능을 전부 다
IS
BEGIN
	 DBMS_OUTPUT.PUT_LINE('p_in value = ' || p_in);
	 DBMS_OUTPUT.PUT_LINE('p_out value = ' || p_out);
	 DBMS_OUTPUT.PUT_LINE('p_in_out value = ' || p_in_out);
	 
	 p_out := '아웃';
	 p_in_out := '인엔아웃';	
END;               

DECLARE 
   v_in VARCHAR2(10) := 'in test';
   v_out VARCHAR2(10) := 'out test'; --내용을 넣었지만 out이기 때문에 값전달은 안됨
   v_in_out VARCHAR2(20) := 'in and out test';
BEGIN
	 my_parameter_test_proc (v_in, v_out, v_in_out);
	 
	 DBMS_OUTPUT.PUT_LINE('v_out value = ' || v_out);
	 DBMS_OUTPUT.PUT_LINE('v_in_out value = ' || v_in_out);
END;
--------------------------------------------------------------------------------