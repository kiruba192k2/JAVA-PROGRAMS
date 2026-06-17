
    class Employee {
    int empid;
    String name;
    double Salary;
 
   
    Employee (int empid, String name, double Salary) {
        this.empid = empid;
        this.name = name;
        this.Salary = Salary;
    }
 
    void display() {
         System.out.println("---------------------");
        System.out.println("Employee ID :    " + empid);
        System.out.println("Name        :    " + name);
        System.out.println("Salary      :    " + Salary);
        System.out.println("---------------------");
    }
}
 
public class Constructor {
    public static void main(String[] args) {
        Employee E1 = new Employee(1002, "Kavitha", 49000);
        Employee E2 = new Employee(1003, "Robert", 57000);
        E1.display();
        E2.display();
    }
 
}
 
 
