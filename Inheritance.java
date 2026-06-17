class Employee {

    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
}
class Tester extends Employee{
    String software;

    public Tester(String software, int empId, String name, double salary) {
        super(empId, name, salary);
        this.software = software;
    }
     void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
        System.out.println("Software Known: " + software);
    }
    

}

class Developer extends Employee {

    String programmingLanguage;

    Developer(int empId,
              String name,
              double salary,
              String programmingLanguage) {

        super(empId, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
        System.out.println("Programming Language : " + programmingLanguage);
    }
}

public class Inheritance {

    public static void main(String[] args) {

        Developer dev = new Developer(
                101,
                "Ram",
                50000,
                "Java"
        );

        dev.display();
        Tester tes=new Tester("CTest",
         103,
          "yuvaraj",
           35999);
           tes.display();

        
    }
}
