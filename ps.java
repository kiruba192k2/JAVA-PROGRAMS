
import java.sql.*;
import java.util.*;

public class ps {

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root"
            );

            String query = "INSERT INTO emp VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);

            System.out.print("Employee ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Employee Name : ");
            String name = sc.nextLine();

            System.out.print("Salary : ");
            double salary = sc.nextDouble();
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Registered Successfully.");
            } else {
                System.out.println("Registration Failed.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
