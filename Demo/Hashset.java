package Demo;

import java.util.HashSet;
import java.util.Scanner;

public class Hashset {

    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        System.out.println("Enter No of Courses: ");
        int n = sa.nextInt();
        System.out.println("--Enter course Name---");
        for (int i = 0; i < n + 1; i++) {
            hs.add(sa.nextLine());
        }
        System.out.print("\nCourses Available\n--------------------");
        for (String string : hs) {
            System.out.println(string);
        }
        System.out.println("\nAvail / Not Avail\nif it's remove it\n");
        System.out.println("Enter the Course: ");
        String c = sa.nextLine();
        if (hs.contains(c)) {
            System.out.println("Avail");
            hs.remove(c);
            System.out.println(hs.size());
        } else {
            System.out.println("Not Avail");
        }
        System.out.print("\nCourses Available after removal\n--------------------");
        for (String st : hs) {
            System.out.println(st);
        }
        sa.close();
    }
}
