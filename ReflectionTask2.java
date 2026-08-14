
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Customer {

    private int custid;
    private String custname;

    public void addCustomer() {
    }

    public void viewCustomer() {
    }
}

class Account {

    private int accnumber;
    private String accounttype;
    private double balance;

    public void deposit() {
    }

    public void withdraw() {
    }
}

class Loan {

    private int loanid;
    private double loanamount;

    public void applyLoan() {
    }

    public void payLoan() {
    }
}

class Transaction {

    private int Id;
    private double Amount;

    public void transfer() {
    }

    public void printReceipt() {
    }
}

public class ReflectionTask2 {

    public static void printDetails(Class<?> c) {

        System.out.println("\nClass Name : " + c.getSimpleName());

        System.out.println("Fields");
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("Methods");
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public static void main(String[] args) {

        printDetails(Customer.class);
        printDetails(Account.class);
        printDetails(Loan.class);
        printDetails(Transaction.class);
    }
}
