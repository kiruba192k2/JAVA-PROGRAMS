
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Deposit implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Deposit ");
    }
}

class Withdraw implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Withdraw ");
    }
}

class Balanceenquiry implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Balance Enquiry");
    }
}

class Ministatement implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Mini Statement");
    }
}

public class Bankingtransactionsystemwithexecutor {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Deposit());
        executor.execute(new Withdraw());
        executor.execute(new Balanceenquiry());
        executor.execute(new Ministatement());
        executor.shutdown();
    }

}
