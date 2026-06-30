package Demo;

import java.util.ArrayList;

public class StudentMark {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(100);
        a.add(60);
        a.add(79);
        a.add(90);
        a.add(98);
        System.err.println("students marks above 85");
        a.stream().filter(mark -> mark > 85).forEach(System.out::println);
        System.err.println("students marks After 5 marks added");
        a.stream().map(mark -> mark + 5).forEach(System.out::println);
        System.err.println("students marks After sorted");
        a.stream().sorted().forEach(System.out::println);

    }

}
