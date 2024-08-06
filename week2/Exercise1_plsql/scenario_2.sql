DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, balance
        FROM customers;
        
    v_customer_id customers.customer_id%TYPE;
    v_balance customers.balance%TYPE;
    
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id, v_balance;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        -- Check if balance is over $10,000
        IF v_balance > 10000 THEN
            UPDATE customers
            SET isVIP = TRUE
            WHERE customer_id = v_customer_id;
        END IF;
    END LOOP;
    CLOSE customer_cursor;
    
    -- Commit the changes
    COMMIT;
END;
/
