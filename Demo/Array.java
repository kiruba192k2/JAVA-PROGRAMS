package Demo;

import java.util.*;

public class Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Entries:");
        String i = sc.nextLine();
        int n = Integer.parseInt(i);
        String[] students = new String[n];
        for (int j = 0; j < n; j++) {
            System.out.println("Enter the data:" + (j + 1));
            students[j] = sc.nextLine();

        }
        System.out.println();
        System.out.println("Student List");
        System.out.println();

        for (String student : students) {
            System.out.println(student);
        }
    }

}
