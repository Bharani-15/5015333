CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
)
IS
    employee_not_found EXCEPTION;
    PRAGMA EXCEPTION_INIT(employee_not_found, -20001);
    
BEGIN
    -- Update the salary of the employee
    UPDATE employees
    SET salary = salary + salary * (p_percentage / 100)
    WHERE employee_id = p_employee_id;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE employee_not_found;
    END IF;
    
    -- Commit the transaction
    COMMIT;
    
EXCEPTION
    WHEN employee_not_found THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred while updating the salary.');
END UpdateSalary;
/
