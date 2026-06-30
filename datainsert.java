
import java.sql.*;

public class datainsert {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root"
            );

            Statement stmt = connection.createStatement();

            String query = "INSERT INTO emp VALUES "
                    + "(101,'Yuva',50000),"
                    + "(102,'Rahul',45000),"
                    + "(103,'Priya',55000),"
                    + "(104,'Arun',60000)";

            int rows = stmt.executeUpdate(query);

            System.out.println(rows + " employee records inserted.");

            stmt.close();

            connection.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
