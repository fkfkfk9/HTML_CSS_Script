---------------------- 뷰 --------------------------
--보는 목적(데이터 변경의 기능은 아니다.)
--긴 select문이나 join으로 구성된 코드를 저장해서 사용한다.
--select문을 뷰 객체에 저장시켜놓고 필요할때 사용
CREATE OR REPLACE VIEW classes_dept AS  
SELECT c.st_code, c.st_name, d.dep_code, d.dep_name  
  FROM classes c, 
       department d
 WHERE c.dep_code = d.dep_code; 
--만들어진 뷰는 테이블 처럼 사용할 수 있다.
SELECT * FROM classes_dept
where dep_code = 200;
--뷰 앞에는 vw를 붙여주는게 좋다 나중에 구별이 힘들다.
create or replace view vw_classes as --이 다음은 무조건 셀렉트문이 와야한다.
select st_code, st_name, st_grade, st_level
from classes;
SELECT * FROM vw_classes;
--실제 데이터를 가진 테이블이 아니라 셀렉트 문이 들어간 코드를 저장
--데이터베이스의 접근을 제어하는 용도로도 사용 할 수 있다.
--직급이 낮은 사람이 테이블을 확인하고 마음대로 접근하게 할수는 없기 때문에
--뷰만 사용할 수 있게 해서 테이블의 칼럼을 이용하지 못하게 한다.
create or replace view vw_classes as
select st_name, st_grade, st_level
from classes;
--한번 더 실행하면 수정이 된다. 내용을 바꾸고 다시 실행해서 수정하면 된다.
--replace가 있는 이유이다. 없는 이름이라면 create가 작동 있다면 replace가 작동
--뷰로 insert, update, delete가 가능은 하지만 권장하지 않는다.
--뷰를 내용으로 해서 뷰를 생성할 수 있다.
SELECT * FROM vw_classes;
drop view vw_classes;
/*
    스키마 : 테이블의 구조, 데이터 베이스 구조
    스키마.객체 - 객체적인 접근
*/
select * from ora_user.classes; --다른 접속자로 접근할때
------------------------------------------------------- 