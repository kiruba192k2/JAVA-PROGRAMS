
import java.sql.*;

public class sample {

    public static void main(String[] args) {
        try {
            Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
            System.err.println("connection successfully");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
