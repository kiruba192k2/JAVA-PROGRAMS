import java.util.Scanner;

public class SuperMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter Customer Name :");
        String na =sc.nextLine();
        System.out.println("Enter Customer ID :");
        String r =sc.nextLine();
        int id= Integer.parseInt(r);
       System.out.println("Enter Total No of Product :");
       String a =sc.nextLine();
       int tno= Integer.parseInt(a);
        int i=0;
        int total=0;
        int discount=0;
        int bill=0;
        //if (i>tno) { 
        System.out.println("Enter Product Name :");
        String n =sc.nextLine();              
        System.out.println("Enter product Price :");
         String b =sc.nextLine();
        int p= Integer.parseInt(b); 
        System.out.println("Enter No of product :");
         String c =sc.nextLine();
        int no= Integer.parseInt(c);
        total = p*no;
        if (total>=5000) {
             discount= total * 20/100;
             bill =total-discount;            
        } 
        else if (total>=3000) {
             discount=total*10/100;
             bill =total-discount; 
        }
        else{
            bill =total;
        }
        // }
         System.out.println("Customer Name :" +na);
         System.out.println("Customer ID :" +id);
          System.out.println(" Product Name :"+n);
           System.out.println("Product Price :"+p);
           System.out.println(" No of product :"+no);
            System.out.println(" Total Amount :"+total);
             System.out.println(" Discount :"+discount); 
             System.out.println(" Billing Amount :"+bill);



          
         
    
                
              
        
           
        }


            
        }
         
        
    

