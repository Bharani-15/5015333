CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_customer_name IN VARCHAR2,
    p_age IN NUMBER,
    p_balance IN NUMBER
)
IS
    duplicate_customer EXCEPTION;
    PRAGMA EXCEPTION_INIT(duplicate_customer, -20002);
    
BEGIN
    -- Insert a new customer into the Customers table
    INSERT INTO customers (customer_id, name, age, balance)
    VALUES (p_customer_id, p_customer_name, p_age, p_balance);
    
    -- Commit the transaction
    COMMIT;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: A customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred while adding the new customer.');
END AddNewCustomer;
/
