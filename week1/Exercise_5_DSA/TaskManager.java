package com.Bharani.TaskManagement;

import java.util.Scanner;

//Understand Linked Lists:
//Singly Linked List:
//A singly linked list is a type of data structure that consists of a sequence of elements where each element points to the next one in the sequence. It has the following characteristics:
//Each element is a node that contains data and a reference (or link) to the next node in the list.
//The list has a head (the first node) and possibly a tail (the last node), where the tail points to null.
//Doubly Linked List:
//A doubly linked list is similar to a singly linked list, but each node contains two references:
//
//One reference points to the next node in the list.
//Another reference points to the previous node in the list.
//This allows traversal in both forward and backward directions.

public class TaskManager {
    static class Task {
        int taskId;
        String taskName;
        String status;

        Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }


    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }


    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while (temp.next != null && temp.next.task.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            return false;
        }
        temp.next = temp.next.next;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskManager tm = new TaskManager();


        System.out.println("Enter the number of tasks:");
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter taskId, taskName, and status for task " + (i + 1) + ":");
            int taskId = in.nextInt();
            in.nextLine();
            String taskName = in.nextLine();
            String status = in.nextLine();
            tm.addTask(new Task(taskId, taskName, status));
        }


        System.out.println("Traversing tasks:");
        tm.traverseTasks();


        System.out.println("\nEnter the taskId to search for:");
        int searchId = in.nextInt();
        Task task = tm.searchTask(searchId);
        if (task != null) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nEnter the taskId to delete:");
        int deleteId = in.nextInt();
        boolean deleted = tm.deleteTask(deleteId);
        if (deleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }


        System.out.println("\nTraversing tasks after deletion:");
        tm.traverseTasks();

        in.close();
    }
}
// Analysis:
//Time Complexity:
//Adding a Task: O(n) in the worst case, as it might need to traverse the entire list to add the task at the end.
//Searching for a Task: O(n), as it may need to check each node in the list.
//Traversing the Tasks: O(n), as it needs to visit each node once.
//Deleting a Task: O(n) in the worst case, as it may need to traverse the entire list to find the task to delete

