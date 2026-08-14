
class Employeeregistrationthread1 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("HR : Registering Employee...");
        }
    }
}

class Payrollthread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Payroll : Processing Salary...");
        }
    }
}

class AttendanceThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Attendance : Creating Attendance Record...");
        }
    }
}

public class HRMSApplication {

    public static void main(String[] args) {

        Employeeregistrationthread1 t1 = new Employeeregistrationthread1();
        Payrollthread t2 = new Payrollthread();
        AttendanceThread t3 = new AttendanceThread();

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main Thread : HRMS Application Started");
    }
}
