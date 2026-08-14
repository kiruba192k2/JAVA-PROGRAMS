
class EmployeeThreadPriorityDemo extends Thread {

    @Override

    public void run() {

        System.out.println(Thread.currentThread().getPriority());

    }

}

public class Threadpriority {

    public static void main(String[] args) {

        EmployeeThreadPriorityDemo thread = new EmployeeThreadPriorityDemo();

        thread.setPriority(8);

        thread.start();

    }

}
