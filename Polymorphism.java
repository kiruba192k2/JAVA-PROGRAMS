class Employee
{
    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary)
    {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    void display()
    {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
    }
}

class Developer extends Employee
{
    String programmingLanguage;

    Developer(int empId,
              String name,
              double salary,
              String programmingLanguage)
    {
        super(empId, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void display()
    {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
        System.out.println("Programming Language : " + programmingLanguage);
    }
}

class Tester extends Employee
{
    String testingTool;

    Tester(int empId,
           String name,
           double salary,
           String testingTool)
    {
        super(empId, name, salary);
        this.testingTool = testingTool;
    }

    @Override
    void display()
    {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
        System.out.println("Testing Tool : " + testingTool);
    }
}

public class Polymorphism
{
    public static void main(String[] args)
    {
        Employee emp;

        emp = new Developer(101, "Ram", 50000, "Java");
        emp.display();

        System.out.println();

        emp = new Tester(102, "Ravi", 45000, "Selenium");
        emp.display();
    }
}