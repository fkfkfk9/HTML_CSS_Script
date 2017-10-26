--******************************* PL/SQL *************************************--
--------------------------------- 익명블록 --------------------------------------
--선언부
DECLARE--변수를 선언하는 키워드 DECLARE 변수명 데이터타입;
   num NUMBER;
--실행부
BEGIN --일반 프로그래밍 언어의 {의미
   num := 88; -- := 대입
   -- 자바스크립트의 document.write()와 유사한 성격
   DBMS_OUTPUT.PUT_LINE(num);--변수의 값을 확인 DBMS_OUTPUT패키지 PUT_LINE프로시저

--예외처리부(지금은 빠짐)
END;-- }을 의미 즉 main{}가 begin end이 된것이다.
--------------------------------------------------------------------------------
---------------------------------- 연산자 ---------------------------------------
DECLARE
  num INTEGER := 2**10+13**2;
BEGIN
    DBMS_OUTPUT.PUT_LINE('num = ' || to_char(num));
  --DBMS_OUTPUT.PUT_LINE('num = ' || num);결과는 같지만 내부적인 형변환이 발생
END;
--------------------------------------------------------------------------------
---------------------------------- DML 문 --------------------------------------
--변수에 sql문의 데이터를 받아오는것
desc CLASSES;
desc department;--변수 사이즈를 정하기전에 원래 데이터 타입을 정확히 파악해본다.

DECLARE
  vs_st_name    VARCHAR2(20); -- 학생이름 변수 --다중행을 받을수는 없다.
  vs_dep_name    VARCHAR2(50); -- 과이름 변수
BEGIN
  SELECT c.st_name, d.dep_name --불러올 컬럼
    INTO vs_st_name, vs_dep_name --select의 into뒤에 컬럼값을 넣을 변수를 넣어준다.
    --당연히 변수와 컬럼의 개수와 데이터타입은 동일해야한다.
    FROM CLASSES c, department d
   WHERE c.dep_code = d.dep_code
     AND c.DEP_CODE = 10100; --추출할 데이터의 조건을 걸어준다.

  DBMS_OUTPUT.PUT_LINE( vs_st_name || ' - ' || vs_dep_name);
  --받아온 변수명을 확인해본다.
END;

DECLARE
  vs_st_name CLASSES.st_name%TYPE; --테이블.컬럼명.%type
  vs_dep_name department.dep_name%TYPE;--해당 테이블의 해당컬럼의 타입으로 선언한다.
BEGIN--여기서부턴 앞의 예제랑 같다.
  SELECT c.st_name, d.dep_name
    INTO vs_st_name, vs_dep_name 
    FROM CLASSES c, department d
   WHERE c.dep_code = d.dep_code
     AND c.DEP_CODE = 10100; 

  DBMS_OUTPUT.PUT_LINE( vs_st_name || ' - ' || vs_dep_name);  
END;
--sql문에서 스던 vachar2와 pl/sql에서 사용하는 varchar2는 비슷하지만
--pl/sql은 훨씬 크게 사용할 수 있다. sql은 4000byte pl/sql 은 32767byte이다.
--------------------------------------------------------------------------------