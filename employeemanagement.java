
import java.sql.*;
import java.util.Scanner;

public class employeemanagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root");
            mainMenu:
            while (true) {
                System.out.println("\n===== Employee Registration System =====");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("How many employees do you want to enter? ");
                        int n = sc.nextInt();
                        String insert = "INSERT INTO employee(id, name, salary) VALUES(?,?,?)";
                        PreparedStatement ps1 = con.prepareStatement(insert);
                        for (int i = 1; i <= n; i++) {
                            System.out.println("\nEnter Details of Employee " + i);
                            System.out.print("Enter Employee ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Employee Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Salary: ");
                            double salary = sc.nextDouble();
                            ps1.setInt(1, id);
                            ps1.setString(2, name);
                            ps1.setDouble(3, salary);
                            try {
                                int rows = ps1.executeUpdate();
                                if (rows > 0) {
                                    System.out.println("Employee " + i + " Inserted Successfully.");
                                }
                            } catch (SQLIntegrityConstraintViolationException e) {
                                System.out.println("\nEmployee ID already exists!");
                                System.out.println("Returning to Main Menu...\n");
                                ps1.close();
                                continue mainMenu;
                            }
                        }
                        ps1.close();
                        break;
                    case 2:
                        String sql = "SELECT * FROM employee";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        System.out.println("\nEmployee Details");
                        System.out.println("---------------------------");
                        while (rs.next()) {
                            System.out.println("Employee ID     : " + rs.getInt("id"));
                            System.out.println("Employee Name   : " + rs.getString("name"));
                            System.out.println("Employee Salary : " + rs.getDouble("salary"));
                            System.out.println("---------------------------");
                        }
                        rs.close();
                        st.close();
                        break;
                    case 3:
                        String update = "UPDATE employee SET name=?, salary=? WHERE id=?";
                        PreparedStatement ps2 = con.prepareStatement(update);
                        System.out.print("Enter Employee ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String uname = sc.nextLine();
                        System.out.print("Enter New Salary: ");
                        double usalary = sc.nextDouble();
                        ps2.setString(1, uname);
                        ps2.setDouble(2, usalary);
                        ps2.setInt(3, uid);
                        int updateRows = ps2.executeUpdate();
                        if (updateRows > 0) {
                            System.out.println("Employee Updated Successfully.");
                        } else {
                            System.out.println("Employee Not Found.");
                        }
                        ps2.close();
                        break;
                    case 4:
                        String delete = "DELETE FROM employee WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(delete);
                        System.out.print("Enter Employee ID to Delete: ");
                        int did = sc.nextInt();
                        ps3.setInt(1, did);
                        int deleteRows = ps3.executeUpdate();
                        if (deleteRows > 0) {
                            System.out.println("Employee Deleted Successfully.");
                        } else {
                            System.out.println("Employee Not Found.");
                        }
                        ps3.close();
                        break;
                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Thank You!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
