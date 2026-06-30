package Demo;

import java.util.*;

public class Markanalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> marksList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT MARKS ANALYSIS MENU =====");
            System.out.println("1. Add Marks");
            System.out.println("2. Display All Marks");
            System.out.println("3. Calculate Total Marks");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Display Highest Mark");
            System.out.println("6. Display Lowest Mark");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter No Student Marks to be Entered: ");
                    int n = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < n; i++) {
                        System.out.print("Mark " + (i + 1) + ": ");
                        int mark = Integer.parseInt(sc.nextLine());
                        marksList.add(mark);
                    }

                    System.out.println("Marks added successfully.");
                    break;

                case 2:
                    System.out.println("\n===== ALL MARKS =====");

                    if (marksList.isEmpty()) {
                        System.out.println("No marks available.");
                    } else {
                        for (int mark : marksList) {
                            System.out.println(mark);
                        }
                    }
                    break;

                case 3:
                    if (marksList.isEmpty()) {
                        System.out.println("No marks available.");
                    } else {
                        int total = 0;

                        for (int mark : marksList) {
                            total += mark;
                        }

                        System.out.println("Total Marks = " + total);
                    }
                    break;

                case 4:
                    if (marksList.isEmpty()) {
                        System.out.println("No marks available.");
                    } else {
                        int total = 0;

                        for (int mark : marksList) {
                            total += mark;
                        }

                        double average = (double) total / marksList.size();

                        System.out.println("Average Marks = " + average);
                    }
                    break;

                case 5:
                    if (marksList.isEmpty()) {
                        System.out.println("No marks available.");
                    } else {
                        int highest = marksList.get(0);

                        for (int mark : marksList) {
                            if (mark > highest) {
                                highest = mark;
                            }
                        }

                        System.out.println("Highest Mark = " + highest);
                    }
                    break;

                case 6:
                    if (marksList.isEmpty()) {
                        System.out.println("No marks available.");
                    } else {
                        int lowest = marksList.get(0);

                        for (int mark : marksList) {
                            if (mark < lowest) {
                                lowest = mark;
                            }
                        }

                        System.out.println("Lowest Mark = " + lowest);
                    }
                    break;

                case 7:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
