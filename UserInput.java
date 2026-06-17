import java.util.*;
public class UserInput {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name");
        String name = sc.nextLine();
         System.out.println("Enter student Department");
        String dept = sc.nextLine();
         System.out.println("Enter student Location");
        String loct = sc.nextLine();
         System.out.println("Enter student Year of Studying");
        int yr = sc.nextInt();
        sc.nextLine();
        
         System.out.println("Enter student DOB");
        String dob = sc.nextLine();
        
        System.out.println("Name              : " + name);
        System.out.println("Department        : " + dept);
        System.out.println("Location          : " +loct);
        System.out.println("DOB               : " +dob);
        System.out.println("Year of Studying  : " +yr);


        sc.close();
    }
}
    

