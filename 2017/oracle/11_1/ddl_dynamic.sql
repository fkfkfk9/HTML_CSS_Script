------------------------- DDL문과 ALTER SESSION ---------------------------------
CREATE OR REPLACE PROCEDURE proc_ddl_ex ( 
            pd_vd IN DATE )
IS
BEGIN	
	 DBMS_OUTPUT.PUT_LINE('pd_vd : ' || pd_vd);
END;


CREATE OR REPLACE PROCEDURE proc_ddl_ex ( 
                            pd_vd IN DATE )
IS
BEGIN
	 CREATE TABLE ddl_table_ex ( vs VARCHAR2(30));	--ddl문은 pl/sql문에서 실행이 안된다.
	 DBMS_OUTPUT.PUT_LINE('pd_vd : ' || pd_vd);
END;

CREATE OR REPLACE PROCEDURE proc_ddl_ex ( 
            pd_vd IN DATE )
IS
  vs_query VARCHAR2(1000);
BEGIN
	 --동적 SQL을 사용하면 오류없이 DDL문도 실행 가능하다.
	 vs_query := 'CREATE TABLE ddl_table_ex ( vs VARCHAR2(30))' ;
	 EXECUTE IMMEDIATE vs_query;
	 
	 DBMS_OUTPUT.PUT_LINE('pd_vd : ' || pd_vd);
END;

EXEC proc_ddl_ex ( SYSDATE );--create any table권한이 없다면 할 수 없다.
--이럴 경우 system계정으로 들어가 권한을 부여해줘야 실행 할 수 있다.
select * from ddl_table_ex;

CREATE OR REPLACE PROCEDURE proc_ddl_ex ( 
                            pd_vd IN DATE )
IS
  vs_query VARCHAR2(1000);
BEGIN
	 -- ALTER SESSION을 이용해 date포멧의 출력 방법을 바꿧다.
     -- ALTER SESSION는 DDL과 마찬가지로 동적 SQL을 통해서만 PL/SQL에서 사용가능
	 vs_query := 'ALTER SESSION SET NLS_DATE_FORMAT = "YY/MM/DD"';
	 EXECUTE IMMEDIATE vs_query;
	 
	 DBMS_OUTPUT.PUT_LINE('pd_vd : ' || pd_vd);
END; 