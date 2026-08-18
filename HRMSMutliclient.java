
import java.io.*;
import java.net.*;

public class HRMSMutliclient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

        output.println("EMP1006");

        System.out.println("Server Response:");

        System.out.println(input.readLine());

        socket.close();
    }
}
