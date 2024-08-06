DECLARE
    CURSOR loan_cursor IS
        SELECT customer_id, due_date
        FROM loans
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_customer_id loans.customer_id%TYPE;
    v_due_date loans.due_date%TYPE;
    
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_customer_id, v_due_date;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        -- Fetch customer's name (assuming there's a customers table with a customer_id and name column)
        DECLARE
            v_customer_name customers.name%TYPE;
        BEGIN
            SELECT name INTO v_customer_name
            FROM customers
            WHERE customer_id = v_customer_id;
            
            -- Print reminder message
            DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customer_name || ', your loan is due on ' || TO_CHAR(v_due_date, 'YYYY-MM-DD') || '.');
        END;
    END LOOP;
    CLOSE loan_cursor;
END;
/
