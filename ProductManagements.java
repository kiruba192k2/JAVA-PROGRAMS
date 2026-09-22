
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class ProductManagements {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Order> orders = new ArrayList<>();
    static Stock stock = new Stock();

    static class Order {

        int id, customerId, quantity;
        String product, status;
        double price;

        Order(int id, int customerId, String product,
                int quantity, double price) {
            this.id = id;
            this.customerId = customerId;
            this.product = product;
            this.quantity = quantity;
            this.price = price;
            status = "CREATED";
        }

        void show() {
            System.out.println(
                    id + " | Customer: " + customerId
                    + " | " + product
                    + " | Qty: " + quantity
                    + " | Price: " + price
                    + " | " + status);
        }
    }

    interface StockService {

        boolean use(String product, int qty);

        void add(String product, int qty);

        void show();
    }

    static class Stock implements StockService {

        Map<String, Integer> stock = new HashMap<>();

        Stock() {
            stock.put("Steel", 5);
            stock.put("Nickel", 10);
            stock.put("Mild Steel", 10);
        }

        public synchronized boolean use(
                String product, int qty) {

            if (stock.containsKey(product)
                    && stock.get(product) >= qty) {

                stock.put(product,
                        stock.get(product) - qty);

                return true;
            }

            return false;
        }

        public synchronized void add(
                String product, int qty) {

            if (stock.containsKey(product)) {
                stock.put(product,
                        stock.get(product) + qty);
            }
        }

        public void show() {
            System.out.println("\n--- STOCK ---");
            System.out.println(stock);
        }
    }

    static class OrderFactory {

        static Order create(int id, int customer,
                String product,
                int qty, double price) {

            return new Order(
                    id, customer, product, qty, price);
        }
    }

    static class Processor {

        StockService stock;

        Processor(StockService stock) {
            this.stock = stock;
        }

        public String process(Order order) {

            if (stock.use(
                    order.product,
                    order.quantity)) {

                order.status = "COMPLETED";

                return "Order " + order.id
                        + " completed";
            }

            order.status = "FAILED";

            return "Order " + order.id
                    + " failed";
        }
    }

    static class Task implements Callable<String> {

        Order order;
        Processor processor;

        Task(Order order, Processor processor) {
            this.order = order;
            this.processor = processor;
        }

        public String call() {
            order.status = "PROCESSING";
            return processor.process(order);
        }
    }

    static void reflection(Order order) {

        try {
            Processor p = new Processor(stock);

            Method m = p.getClass()
                    .getMethod("process", Order.class);

            System.out.println(
                    m.invoke(p, order));

        } catch (Exception e) {
            System.out.println("Reflection error");
        }
    }

    static void createOrder() {

        System.out.print("Order ID: ");
        int id = sc.nextInt();

        System.out.print("Customer ID: ");
        int customer = sc.nextInt();

        sc.nextLine();

        System.out.print("Product: ");
        String product = sc.nextLine();

        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        orders.add(
                OrderFactory.create(
                        id, customer, product, qty, price));

        System.out.println("Order created");
    }

    static void processOrders() {

        ExecutorService ex
                = Executors.newFixedThreadPool(3);

        Processor p = new Processor(stock);

        ArrayList<Future<String>> results
                = new ArrayList<>();

        for (Order order : orders) {

            if (order.status.equals("CREATED")) {

                results.add(
                        ex.submit(new Task(order, p)));
            }
        }

        for (Future<String> f : results) {

            try {
                System.out.println(f.get());
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        ex.shutdown();
    }

    static Order find(int id) {

        for (Order o : orders) {
            if (o.id == id) {
                return o;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== ORDER SYSTEM =====");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Process Orders");
            System.out.println("4. Reflection");
            System.out.println("5. View Stock");
            System.out.println("6. Add Stock");
            System.out.println("7. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createOrder();
                    break;

                case 2:
                    for (Order o : orders) {
                        o.show();
                    }
                    break;

                case 3:
                    processOrders();
                    break;

                case 4:
                    System.out.print("Order ID: ");
                    int id = sc.nextInt();

                    Order o = find(id);

                    if (o != null) {
                        reflection(o);
                    } else {
                        System.out.println("Not found");
                    }

                    break;

                case 5:
                    stock.show();
                    break;

                case 6:
                    sc.nextLine();

                    System.out.print("Product: ");
                    String product = sc.nextLine();

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    stock.add(product, qty);

                    System.out.println("Stock updated");
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
