

import java.util.concurrent.*;

class EmployeeProfileTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);

        return """
                -----------------------------
                Employee Profile
                -----------------------------
                Employee ID   : EMP1001
                Employee Name : Raj
                Department    : SAP
                Status        : Active
                -----------------------------
                """;
    }
}

class PayrollReportTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);

        return """
                -----------------------------
                Payroll Report
                -----------------------------
                Basic Salary : ₹50,000
                HRA          : ₹20,000
                Net Salary   : ₹70,000
                -----------------------------
                """;
    }
}

class AttendanceReportTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1500);

        return """
                -----------------------------
                Attendance Report
                -----------------------------
                Working Days : 30
                Present      : 29
                Leave        : 1
                -----------------------------
                """;
    }
}

class LeaveReportTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);

        return """
                -----------------------------
                Leave Report
                -----------------------------
                Casual Leave : 3
                Sick Leave   : 1
                Balance      : 8
                -----------------------------
                """;
    }
}

public class HRMSdashboard {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> employeeFuture =
                executor.submit(new EmployeeProfileTask());

        Future<String> payrollFuture =
                executor.submit(new PayrollReportTask());

        Future<String> attendanceFuture =
                executor.submit(new AttendanceReportTask());

        Future<String> leaveFuture =
                executor.submit(new LeaveReportTask());

        System.out.println("=========================================");
        System.out.println("      HRMS DASHBOARD REPORT SYSTEM");
        System.out.println("=========================================");
        System.out.println("Generating reports...\n");

        try {
            System.out.println(employeeFuture.get());
            System.out.println(payrollFuture.get());
            System.out.println(attendanceFuture.get());
            System.out.println(leaveFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("All reports generated successfully.");
    }
}
