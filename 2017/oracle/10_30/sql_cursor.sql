--------------------------- 묵시적 커서와 커서속성 ---------------------------------
/*커서
    셀렉트문으로 테이블을 검색했을때 테이블을 메모리상에 저장하고 있을때 
    메모리상 위치를 가리키고 있는걸 커서라고 한다.
*/
select * from classes;
DECLARE 
  vi_dep_code department.dep_code%TYPE := 10100;
  vs_st_name classes.st_name%TYPE := '홍명보';
BEGIN
	-- 10100학과의 사람 이름을 자신의 이름으로 갱신
	 UPDATE classes
	     SET st_name = vs_st_name
	   WHERE dep_code = vi_dep_code;	   
	   
	-- 몇 건의 데이터가 갱신됐는지 출력   
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT);
    /*
        SQL%ROWCOUNT가 묵시적 커서이다. SQL커서라고도 한다.
        SQL%FOUND는  집합 패치의 로우수가 1개 이상이면 true 아니면 펄스이다.
        SQL%NOTFOUND 파운드와 반대로 작용한다.
        SQL%ISOPEN 항상 펄스를 리턴한다. 이 속성은 항상 커서가 종료된뒤에 작동한다.
    */
	COMMIT;
END;
--------------------------------------------------------------------------------