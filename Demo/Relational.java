package Demo;
import java.util.Scanner;

public class Relational {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Age");
        String p = sc.nextLine();
        int a=Integer.parseInt(p);
        System.out.println("Enter ID present  Type yes or no");
        String i = sc.nextLine();
         boolean d;
        if(i.equalsIgnoreCase("yes")){
            d =true;
        }else{
             d=false;
        }

        System.out.println((a > 18 && d==true) ? "Eligibe":"Not Eligible");
}
    
}
