
import java.util.*;

class Student {

    int studentId;
    String studentName;
    String department;

    Student(int id, String name, String dept) {
        studentId = id;
        studentName = name;
        department = dept;
    }

    void display() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Department   : " + department);
        System.out.println("----------------------------");
    }
}

public class Studentdatabase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        HashMap<Integer, Student> studentMap = new HashMap<>();
        int choice;
        do {
            System.out.println("\n===== STUDENT DATABASE MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students (ArrayList)");
            System.out.println("3. Search Student by ID (HashMap)");
            System.out.println("4. Remove Student");
            System.out.println("5. Display Students from HashMap");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nEnter details of Student " + (i + 1));
                        System.out.print("Student ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Student Name: ");
                        String name = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        Student student = new Student(id, name, dept);
                        studentList.add(student);
                        studentMap.put(id, student);
                    }
                    System.out.println(n + " Student(s) added successfully.");
                    break;
                case 2:
                    System.out.println("\n===== STUDENTS (ArrayList) =====");
                    if (studentList.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("details in the list");
                        for (Student s : studentList) {
                            s.display();
                        }
                        System.out.println("details in the map");
                        for (Student s : studentMap.values()) {
                            s.display();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = Integer.parseInt(sc.nextLine());
                    if (studentMap.containsKey(searchId)) {
                        System.out.println("\nStudent Found:");
                        studentMap.get(searchId).display();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = Integer.parseInt(sc.nextLine());
                    if (studentMap.containsKey(removeId)) {
                        Student removedStudent = studentMap.remove(removeId);
                        studentList.remove(removedStudent);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("\n===== STUDENTS (HashMap) =====");
                    if (studentMap.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student s : studentMap.values()) {
                            s.display();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 6);
        sc.close();
    }
}

// import java.util.*;
// class Student {
//     int studentId;
//     String studentName;
//     String department;
//     Student(int id, String name, String dept) {
//         studentId = id;
//         studentName = name;
//         department = dept;
//     }
//     void display() {
//         System.out.println("Student ID   : " + studentId);
//         System.out.println("Student Name : " + studentName);
//         System.out.println("Department   : " + department);
//         System.out.println("----------------------------");
//     }
// }
// public class Studentdatabase {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         //  ArrayList
//         ArrayList<Student> studentA = new ArrayList<>();
//         // HashMap
//         HashMap<Integer, Student> studentH = new HashMap<>();
//         System.out.print("Enter number of students: ");
//         int n = Integer.parseInt(sc.nextLine());
//         for (int i = 0; i < n; i++) {
//             System.out.println("\nEnter details of Student " + (i + 1));
//             System.out.print("Student ID: ");
//             int id = Integer.parseInt(sc.nextLine());
//             // int id = sc.nextInt();
//             // sc.nextLine();
//             System.out.print("Student Name: ");
//             String name = sc.nextLine();
//             System.out.print("Department: ");
//             String dept = sc.nextLine();
//             Student student = new Student(id, name, dept);
//             studentA.add(student);
//             studentH.put(id, student);
//         }
//         System.out.println("\n===== STUDENT DETAILS (ArrayList) =====");
//         for (Student s : studentA) {
//             s.display();
//         }
//         System.out.print("\nEnter Student ID to search in HashMap: ");
//         int searchId = Integer.parseInt(sc.nextLine());
//         if (studentH.containsKey(searchId)) {
//             System.out.println("\nStudent details is Available:");
//             studentH.get(searchId).display();
//         } else {
//             System.out.println("Student details is not Available.");
//         }
//         System.out.print("\nEnter Student ID to remove: ");
//         int removeId = Integer.parseInt(sc.nextLine());
//         if (studentH.containsKey(removeId)) {
//             studentH.remove(removeId);
//             System.out.println("Student removed successfully.");
//         } else {
//             System.out.println("Student not found.");
//         }
//         System.out.println("\n===== STUDENTS AFTER REMOVAL =====");
//         for (Student S : studentH.values()) {
//             S.display();
//         }
//         sc.close();
//     }
// }
//51 System.out.print("\nEnter Student ID to check : ");
// int checkId = Integer.parseInt(sc.nextLine());
// if (studentH.containsKey(checkId)) {
//     System.out.println("Student is available.");
// } else {
//     System.out.println("Student is not available.");
// }
//  56 Student removedStudent = studentH.remove(removeId);      
//62 studentA.remove(removedStudent);
