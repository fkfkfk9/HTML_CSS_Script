---------------------------------- CASE 문 -------------------------------------
/*
    case문은 2가지 방식이 있다.
    유형 1                               유형2
    case 표현식                          case when 표현식1 then 
        when 결과1 then 처리문1;             처리문1;
        when 결과2 then 처리문2;             when 표현식2 then 처리문2;
        else 기타처리문;                     else 기타처리문;
    end case                            end case
*/
DECLARE --유형2의 스위치문
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
  
  CASE WHEN pl_st_grade BETWEEN 0 AND 2 THEN
            DBMS_OUTPUT.PUT_LINE('학사경고');
       WHEN pl_st_grade BETWEEN 2.1 AND 3.5 THEN
            DBMS_OUTPUT.PUT_LINE('성실합니다');
       WHEN pl_st_grade BETWEEN 3.6 AND 4.1 THEN
            DBMS_OUTPUT.PUT_LINE('잘했지만 장학금은 없습니다.');
       WHEN pl_st_grade BETWEEN 4.2 AND 4.4 THEN
            DBMS_OUTPUT.PUT_LINE('반액 장학금');     
       ELSE 
            DBMS_OUTPUT.PUT_LINE('전액 장학금');
  END CASE;
END;  
--------------------------------------------------------------------------------