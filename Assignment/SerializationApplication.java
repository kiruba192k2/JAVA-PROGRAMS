package Assignment;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Sensitive {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface DisplayName {

    String value();
}

class Employee implements Serializable {

    private int id;
    private String name;
    private String department;
    @DisplayName("Employee Salary")
    private double salary;
    @Sensitive
    private transient String password;
    private String address;

    public Employee(int id, String name, String department,
            double salary, String password, String address) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "\nName: " + name
                + "\nDepartment: " + department
                + "\nSalary: ₹" + salary
                + "\nPassword: " + password
                + "\nAddress: " + address;
    }
}

class EmployeeSerializer {

    public void save(List<Employee> employees, String fileName) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
        output.writeObject(employees);
        output.close();
    }
}

class EmployeeDeserializer {

    @SuppressWarnings("unchecked")
    public List<Employee> load(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
        List<Employee> employees = (List<Employee>) input.readObject();

        input.close();
        return employees;
    }
}

class EmployeeManager {

    public void displaySensitiveFields() {
        System.out.println("\nSensitive fields:");
        Field[] fields = Employee.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Sensitive.class)) {
                System.out.println(field.getName());
            }
        }
    }

    public void displayAnnotatedFields(Employee employee) throws IllegalAccessException {
        System.out.println("\nAnnotated fields:");
        Field[] fields = Employee.class.getDeclaredFields();
        for (Field field : fields) {
            DisplayName displayName = field.getAnnotation(DisplayName.class);

            if (displayName != null) {
                field.setAccessible(true);
                Object value = field.get(employee);
                System.out.println(displayName.value() + ": " + value);
            }
        }
    }
}

public class SerializationApplication {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.println("\nEnter details for employee " + i);
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            Employee employee = new Employee(id, name, department, salary, password, address);
            employees.add(employee);
        }
        System.out.println("\nOriginal Employee Details:");
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println();
        }
        EmployeeManager manager = new EmployeeManager();
        manager.displaySensitiveFields();
        if (!employees.isEmpty()) {
            manager.displayAnnotatedFields(employees.get(0));
        }
        String fileName = "employees.dat";
        EmployeeSerializer serializer = new EmployeeSerializer();
        serializer.save(employees, fileName);
        System.out.println("\nEmployees saved successfully.");
        EmployeeDeserializer deserializer = new EmployeeDeserializer();
        List<Employee> restored = deserializer.load(fileName);
        System.out.println("\nRestored Employee Details:");
        for (Employee employee : restored) {
            System.out.println(employee);
            System.out.println();
        }
        System.out.println("Verification:");
        if (employees.size() == restored.size()) {
            System.out.println("All employees were restored successfully.");
        } else {
            System.out.println("Employee restoration failed.");
        }
        System.out.println("\nPassword check:");
        for (Employee employee : restored) {
            System.out.println(employee.getName() + " - Password: " + employee.getPassword());
        }
        System.out.println("\nPassword is null because the field is transient.");
        scanner.close();
    }
}
