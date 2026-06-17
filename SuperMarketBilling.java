import java.util.*;

public class SuperMarketBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer Name :");
        String na = sc.nextLine();

        System.out.println("Enter Customer ID :");
        String r = sc.nextLine();
        int id = Integer.parseInt(r);

        System.out.println("Enter Total No of Products :");
        String a = sc.nextLine();
        int tno = Integer.parseInt(a);

        String[] productname = new String[tno];
        int[] quantity = new int[tno];
        int[] price = new int[tno];
        int[] totalprice = new int[tno];

        int total = 0;

        // Input Products
        for (int i = 0; i < tno; i++) {

            System.out.println("\nEnter Product Name :");
            productname[i] = sc.nextLine();

            System.out.println("Enter Quantity (Kg) :");
            String c = sc.nextLine();
            int no = Integer.parseInt(c);
            quantity[i] = no;

            System.out.println("Enter Price :");
            String b = sc.nextLine();
            int p = Integer.parseInt(b);
            price[i] = p;

            totalprice[i] = quantity[i] * price[i];

            total += totalprice[i];
        }

        // Discount
        int discount = 0;

        if (total >= 5000) {
            discount = total * 20 / 100;
        }
        else if (total >= 3000) {
            discount = total * 10 / 100;
        }

        int finalBill = total - discount;

        
        System.out.println("\n========== BILL ==========");

        System.out.println("Customer Name : " + na);
        System.out.println("Customer ID   : " + id);

        System.out.println("\nProducts Details:");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < tno; i++) {

            System.out.println("Product Name : Quantity  Price  Total  " );
            System.out.println(   productname[i]+
             + quantity[i]   + price[i] +   totalprice[i] );
            

            System.out.println("-----------------------------------------");
        }

        System.out.println("Grand Total  : " + total);
        System.out.println("Discount     : " + discount);
        System.out.println("Final Bill   : " + finalBill);

        
    }
}