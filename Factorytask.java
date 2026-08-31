
public class Factorytask {

    interface PaymentF {

        void processPayment(double amount);
    }

    static class SalaryPayment implements PaymentF {

        public void processPayment(double amount) {
            System.out.println("Salary paid: $" + amount);
        }
    }

    static class BonusPayment implements PaymentF {

        public void processPayment(double amount) {
            System.out.println("Bonus paid: $" + amount);
        }
    }

    static class ReimbursementPayment implements PaymentF {

        public void processPayment(double amount) {
            System.out.println("Reimbursement paid: $" + amount);
        }
    }

    static class PaymentFactory {

        public PaymentF createPayment(String type) {
            if ("SALARY".equalsIgnoreCase(type)) {
                return new SalaryPayment();
            } else if ("BONUS".equalsIgnoreCase(type)) {
                return new BonusPayment();
            } else if ("REIMBURSEMENT".equalsIgnoreCase(type)) {
                return new ReimbursementPayment();
            }
            throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }

    public static class HRMSPaymentFactoryDemo {

        public static void main(String[] args) {
            PaymentFactory factory = new PaymentFactory();
            PaymentF payment1 = factory.createPayment("SALARY");
            payment1.processPayment(30000);
            PaymentF payment2 = factory.createPayment("BONUS");
            payment2.processPayment(5000);
            PaymentF payment3 = factory.createPayment("REIMBURSEMENT");
            payment3.processPayment(2500);
        }
    }
}
