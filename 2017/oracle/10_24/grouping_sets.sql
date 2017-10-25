---------------------------- GROUPING SETS -------------------------------------
/*
    GROUP BY writer + GROUP BY readnum 각각 GROUP BY를 시켜 더해준 값
*/
 
 select dep_code, st_level, avg(st_grade), count(*)
 from classes
 group by GROUPING SETS(dep_code, st_level);--각각 그룹바이한 결과를 유니온 올 한것과 같다.
 
select dep_code, avg(st_grade), count(*)
 from classes
 group by dep_code
 order by dep_code;
 --위 아래 결과를 합친것은 GROUPING SETS(dep_code, st_level) 같다.
 select st_level, avg(st_grade), count(*)
 from classes
 group by st_level
 order by st_level;


 select st_gender, dep_code, st_level, avg(st_grade), count(*)
 from classes
 group by GROUPING SETS(st_gender, (dep_code, st_level))
 order by st_gender, dep_code;
--성별로만 그룹바이 한것과 아래것의 결과를 합친(유니온 올)것과 같다
select dep_code, st_level, avg(st_grade), count(*)
 from classes
 group by dep_code, st_level
 order by dep_code, st_level;
--------------------------------------------------------------------------------