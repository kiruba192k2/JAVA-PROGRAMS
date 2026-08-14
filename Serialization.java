
import java.io.*;

class EmployeeSerialization implements Serializable {

    private String employeeId;
    private String employeeName;
    private String department;
    private double salary;

    EmployeeSerialization(String employeeId, String employeeName,
            String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Department    : " + department);
        System.out.println("Salary        : ₹" + salary);
    }
}

public class Serialization {

    public static void main(String[] args) throws Exception {

        EmployeeSerialization employee
                = new EmployeeSerialization(
                        "EMP1001",
                        "Rama",
                        "SAP",
                        50000
                );

        ObjectOutputStream output
                = new ObjectOutputStream(
                        new FileOutputStream("employee.ser")
                );

        output.writeObject(employee);
        output.close();

        System.out.println("Employee object serialized successfully.");
    }
}
