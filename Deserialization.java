
import java.io.*;

public class Deserialization {

    public static void main(String[] args) throws Exception {

        ObjectInputStream input
                = new ObjectInputStream(
                        new FileInputStream("employee.ser")
                );

        EmployeeSerialization employee
                = (EmployeeSerialization) input.readObject();

        input.close();

        System.out.println("--------------------------------");
        System.out.println("Employee Details");
        System.out.println("--------------------------------");

        employee.displayEmployee();

        System.out.println("--------------------------------");
    }
}
