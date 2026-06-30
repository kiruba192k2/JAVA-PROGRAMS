package Demo;

import java.util.*;

public class Add {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter shirt price");
        String p = sc.nextLine();
        int sp = Integer.parseInt(p);
        System.out.println("Enter Pant price");
        String p1 = sc.nextLine();
        int pp = Integer.parseInt(p1);
        int total = sp + pp;
        System.out.println("Total bill price    " + total);

    }

}
