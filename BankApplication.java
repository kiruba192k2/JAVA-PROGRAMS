
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount <= 0 || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public boolean transfer(BankAccount target, double amount) {
        BankAccount first = this;
        BankAccount second = target;
        if (accountNumber.compareTo(target.accountNumber) > 0) {
            first = target;
            second = this;
        }
        synchronized (first) {
            synchronized (second) {
                if (amount <= 0 || balance < amount) {
                    return false;
                }
                balance -= amount;
                target.balance += amount;
                return true;
            }
        }
    }
}

class Transaction {

    private final String transactionId;
    private final String accountNumber;
    private final String transactionType;
    private final double amount;

    public Transaction(String transactionId, String accountNumber,
            String transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}

class TransactionProcessor {

    private final Map<String, BankAccount> accounts;
    private int successfulTransactions;
    private int failedTransactions;

    public TransactionProcessor(Map<String, BankAccount> accounts) {
        this.accounts = accounts;
    }

    public synchronized void process(Transaction transaction) {
        String threadName = Thread.currentThread().getName();
        BankAccount account = accounts.get(transaction.getAccountNumber());
        if (account == null) {
            failedTransactions++;
            System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | Account not found");
            return;
        }
        String type = transaction.getTransactionType();
        double amount = transaction.getAmount();
        boolean success;
        if (type.equalsIgnoreCase("DEPOSIT")) {
            success = account.deposit(amount);
        } else if (type.equalsIgnoreCase("WITHDRAW")) {
            success = account.withdraw(amount);
        } else if (type.equalsIgnoreCase("BALANCE")) {
            successfulTransactions++;
            System.out.println(threadName + " | " + transaction.getTransactionId() + " | BALANCE | ₹" + account.getBalance());
            return;
        } else {
            failedTransactions++;
            System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | Invalid transaction type");
            return;
        }
        if (success) {
            successfulTransactions++;
            System.out.println(threadName + " | " + transaction.getTransactionId() + " | " + type + " | SUCCESS | ₹" + amount);
        } else {
            failedTransactions++;
            System.out.println(threadName + " | " + transaction.getTransactionId() + " | " + type + " | FAILED | ₹" + amount);
        }
    }

    public synchronized int getSuccessfulTransactions() {
        return successfulTransactions;
    }

    public synchronized int getFailedTransactions() {
        return failedTransactions;
    }
}

class TransactionTask implements Runnable {

    private final Transaction transaction;
    private final TransactionProcessor processor;

    public TransactionTask(Transaction transaction, TransactionProcessor processor) {
        this.transaction = transaction;
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.process(transaction);
    }
}

public class BankApplication {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();
        System.out.println("BANK ACCOUNT CREATION");
        System.out.print("Enter number of accounts: ");
        int numberOfAccounts = sc.nextInt();
        for (int i = 1; i <= numberOfAccounts; i++) {
            String accountNumber = String.format("AC%03d", i);
            System.out.println("Account " + i);
            System.out.println("Generated Account Number: " + accountNumber);
            System.out.print("Enter initial balance: ₹");
            double balance = sc.nextDouble();
            accounts.put(accountNumber, new BankAccount(accountNumber, balance));
            System.out.println("Account " + accountNumber + " created successfully!");
        }
        TransactionProcessor processor = new TransactionProcessor(accounts);
        System.out.print("Enter number of transactions: ");
        int numberOfTransactions = sc.nextInt();
        Thread[] threads = new Thread[numberOfTransactions];
        for (int i = 0; i < numberOfTransactions; i++) {
            System.out.println("Transaction " + (i + 1));
            String transactionId = String.format("T%03d", i + 1);
            System.out.println("Transaction ID: " + transactionId);
            System.out.print("Enter Account Number: ");
            String accountNumber = sc.next();
            System.out.print("Enter Transaction Type (DEPOSIT / WITHDRAW / BALANCE): ");
            String transactionType = sc.next();
            double amount = 0;
            if (!transactionType.equalsIgnoreCase("BALANCE")) {
                System.out.print("Enter Amount: ₹");
                amount = sc.nextDouble();
            }
            Transaction transaction = new Transaction(transactionId, accountNumber, transactionType, amount);
            threads[i] = new Thread(new TransactionTask(transaction, processor), "Transaction-Thread-" + (i + 1));
        }
        System.out.println("PROCESSING TRANSACTIONS");
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("TRANSACTION SUMMARY");
        System.out.println("Successful Transactions : " + processor.getSuccessfulTransactions());
        System.out.println("Failed Transactions : " + processor.getFailedTransactions());
        System.out.println("FUND TRANSFER");
        System.out.print("Enter first account: ");
        String firstAccount = sc.next();
        System.out.print("Enter second account: ");
        String secondAccount = sc.next();
        System.out.print("Enter amount for first transfer (" + firstAccount + " -> " + secondAccount + "): ₹");
        double amount1 = sc.nextDouble();
        System.out.print("Enter amount for second transfer (" + secondAccount + " -> " + firstAccount + "): ₹");
        double amount2 = sc.nextDouble();
        BankAccount account1 = accounts.get(firstAccount);
        BankAccount account2 = accounts.get(secondAccount);
        if (account1 == null || account2 == null) {
            System.out.println("Transfer FAILED - Account not found");
        } else if (account1 == account2) {
            System.out.println("Transfer FAILED - Cannot transfer to the same account");
        } else {
            Thread transferThread1 = new Thread(() -> {
                boolean result = account1.transfer(account2, amount1);
                System.out.println(Thread.currentThread().getName() + " | " + firstAccount + " -> " + secondAccount + " | ₹" + amount1 + " | " + (result ? "SUCCESS" : "FAILED"));
            }, "Transfer-Thread-1");
            Thread transferThread2 = new Thread(() -> {
                boolean result = account2.transfer(account1, amount2);
                System.out.println(Thread.currentThread().getName() + " | " + secondAccount + " -> " + firstAccount + " | ₹" + amount2 + " | " + (result ? "SUCCESS" : "FAILED"));
            }, "Transfer-Thread-2");
            transferThread1.start();
            transferThread2.start();
            transferThread1.join();
            transferThread2.join();
        }
        System.out.println("FINAL BALANCES");
        for (BankAccount account : accounts.values()) {
            System.out.println(account.getAccountNumber() + " : ₹" + account.getBalance());
        }
        sc.close();
    }
}
