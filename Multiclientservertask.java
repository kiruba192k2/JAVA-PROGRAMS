
import java.io.*;
import java.net.*;

class ClientHandler extends Thread {

    private Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(),
                    true);

            String employeeId = input.readLine();
            String leaveRequest = input.readLine();
            System.out.println(
                    Thread.currentThread().getName()
                    + " processing "
                    + employeeId
                    + " - "
                    + leaveRequest);

            output.println(
                    "Employee " + employeeId);

            output.println(
                    "Leave Request Received Successfully.");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Multiclientservertask {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("HRMS Server Started...");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client Connected");
            ClientHandler handler
                    = new ClientHandler(socket);
            handler.start();
        }
    }

}
