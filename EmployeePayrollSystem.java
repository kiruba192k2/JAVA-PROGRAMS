import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class EmployeePayrollSystem {
    static final String URL = "jdbc:mysql://localhost:3306/payroll_db";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static Scanner sc = new Scanner(System.in);
    static class Employee implements Comparable<Employee> {
        private int empid;
        private String empname;
        private String department;
        private String designation;
        private double salary;
        public Employee(int empid, String empname, String department, String designation, double salary) {
            this.empid = empid;
            this.empname = empname;
            this.department = department;
            this.designation = designation;
            this.salary = salary;
        }
        public int getEmpid() {
            return empid;
        }
        public String getEmpname() {
            return empname;
        }
        public String getDepartment() {
            return department;
        }
        public String getDesignation() {
            return designation;
        }
        public double getSalary() {
            return salary;
        }
        @Override
        public int compareTo(Employee other) {
            return this.empname.compareToIgnoreCase(other.empname);
        }
        @Override
        public String toString() {
            return String.format( "%-8d %-20s %-15s %-20s %.2f", empid, empname, department, designation, salary );
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void registerEmployee() {
        int empid;
        while (true) {
            empid = getInt("Enter Employee ID: ");
            if (empid <= 0) {
                System.out.println("Employee ID must be greater than 0.");
            } else {
                break;
            }
        }
        String empname;
        while (true) {
            System.out.print("Enter Employee Name: ");
            empname = sc.nextLine().trim();
            if (!empname.isEmpty() && empname.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Invalid Name!");
                System.out.println("Name must contain only alphabets and spaces.");
            }
        }
        String department;
        while (true) {
            System.out.print("Enter Department: ");
            department = sc.nextLine().trim();
            if (!department.isEmpty()) {
                break;
            } else {
                System.out.println("Department should not be empty.");
            }
        }
        String designation;
        while (true) {
            System.out.print("Enter Designation: ");
            designation = sc.nextLine().trim();
            if (!designation.isEmpty()) {
                break;
            } else {
                System.out.println("Designation should not be empty.");
            }
        }
        double salary;
        while (true) {
            salary = getDouble("Enter Salary: ");

            if (salary <= 0) {
                System.out.println("Salary must be greater than 0.");
            } else {
                break;
            }
        }
        Employee employee = new Employee(empid, empname, department, designation, salary);
        String sql = "INSERT INTO employee " + "(empid, empname, department, designation, salary) " +"VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql) ) {
            ps.setInt(1, employee.getEmpid());
            ps.setString(2, employee.getEmpname());
            ps.setString(3, employee.getDepartment());
            ps.setString(4, employee.getDesignation());
            ps.setDouble(5, employee.getSalary());
            ps.executeUpdate();
            System.out.println("Employee Registered Successfully.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Employee ID already exists.");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
    public static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection con = getConnection();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("empid"),
                        rs.getString("empname"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDouble("salary"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return employees;
    }
    public static void viewAllEmployees() {
        ArrayList<Employee> employees = getAllEmployees();
        displayEmployees(employees);
    }
    public static void displayEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-15s %-20s %-10s%n", "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY");
        System.out.println("-----------------------------------------------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("-----------------------------------------------------------------------");
    }
    public static void searchEmployee() {
        int empid = getInt("Enter Employee ID: ");
        String sql = "SELECT * FROM employee WHERE empid = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql) ) {
            ps.setInt(1, empid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("\nEmployee Found");
                System.out.println("Employee ID: " + rs.getInt("empid"));
                System.out.println("Employee Name: " + rs.getString("empname"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee Not Found.");
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
    public static void updateSalary() {
        int empid = getInt("Enter Employee ID: ");
        double salary;
        while (true) {
            salary = getDouble("Enter New Salary: ");
            if (salary <= 0) {
                System.out.println("Salary must be greater than 0.");
            } else {
                break;
            }
        }
        String sql = "UPDATE employee SET salary = ? WHERE empid = ?";
        try ( Connection con = getConnection();  PreparedStatement ps = con.prepareStatement(sql) ) {
            ps.setDouble(1, salary);
            ps.setInt(2, empid);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Salary Updated Successfully.");
            } else {
                System.out.println("Employee Not Found.");
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
    public static void deleteEmployee() {
        int empid = getInt("Enter Employee ID: ");
        System.out.print("Are you sure (Y/N)? ");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            String sql = "DELETE FROM employee WHERE empid = ?";
            try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, empid);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Employee Deleted Successfully.");
                } else {
                    System.out.println("Employee Not Found.");
                }
            } catch (SQLException e) {
                System.out.println("Database Error: " + e.getMessage());
            }
        } else {
            System.out.println("Delete Operation Cancelled.");
        }
    }
    public static void sortByName() {
        ArrayList<Employee> employees = getAllEmployees();
        employees.sort(null);
        System.out.println("\nEmployees Sorted by Name:");
        displayEmployees(employees);
    }
    public static void sortBySalary() {
        ArrayList<Employee> employees = getAllEmployees();
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("\nEmployees Sorted by Salary Descending:");
        displayEmployees(employees);
    }
    public static void exportToFile() {
        ArrayList<Employee> employees = getAllEmployees();
        try (FileWriter writer = new FileWriter("employeedetails.txt")) {
            writer.write("EMPLOYEE PAYROLL DETAILS\n");
            writer.write("-----------------------------------------------------------------------\n");
            writer.write( String.format(  "%-8s %-20s %-15s %-20s %-10s%n","ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY" ));
            writer.write("-----------------------------------------------------------------------\n");
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.write("\n");
            }
            System.out.println("Employee Details Exported Successfully.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
    public static int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid integer.");
            }
        }
    }
    public static double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary input.");
            }
        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("       EMPLOYEE PAYROLL SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Register Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Sort by Name");
            System.out.println("7. Sort by Salary");
            System.out.println("8. Export to File");
            System.out.println("9. Exit");
            System.out.println("========================================");
            int choice = getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateSalary();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    sortByName();
                    break;
                case 7:
                    sortBySalary();
                    break;
                case 8:
                    exportToFile();
                    break;
                case 9:
                    System.out.println("Thank you for using Employee Payroll System.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }
}