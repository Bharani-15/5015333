CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_interest_rate CONSTANT NUMBER := 0.01;
BEGIN
    FOR rec IN (SELECT account_id, balance FROM savings_accounts FOR UPDATE) LOOP
        UPDATE savings_accounts
        SET balance = balance + (balance * v_interest_rate)
        WHERE account_id = rec.account_id;
    END LOOP;
    COMMIT;
END ProcessMonthlyInterest;
/
