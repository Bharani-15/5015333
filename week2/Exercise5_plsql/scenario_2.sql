CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (transaction_id, account_id, amount, transaction_date)
    VALUES (:NEW.transaction_id, :NEW.account_id, :NEW.amount, SYSDATE);
END LogTransaction;
/
