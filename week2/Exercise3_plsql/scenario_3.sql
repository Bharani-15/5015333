CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
)
IS
    insufficient_funds EXCEPTION;
    PRAGMA EXCEPTION_INIT(insufficient_funds, -20101);

    v_from_balance NUMBER;
    v_to_balance NUMBER;
BEGIN
    -- Check the balance of the from_account
    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account_id
    FOR UPDATE;
    
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    -- Deduct the amount from the from_account
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;
    
    -- Add the amount to the to_account
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    -- Commit the transaction
    COMMIT;
    
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred during the transfer.');
END TransferFunds;
/
