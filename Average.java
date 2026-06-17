import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mark in subject 1");
        String p = sc.nextLine();
        int m1=Integer.parseInt(p);
        System.out.println("Enter mark in subject 2");
        String p1 = sc.nextLine();
        int m2=Integer.parseInt(p1);
        System.out.println("Enter mark in subject 3");
       String p2 = sc.nextLine();
        int m3=Integer.parseInt(p2);

        int total =m1+m2+m3;
        float avg =total/3;
        System.out.println("Average    "+avg);
       
    
}
}
