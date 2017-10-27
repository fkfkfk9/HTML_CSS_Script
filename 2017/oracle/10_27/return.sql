----------------------------------- RETURN 문 ----------------------------------
--반환값을 목적으로 사용하는것이 아니라 프로시저를 종료하기 위해 사용한다.
CREATE OR REPLACE PROCEDURE proc_return_test
            (   p_m_name  IN  meminfo.m_name%TYPE,
                p_m_job   IN  meminfo.m_job%TYPE,
                p_m_date  out  meminfo.m_update_date%type,  
                p_m_no    IN  meminfo.m_no%type ) 
IS
    vd_m_date meminfo.m_update_date%TYPE := sysdate;
BEGIN
    IF p_m_no > SEQ_MEMINFO_M_NO.currval then
        dbms_output.put_line('바로종료');
        return;--밑에 구문들을 무시하고 바로 종료 시켜버린다.
    END IF;
    
    INSERT INTO meminfo
    values(SEQ_MEMINFO_M_NO.nextval, p_m_name, p_m_job, vd_m_date, vd_m_date);
    p_m_date := vd_m_date;
    dbms_output.put_line('입력매개 용도의 번호? ' || TO_CHAR(p_m_no));
    commit;
end;

DECLARE
     vd_m_date meminfo.m_update_date%TYPE;
BEGIN
	 proc_return_test('마동석', '배우', vd_m_date, 10);
	 --익명함수에서 프로시저 실행시 exec를 제외하고 한다.
	 DBMS_OUTPUT.PUT_LINE('가입날짜 :' || vd_m_date);
END;
--------------------------------------------------------------------------------