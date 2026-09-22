
import java.util.*;

interface Observer {

    void update(String message);
}

class EmployeeObserveDemo implements Observer {

    private String name;

    EmployeeObserveDemo(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class HRMSNotificationSystem {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyEmployees(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

public class HRMSNotification {

    public static void main(String[] args) {

        HRMSNotificationSystem notification
                = new HRMSNotificationSystem();

        notification.addObserver(new EmployeeObserveDemo("Rama"));
        notification.addObserver(new EmployeeObserveDemo("Kumar"));

        notification.notifyEmployees("Leave Approved");
    }
}
