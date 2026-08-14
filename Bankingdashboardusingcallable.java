
import java.util.concurrent.*;

class AccountDetailsTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return """
                =============================
                Account Details
                =============================
                Account No   : 9876543210
                Customer     : Raj Kumar
                Account Type : Savings
                Balance      : ₹1,25,000
                =============================
                """;
    }
}

class DepositHistoryTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1500);
        return """
                =============================
                Deposit History
                =============================
                01-Aug-2026 : ₹20,000
                03-Aug-2026 : ₹10,000
                05-Aug-2026 : ₹15,000
                =============================""";
    }
}

class WithdrawalHistoryTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2500);
        return """
                =============================
                Withdrawal History
                =============================
                02-Aug-2026 : ₹5,000
                04-Aug-2026 : ₹2,500
                05-Aug-2026 : ₹8,000
                =============================
                """;
    }
}

class LoanDetailsTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return """
                =============================
                Loan Details
                =============================
                Loan Type    : Home Loan
                Loan Amount  : ₹55,00,000
                EMI          : ₹22,500
                Balance Loan : ₹48,40,000
                =============================""";
    }
}

public class Bankingdashboardusingcallable {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String> accountFuture = executor.submit(new AccountDetailsTask());
        Future<String> depositFuture = executor.submit(new DepositHistoryTask());
        Future<String> withdrawalFuture = executor.submit(new WithdrawalHistoryTask());
        Future<String> loanFuture = executor.submit(new LoanDetailsTask());
        System.out.println("==========================================");
        System.out.println("      BANKING DASHBOARD SYSTEM");
        System.out.println("==========================================");
        System.out.println("Generating reports...\n");
        try {
            System.out.println(accountFuture.get());
            System.out.println(depositFuture.get());
            System.out.println(withdrawalFuture.get());
            System.out.println(loanFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("All banking reports generated successfully.");
    }
}
