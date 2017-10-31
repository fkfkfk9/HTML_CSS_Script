-------------------------------- DELETE 메소드 ----------------------------------
DECLARE
   -- 숫자-문자 쌍의 연관배열 선언
   TYPE arr_type IS TABLE OF VARCHAR2(33)
        INDEX BY VARCHAR2(13);        
   -- 연관배열 변수 선언
   arr_test arr_type;   
   vi_cnt number := 0;
BEGIN
  -- 연관배열에 값 할당
  arr_test('한국') := '한국의 수도는 서울';
  arr_test('일본') := '일본의 수도는 도쿄';
  arr_test('중국') := '중국의 수도는 베이징';  
  vi_cnt := arr_test.COUNT;
  DBMS_OUTPUT.PUT_LINE('삭제 전 요소 개수: ' || vi_cnt);    
  DBMS_OUTPUT.PUT_LINE('1: ' || arr_test('한국'));
  DBMS_OUTPUT.PUT_LINE('2: ' || arr_test('일본'));
  DBMS_OUTPUT.PUT_LINE('3: ' || arr_test('중국'));
  arr_test.DELETE('일본', '중국');
  
  vi_cnt := arr_test.COUNT;
  DBMS_OUTPUT.PUT_LINE('삭제 후 요소 개수: ' || vi_cnt);
END;
--------------------------------------------------------------------------------
---------------------------------- TRIM 메소드 ----------------------------------
DECLARE
  -- 중첩 테이블 선언
  TYPE nt_arr_type IS TABLE OF VARCHAR2(13);
  
  -- 변수 선언
  vnt_arr_test nt_arr_type;
BEGIN
  -- 생성자를 사용해 값 할당
  vnt_arr_test := nt_arr_type('홍길동', '박지성', '김연아');
  -- 맨 마지막부터 2개 요소 삭제 
  vnt_arr_test.TRIM(2);  
  DBMS_OUTPUT.PUT_LINE(vnt_arr_test(1));--출력
  DBMS_OUTPUT.PUT_LINE(vnt_arr_test(2));--출력이안됨 데이터는 하나만 남음
  
  EXCEPTION WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE(SQLERRM(sqlcode));
END;
--------------------------------------------------------------------------------
-------------- EXTEND 메소드 ------------------- FIRST와 LAST -------------------
DECLARE
  -- 중첩 테이블 선언
  TYPE nt_arr_type IS TABLE OF VARCHAR2(13);
  
  -- 변수 선언
  vnt_arr_test nt_arr_type;
BEGIN
  -- 생성자를 사용해 값 할당
  vnt_arr_test := nt_arr_type('홍길동', '박지성', '김연아');
  vnt_arr_test.EXTEND;
  -- 맨 끝에 NULL 요소 한개를 추가한 뒤 값 할당 후 출력
  --EXTEND(n)은 n개의 null값을 가지고있는 요소를 추가한다.
  vnt_arr_test(4) := '박찬호';   
  DBMS_OUTPUT.PUT_LINE(vnt_arr_test(4));
  -- 첫 번째 요소를 맨끝에 2개 복사해 추가 후 출력
  vnt_arr_test.EXTEND(2, 1);
  DBMS_OUTPUT.PUT_LINE('첫번째 : ' || vnt_arr_test(1));
  -- 첫 번째 요소를 복사해 2개 추가했으므로 추가된 요소는 5, 6
  DBMS_OUTPUT.PUT_LINE('추가한 요소1 : ' || vnt_arr_test(5));
  DBMS_OUTPUT.PUT_LINE('추가한 요소2 : ' || vnt_arr_test(6));
  -- FIRST와 LAST 메소드를 FOR문에서 사용해 컬렉션 값을 출력
  FOR i IN vnt_arr_test.FIRST..vnt_arr_test.LAST
  LOOP  
     DBMS_OUTPUT.PUT_LINE(i || '번째 요소 값: ' || vnt_arr_test(i));
  END LOOP;
END;
--------------------------------------------------------------------------------
-------------------- COUNT와 LIMIT -----------PRIOR와 NEXT-----------------------
DECLARE  
  TYPE nt_arr_type IS TABLE OF VARCHAR2(13);      -- 중첩테이블 선언
  TYPE varr_type IS VARRAY(8) OF VARCHAR2(13); -- VARRAY 선언
   -- 변수 선언
  vnt_arr_test nt_arr_type;
  vvarr_test varr_type;
BEGIN
  -- 생성자를 사용해 값 할당
  vnt_arr_test := nt_arr_type('박지성', '홍길동', '김연아', '손흥민'); -- 중첩테이블
  vvarr_test := varr_type('장동민', '최연성', '페이커', '임요환'); -- VARRAY  
  DBMS_OUTPUT.PUT_LINE('VARRAY COUNT: ' || vvarr_test.COUNT);
  DBMS_OUTPUT.PUT_LINE('중첩테이블 COUNT: ' || vnt_arr_test.COUNT);
  DBMS_OUTPUT.PUT_LINE('VARRAY LIMIT: ' || vvarr_test.LIMIT); 
  DBMS_OUTPUT.PUT_LINE('중첩테이블 LIMIT: ' || vnt_arr_test.LIMIT);
  DBMS_OUTPUT.PUT_LINE('----------------------------------------------------');
  --varry많이 최대 값을 정해 놓기때문에 count와 같은값이 나온다.
  --중첩테이블과 연관배열은 최대치를 정해놓지 않기때문에 limit값은 null값이 들어간다.
  --PRIOR: 바로 전 인덱스값 NEXT: 다음 인덱스 값 
  --즉 무슨 요소든 first값 이전 인덱스 prior는 null값이 나온다 last의 next또한 마찬가지
  DBMS_OUTPUT.PUT_LINE('FIRST의 PRIOR : ' || vnt_arr_test.PRIOR(vnt_arr_test.FIRST));
  DBMS_OUTPUT.PUT_LINE('LAST의 NEXT : ' || vnt_arr_test.NEXT(vnt_arr_test.LAST));
--위의 2개값은 null이 나왔고 아래 2개 인덱스값은 인덱스를 3을 주기 때문에 2와 4가 나온다.
  DBMS_OUTPUT.PUT_LINE('인덱스3의 PRIOR :' || vnt_arr_test.PRIOR(3));
  DBMS_OUTPUT.PUT_LINE('인덱스3의 NEXT :' || vnt_arr_test.NEXT(3));
END;
--------------------------------------------------------------------------------