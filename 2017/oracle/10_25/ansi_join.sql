--조인은 내부 조인(inner join)과 외부조인(outer join) 두가지로 구분을 해서 이해하면 된다.
 --조인을 사용시 컬럼명에 별칭이나 테이블명을 사용하면 성능에 좋다. 두 테이블을 모두 검색할것을
 --테이블 명을 명시함으로써 하나의 테이블만 검색해도 되기 때문이다.
---------------------------------------------------
--INNER JOIN 문법: 컬럼과 컬럼의 데이터를 비교해서 사용
select c.st_code, c.st_name, c.st_grade, d.dep_name 
    from classes c, department d
    where c.dep_code = d.dep_code;
--ansi join
select c.st_code, c.st_name, c.st_grade, d.dep_name 
    from classes c INNER JOIN department d
    on c.dep_code = d.dep_code;
----------------------------------------------------  
--OUTER JOIN:컬럼과 컬럼 뿐 아니라 겹치지 않는 부분까지 조인함-----------------------
select c.st_code, c.st_name, c.st_grade, d.dep_name, d.dep_code --inner join
    from classes c, department d
    where c.dep_code = d.dep_code; --3개 검색
--(+)가 들어가면 outer join이다. (+)의 위치에 따라 주 테이블이 바뀐다.
select c.st_code, c.st_name, c.st_grade, d.dep_name, d.dep_code --outer join
    from classes c, department d
    where c.dep_code = d.dep_code(+); --NULL값까지 4개 검색
select c.st_code, c.st_name, c.st_grade, d.dep_name, d.dep_code --outer join
    from classes c, department d
    where c.dep_code (+) = d.dep_code; --classes 테이블 기준   
--데이터가 더 많은쪽의 데이터를 전부 출력하고 싶다면 더 적은쪽에 (+)기호를 붙인다.
--테스트는 칼럼이 4개씩 밖에 없어서 확인할 수 없지만 한쪽에 데이터가 훨씬 많고
--겹치는 데이터가 작은쪽 데이터만 큼 있다면 작은쪽에 (+)를 붙이면 큰쪽의 데이터가 전부
--나오고 데이터는 NULL값이 부여되어 나온다.
--(+)기호는 오라클에서만 동작한다.
--ansi outer join
select c.st_code, c.st_name, c.st_grade, d.dep_name, d.dep_code 
    from classes c left outer join department d--왼쪽 테이블 기준이면 left
    on c.dep_code = d.dep_code;--반대 테이블을 기준으로 한다면 right를 준다.
--ansi조인은 다른 DB프로그램과도 호환이 가능하기 때문에 많이 사용한다.
select c.st_code, c.st_name, c.st_grade, d.dep_name, d.dep_code 
    from classes c full outer join department d--full outer join
    on c.dep_code = d.dep_code;--레프트 라이트 조인 전부 출력해준다.
-----------------------------------------------------------------------------
----------------------------------- ANSI ---------------------------------------
--ansi에 조건을 줄 때
select c.st_code, c.st_name, c.st_grade, d.dep_name 
    from classes c INNER JOIN department d
    on c.dep_code = d.dep_code
    and c.dep_code = 200;--결과를 뽑아올 때 한꺼번에 가져온다.
select c.st_code, c.st_name, c.st_grade, d.dep_name 
    from classes c INNER JOIN department d
    on c.dep_code = d.dep_code
    where c.dep_code = 200;--결과를 보고 거기서 뽑아온다.
--즉 결과를 가져올 때 한번에 처리하는 and를 쓰는것이 성능상 좋다. 결과 자체는 동일   
--------------------------------------------------------------------------------