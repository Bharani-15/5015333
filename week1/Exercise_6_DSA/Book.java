package com.Bharani.LibManagement;

import java.util.Arrays;
import java.util.Scanner;
// Understand Search Algorithms:
//Linear Search:
//Linear search is a straightforward algorithm that checks each element in a list one by one until it finds the target element or reaches the end of the list. It does not require the list to be sorted.
//
//Algorithm Steps:
//
//Start from the first element of the list.
//Compare the current element with the target element.
//If the current element matches the target, return its index.
//        If not, move to the next element and repeat step 2.
//If the end of the list is reached without finding the target, return -1.
//Time Complexity: O(n), where n is the number of elements in the list.

//Binary Search:
//Binary search is an efficient algorithm that finds the position of a target element within a sorted list. It works by repeatedly dividing the search interval in half.
//
//Algorithm Steps:
//
//Start with two pointers, one at the beginning (low) and one at the end (high) of the list.
//Calculate the middle index: mid = (low + high) / 2.
//Compare the middle element with the target element.
//If the middle element matches the target, return its index.
//If the middle element is greater than the target, move the high pointer to mid - 1 and repeat steps 2-4.
//If the middle element is less than the target, move the low pointer to mid + 1 and repeat steps 2-4.
//If the pointers cross and the target is not found, return -1.
//Time Complexity: O(log n), where n is the number of elements in the list.

public class Book {
    public int bookId;
    public String title;
    public String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of books:");
        int n = in.nextInt();
        in.nextLine(); // consume the newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter bookId, title, and author for book " + (i + 1) + ":");
            int bookId = in.nextInt();
            in.nextLine(); // consume the newline
            String title = in.nextLine();
            String author = in.nextLine();
            books[i] = new Book(bookId, title, author);
        }

        System.out.println("Enter the title of the book to search (Linear Search):");
        String bookTitle = in.nextLine();
        linearSearch(books, bookTitle);

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));

        System.out.println("Enter the title of the book to search (Binary Search):");
        bookTitle = in.nextLine();
        binarySearch(books, bookTitle);

        in.close();
    }

    public static void linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.bookId + " " + book.title + " " + book.author);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);

            if (comparison == 0) {
                System.out.println("Book found: " + books[mid].bookId + " " + books[mid].title + " " + books[mid].author);
                return;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }
}
//Analysis:
//Time Complexity Comparison:
//Linear Search: O(n)
//Binary Search: O(log n)
//When to Use Each Algorithm
//Linear Search: Use when:
//
//The list is small.
//The list is unsorted.
//Insertion and deletion are frequent, and sorting after each operation is not feasible.
//Binary Search: Use when:
//
//The list is large.
//The list is sorted or can be maintained in a sorted state.
//Fast search times are crucial.