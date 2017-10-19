-----------------------------숫자형 데이터-----------------------------
-- 숫자 데이터 타입(NUMBER데이터 타입으로한다.)
CREATE TABLE NUMBER_EX (
    COL_INT    INTEGER, 
    COL_DEC    DECIMAL, 
    COL_NUM    NUMBER
);
--내부적으로 NUMBER 데이타타입 하나로 사용이 된다.
--length가 22가 나오는 이유는 최대길이가 22바이트이다.
SELECT column_id, column_name, data_type, data_length
  FROM user_tab_cols
 WHERE table_name = 'NUMBER_EX'
 ORDER BY column_id;
---------------------------------------------------------------------