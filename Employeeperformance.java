
import java.util.ArrayList;

public class Employeeperformance {

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(72);
        scores.add(90);
        scores.add(88);
        scores.add(65);
        scores.add(95);
        scores.add(80);
        scores.add(91);
        scores.add(78);
        scores.add(86);
        scores.add(70);
        long count = scores.stream().filter(mark -> mark >= 80).count();
        System.out.println(" No of Employees Eligible for Promotion with Score >= 80 is" + count);
        System.out.println("Employees Eligible for Promotion (Score >= 85):");
        scores.stream()
                .filter(score -> score >= 85)
                .forEach(System.out::println);
    }
}
