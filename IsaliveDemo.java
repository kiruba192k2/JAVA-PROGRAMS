
class EmployeeThreadIsAliveDemo extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Employee Registration Started...");
            Thread.sleep(3000);
            System.out.println("Employee Registration Completed...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class IsaliveDemo {

    public static void main(String[] args) throws InterruptedException {
        EmployeeThreadIsAliveDemo thread = new EmployeeThreadIsAliveDemo();

        System.out.println("Before start() : " + thread.isAlive());

        thread.start();

        Thread.sleep(500);

        System.out.println("After start() : " + thread.isAlive());

        thread.join();

        System.out.println("After completion : " + thread.isAlive());
    }
}
