
import java.sql.*;
import java.util.*;

public class EmployeeDatabase {

    public static int getValidInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine();
            }
        }
    }

    public static int getPositiveInt(Scanner sc, String message) {
        while (true) {
            int value = getValidInt(sc, message);
            if (value > 0) {
                return value;
            }
            System.out.println("Value must be greater than 0.");
        }
    }

    public static String getValidName(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Name should contain alphabets and spaces only.");
            } else {
                return name;
            }
        }
    }

    // Salary Validation
    public static double getValidSalary(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                double salary = sc.nextDouble();
                sc.nextLine();
                if (salary < 0) {
                    System.out.println("Salary cannot be negative.");
                } else {
                    return salary;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid salary! Enter numbers only.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root");
            while (true) {
                System.out.println("\n===== Employee Registration System =====");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                int choice = getPositiveInt(sc, "Enter Choice: ");
                switch (choice) {
                    case 1:
                        insert(con, sc);
                        break;
                    case 2:
                        view(con);
                        break;
                    case 3:
                        update(con, sc);
                        break;
                    case 4:
                        delete(con, sc);
                        break;
                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Thank You!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    // Insert Employee
    public static void insert(Connection con, Scanner sc) {
        try {
            int n = getPositiveInt(sc, "How many employees do you want to enter? ");
            String sql = "INSERT INTO employee(id,name,salary) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 1; i <= n; i++) {
                System.out.println("\nEmployee " + i);
                int id = getPositiveInt(sc, "Enter Employee ID: ");
                // Check Duplicate ID
                PreparedStatement check = con.prepareStatement(
                        "SELECT id FROM employee WHERE id=?");
                check.setInt(1, id);
                ResultSet rs = check.executeQuery();
                if (rs.next()) {
                    System.out.println("Employee ID already exists.");
                    rs.close();
                    check.close();
                    i--;
                    continue;
                }
                rs.close();
                check.close();
                String name = getValidName(sc, "Enter Employee Name: ");
                double salary = getValidSalary(sc, "Enter Salary: ");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, salary);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Employee Inserted Successfully.");
                }
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // View Employees
    public static void view(Connection con) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");
            System.out.println("\n========== Employee Details ==========");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("--------------------------------------");
                System.out.println("Employee ID     : " + rs.getInt("id"));
                System.out.println("Employee Name   : " + rs.getString("name"));
                System.out.println("Employee Salary : " + rs.getDouble("salary"));
            }
            if (!found) {
                System.out.println("No Employees Found.");
            }
            System.out.println("--------------------------------------");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Employee
    public static void delete(Connection con, Scanner sc) {
        try {
            int id = getPositiveInt(sc, "Enter Employee ID to Delete: ");
            // Check whether employee exists
            PreparedStatement check = con.prepareStatement(
                    "SELECT * FROM employee WHERE id=?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (!rs.next()) {
                System.out.println("Employee Not Found.");
                rs.close();
                check.close();
                return;
            }
            rs.close();
            check.close();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee Deleted Successfully.");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Employee
    public static void update(Connection con, Scanner sc) {
        try {
            int id = getPositiveInt(sc, "Enter Employee ID to Update: ");
            // Check whether employee exists
            PreparedStatement check = con.prepareStatement(
                    "SELECT * FROM employee WHERE id=?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (!rs.next()) {
                System.out.println("Employee Not Found.");
                rs.close();
                check.close();
                return;
            }
            rs.close();
            check.close();
            String name = getValidName(sc, "Enter New Name: ");
            double salary = getValidSalary(sc, "Enter New Salary: ");
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE employee SET name=?, salary=? WHERE id=?");
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee Updated Successfully.");
            } else {
                System.out.println("Employee Not Found.");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
