
import java.util.ArrayList;

public class wrap {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(90);
        a.add(76);
        a.add(99);
        a.add(87);
        a.add(89);
        System.out.println("Student marks :");
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
