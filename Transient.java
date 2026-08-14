
import java.io.*;

class EmployeeSerialDeserialDemo implements Serializable {

    private String employeeId;
    private String employeeName;
    private String department;
    private transient double salary;

    EmployeeSerialDeserialDemo(String employeeId, String employeeName,
            String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID    : " + employeeId);
        System.out.println("Employee Name  : " + employeeName);
        System.out.println("Department     : " + department);
        System.out.println("Salary         : ₹" + salary);
    }
}

public class Transient {

    public static void main(String[] args) throws Exception {
        EmployeeSerialDeserialDemo employee
                = new EmployeeSerialDeserialDemo(
                        "EMP1001",
                        "Rama",
                        "SAP",
                        50000
                );

        // Serialization
        ObjectOutputStream output
                = new ObjectOutputStream(
                        new FileOutputStream("employee.ser")
                );

        output.writeObject(employee);
        output.close();

        System.out.println("Employee data saved successfully.");

        // Deserialization
        ObjectInputStream input
                = new ObjectInputStream(
                        new FileInputStream("employee.ser")
                );

        EmployeeSerialDeserialDemo savedEmployee
                = (EmployeeSerialDeserialDemo) input.readObject();

        input.close();

        System.out.println();
        System.out.println("-------- Employee Details --------");
        savedEmployee.displayEmployee();
        System.out.println("----------------------------------");
    }
}
