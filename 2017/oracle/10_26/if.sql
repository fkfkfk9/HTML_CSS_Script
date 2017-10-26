------------------------------------ IF 문 -------------------------------------

DECLARE
   num1 number := 8;
   num2 number := 13;
BEGIN	
	 IF num1 >= num2 THEN --이 붙는다
        begin--조건문안에 내용이 길어질경우 괄호처럼 넣어줄 수 있다.
	    DBMS_OUTPUT.PUT_LINE(num1 ||'이 큰 수');
        DBMS_OUTPUT.PUT_LINE(num1 ||'이 큰 수');
        DBMS_OUTPUT.PUT_LINE(num1 ||'이 큰 수');
        DBMS_OUTPUT.PUT_LINE(num1 ||'이 큰 수');
        end;
	 ELSE
        begin
	    DBMS_OUTPUT.PUT_LINE(num2 ||'이 큰 수');
        DBMS_OUTPUT.PUT_LINE(num2 ||'이 큰 수');
        DBMS_OUTPUT.PUT_LINE(num2 ||'이 큰 수');
        DBMS_OUTPUT.PUT_LINE(num2 ||'이 큰 수');
        end;
	 END IF;--마무리를 지어준다.	
END;

select ROUND(DBMS_RANDOM.VALUE (10, 120), -1) from dual;
--10~120사이의 랜덤 실수값 10단위
select * from classes;
--사용할 테이블 내용 확인해보기

DECLARE
   pl_st_grade NUMBER := 0;--학점 입력받을 변수
   pl_dep_code NUMBER := 0;--학과코드 입력받을 변수
BEGIN	
	pl_dep_code := 10000 + ROUND(DBMS_RANDOM.VALUE (100, 200), -2);
    --10000에다 100 또는 200을 랜덤으로 받아 더해준다. 그값을 학과코드에 삽입
   SELECT st_grade
     INTO pl_st_grade --검색된 학점을 입력받을 변수
     FROM classes
    WHERE dep_code = pl_dep_code --랜덤 학과코드와 같은값인가
      AND ROWNUM = 1;--일치하는 값중에 1번째로 검색된 값만 뽑는다.

  DBMS_OUTPUT.PUT_LINE(pl_st_grade);--결과를 출력하여 확인해본다.
  
  IF pl_st_grade <= 2 THEN --결과값의 조건을 걸어 2보다 낮으면 문자 출력
     DBMS_OUTPUT.PUT_LINE('학사경고');  
  ELSIF pl_st_grade BETWEEN 2.1 AND 3.5 THEN
     DBMS_OUTPUT.PUT_LINE('성실합니다.');  
  ELSE
    IF pl_st_grade = 4.5 then--2중 if문
        DBMS_OUTPUT.PUT_LINE('전액 장학금');
    elsif pl_st_grade BETWEEN 4.2 AND 4.4 THEN
        DBMS_OUTPUT.PUT_LINE('반액 장학금');
    else
        DBMS_OUTPUT.PUT_LINE('잘했지만 장학금은 없습니다.');
    end if;
  END IF;    
END;
--------------------------------------------------------------------------------