
class DepositThreadJoin extends Thread {

    @Override
    public void run() {
        System.out.println("Deposit Processing Started...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Deposit Completed.");
    }
}

class WithdrawThreadJoin extends Thread {

    @Override
    public void run() {
        System.out.println("Withdraw Processing Started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Withdraw Completed.");
    }
}

public class Joindemo {

    public static void main(String[] args) throws InterruptedException {
        DepositThreadJoin deposit = new DepositThreadJoin();
        WithdrawThreadJoin withdraw = new WithdrawThreadJoin();

        deposit.start();
        withdraw.start();

        // Wait until both threads finish
        deposit.join();
        withdraw.join();

        System.out.println("----------------------------------------");
        System.out.println("Displaying Final Balance...");
        System.out.println("----------------------------------------");
    }

}
