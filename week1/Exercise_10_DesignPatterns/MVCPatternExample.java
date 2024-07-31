package com.Bharani.week1.Ex10;

public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a student model
        Student student = new Student();
        student.setName("John Doe");
        student.setId("123");
        student.setGrade("A");

        // Create a student view
        StudentView view = new StudentView();

        // Create a student controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}

