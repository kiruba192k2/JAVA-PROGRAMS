package Demo;
import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Salary per Day");
        String p = sc.nextLine();
        int pds=Integer.parseInt(p);
        System.out.println("Enter Total no of days worked");
        String p1 = sc.nextLine();
        int td=Integer.parseInt(p1);
        int total =pds*td;
        System.out.println("Total bill price    "+total);
    
}
}
