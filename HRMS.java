
class EmployeeRegistration implements Runnable {

    @Override
    public void run() {
        System.out.println("--------------------------------------");
        System.out.println("Employee Registration Started");
        System.out.println("Employee ID : EMP1001");
        System.out.println("Employee Name : Rama");
        System.out.println("Department : SAP");
        System.out.println("Employee Registered Successfully");
        System.out.println("--------------------------------------");
    }
}

class PayrollProcessing implements Runnable {

    @Override
    public void run() {
        System.out.println("Payroll Processing Started");
    }
}

class AttendanceProcessing implements Runnable {

    @Override
    public void run() {
        System.out.println("Attendance Processing Started");
    }
}

class EmailNotification implements Runnable {

    @Override
    public void run() {
        System.out.println("Email Notification Sent");
    }
}

public class HRMS {

    public static void main(String args[]) {

        EmployeeRegistration employee = new EmployeeRegistration();
        PayrollProcessing payrollTask = new PayrollProcessing();
        AttendanceProcessing attendanceTask = new AttendanceProcessing();
        EmailNotification emailTask = new EmailNotification();

        Thread payroll = new Thread(payrollTask);
        Thread attendance = new Thread(attendanceTask);
        Thread email = new Thread(emailTask);

        payroll.start();
        attendance.start();
        email.start();

        Thread thread = new Thread(employee);
        thread.start();
    }
}
