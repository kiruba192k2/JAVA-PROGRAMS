
import java.util.Scanner;
import java.util.concurrent.*;

class Order {

    public int Orderid;
    public String Cusname;
    public String Item;
    public int Quantity;
    public double Amount;

    public Order(int Ordid, String Cusname, String Item, int Quantity, double Amount) {
        this.Orderid = Ordid;
        this.Cusname = Cusname;
        this.Item = Item;
        this.Quantity = Quantity;
        this.Amount = Amount;
    }
}

class OrderChecking implements Callable<String> {

    Order order;

    OrderChecking(Order order) {
        this.order = order;
    }

    public String call() throws Exception {
        Thread.sleep(500);
        if (order.Quantity <= 0) {
            return "Invalid quantity";
        }
        if (order.Amount <= 0) {
            return "Invalid order amount";
        }
        return "Order is valid";
    }
}

class Bill implements Callable<String> {

    Order order;

    Bill(Order order) {
        this.order = order;
    }

    public String call() throws Exception {
        Thread.sleep(700);
        double cost = order.Amount * order.Quantity;
        int service = 35;
        double total = cost + service;
        return "Total Bill = " + total;
    }
}

class Delivery implements Callable<String> {

    Order order;

    Delivery(Order order) {
        this.order = order;
    }

    public String call() throws Exception {
        Thread.sleep(600);
        double Charge;
        if (order.Amount >= 500) {
            Charge = 0;
        } else {
            Charge = 50;
        }
        return "Delivery Charge = " + Charge;
    }
}

class Orderstatus implements Callable<String> {

    Order order;

    Orderstatus(Order order) {
        this.order = order;
    }

    public String call() throws Exception {
        Thread.sleep(400);
        return "Order Status = Confirmed and Preparing";
    }
}

public class OnlineFoodOrderingusingExecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Online Food Ordering System ");
        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter Food Item: ");
        String foodItem = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Order Amount: ");
        double orderAmount = sc.nextDouble();
        Order order = new Order(orderId, customerName, foodItem, quantity, orderAmount);
        System.out.println("Order ID      : " + order.Orderid);
        System.out.println("Customer Name : " + order.Cusname);
        System.out.println("Food Item     : " + order.Item);
        System.out.println("Quantity      : " + order.Quantity);
        System.out.println("Order Amount  : " + order.Amount);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            Future<String> validation = executor.submit(new OrderChecking(order));
            Future<String> bill = executor.submit(new Bill(order));
            Future<String> delivery = executor.submit(new Delivery(order));
            Future<String> status = executor.submit(new Orderstatus(order));
            try {
                System.out.println("\nTask Name : Order Validation");
                System.out.println("Result    : " + validation.get());
                System.out.println("\nTask Name : Bill Calculation");
                System.out.println("Result    : " + bill.get());
                System.out.println("\nTask Name : Delivery Charge ");
                System.out.println("Result    : " + delivery.get());
                System.out.println("\nTask Name : Order Status");
                System.out.println("Result    : " + status.get());
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                System.out.println("Task interrupted.");

            } catch (ExecutionException e) {

                System.out.println("Task failed: "
                        + e.getCause().getMessage());
            }
        } finally {
            executor.shutdown();
        }

        sc.close();
    }
}
