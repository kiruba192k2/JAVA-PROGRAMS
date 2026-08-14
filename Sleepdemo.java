
class DepositThreadSleepDemo extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Deposit Started...");
            Thread.sleep(3000);
            System.out.println("Deposit Completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Sleepdemo {

    public static void main(String args[]) {
        DepositThreadSleepDemo deposit = new DepositThreadSleepDemo();
        deposit.start();
    }
}
