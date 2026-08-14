
class Employeeregistrationthread extends Thread {

    @Override
    public void run() {
        System.out.println("----------------------------------------");
        System.out.println("Employee Registration Started...");
        System.out.println("Employee ID : EMP1001");
        System.out.println("Employee Name : Rama");
        System.out.println("Department : SAP");
        System.out.println("Employee Registered Successfully.");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Employeeregistrationthread registration = new Employeeregistrationthread();
        registration.start();
    }
}
