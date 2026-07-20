
import java.util.*;

class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Comparatordemo {

    public static void main(String[] args) {
        ArrayList<Employee> ar = new ArrayList<>();
        ar.add(new Employee(104, "Yuvasri"));
        ar.add(new Employee(101, "Ravichandran"));
        ar.add(new Employee(103, "JaiRam"));
        // ar.sort((e1,e2)->e1.id-e2.id);
        Collections.sort(ar, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }
        });
        for (Employee e : ar) {
            System.out.println(e.id + " " + e.name);
        }
    }
}
