package Demo;

import java.util.Scanner;
// Abstract Class

abstract class Item {

    protected int id;
    protected String name;
    private double price;
// Parameterized Constructor

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        setPrice(price);
    }
// Getter Method

    public double getPrice() {
        return price;
    }
// Setter Method with Validation

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid Price");
            this.price = 0;
        }
    }
// Display Method

    public void display() {
        System.out.println("\nItem ID : " + id);
        System.out.println("Item Name : " + name);
        System.out.println("Price : " + getPrice());
    }
// Abstract Method

    abstract void issueItem();
}
// Book Class

class Book extends Item {

    public Book(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    void issueItem() {
        System.out.println(name + " Book Issued Successfully");
    }
}
// Magazine Class

class Magazine extends Item {

    public Magazine(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    void issueItem() {
        System.out.println(name + " Magazine Issued Successfully");
    }
}
// Library Class

class Library {

    Book book;
    Magazine magazine;
// Method Overloading

    void addItem() {
        System.out.println("Item Added");
    }

    void addItem(int id, String name) {
        System.out.println("Item Added : " + name);
    }

    void addItem(int id, String name, double price) {
        System.out.println("Item Added Successfully");
    }
// Search Method

    void searchItem(Item item, int searchId) {
        if (item != null && item.id == searchId) {
            System.out.println("\nItem Found");
            item.display();
        } else {
            System.out.println("Item Not Found");
        }
    }
}

public class LibraryManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;
        do {
            System.out.println("MENU");
            System.out.println("1. Add Item");
            System.out.println("2. Issue Item");
            System.out.println("3. Search Item");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add Book");
                    System.out.println("2. Add Magazine");
                    System.out.print("Enter Choice : ");
                    int addChoice = sc.nextInt();
                    sc.nextLine();
                    if (addChoice == 1) {
                        System.out.print("Enter Book ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Book Name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price : ");
                        double price = sc.nextDouble();
                        library.book = new Book(id, name, price);
                        library.addItem(id, name, price);
                        System.out.println("Book Added Successfully");
                    } else if (addChoice == 2) {
                        System.out.print("Enter Magazine ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Magazine Name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price : ");
                        double price = sc.nextDouble();
                        library.magazine = new Magazine(id, name, price);
                        library.addItem(id, name, price);
                        System.out.println("Magazine Added Successfully");
                    } else {
                        System.out.println("Invalid Choice");
                    }
                    break;

                case 2:
                    System.out.println("\n1. Issue Book");
                    System.out.println("2. Issue Magazine");
                    System.out.print("Enter Choice : ");
                    int issueChoice = sc.nextInt();
                    if (issueChoice == 1) {

                        if (library.book != null) {

// Polymorphism
                            Item item = library.book;

                            item.display();
                            item.issueItem();
                        } else {
                            System.out.println("Book Not Available");
                        }
                    } else if (issueChoice == 2) {
                        if (library.magazine != null) {
// Polymorphism
                            Item item = library.magazine;
                            item.display();
                            item.issueItem();
                        } else {
                            System.out.println("Magazine Not Available");
                        }
                    } else {
                        System.out.println("Invalid Choice");
                    }
                    break;
                case 3:
                    System.out.println("\n1. Search Book");
                    System.out.println("2. Search Magazine");
                    System.out.print("Enter Choice : ");
                    int searchChoice = sc.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter Book ID : ");
                        int searchId = sc.nextInt();
                        library.searchItem(library.book, searchId);
                    } else if (searchChoice == 2) {
                        System.out.print("Enter Magazine ID : ");
                        int searchId = sc.nextInt();
                        library.searchItem(library.magazine, searchId);
                    } else {
                        System.out.println("Invalid Choice");
                    }
                    break;
                case 4:
                    System.out.println("Thank You...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 4);
    }
}
