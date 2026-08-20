
import java.io.*;
import java.net.*;
public class Twowaychatserver {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("==============================");
        System.out.println("        HRMS CHAT SERVER");
        System.out.println("==============================");
        System.out.println("Server Started...");
        System.out.println("Waiting for Employee...");
        Socket socket = server.accept();
        System.out.println();
        System.out.println("Employee Connected Successfully!");
        System.out.println("--------------------------------");
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter( socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        Thread receiveThread = new Thread(() -> {
            try {
                String message;

                while ((message = input.readLine()) != null) {

                    if (message.equalsIgnoreCase("exit")) {
                        System.out.println("\nEmployee disconnected.");
                        break;
                    }

                    System.out.println("\nEmployee : " + message);
                    System.out.print("HR       : ");
                }

            } catch (IOException e) {
                System.out.println("\nEmployee disconnected.");
            }
        });

        // Send messages to Employee
        Thread sendThread = new Thread(() -> {

            try {
                String message;

                while (true) {

                    System.out.print("HR       : ");
                    message = keyboard.readLine();

                    if (message == null) {
                        break;
                    }

                    output.println(message);

                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

            } catch (IOException e) {
                System.out.println("\nError sending message.");
            }
        });

        receiveThread.start();
        sendThread.start();

        receiveThread.join();
        sendThread.join();

        socket.close();
        server.close();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("HRMS Chat Server Closed.");
        System.out.println("--------------------------------");
    }
}
