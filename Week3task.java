
interface Notification {

    void sendMessage();
}

public class Week3task {

    public static void main(String[] args) {

        Notification notification = () -> {
            System.out.println("notification sent successfully");
        };

        notification.sendMessage();
    }
}
