
import java.util.*;

public class Collegeeventresgisteration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> students = new HashSet<>();

        while (true) {
            System.out.println("\n===== College Event Registration =====");
            System.out.println("1. Register Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Check Student Registration");
            System.out.println("4. Remove Registration");
            System.out.println("5. Display Total Participants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    if (students.add(name)) {
                        System.out.println(name + " registered successfully.");
                    } else {
                        System.out.println("Duplicate registration not allowed!");
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students registered.");
                    } else {
                        System.out.println("Registered Students:");
                        int count = 1;
                        for (String student : students) {
                            System.out.println(count++ + ". " + student);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student name to check: ");
                    String checkName = sc.nextLine();

                    if (students.contains(checkName)) {
                        System.out.println(checkName + " is registered.");
                    } else {
                        System.out.println(checkName + " is not registered.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine();

                    if (students.remove(removeName)) {
                        System.out.println(removeName + " removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Total Participants: " + students.size());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
