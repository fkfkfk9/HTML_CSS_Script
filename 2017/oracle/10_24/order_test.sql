------------------------------ 2017_10_24 TEST ---------------------------------
CREATE TABLE ORDERS(
    ORDER_ID        NUMBER(12,0),
    ORDER_DATE      DATE,
    ORDER_MODE      VARCHAR2(8),
    CUSTOMER_ID     NUMBER(6,0),
    ORDER_STATUS    NUMBER(2,0),
    ORDER_TOTAL     NUMBER(8,2) DEFAULT 0,
    SALES_REP_ID    NUMBER(6,0),
    PROMOTION_ID    NUMBER(6,0),
    CONSTRAINTS PK_ORDER_ID PRIMARY KEY(ORDER_ID),
    CONSTRAINTS check_MODE CHECK ( ORDER_MODE IN ('direct', 'online'))
);
SELECT constraint_name, constraint_type, table_name, search_condition 
   FROM user_constraints 
  WHERE table_name = 'ORDERS'; 

INSERT INTO ORDERS(ORDER_ID, ORDER_DATE, ORDER_MODE, CUSTOMER_ID, ORDER_STATUS,
SALES_REP_ID, PROMOTION_ID)--디폴트 값을 빼줘야 하기 때문에 컬럼명 입력
VALUES(20171024, SYSDATE, 'home', 171024, 02, 111111, 888888);
--check값을 벗어나기 때문에 오류가 난다.

INSERT INTO ORDERS(ORDER_ID, ORDER_DATE, ORDER_MODE, CUSTOMER_ID, ORDER_STATUS,
SALES_REP_ID, PROMOTION_ID)
VALUES(20171024, SYSDATE, 'direct', 171024, 02, 111111, 888888);

select * from ORDERS;--디폴트 값인 ORDER_TOTAL 0으로 나온다.
--------------------------------------------------------------------------------