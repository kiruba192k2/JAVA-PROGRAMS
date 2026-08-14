
class AuthenticationThread extends Thread {

    public void run() {
        System.out.println("Authenticating Employee...");
    }
}

class AttendanceThreadDemo extends Thread {

    public void run() {
        System.out.println("Loading Attendance...");
    }
}

class EmailThread extends Thread {

    public void run() {
        System.out.println("Sending Welcome Email...");
    }
}

class SalaryThread extends Thread {

    public void run() {
        System.out.println("Loading Salary Information...");
    }
}

public class Employeeportal {

    public static void main(String[] args) {

        AuthenticationThread t1 = new AuthenticationThread();
        AttendanceThreadDemo t2 = new AttendanceThreadDemo();
        EmailThread t3 = new EmailThread();
        SalaryThread t4 = new SalaryThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
