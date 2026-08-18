
import java.io.*;
import java.net.*;

public class Multiclienttask {

    public static void main(String[] args) throws Exception {
        // Connect to server
        Socket socket
                = new Socket("localhost", 5000);

        BufferedReader input
                = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

        PrintWriter output
                = new PrintWriter(
                        socket.getOutputStream(),
                        true);

        output.println("EMP1001");

        output.println("Leave");

        System.out.println("Server Response:");

        System.out.println(input.readLine());

        System.out.println(input.readLine());
        socket.close();
    }
}
