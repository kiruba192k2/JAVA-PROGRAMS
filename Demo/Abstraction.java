package Demo;

abstract class Employeerole {

    int empId;
    String name;
    double salary;

    Employeerole(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    abstract void work();

    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
    }
}

class Developer extends Employeerole {

    Developer(int empId, String name, double salary) {
        super(empId, name, salary);
    }

    @Override
    void work() {
        System.out.println("Developer develops software applications.");
    }
}

public class Abstraction {

    public static void main(String[] args) {
        Employeerole emp = new Developer(101, "Kiruba", 50000);

        emp.display();
        emp.work();
    }
}
