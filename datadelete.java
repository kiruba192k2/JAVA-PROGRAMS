
import java.sql.*;
import java.util.Scanner;

public class datadelete {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root"
            );
            Statement stm = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("enter id : ");
            int id = sc.nextInt();

            String query = "DELETE FROM emp WHERE empid=" + id;
            int rows = stm.executeUpdate(query);
            if (rows > 0) {
                System.out.println("employee deleted...");
            } else {
                System.out.println("id not found");
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
