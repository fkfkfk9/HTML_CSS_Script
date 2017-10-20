--------------------------------- DEFAULT -------------------------------------- 
--값을 넣지 않았을 때 NULL이 들어가는게 아니라 디폴트 설정해놓은 값이 들어간다.
CREATE TABLE DEFAULT_EX (
   id        VARCHAR2(10) NOT NULL, 
   name      VARCHAR2(10) NULL, 
   join_date DATE DEFAULT SYSDATE);
   --join_date값은 생략할 시 현재 시스템상 시간을 입력 해준다.
INSERT INTO DEFAULT_EX (id, name) VALUES ('AA', 'AA'); 
--데이트값을 빼고 입력하기 때문에 컬럼명을 넣어주고 입력해야한다.
SELECT * FROM DEFAULT_EX;   
INSERT INTO DEFAULT_EX VALUES ('test02', 'mary', '20171111'); 
--데이터 형식을 비슷하게라도 적어주면 yy/mm/dd형식으로 바꿔서 저장한다.
---------------------------------------------------------------------------------