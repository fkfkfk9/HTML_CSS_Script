---------------------------------- 문자함수 -------------------------------------
SELECT INITCAP('naver daum google'), INITCAP('naver6daum*goo가gle')
  FROM DUAL;--각 단어의 첫글자를 대문자로 바꿔줌, 
  --공백이나 알파벳이(숫자포함) 아닌 문자가 나오면 다음문자는 대문자로 바꿈  
  
SELECT LOWER('NAVER DAUM GOOGLE'), UPPER('naver daum google')
  FROM DUAL;--lower전부 소문자로 upper 전부 대문자로
    
SELECT CONCAT('NAVER', ' GOOGLE'), 'NAVER' || ' GOOGLE'
  FROM DUAL;--두 문자를 붙여서 반환
  
SELECT CONCAT('NAVER', ' GOOGLE', 'DAUM')
  FROM DUAL;--문자를 3개 넣으면 오류가 난다.
  
SELECT SUBSTR('NAVER DAUM', 7, 4)
  FROM DUAL;--인덱스가 아닌 몇번째에서 몇개를 가져온다.(0부터 시작이 아니다.) 디폴트가 1
  
SELECT SUBSTR('NAVER DAUM', 1, 5), SUBSTR('NAVER DAUM', -2, 4)
  FROM DUAL;--음수를 넣으면 뒤에서 부터 계산한다.  
  
SELECT SUBSTRB('NAVER DAUM', 1, 5), SUBSTRB('네이버 다음', -7, 7)
  FROM DUAL;--substr과 같지만 글자수가 아닌 바이트로 계산한다.    
  
SELECT LTRIM('NAVER DAUM', 'NA'),--왼쪽 단어 제거 
       LTRIM('네이버 다음', '네'),
       RTRIM('NAVER DAUM', 'M'), --오른쪽 단어 제거
       RTRIM('네이버 다음', '음')
  FROM DUAL;--원래는 공백을 제거하지만 특정 문자를 지우기도 한다.    
  
SELECT LTRIM('네이버 다음', '이'), RTRIM('네이버 다음', '다')
  FROM DUAL;--맨 왼쪽이 이가 아니고 맨 오른쪽이 다가 아니라서 삭제가 되지 않음    
  
SELECT RTRIM(LTRIM('      네이버 다음       ')) FROM DUAL;
--LTRIM으로 왼쪽 공백을 지우는 함수를  RTRIM으로 삽입하여 오른쪽 공백을 지움
--한줄로 양쪽 공백을 지울 수 있다.
  
CREATE TABLE lrpad_ex (
       num   NUMBER,
       phone VARCHAR2(30));

INSERT INTO lrpad_ex VALUES (1, '422-5395');
INSERT INTO lrpad_ex VALUES (2, '424-8888');
INSERT INTO lrpad_ex VALUES (3, '388-5532');

SELECT *
FROM lrpad_ex;

SELECT LPAD(phone, 12, '010-')
FROM lrpad_ex;
--해당 컬럼을 3번째 넣어준 값을 포함하여 가운대 숫자만큼 길이를 채운다.
--l을 넣으면 왼쪽 r을넣으면 오른쪽이다.
--값을 넣어준게 최대길이를 만족하지 못하면 3번째 값이 패턴화되어 반복출력된다.
--3번째 값을 넣어주지 않는다면 공백으로 채워준다.
SELECT RPAD(phone, 13, '(031)')
FROM lrpad_ex;          
--REPLACE VS TRANSLATE          
SELECT REPLACE('내가 그린 기린 그림은 잘 그린 기린 그림이고', '그', '기')
  FROM DUAL;--넣어준 문자열에서 2번째 값을 찾아 3번재 값으로 바꿔준다.   
  
SELECT LTRIM('  NAVER DAUM  '),--왼쪽공백을 지움
       RTRIM('  NAVER DAUM  '),--오른쪽 공백을 지움
       REPLACE('  NAVER  DAUM  ', ' ', '')--모든 공백을 다 지움
  FROM DUAL;            
  
SELECT REPLACE('내가 그린 기린 그림은 잘 그린 기린 그림이고', '그린', '기린') AS rep,
       TRANSLATE('내가 그린 기린 그림은 잘 그린 기린 그림이고', '그린', '기린') AS trn
  FROM DUAL; --REPLACE는 그린을 기린으로 바꿔주는 건대 TRANSLATE는 그를 기로 린을 린으로 바꾼다.
  --즉 리플레이스는 문장단위로 바꾸고 트랜스레이트는 글자별로 바꾸는 작업이다.    
    
SELECT INSTR('내가 그린 기린 그림은 잘 그린 기린 그림이고', '기린') AS INSTR1,--기린의 위치 
       INSTR('내가 그린 기린 그림은 잘 그린 기린 그림이고', '기린', 9) AS INSTR2,--9번째 부터 기린의 위치 
       INSTR('내가 그린 기린 그림은 잘 그린 기린 그림이고 니가 그린 기린 그림은', '기린', 9, 2) AS INSTR3
       --9번째 부터 기린을 찾는대 2번째 나온 기린의 위치
  FROM DUAL;   
  
SELECT LENGTH('경기도 안양시'),
       LENGTHB('경기도 안양시')
  FROM DUAL;--LENGTH는 문자열의 개수 반환, LENGTHB는 문자열의 바이트를 반환
  
  --오라클을 설치시 문자셋을 선택할 수 있든대 문자셋의 이름에 따라 한글이
  --2바이트인지 3바이트인지 결정된다.
  
SELECT num, TRANSLATE(title,'QWERASDZXC','poiuytghjk') AS TRANS_NAME
  FROM board;
  --가운대 입력값의 문자별로 3번째 문자열의 문자별로 교체해준다.
  --암호화 작업에 이용된다.
-------------------------------------------------------------------------------- 