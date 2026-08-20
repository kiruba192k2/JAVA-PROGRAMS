
import java.io.*;
import java.net.Socket;

public class Twowaychatclient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("==============================");
        System.out.println("        HRMS CHAT CLIENT");
        System.out.println("==============================");
        System.out.println("Connected to HRMS Server !");
        System.out.println("------------------------------");
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Thread receiveThread = new Thread(() -> {
            try {
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println();
                    System.out.println("HR       : " + message);
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                    System.out.print("Employee : ");
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Server disconnected.");
            }
        });
        Thread sendThread = new Thread(() -> {
            try {
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String message;
                while (true) {
                    System.out.print("Employee : ");
                    message = keyboard.readLine();
                    output.println(message);
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error sending message.");
            }
        });
        receiveThread.start();
        sendThread.start();
        receiveThread.join();
        sendThread.join();
        socket.close();
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("HRMS Chat Client Closed.");
        System.out.println("--------------------------------");
    }
}
