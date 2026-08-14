
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Servertask {

    public static void main(String[] args) {
        int port = 5000;
        Map<String, String> employees = new HashMap<>();
        employees.put("EMP1001",
                "Employee Details\n"
                + "------------------------\n"
                + "Employee ID   : EMP1001\n"
                + "Employee Name : Rama\n"
                + "Department    : SAP\n"
                + "Status        : Active\n"
                + "------------------------");
        employees.put("EMP1002",
                "Employee Details\n"
                + "------------------------\n"
                + "Employee ID   : EMP1002\n"
                + "Employee Name : Kumar\n"
                + "Department    : HR\n"
                + "Status        : Active\n"
                + "------------------------");
        employees.put("EMP1003",
                "Employee Details\n"
                + "------------------------\n"
                + "Employee ID   : EMP1003\n"
                + "Employee Name : Priya\n"
                + "Department    : Finance\n"
                + "Status        : Active\n"
                + "------------------------");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HRMS Server started...");
            System.out.println("Waiting for client connection...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: "
                        + socket.getInetAddress());
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(
                        socket.getOutputStream(), true);
                String employeeId = input.readLine();
                System.out.println("Employee ID received: " + employeeId);
                String response = employees.get(employeeId);
                if (response == null) {
                    response = "Employee not found for ID: " + employeeId;
                }
                output.println(response);
                System.out.println("Employee details sent to client.");
                socket.close();
                System.out.println("Client disconnected.");
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
