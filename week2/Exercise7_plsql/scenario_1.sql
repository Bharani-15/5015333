CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(p_customer_id IN NUMBER, p_name IN VARCHAR2, p_age IN NUMBER, p_balance IN NUMBER);
    PROCEDURE UpdateCustomerDetails(p_customer_id IN NUMBER, p_name IN VARCHAR2, p_age IN NUMBER);
    FUNCTION GetCustomerBalance(p_customer_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddNewCustomer(p_customer_id IN NUMBER, p_name IN VARCHAR2, p_age IN NUMBER, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO customers (customer_id, name, age, balance)
        VALUES (p_customer_id, p_name, p_age, p_balance);
        COMMIT;
    END AddNewCustomer;
    
    PROCEDURE UpdateCustomerDetails(p_customer_id IN NUMBER, p_name IN VARCHAR2, p_age IN NUMBER) IS
    BEGIN
        UPDATE customers
        SET name = p_name, age = p_age
        WHERE customer_id = p_customer_id;
        COMMIT;
    END UpdateCustomerDetails;
    
    FUNCTION GetCustomerBalance(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance
        FROM customers
        WHERE customer_id = p_customer_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
/
