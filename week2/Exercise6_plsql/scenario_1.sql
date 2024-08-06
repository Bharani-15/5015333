DECLARE
    CURSOR transaction_cursor IS
        SELECT customer_id, transaction_date, amount, description
        FROM transactions
        WHERE transaction_date BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
    
    v_customer_id customers.customer_id%TYPE;
    v_transaction_date transactions.transaction_date%TYPE;
    v_amount transactions.amount%TYPE;
    v_description transactions.description%TYPE;
BEGIN
    OPEN transaction_cursor;
    LOOP
        FETCH transaction_cursor INTO v_customer_id, v_transaction_date, v_amount, v_description;
        EXIT WHEN transaction_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || 
                             ', Date: ' || v_transaction_date || 
                             ', Amount: ' || v_amount || 
                             ', Description: ' || v_description);
    END LOOP;
    CLOSE transaction_cursor;
END;
/
