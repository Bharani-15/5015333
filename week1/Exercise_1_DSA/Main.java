import java.util.ArrayList;
import java.util.Scanner;


//Why Data Structures and Algorithms are Essential:
//Efficiency: Efficient data structures and algorithms enable quick storage, retrieval, and manipulation of inventory data.
//Scalability: As the inventory grows, the right data structures ensure the system can handle the increased load without performance degradation.
//Maintainability: Proper algorithms and data structures make the codebase easier to maintain and extend.
//Types of Data Structures Suitable for This Problem:
//ArrayList: Provides dynamic array functionality with fast random access and iteration, suitable for scenarios with frequent additions and traversal.
//HashMap: Offers average O(1) time complexity for insertions, deletions, and lookups, making it suitable for quick access and modification of product records.//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m;
        System.out.println("press 1 to start");
        m=in.nextInt();
        System.out.println("Choose an option: 1-Add, 2-Update, 3-Delete");
        int n=in.nextInt();
        System.out.println("give no. of products");
        int products=in.nextInt();
//      Product a=new Product(1,"bulb",1,450);
        ArrayList<Product> list=new ArrayList<>();
        ArrayList<Product> list1 = null;
        while(m!=0){
            if(n==1){
                list1=ProductAdd(list,products);
            }else if(n==2){
                list1=ProductUpdate(list,products);
            }else if(n==3){
            list1=ProductDelete(list,products);
            }
            int i;
            for(i=0;i<list1.size();i++){
                if (list.get(i) != null) {
                    System.out.print(list1.get(i).productId+" ");
                    System.out.print(list1.get(i).productName+" ");
                    System.out.print(list1.get(i).quantity+" ");
                    System.out.print(list1.get(i).price+" ");
                    System.out.println();
                }
            }
            System.out.println("press 1 to start or 0 to stop");
            m=in.nextInt();
            if(m==1){
                System.out.println("do you want to add=1,update=2,delete=3");
                n=in.nextInt();
                System.out.println("give no. of products");
                products=in.nextInt();
                System.out.println("give details of the products");
            }
        }
//        list1=ProductAdd(productId,productName,quantity,price,list);
//        int i;
//        for(i=0;i<list1.size();i++){
//            System.out.print(list1.get(i).productId+" ");
//            System.out.print(list1.get(i).productName+" ");
//            System.out.print(list1.get(i).quantity+" ");
//            System.out.print(list1.get(i).price+" ");
//            System.out.println();
//        }
    }
    public static ArrayList<Product> ProductAdd(ArrayList<Product> list,int products){
        Scanner in=new Scanner(System.in);
        int i;
        for(i=0;i<products;i++){
            System.out.println("give details of the products");
            int productId=in.nextInt();
            String productName=in.next();
            int quantity=in.nextInt();
            int price=in.nextInt();
            Product add=new Product(productId,productName,quantity,price);
            list.add(i,add);
        }
        return list;
    }
    public static ArrayList<Product> ProductUpdate(ArrayList<Product> list,int products){
        Scanner in=new Scanner(System.in);
        int i;
        for(i=0;i<list.size();i++){
            System.out.println("give details of the products");
            int productId=in.nextInt();
            String productName=in.next();
            int quantity=in.nextInt();
            int price=in.nextInt();
            if(list.get(i).productId==productId){
                list.get(i).productName=productName;
                list.get(i).productId=productId;
                list.get(i).price=price;
                list.get(i).quantity=quantity;
            }else{
                System.out.println("give correct product ID");
                i--;
            }
        }
        return list;
    }

    public static ArrayList<Product> ProductDelete(ArrayList<Product> list,int products){
        Scanner in=new Scanner(System.in);
        int i,j;
        for(i=0;i<products;i++){
            System.out.println("give product ID");
            int productId=in.nextInt();
            for(j=0;j<list.size();j++){
                Product tem=list.get(j);
                if(tem.productId==productId){
                    list.remove(j);
                }
            }
        }
         return list;
    }
}

//Analysis:
//Time Complexity:
//Add Operation:
//ArrayList: O(1) average time complexity for adding an element at the end.
//Update Operation:
//ArrayList: O(n) in the worst case, as it may need to scan the entire list to find the product.
//Delete Operation:
//ArrayList: O(n) in the worst case, as it may need to scan the entire list to find the product and shift elements.