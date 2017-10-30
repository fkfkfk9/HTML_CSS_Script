---------------------------- COMMIT 과 ROLLBACK --------------------------------
/*
    데이터를 처리함에 있어서 데이터 처리를 확실시 하려면 커밋을 하고
    데이터 처리중 오류가 생긴다면 롤백을 통해 작업시작전으로 돌아갈 수 있다.
    이렇게 데이터 처리할때 롤백과 커밋을 하는것을 트랜잭션이라 하는데 오라클은 따로 설정을
    하지 않아도 이미 트랜잭션이 기본으로 설정되어있다.
    하지만 다른 DB를 사용할 때는 그렇지 않은 경우가 있기 때문에 시스템을 사용할때 확인 해야함
    ALL OR NOTHING : 제대로 작동한다면 전부 처리하던가 문제가 생겼다면 처리하지 않던가
*/

create table transaction_ex(
    t_no    number primary key,
    t_name  varchar(20) NOT NULL
);

CREATE OR REPLACE PROCEDURE proc_transaction_ex_udp--udp사용자전용 프로시져
            ( p_no  number,
              p_name varchar2)
IS
BEGIN
    --begin tran; 오라클은 트랜잭션이 기본설정에 의하여 되어있음
    INSERT INTO transaction_ex values(p_no, p_name);--입력된 값으로 실행된다.    
    INSERT INTO transaction_ex values(1, '홍길동');--이미 1이 있기때매 pk제약으로
                                                  --오류가 난다. 
    DBMS_OUTPUT.PUT_LINE('작업이 성공했습니다.');
        
    exception when others then
        DBMS_OUTPUT.PUT_LINE(SQLERRM(SQLCODE));
        ROLLBACK;--롤백을 하기때문에 insert되었던게 처리가 되지 않는다.

commit;--커밋은 일반적으로 마지막에 한다.
end;    

exec proc_transaction_ex_udp(3, '박지성');
--이 예제처럼 데이터를 insert처리하던중 오류가 난다면 기존에 insert한것까지 전부
--취소해야 될 상황에선 rollback를 해줘야 한다.

select * from transaction_ex;
 
update transaction_ex
set t_name = '이승엽'
where t_no = 1;
rollback;
/*
    사용자가 데이터베이스에 접근하여 insert나 update, delete등을 하고있다면
    해당 데이터베이스를 점유하고 있기 때문에 다른사용자가 작업을 할 수 없다.
    이럴경우 commit이나 rollback등을 하는 순간 점유가 끝나고 다음사용자로 넘어간다.
    이런 점유문제를 해결하기 위해서라도 트랜잭션은 반드시 사용되어야 한다.
    위에 update문을 실행하고 sqlplus로 delete문을 작성한다면 sqlplus는 작업이 진행되지
    않는다. 이후 롤백이나 커밋을 한다면 여기서도 처리되고 sqlplus도 처리된다.
*/

CREATE OR REPLACE PROCEDURE proc_transaction_ex_udp
            ( p_no  number,
              p_name varchar2)
IS
BEGIN
    INSERT INTO transaction_ex values(p_no, p_name);    
    savepoint aaa;--위치를 지정한다.
    INSERT INTO transaction_ex values(1, '홍길동');
    DBMS_OUTPUT.PUT_LINE('작업이 성공했습니다.');
        
    exception when others then
        DBMS_OUTPUT.PUT_LINE(SQLERRM(SQLCODE));
        ROLLBACK to aaa;--지정된 위치까지만 진행하고 롤백한다.

commit;--커밋은 일반적으로 마지막에 한다.
end;    

exec proc_transaction_ex_udp(3, '박지성');

select * from transaction_ex;
--------------------------------------------------------------------------------