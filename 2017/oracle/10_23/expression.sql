---------------------------- 표현식 -----------------------------
--case when 조건식1 then 결과값1
--     when 조건식2 then 결과값2 ...
--     esle 결과값3
--     end as 컬럼별칭
-- 조건식이 추가될수록 when~이 계속 삽입된다.
select num, writer, title,
    case when num < 3 then 'old user'
         when num >2 AND num < 5 then 'member'
         else 'beginer'
    end as member_info from board;
----------------------------------------------------------------- 