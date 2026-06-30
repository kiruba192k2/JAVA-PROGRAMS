package Demo;

import java.util.*;

public class registeration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> h = new HashSet<>();
        h.add("java");
        h.add("python");
        h.add("c++");
        h.add("c");
        h.add("python");

        System.out.println("registered course");
        int count = 1;
        for (String st : h) {
            System.out.println(count++ + "." + st);
        }
        count = 1;
        System.out.println();
        System.out.println("enter course name : ");
        String cs = sc.nextLine();

        if (!h.contains(cs)) {
            System.out.println("not available");
        } else {
            System.out.println(cs + " course available");
        }
        System.out.println();
        System.out.println("enter remove course name :");
        String re = sc.nextLine();
        h.remove(re);
        System.out.println();
        System.out.println("after removing...");
        for (String st : h) {
            System.out.println(st);
        }
        System.out.println();
        System.out.println("total courses : " + h.size());
    }
}
