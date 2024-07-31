package com.Bharani.eCommerce;

import java.util.Scanner;

// Understand Asymptotic Notation:
//Big O Notation:
//
//Big O Notation helps describe the upper bound of the time complexity of an algorithm. It provides a worst-case scenario.
//        Best, Average, and Worst-Case Scenarios:
//Best Case: The minimum time an algorithm can take.
//Average Case: The expected time on average.
//Worst Case: The maximum time an algorithm can take.
public class Product {
    int ProductId;
    String ProductNmae;
    String category;


    public Product(int ProductId,String ProductName,String category){
        this.ProductId=ProductId;
        this.ProductNmae=ProductName;
        this.category=category;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n= in.nextInt();
        int i=0;
        Product[] arr=new Product[n];
        while(i<n){
            int id=in.nextInt();
            String name=in.next();
            String c=in.next();
            arr[i]=new Product(id,name,c);
            i++;
        }
        int ID=in.nextInt();
        Product ans=BinarySearch(arr,ID);
        if(ans!=null){
            System.out.println(ans.ProductId+" "+ans.ProductNmae+" "+ans.category);
        }else{
            System.out.println("not found");
        }
    }
    public static Product LinearSearch(Product[] arr,int ID){
        int i,j;
        for(i=0;i< arr.length;i++){
            if(arr[i].ProductId==ID){
                return arr[i];
            }
        }
        return null;
    }

    public static Product BinarySearch(Product[] arr,int ID){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int middle=(start+end)/2;
            if(arr[middle].ProductId==ID){
                return arr[middle];
            }else if(arr[middle].ProductId>ID){
                end=middle-1;
            }else if(arr[middle].ProductId<ID){
                start=middle+1;
            }
        }
        return null;
    }
}

//Analysis;
//Time Complexity Comparison:
//
//Linear Search: O(n) for the worst-case scenario where the product is not found or is the last element.
//Binary Search: O(log n) for the worst-case scenario because it splits the array in half each time.