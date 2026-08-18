
import java.io.*;
import java.net.*;

public class HRMSChatclient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            System.out.print("Employee : ");

            String message = keyboard.readLine();

            output.println(message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            String response = input.readLine();

            System.out.println(response);
        }

        socket.close();
    }
}
