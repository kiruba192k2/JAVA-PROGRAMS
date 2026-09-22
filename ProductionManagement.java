
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ProductionManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Order> orders = new ArrayList<>();
    static Stock stock = new Stock();
    static final int PORT = 5000;

    static class Order implements Serializable {

        private static final long serialVersionUID = 1L;
        private int orderId;
        private int customerId;
        private String product;
        private int quantity;
        private double price;
        private String status;

        Order(int orderId, int customerId, String product,
                int quantity, double price, String status) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.product = product;
            this.quantity = quantity;
            this.price = price;
            this.status = status;
        }

        void display() {
            System.out.println("----------------------------");
            System.out.println("Order ID : " + orderId);
            System.out.println("Customer ID : " + customerId);
            System.out.println("Product : " + product);
            System.out.println("Quantity : " + quantity);
            System.out.println("Price : " + price);
            System.out.println("Status : " + status);
            System.out.println("----------------------------");
        }
    }

    static class Stock {

        private HashMap<String, Integer> stock = new HashMap<>();

        Stock() {
            stock.put("Steel", 5);
            stock.put("Nickel", 10);
            stock.put("Mild Steel", 10);
        }

        synchronized boolean checkStock(String product, int quantity) {
            String productName = findProduct(product);
            if (productName == null || quantity <= 0) {
                return false;
            }
            int available = stock.get(productName);
            if (available >= quantity) {
                stock.put(productName, available - quantity);
                return true;
            }
            return false;
        }

        synchronized void addStock(String product, int quantity) {
            String productName = findProduct(product);
            if (productName != null && quantity > 0) {
                stock.put(
                        productName,
                        stock.get(productName) + quantity
                );
            }
        }

        String findProduct(String product) {
            if (product == null) {
                return null;
            }
            for (String name : stock.keySet()) {
                if (name.equalsIgnoreCase(product.trim())) {
                    return name;
                }
            }
            return null;
        }

        synchronized void display() {
            System.out.println("\n===== STOCK =====");
            System.out.println("Steel : " + stock.get("Steel"));
            System.out.println("Nickel : " + stock.get("Nickel"));
            System.out.println("Mild Steel : " + stock.get("Mild Steel"));
        }
    }

    static class OrderFactory {

        static Order createOrder(
                int orderId,
                int customerId,
                String product,
                int quantity,
                double price,
                String status) {
            return new Order(
                    orderId,
                    customerId,
                    product,
                    quantity,
                    price,
                    status
            );
        }
    }

    static class OrderProcessor {

        private final Stock stock;

        OrderProcessor(Stock stock) {
            this.stock = stock;
        }

        public String process(Order order) {
            boolean result
                    = stock.checkStock(
                            order.product,
                            order.quantity
                    );
            if (result) {
                order.status = "COMPLETED";
                return "Order "
                        + order.orderId
                        + " completed successfully.";
            } else {
                order.status = "FAILED";
                return "Order "
                        + order.orderId
                        + " failed. Stock not available.";
            }
        }
    }

    static class OrderTask implements Callable<String>, Runnable {

        private final Order order;
        private final OrderProcessor processor;

        OrderTask(Order order, OrderProcessor processor) {
            this.order = order;
            this.processor = processor;
        }

        @Override
        public String call() {
            try {
                System.out.println(
                        Thread.currentThread().getName()
                        + " started Order "
                        + order.orderId
                );
                order.status = "PROCESSING";
                Thread.sleep(1000);
                String result = processor.process(order);
                System.out.println(
                        Thread.currentThread().getName()
                        + " finished Order "
                        + order.orderId
                );
                return result;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                order.status = "FAILED";
                return "Order "
                        + order.orderId
                        + " processing interrupted.";
            } catch (Exception e) {
                order.status = "FAILED";
                return "Order "
                        + order.orderId
                        + " processing failed.";
            }
        }

        @Override
        public void run() {
            String result = call();
            System.out.println(result);
        }
    }

    static class OrderFile {

        static void save() {
            try (
                    ObjectOutputStream out
                    = new ObjectOutputStream(
                            new FileOutputStream("orders.ser")
                    )) {
                out.writeObject(orders);
            } catch (IOException e) {
                System.out.println(
                        "Error saving orders: "
                        + e.getMessage()
                );
            }
        }

        @SuppressWarnings("unchecked")
        static void load() {
            File file = new File("orders.ser");
            if (!file.exists()) {
                return;
            }
            try (
                    ObjectInputStream in
                    = new ObjectInputStream(
                            new FileInputStream(file)
                    )) {
                orders
                        = (ArrayList<Order>) in.readObject();
            } catch (Exception e) {
                orders = new ArrayList<>();
            }
        }
    }

    static class OrderServer implements Runnable {

        @Override
        public void run() {
            try (
                    ServerSocket server
                    = new ServerSocket(PORT)) {
                System.out.println(
                        "Order Server started on port "
                        + PORT
                );
                try (
                        Socket socket = server.accept(); ObjectInputStream input
                        = new ObjectInputStream(
                                socket.getInputStream()
                        ); ObjectOutputStream output
                        = new ObjectOutputStream(
                                socket.getOutputStream()
                        )) {
                    Order order
                            = (Order) input.readObject();
                    output.writeObject(order);
                    output.flush();
                }
            } catch (Exception e) {
                System.out.println(
                        "Server error: "
                        + e.getMessage()
                );
            }
        }
    }

    static class OrderClient {

        static void send(Order order) {
            try (
                    Socket socket
                    = new Socket(
                            "localhost",
                            PORT
                    ); ObjectOutputStream output
                    = new ObjectOutputStream(
                            socket.getOutputStream()
                    ); ObjectInputStream input
                    = new ObjectInputStream(
                            socket.getInputStream()
                    )) {
                output.writeObject(order);
                output.flush();
                Order result
                        = (Order) input.readObject();
                order.status = result.status;
            } catch (Exception e) {
                System.out.println(
                        "Client error: "
                        + e.getMessage()
                );
            }
        }
    }

    static void createOrder() {
        System.out.println("\n===== CREATE ORDERS =====");
        System.out.print("Enter Number of Orders: ");
        int numberOfOrders = sc.nextInt();
        if (numberOfOrders <= 0) {
            System.out.println("Invalid number of orders.");
            return;
        }
        int createdOrders = 0;
        for (int i = 1; i <= numberOfOrders; i++) {
            System.out.println("\n===== ORDER " + i + " =====");
            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();
            if (findOrder(orderId) != null) {
                System.out.println("Order ID already exists.");
                i--;
                continue;
            }
            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Product: ");
            String product = sc.nextLine();
            if (!isValidProduct(product)) {
                System.out.println("Invalid product.");
                i--;
                continue;
            }
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                i--;
                continue;
            }
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            if (price < 0) {
                System.out.println("Invalid price.");
                i--;
                continue;
            }
            Order order
                    = OrderFactory.createOrder(
                            orderId,
                            customerId,
                            product,
                            quantity,
                            price,
                            "CREATED"
                    );
            orders.add(order);
            createdOrders++;
            System.out.println(
                    "Order "
                    + orderId
                    + " created successfully."
            );
        }
        OrderFile.save();
        System.out.println(
                "\n" + createdOrders
                + " order(s) created successfully."
        );
    }

    static void processOrders() {
        if (orders.isEmpty()) {
            System.out.println(
                    "No orders available."
            );
            return;
        }
        System.out.println(
                "\n===== CONCURRENT ORDER PROCESSING ====="
        );
        ExecutorService executor
                = Executors.newFixedThreadPool(3);
        OrderProcessor processor
                = new OrderProcessor(stock);
        ArrayList<Future<String>> futures
                = new ArrayList<>();
        try {
            for (Order order : orders) {
                if (order.status.equalsIgnoreCase("CREATED")) {
                    OrderTask task
                            = new OrderTask(
                                    order,
                                    processor
                            );
                    FutureTask<String> futureTask
                            = new FutureTask<>(task);
                    executor.execute(futureTask);
                    futures.add(futureTask);
                }
            }
            if (futures.isEmpty()) {
                System.out.println(
                        "No CREATED orders available for processing."
                );
                return;
            }
            for (Future<String> future : futures) {
                try {
                    String result
                            = future.get();
                    System.out.println(
                            "RESULT: " + result
                    );
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(
                            "Processing interrupted."
                    );
                } catch (ExecutionException e) {
                    System.out.println(
                            "Processing error: "
                            + e.getCause()
                    );
                }
            }
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(
                        5,
                        TimeUnit.SECONDS
                )) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
        OrderFile.save();
        System.out.println(
                "\nAll orders have been processed."
        );
    }

    static void viewOrderStatus() {
        System.out.println(
                "\n===== ORDER STATUS ====="
        );
        if (orders.isEmpty()) {
            System.out.println(
                    "No orders found."
            );
            return;
        }
        for (Order order : orders) {
            order.display();
        }
    }

    static void updateStock() {
        System.out.println(
                "\n===== UPDATE STOCK ====="
        );
        System.out.println("1. Steel");
        System.out.println("2. Nickel");
        System.out.println("3. Mild Steel");
        System.out.print("Choose product: ");
        int choice = sc.nextInt();
        String product;
        if (choice == 1) {
            product = "Steel";
        } else if (choice == 2) {
            product = "Nickel";
        } else if (choice == 3) {
            product = "Mild Steel";
        } else {
            System.out.println(
                    "Invalid product."
            );
            return;
        }
        System.out.print(
                "Enter quantity to add: "
        );
        int quantity = sc.nextInt();
        if (quantity <= 0) {
            System.out.println(
                    "Invalid quantity."
            );
            return;
        }
        stock.addStock(
                product,
                quantity
        );
        System.out.println(
                "Stock updated successfully."
        );
    }

    static boolean isValidProduct(
            String product) {
        if (product == null) {
            return false;
        }
        return product.equalsIgnoreCase("Steel")
                || product.equalsIgnoreCase("Nickel")
                || product.equalsIgnoreCase("Mild Steel");
    }

    static Order findOrder(int orderId) {
        for (Order order : orders) {
            if (order.orderId == orderId) {
                return order;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OrderFile.load();
        int choice;
        do {
            System.out.println(
                    "\n=============================="
            );
            System.out.println(
                    " PRODUCTION ORDER SYSTEM"
            );
            System.out.println(
                    "=============================="
            );
            System.out.println(
                    "1. Create Orders"
            );
            System.out.println(
                    "2. View Order Status"
            );
            System.out.println(
                    "3. Process Orders Concurrently"
            );
            System.out.println(
                    "4. View Stock"
            );
            System.out.println(
                    "5. Update Stock"
            );
            System.out.println(
                    "6. Exit"
            );
            System.out.println(
                    "=============================="
            );
            System.out.print(
                    "Enter choice: "
            );
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    viewOrderStatus();
                    break;
                case 3:
                    processOrders();
                    break;
                case 4:
                    stock.display();
                    break;
                case 5:
                    updateStock();
                    break;
                case 6:
                    OrderFile.save();
                    System.out.println(
                            "Thank you."
                    );
                    break;
                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        } while (choice != 6);
        sc.close();
    }
}
