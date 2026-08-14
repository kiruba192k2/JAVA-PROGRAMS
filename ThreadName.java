
class EmployeeThreadNameDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Thread Name : " + Thread.currentThread().getName());
    }
}

public class ThreadName {

    public static void main(String[] args) {
        EmployeeThreadNameDemo thread = new EmployeeThreadNameDemo();
        thread.setName("Employee Registration Thread");
        thread.start();
    }
}
