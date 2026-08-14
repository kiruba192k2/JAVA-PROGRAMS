
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("server started......");
        System.out.println("waiing for client");
        Socket socket = server.accept();
        System.out.println("client connected....");
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        String empid = input.readLine();
        System.out.println("Employee id received : " + empid);
        output.println("employee " + empid + " active");
        socket.close();
        server.close();
    }
}
