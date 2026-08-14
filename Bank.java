
class DepositTransaction implements Runnable {

    @Override
    public void run() {
        System.out.println("Deposit Transaction Completed Successfully.");
    }
}

class WithdrawTransaction implements Runnable {

    @Override
    public void run() {
        System.out.println("Withdrawal Transaction Completed Successfully.");
    }
}

class BalanceEnquiry implements Runnable {

    @Override
    public void run() {
        System.out.println("Balance Enquiry Completed Successfully.");
    }
}

class MiniStatement implements Runnable {

    @Override
    public void run() {
        System.out.println("Mini Statement Generated Successfully.");
    }
}

class FundTransfer implements Runnable {

    @Override
    public void run() {
        System.out.println("Fund Transfer Completed Successfully.");
    }
}

class LoanPayment implements Runnable {

    @Override
    public void run() {
        System.out.println("Loan Payment Processed Successfully.");
    }
}

class AccountVerification implements Runnable {

    @Override
    public void run() {
        System.out.println("Account Verification Completed Successfully.");
    }
}

class ChequeStatus implements Runnable {

    @Override
    public void run() {
        System.out.println("Cheque Status Checked Successfully.");
    }
}

public class Bank {

    public static void main(String[] args) {

        DepositTransaction deposit = new DepositTransaction();
        WithdrawTransaction withdraw = new WithdrawTransaction();
        BalanceEnquiry balance = new BalanceEnquiry();
        MiniStatement mini = new MiniStatement();
        FundTransfer transfer = new FundTransfer();
        LoanPayment loan = new LoanPayment();
        AccountVerification verify = new AccountVerification();
        ChequeStatus cheque = new ChequeStatus();

        Thread t1 = new Thread(deposit);
        Thread t2 = new Thread(withdraw);
        Thread t3 = new Thread(balance);
        Thread t4 = new Thread(mini);
        Thread t5 = new Thread(transfer);
        Thread t6 = new Thread(loan);
        Thread t7 = new Thread(verify);
        Thread t8 = new Thread(cheque);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
