package Demo;
import java.util.*;

public class While {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        
        for (int i = 1; i <= n; i++) {
            System.out.println("roll num " + i);
        }

      
        int atmp = 3;
        int i = 1;

        while (i <= atmp) {
            System.out.println("checking password attempt " + i);
            i++;
        }

       
    }
}