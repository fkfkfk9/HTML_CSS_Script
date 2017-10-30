---------------------------------- 명시적 커서 -----------------------------------
DECLARE 
  --vi_dep_code department.dep_code%TYPE := 10100;
  vs_st_name classes.st_name%TYPE;
  --1단계 커서선언
  --커서 선언 매개변수는 필요하면 쓰고 없다면 안써도 된다.
  CURSOR cor_dep_st(cp_dep_code classes.dep_code%type)
  IS--절대로 셀렉트문만 사용가능 하다.
  SELECT st_name
  from classes
  where dep_code = cp_dep_code;
BEGIN
    --2단계 : 커서 오픈
    open cor_dep_st(10200);--위에 정의해놓은 커서를 오픈한다.
    LOOP
        --3단계 : 패치단계에서 커서 작용 순차적으로 접근함
        FETCH cor_dep_st INTO vs_st_name;--커서의 구문의 결과값을 넣어준다.  
        EXIT WHEN cor_dep_st%NOTFOUND;--남은 행이 없다면 루프문 탈출
        DBMS_OUTPUT.PUT_LINE(vs_st_name);--저장된 변수값을 출력
    END LOOP;
    --4단계 커서 닫기
    CLOSE cor_dep_st;--커서를 닫아준다.
END;	
	
-- 커서와 FOR문
DECLARE   
  vs_st_name classes.st_name%TYPE; 
  CURSOR cor_dep_st(cp_dep_code classes.dep_code%type)
  IS
  SELECT st_name
  from classes
  where dep_code = cp_dep_code;
BEGIN    
    FOR classes_dep IN cor_dep_st(10100)--커서를 오픈하지 않고 포문에서 직접 불러옴
        LOOP--for문보단 loop문 권장 다른 db에서도 비슷하게 사용되기 때문
          DBMS_OUTPUT.PUT_LINE(classes_dep.st_name);	
        END LOOP;
END;	

DECLARE
BEGIN
	--커서 정의 부분을 FOR문에 직접 기술
	FOR classes_dep IN ( SELECT st_name
                     FROM classes
                    WHERE dep_code = 10200 ) 
	LOOP
	  DBMS_OUTPUT.PUT_LINE(classes_dep.st_name);	
    END LOOP;
END;
--DBMS_OUTPUT.PUT_LINE은 인수가 하나만 가능하다(인수, 인수)이런식은 불가능하다.
--두개의 인수를 사용하겠다면 (인수 || 인수)로 해야한다.
--------------------------------------------------------------------------------