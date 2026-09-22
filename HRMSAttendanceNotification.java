
import java.util.ArrayList;
import java.util.List;

interface AttendanceObserver {

    void update(String employeeName, String status);
}

class HRManager implements AttendanceObserver {

    private String name;

    HRManager(String name) {
        this.name = name;
    }

    @Override
    public void update(String employeeName, String status) {
        System.out.println(
                name + " received notification: "
                + employeeName + " is " + status
        );
    }
}

class AttendanceSystem {

    private List<AttendanceObserver> observers = new ArrayList<>();

    public void addObserver(AttendanceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AttendanceObserver observer) {
        observers.remove(observer);
    }

    public void changeAttendance(String employeeName, String status) {
        System.out.println("\nAttendance Event: " + employeeName + " - " + status);
        for (AttendanceObserver observer : observers) {
            observer.update(employeeName, status);
        }
    }
}

public class HRMSAttendanceNotification {

    public static void main(String[] args) {
        AttendanceSystem attendance = new AttendanceSystem();
        HRManager rama = new HRManager("Rama");
        HRManager kumar = new HRManager("Kumar");
        HRManager priya = new HRManager("Priya");
        attendance.addObserver(rama);
        attendance.addObserver(kumar);
        attendance.addObserver(priya);
        attendance.changeAttendance("John", "Checked In");
        attendance.changeAttendance("David", "Late");
        System.out.println("\nRemoving Kumar from notification list...");
        attendance.removeObserver(kumar);
        attendance.changeAttendance("Anita", "Absent");
    }
}
