
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class HRMSChatClientGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    private Socket socket;

    private BufferedReader input;
    private PrintWriter output;

    public HRMSChatClientGUI() {
        setTitle("HRMS Chat Client - Employee");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Message input
        messageField = new JTextField();
        messageField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Send button
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());

        messageField.addActionListener(e -> sendMessage());

        setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        Thread connectionThread = new Thread(()
                -> {
            try {
                socket = new Socket("localhost", 5000);

                input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                output = new PrintWriter(
                        socket.getOutputStream(), true);

                appendMessage("Connected to HRMS Chat Server.");
                appendMessage("---------------------------------");

                receiveMessages();
            } catch (IOException e) {
                appendMessage("Unable to connect to Server.");
            }
        });

        connectionThread.start();
    }

    private void receiveMessages() {
        Thread receiveThread = new Thread(()
                -> {
            try {
                String message;

                while ((message = input.readLine()) != null) {
                    appendMessage("HR       : " + message);

                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            } catch (IOException e) {
                appendMessage("Server disconnected.");
            }
        });

        receiveThread.start();
    }

    private void sendMessage() {
        String message = messageField.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        if (output != null) {
            output.println(message);

            appendMessage("Employee : " + message);

            messageField.setText("");
        }
    }

    private void appendMessage(String message) {
        SwingUtilities.invokeLater(()
                -> {
            chatArea.append(message + "\n");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> {
            new HRMSChatClientGUI();
        });
    }
}
