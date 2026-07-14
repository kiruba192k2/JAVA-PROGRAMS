
import java.sql.*;
import java.util.Scanner;

public class employeemanagement {

    // Insert Employee
    public static void insertEmployee(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 0) {
            System.out.println("Negative Employee ID not allowed.");
            return;
        }

        String check = "SELECT * FROM employee WHERE id=?";
        PreparedStatement cps = con.prepareStatement(check);
        cps.setInt(1, id);

        ResultSet rs = cps.executeQuery();

        if (rs.next()) {
            System.out.println("Duplicate Employee ID. Employee already exists.");
            rs.close();
            cps.close();
            return;
        }

        rs.close();
        cps.close();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        if (salary < 0) {
            System.out.println("Negative Salary not allowed.");
            return;
        }

        String sql = "INSERT INTO employee VALUES(?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee Inserted Successfully.");
        } else {
            System.out.println("Insertion Failed.");
        }

        ps.close();
    }

    // View Employees
    public static void viewEmployee(Connection con) throws Exception {

        String sql = "SELECT * FROM employee";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n******** Employee Details ********");

        while (rs.next()) {
            System.out.println("Employee ID   : " + rs.getInt("id"));
            System.out.println("Employee Name : " + rs.getString("name"));
            System.out.println("Salary        : " + rs.getDouble("salary"));
            System.out.println("----------------------------------");
        }

        rs.close();
        st.close();
    }

    // Update Employee
    public static void updateEmployee(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        if (salary < 0) {
            System.out.println("Negative Salary not allowed.");
            return;
        }

        String sql = "UPDATE employee SET name=?,salary=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

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
    }

    // Delete Employee
    public static void deleteEmployee(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM employee WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee Deleted Successfully.");
        } else {
            System.out.println("Employee Not Found.");
        }

        ps.close();
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root");

            while (true) {

                System.out.println("\n***** EMPLOYEE MANAGEMENT SYSTEM *****");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        insertEmployee(con, sc);
                        break;

                    case 2:
                        viewEmployee(con);
                        break;

                    case 3:
                        updateEmployee(con, sc);
                        break;

                    case 4:
                        deleteEmployee(con, sc);
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
