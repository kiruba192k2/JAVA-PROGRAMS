
import java.util.ArrayList;

public class Week4day2 {

    public static void main(String[] args) {
        ArrayList<Integer> salaries = new ArrayList<>();
        salaries.add(10000);
        salaries.add(20000);
        salaries.add(50000);
        salaries.add(30000);
        salaries.add(14000);
        System.err.println("Salaries > 15000");
        salaries.stream().filter(salary -> salary > 15000).forEach(System.out::println);

    }
}
