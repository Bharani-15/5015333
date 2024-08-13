package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmailAddress(String email);

    @Query("SELECT e.name AS name, d.name AS departmentName " +
            "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeDetails();

}
