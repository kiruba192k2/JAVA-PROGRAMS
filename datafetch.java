
import java.sql.*;

public class datafetch {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root"
            );
            Statement stm = connection.createStatement();
            String query = "SELECT*FROM emp";
            ResultSet rs = stm.executeQuery(query);
            System.out.println("employee details.....");
            System.out.println("----------------");
            while (rs.next()) {
                System.out.println("employee id : " + rs.getInt("empid"));
                System.out.println("employee name :" + rs.getString("emp_name"));
                System.out.println("employee salary : " + rs.getDouble("salary"));
                System.out.println();
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
