CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
BEGIN
    IF :NEW.amount < 0 THEN
        DECLARE
            v_balance NUMBER;
        BEGIN
            SELECT balance INTO v_balance
            FROM accounts
            WHERE account_id = :NEW.account_id;
            
            IF v_balance + :NEW.amount < 0 THEN
                RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal.');
            END IF;
        END;
    ELSIF :NEW.amount = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
END CheckTransactionRules;
/
