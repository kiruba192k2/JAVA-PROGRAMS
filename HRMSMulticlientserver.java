
import java.io.*;
import java.net.*;

class Clienthandler extends Thread {

    private Socket socket;

    Clienthandler(Socket socket) {
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
            System.out.println(
                    Thread.currentThread().getName()
                    + " processing " + employeeId);
            output.println(
                    "Employee " + employeeId + " is Active");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class HRMSMulticlientserver {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("HRMS Server Started...");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client Connected");
            Clienthandler handler = new Clienthandler(socket);
            handler.start();
        }
    }
}
