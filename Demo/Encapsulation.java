package Demo;
class Employeedetails
{
    private int empId;
    private String name;
    private double salary;

    Employeedetails(int empId, String name, double salary)
    {
        this.empId = empId;
        this.name = name;
        setSalary(salary);
    }

    void setSalary(double salary)
    {
        if (salary > 0)
        {
            this.salary = salary;
        }
        else
        {
            System.out.println("Invalid Salary");
        }
    }

    double getSalary()
    {
        return salary;
    }

    void display()
    {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
    }
}

public class Encapsulation
{
    public static void main(String[] args)
    {
        Employeedetails emp = new Employeedetails(101, "John", 50000);

        emp.display();

        System.out.println("Salary using Getter: " + emp.getSalary());
    }
}