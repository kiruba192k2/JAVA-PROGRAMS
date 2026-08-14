
class DepositThread extends Thread {

    public void run() {
        System.out.println("Deposit : ₹500 Successfully.");
    }
}

class WithdrawThread extends Thread {

    public void run() {
        System.out.println("Withdraw : ₹300 Successfully.");
    }
}

class BalanceThread extends Thread {

    public void run() {
        System.out.println("Current Balance : ₹8,200");
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        DepositThread deposit = new DepositThread();
        WithdrawThread withdraw = new WithdrawThread();
        BalanceThread balance = new BalanceThread();

        deposit.start();
        withdraw.start();
        balance.start();
    }
}
