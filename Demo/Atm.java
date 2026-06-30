package Demo;

import java.util.Scanner;

public class Atm {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account number ");
        String a = sc.nextLine();
        int ac = Integer.parseInt(a);
        System.out.println("Enter amount to be Withdraw");
        String b = sc.nextLine();
        int am = Integer.parseInt(a);
        int bl = 10000;
        if (am <= bl) {
            System.out.println("Witdrawl processing");

        } else {
            System.out.println("Unable to  Process Withdrawal");
        }

    }

}
