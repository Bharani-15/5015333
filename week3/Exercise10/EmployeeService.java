package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void batchInsert(List<Employee> employees) {
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < employees.size(); i++) {
            session.save(employees.get(i));
            if (i % 50 == 0) { 
                session.flush();
                session.clear();
            }
        }
    }

    @Transactional
    public void batchUpdate(List<Employee> employees) {
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < employees.size(); i++) {
            session.update(employees.get(i));
            if (i % 50 == 0) {
                session.flush();
                session.clear();
            }
        }
    }
}

