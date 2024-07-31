package com.Bharani.SortingCustomersOrders;

import com.Bharani.Quicksort;

import java.util.Arrays;

//Understanding Sorting Algorithms:
//Bubble Sort:
//
//Simple sorting algorithm.
//Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
//Time Complexity: O(n^2) for all cases.

//Insertion Sort:
//Builds the final sorted array one item at a time.
//Picks the next element and inserts it into its correct position in the sorted part.
//Time Complexity: O(n^2) in the average and worst case, O(n) in the best case.

//Quick Sort:
//Divide-and-conquer algorithm.
//Picks a pivot element and partitions the array around the pivot.
//Recursively applies the same process to sub-arrays.
//Time Complexity: O(n log n) on average, O(n^2) in the worst case.

//Merge Sort:
//Divide-and-conquer algorithm.
//Divides the array into two halves, sorts them, and then merges them.
//Time Complexity: O(n log n) in all cases.

public class Order {
    int orderId;
    String customerName;
    int totalPrice;

    public Order(int orderId,String customerName,int totalPrice){
        this.orderId=orderId;
        this.customerName=customerName;
        this.totalPrice=totalPrice;
    }

    public static void main(String[] args) {
        Order[] arr={new Order(2,"guru",122),new Order(4,"balaji",34),new Order(1,"Devakaran",10)};
        int i;
        QuickSort(arr,0,arr.length-1);
        for(i=0;i<arr.length;i++){
            System.out.println(arr[i].orderId+" "+arr[i].customerName+" "+arr[i].totalPrice);
        }

    }
    public static Order[] BubbleSort(Order[] arr){
        int i,j;
        for(i=0;i<arr.length;i++){
            for(j=1;j<arr.length-i;j++){
                if(arr[j].totalPrice<arr[j-1].totalPrice){
                    Order temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;
    }

    public static Order[] QuickSort(Order[] arr,int low,int hi){
            if (low >= hi) {
                return arr;
            }
            int s = low;
            int e = hi;
            int m = s + (e - s) / 2;
            Order pivot = arr[m];

            while (s <= e) {
                while (arr[s].totalPrice < pivot.totalPrice) {
                    s++;
                }
                while (arr[e].totalPrice > pivot.totalPrice) {
                    e--;
                }

                if (s <= e) {
                    Order temp = arr[s];
                    arr[s] = arr[e];
                    arr[e] = temp;
                    s++;
                    e--;
                }
            }
            QuickSort(arr, low, e);
            QuickSort(arr, s, hi);
            return arr;
    }
}

//Analysis:
//Performance Comparison:
//Bubble Sort: O(n^2) time complexity, inefficient for large datasets.
//Quick Sort: O(n log n) average time complexity, much faster for large datasets but has a worst-case time complexity of O(n^2).

//Why Quick Sort is Preferred:
//Quick Sort is generally faster due to its O(n log n) average time complexity.
//Bubble Sort’s O(n^2) complexity makes it impractical for large datasets.
//Quick Sort efficiently sorts large arrays due to its divide-and-conquer approach, making it suitable for real-world applications.