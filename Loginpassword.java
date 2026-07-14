
import java.util.Scanner;

public class Loginpassword {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLetter(ch)) {
                hasLetter = true;
            }
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }
        }
        if (password.length() >= 8
                && hasLetter
                && hasNumber
                && !password.contains(" ")) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
        sc.close();
    }
}
