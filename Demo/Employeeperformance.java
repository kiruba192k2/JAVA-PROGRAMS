package Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int f = scores.stream().filter(mark -> mark >= 80).findFirst().get();
        List<Integer> l = scores.stream().filter(mark -> mark >= 80).collect(Collectors.toList());
        System.out.println("eligibe employee");
        l.forEach(System.out::println);

        System.out.println(" No of Employees Eligible for Promotion with Score >= 80 is " + count);
        System.out.println(" First Score of Employees Eligible for Promotion with Score >= 80 is " + f);
        System.out.println("Employees Eligible for Promotion (Score >= 85):");
        scores.stream()
                .filter(score -> score >= 85)
                .forEach(System.out::println);
    }
}
