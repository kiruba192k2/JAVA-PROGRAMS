
public class Synchronization {

    static class EmployeeSalary {

        int empId;
        String empName;
        double salary;

        EmployeeSalary(int empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
        }

        public void updateSalary(String department, double amount) {
            System.out.println(department + " started updating salary...");
            double temp = salary;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            temp = temp + amount;
            salary = temp;
            System.out.println(department + " Updated Salary : " + salary);
        }
    }

    static class PayrollThread_RC extends Thread {

        EmployeeSalary employee;

        PayrollThread_RC(EmployeeSalary employee) {
            this.employee = employee;
        }

        @Override
        public void run() {
            employee.updateSalary("Payroll Team", 3000);
        }
    }

    static class AttendanceThread_RC extends Thread {

        EmployeeSalary employee;

        AttendanceThread_RC(EmployeeSalary employee) {
            this.employee = employee;
        }

        @Override
        public void run() {
            employee.updateSalary("Attendance Team", -1000);
        }
    }

    static class FinanceThread_RC extends Thread {

        EmployeeSalary employee;

        FinanceThread_RC(EmployeeSalary employee) {
            this.employee = employee;
        }

        @Override
        public void run() {
            employee.updateSalary("Finance Team", 500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EmployeeSalary employee = new EmployeeSalary(1001, "Rama", 50000);
        PayrollThread_RC payroll = new PayrollThread_RC(employee);
        AttendanceThread_RC attendance = new AttendanceThread_RC(employee);
        FinanceThread_RC finance = new FinanceThread_RC(employee);
        payroll.start();
        attendance.start();
        finance.start();
        payroll.join();
        attendance.join();
        finance.join();
        System.out.println("\n--------------------------------");
        System.out.println("Final Salary : " + employee.salary);
        System.out.println("--------------------------------");
    }
}
