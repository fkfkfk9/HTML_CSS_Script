------------------------------- 집합 연산자 --------------------------------------

CREATE TABLE set_ex (
       se_country VARCHAR2(10),
       se_num     NUMBER,
       se_job   VARCHAR2(80));
       
INSERT INTO set_ex VALUES ('한국', 1, '프로그래머');
INSERT INTO set_ex VALUES ('한국', 2, '자동차 정비공');
INSERT INTO set_ex VALUES ('한국', 3, '전기 엔지니어');
INSERT INTO set_ex VALUES ('한국', 4, '모바일 엔지니어');
INSERT INTO set_ex VALUES ('한국', 5,  '액정 엔지니어');
INSERT INTO set_ex VALUES ('한국', 6,  '엔진 엔지니어');
INSERT INTO set_ex VALUES ('한국', 7,  '웹 개발');
INSERT INTO set_ex VALUES ('한국', 8,  '그래픽 디자이너');
INSERT INTO set_ex VALUES ('한국', 9,  'A/S기사');
INSERT INTO set_ex VALUES ('한국', 10,  '생산직');

INSERT INTO set_ex VALUES ('중국', 1, '웹 개발');
INSERT INTO set_ex VALUES ('중국', 2, '생산직');
INSERT INTO set_ex VALUES ('중국', 3, '액정 엔지니어');
INSERT INTO set_ex VALUES ('중국', 4, '프로그래머');
INSERT INTO set_ex VALUES ('중국', 5, '전기 엔지니어');
INSERT INTO set_ex VALUES ('중국', 6, '그래픽 디자이너');
INSERT INTO set_ex VALUES ('중국', 7, '자동차 정비공');
INSERT INTO set_ex VALUES ('중국', 8, '건설 안전검사');
INSERT INTO set_ex VALUES ('중국', 9, 'A/S기사');
INSERT INTO set_ex VALUES ('중국', 10, '모바일 엔지니어');
COMMIT;

SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
 ORDER BY se_num;

SELECT se_job
  FROM set_ex
 WHERE se_country = '중국'
 ORDER BY se_num; 
 
SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
UNION --중복 데이터를 제거
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국';
 /*UNION 또는 UNION ALL
    규칙 : select할 컬럼의 데이터 타입이 일치하거나 호환이 가능해야하며,
          컬럼의 개수가 동일해야 한다.
    비슷한 성격의 테이블이 조금의 데이터 차이로 나뉘어져 있을 때 사용
 */
SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
UNION ALL --중복데이터 모두 출력 검사가 없기 때문에 속도가 빠르다.  
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국';
 
SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
INTERSECT--교집합 즉 같은것만 출력
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국';
  
SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
MINUS--차집합 겹치는 데이터를 제외한 데이터를 출력 
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국';
 
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국'
MINUS
SELECT se_job
  FROM set_ex
 WHERE se_country = '한국';
 
SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
UNION 
SELECT se_num, se_job --컬럼이 위와 개수가 틀려 오류가 난다.
  FROM set_ex
 WHERE se_country = '중국';
 
 
SELECT se_num, se_job--컬럼의 갯수를 맞춰줌으로 오류 해결
  FROM set_ex
 WHERE se_country = '한국'
UNION 
SELECT se_num, se_job
  FROM set_ex
 WHERE se_country = '중국';  
 
SELECT se_num--컬럼의 갯수를 맞춰줬지만 데이터 타입이 다름으로 오류
  FROM set_ex
 WHERE se_country = '한국'
UNION 
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국'; 
 
 
 SELECT se_num, se_job
  FROM set_ex
 WHERE se_country = '한국'
 ORDER BY se_num  --중간에 order by는 넣을 수 없다.
UNION
SELECT se_num, se_job
  FROM set_ex
 WHERE se_country = '중국';
 
 
 SELECT se_job
  FROM set_ex
 WHERE se_country = '한국'
UNION
SELECT se_job
  FROM set_ex
 WHERE se_country = '중국'
 ORDER BY se_job; --마지막에 넣으면 사용 가능 아래뿐만 아니라 유니온된 결과를 정렬
 
 --BLOB, CLOB, BFILE 타입의 컬럼에 대해서는 집합연산자를 사용 못한다.(대용량 타입)
 --마찬가지로 LONG타입도 집합연산자는 사용 못함
 --order by, distinct같은 비교용도는 대용량 데이터 타입에는 사용하지 않는다.
--------------------------------------------------------------------------------