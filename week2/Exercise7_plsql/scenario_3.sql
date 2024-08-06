CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_account_id IN NUMBER, p_customer_id IN NUMBER, p_balance IN NUMBER);
    PROCEDURE CloseAccount(p_account_id IN NUMBER);
    FUNCTION GetTotalBalance(p_customer_id IN NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_account_id IN NUMBER, p_customer_id IN NUMBER, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO accounts (account_id, customer_id, balance)
        VALUES (p_account_id, p_customer_id, p_balance);
        COMMIT;
    END OpenAccount;
    
    PROCEDURE CloseAccount(p_account_id IN NUMBER) IS
    BEGIN
        DELETE FROM accounts
        WHERE account_id = p_account_id;
        COMMIT;
    END CloseAccount;
    
    FUNCTION GetTotalBalance(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(balance) INTO v_total_balance
        FROM accounts
        WHERE customer_id = p_customer_id;
        RETURN v_total_balance;
    END GetTotalBalance;
END AccountOperations;
/
