
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee1 {

    private int employeeId;
    private String employeeName;
    private String department;
    private double salary;

    public Employee1() {
    }

    public Employee1(int employeeId, String employeeName, String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Department : " + department);
        System.out.println("Salary : " + salary);
    }
}

public class ReflectionTask1 {

    public static void main(String[] args) {

        Employee1 employee = new Employee1(101, "Sri", "IT", 50000);

        Class<?> employeeClass = employee.getClass();

        System.out.println("Class Name");
        System.out.println(employeeClass.getName());

        System.out.println("\nFields");

        Field[] fields = employeeClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName());
        }

        System.out.println("\nMethods");

        Method[] methods = employeeClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
