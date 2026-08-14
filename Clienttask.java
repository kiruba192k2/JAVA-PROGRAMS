import java.io.*;
import java.net.*;
public class Clienttask{
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;
        String employeeId = "EMP1001";
        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to HRMS Server.");
            System.out.println();
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);
            output.println(employeeId);
            System.out.println("Employee ID sent: " + employeeId);
            System.out.println();
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String line;
            System.out.println("Employee Details Received:");
            System.out.println();
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
