CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_department_id IN NUMBER, p_salary IN NUMBER);
    PROCEDURE UpdateEmployeeDetails(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_department_id IN NUMBER, p_salary IN NUMBER);
    FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_department_id IN NUMBER, p_salary IN NUMBER) IS
    BEGIN
        INSERT INTO employees (employee_id, name, department_id, salary)
        VALUES (p_employee_id, p_name, p_department_id, p_salary);
        COMMIT;
    END HireEmployee;
    
    PROCEDURE UpdateEmployeeDetails(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_department_id IN NUMBER, p_salary IN NUMBER) IS
    BEGIN
        UPDATE employees
        SET name = p_name, department_id = p_department_id, salary = p_salary
        WHERE employee_id = p_employee_id;
        COMMIT;
    END UpdateEmployeeDetails;
    
    FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT salary INTO v_salary
        FROM employees
        WHERE employee_id = p_employee_id;
        RETURN v_salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;
/
