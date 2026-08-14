
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
        );

        output.println("EMP1001");

        String response = input.readLine();

        System.out.println("HRMS Server Response: " + response);

        socket.close();
    }
}
