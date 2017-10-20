------------------------------- 의사컬럼 -------------------------------
SELECT ROWNUM, writer, title --rownum은 컬럼별로 번호를 부여해서 출력해준다.
  FROM board;--주로 게시판같은걸 만들 때 게시판번호용으로 쓸 수 있다.

SELECT ROWNUM, writer, title
  FROM board
  WHERE ROWNUM < 4;--5개 미만으로 출력

SELECT ROWNUM, writer,title, ROWID --데이터가 저장된 주소 값을 가리킨다.
FROM board
WHERE ROWNUM < 5;
----------------------------------------------------------------------