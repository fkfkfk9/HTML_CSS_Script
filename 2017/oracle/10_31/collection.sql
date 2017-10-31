----------------------------------- 연관배열 ------------------------------------
--TYPE 연관_배열명 IS TABLE OF 연관배열 값 타입 INDEX BY 인덱스 타입;
DECLARE
   -- 숫자-문자 쌍의 연관배열 선언
   TYPE arr_type IS TABLE OF VARCHAR2(53)
        INDEX BY PLS_INTEGER;        
   -- 연관배열 변수 선언
   arr_test arr_type;
BEGIN
  -- 연관배열에 값 할당
  arr_test('13') := '인덱스에 13을 넣었을 때';
  arr_test('33') := '인덱스에 33을 넣었을 때';  
  --연관배열 값 출력
  DBMS_OUTPUT.PUT_LINE(arr_test(13));
  DBMS_OUTPUT.PUT_LINE(arr_test(33));
END;
--------------------------------------------------------------------------------
------------------------------------ VARRAY ------------------------------------
--연관배열하고는 다르게 크기에 제한이 있다.
DECLARE
   -- 8개의 문자형 값으로 이루어진 VARRAY 선언
   TYPE varr_type IS VARRAY(8) OF VARCHAR2(13);
   -- VARRY 변수 선언
   varr_ex varr_type;
   
   vi_cnt NUMBER := 0;
BEGIN
--생성자 함수 : 기억장소의 값을 초기화 하기위해서 제공하는 함수
--생성자 함수명 : 테이터 타입 이름으로 함수를 제공
  -- 생성자를 사용해 값 할당 (총 8개지만 최초 5개만 값 할당)
  varr_ex := varr_type('홍길동', '박지성', '김연아', '박찬호', '백종원', '', '', '');  
  LOOP
     vi_cnt := vi_cnt + 1;--다른언어의 배열과는 다르게 1부터 시작된다.     
     -- 크기가 8이므로 8회 루프를 돌면서 각 요소 값 출력 
     IF vi_cnt > 8 THEN 
        EXIT;--어떤식으로는 exit를 써주지 않는다면 무한 loop를 하게된다.
     END IF;  
     -- VARRY 요소 값 출력 
     DBMS_OUTPUT.PUT_LINE(varr_ex(vi_cnt));  
  END LOOP;  
  -- 값 변경
  varr_ex(1) := '반기문';
  varr_ex(3) := '손흥민';  
  -- 다시 루프를 돌려 값 출력
  vi_cnt := 0;
  LOOP
     vi_cnt := vi_cnt + 1;    
     IF vi_cnt > 5 THEN 
        EXIT;
     END IF;  
     DBMS_OUTPUT.PUT_LINE(varr_ex(vi_cnt));  
  END LOOP;
END;
--------------------------------------------------------------------------------
----------------------------------- 중첩 테이블 ----------------------------------
--연관배열&VARRY 제한은 없지만 구조는 인덱스로 관리 키는 숫자로만 가능, 생성자 지원
--TYPE 중첩테이블명 IS TABLE OF 값 타입;
DECLARE
  -- 중첩 테이블 선언
  TYPE nt_arr_type IS TABLE OF VARCHAR2(13);  
  -- 변수 선언
  vnt_arr_test nt_arr_type;
BEGIN
  -- 생성자를 사용해 값 할당
  vnt_arr_test := nt_arr_type('홍길동', '박지성', '김연아', '');  
  vnt_arr_test(4) := '손흥민';  --생성자 함수에서 정의한 인덱스값을 넘어갈 수 없다.
  -- 값 출력
  DBMS_OUTPUT.PUT_LINE (vnt_arr_test(1));
  DBMS_OUTPUT.PUT_LINE (vnt_arr_test(2));
  DBMS_OUTPUT.PUT_LINE (vnt_arr_test(3));
  DBMS_OUTPUT.PUT_LINE (vnt_arr_test(4));  
END;
--------------------------------------------------------------------------------