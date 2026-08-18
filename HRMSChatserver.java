
import java.io.*;
import java.net.*;

public class HRMSChatserver {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);

        System.out.println("HRMS Chat Server Started...");
        System.out.println("Waiting for employee...");

        Socket socket = server.accept();

        BufferedReader input
                = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

        PrintWriter output
                = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String message = input.readLine();

            if (message == null || message.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Employee : " + message);
            output.println("HR : Your message has been received.");
        }
        socket.close();
        server.close();

        System.out.println("Chat Ended.");
    }
}
