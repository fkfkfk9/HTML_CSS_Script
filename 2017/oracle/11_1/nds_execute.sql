------------------------------------- NDS --------------------------------------
-- (1) EXECUTE IMMEDIATE -- 동적쿼리를 실행하기 위한 명령어
begin
    EXECUTE IMMEDIATE 'select st_code, st_name, dep_code 
                        from classes where dep_code = ''10100''';
end;

-- 값 출력
DECLARE
  --출력 변수 선언 
  vi_st_code    classes.st_code%TYPE;
  vs_st_name    classes.st_name%TYPE;
  vi_dep_code   classes.dep_code%TYPE;
BEGIN
        EXECUTE IMMEDIATE 'select st_code, st_name, dep_code  
                            from classes where dep_code = ''10100'''
                            INTO vi_st_code, vs_st_name, vi_dep_code;
                            --검색된걸 INTO뒤의 변수에 전달 타입, 순서가 같아야 한다.
  DBMS_OUTPUT.PUT_LINE( '학번 : '   || vi_st_code );	          
  DBMS_OUTPUT.PUT_LINE( '학생이름 : ' || vs_st_name );	 
  DBMS_OUTPUT.PUT_LINE( '학과코드 : '   || vi_dep_code );
END;

-- SQL문을 변수로 저장해서 사용한다.
DECLARE
  --출력 변수 선언 
  vi_st_code    classes.st_code%TYPE;
  vs_st_name    classes.st_name%TYPE;
  vi_dep_code   classes.dep_code%TYPE;
  
  vs_query VARCHAR2(1000);
BEGIN
	-- SQL문을 변수에 담는다. 
	vs_query := 'select st_code, st_name, dep_code 
                        from classes where dep_code = ''10100''';	
  EXECUTE IMMEDIATE vs_query INTO vi_st_code, vs_st_name, vi_dep_code;
  --쿼리를 담은 변수를 동적쿼리 실행명령어로 실행하여 검색된값을 변수에 전달
  DBMS_OUTPUT.PUT_LINE( '학번 : '   || vi_st_code );	          
  DBMS_OUTPUT.PUT_LINE( '학생이름 : ' || vs_st_name );	 
  DBMS_OUTPUT.PUT_LINE( '학과코드 : '   || vi_dep_code );         
END;
--------------------------------------------------------------------------------