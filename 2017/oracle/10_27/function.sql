------------------------------------- 함수 --------------------------------------
/*
    함수(내장함수 vs 사용자 정의함수)
    CREATE OR REPLACE FUNCTION 함수명([매개변수1, 매개변수2,.....])
    RETURN 데이터타입;
    IS[AS] e둘중에 하나
    변수 상수 선언
    BEGIN
    RETURN 반환값 --앞에 RETURN에서 정의한 값과 타입이 같아야함
    END;
*/
CREATE OR REPLACE FUNCTION my_add ( num1 NUMBER, num2 NUMBER )
   RETURN NUMBER  -- 반환 데이터타입은 NUMBER
IS--변수 선언부
   vi_sum NUMBER := 0; -- 합을 넣을 변수
BEGIN	 
	 vi_sum  := num1 + num2;	 	 
	 RETURN vi_sum;	
END;	  
  
SELECT my_add(13, 8) result --숫자 2개를 넣으면 합을 구해준다.
  FROM DUAL;  
  
CREATE OR REPLACE FUNCTION dp_get_dp_name ( get_dep_code NUMBER )--숫자를 받는다
   RETURN VARCHAR2  --문자로 반환
IS
    vs_dep_name department.dep_name%type; --입력받을 데이터의 타입을 컬럼과 일치시킨다.
begin
    select dep_name
    into vs_dep_name--학과코드에 맞는 학과이름을 입력받음
    from department
    where dep_code = get_dep_code;--입력받은 숫자와 같은 학과코드를 찾는다.
    
    return vs_dep_name;--찾은 학과이름을 리턴시킴
end;

SELECT dp_get_dp_name(10300) 학과 --학과코드를 입력하면 학과를 알려준다.
  FROM DUAL;  

CREATE OR REPLACE FUNCTION dp_get_dp_name ( get_dep_code NUMBER )--숫자를 받는다
   RETURN VARCHAR2  --문자로 반환
IS
    vs_dep_name department.dep_name%type; --입력받을 데이터의 타입을 컬럼과 일치시킨다.
    vi_check number; --해당 자료가 있는지 체크
begin
    select count(*)--찾은 데이터의 숫자의 개수를 계산
    into vi_check--데이터 개수를 대입
    from department
    where dep_code = get_dep_code;--입력받은 숫자와 같은 학과코드를 찾는다.
    
    IF vi_check = 0 then--일치하는게 없을때 실행
        vs_dep_name := '해당학과 없음';    
    ELSE--일치하는게 있을경우 실행
        begin
            select dep_name
            into vs_dep_name--학과코드에 맞는 학과이름을 입력받음
            from department
            where dep_code = get_dep_code;
        end;
   END IF;    
    return vs_dep_name;--찾은 학과이름을 리턴시킴
end;
--------------------------------------------------------------------------------