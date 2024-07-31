package com.Bharani.EmployeeManagementSystem;

import java.util.Scanner;

//Array Representation:
//
//Arrays in Java are stored in contiguous memory locations.
//        Advantages:
//Fast Access: O(1) time complexity for accessing elements by index.
//Memory Efficiency: Arrays have a small overhead.


public class Employee {
    int employeeId;
    String name;
    String position;
    int salary;
    public Employee(int employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the initial size of the employee array:");
        int n = in.nextInt();
        Employee[] arr = new Employee[n];

        while (true) {
            System.out.println("Choose an option: Add=1, Update=2, Traverse=3, Delete=4, Exit=5");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    arr = add(arr);
                    break;
                case 2:
                    update(arr);
                    break;
                case 3:
                    traverse(arr);
                    break;
                case 4:
                    arr = delete(arr);
                    break;
                case 5:
                    in.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Employee[] add(Employee[] arr) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of employees to add:");
        int count = in.nextInt();

        int addedCount = 0;
        for (int i = 0; i < arr.length && addedCount < count; i++) {
            if (arr[i] == null) {
                System.out.println("Enter employee details (ID, Name, Position, Salary):");
                int id = in.nextInt();
                String name = in.next();
                String position = in.next();
                int salary = in.nextInt();
                arr[i] = new Employee(id, name, position, salary);
                addedCount++;
            }
        }
        if (addedCount < count) {
            System.out.println("Not enough space in the array to add all employees.");
        }
        return arr;
    }

    public static void update(Employee[] arr) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ID of the employee to update:");
        int id = in.nextInt();

        for (Employee employee : arr) {
            if (employee != null && employee.employeeId == id) {
                System.out.println("Enter new details (Name, Position, Salary):");
                employee.name = in.next();
                employee.position = in.next();
                employee.salary = in.nextInt();
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void traverse(Employee[] arr) {
        System.out.println("Employee List:");
        for (Employee employee : arr) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static int findEmployeeIndex(Employee[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].employeeId == id) {
                return i;
            }
        }
        return -1;
    }

    public static Employee[] delete(Employee[] arr) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ID of the employee to delete:");
        int id = in.nextInt();

        int index = findEmployeeIndex(arr, id);

        if (index != -1) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = null;
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
        return arr;
    }
}
//Analysis:
//Add Operation: O(1) - Adding an employee is constant time if there is space in the array.
//Search Operation: O(n) - Linear search through the array.
//Traverse Operation: O(n) - Iterates through the array.
//Delete Operation: O(n) - Linear search to find the employee and then shift remaining elements.
