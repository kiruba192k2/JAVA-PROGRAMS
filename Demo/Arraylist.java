package Demo;

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
//         System.out.println("------------------------");
//     }
// }
// public class Arraylist {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         ArrayList<Student> students = new ArrayList<>();
//         System.out.print("Enter number of students: ");
//         String I = sc.nextLine();
//         int n = Integer.parseInt(I);
//         for (int i = 0; i < n; i++) {
//             System.out.println("\nEnter details of Student " + (i + 1));
//             System.out.print("Student ID: ");
//             String Id = sc.nextLine();
//             int id = Integer.parseInt(Id);
//             System.out.print("Student Name: ");
//             String name = sc.nextLine();
//             System.out.print("Department: ");
//             String dept = sc.nextLine();
//             students.add(new Student(id, name, dept));
//         }
//         System.out.println("\n\n STUDENT DETAILS");
//         for (Student s : students) {
//             s.display();
//         }
//         sc.close();
//     }
// }
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
//         System.out.println("------------------------");
//     }
// }
// public class Arraylist {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         HashMap<Integer, Student> data = new HashMap<>();
//         System.out.print("Enter number of students: ");
//         String I = sc.nextLine();
//         int n = Integer.parseInt(I);
//         for (int i = 0; i < n; i++) {
//             System.out.println("\nEnter details of Student " + (i + 1));
//             System.out.print("Student ID: ");
//             String Id = sc.nextLine();
//             int id = Integer.parseInt(Id);
//             System.out.print("Student Name: ");
//             String name = sc.nextLine();
//             System.out.print("Department: ");
//             String dept = sc.nextLine();
//             data.put(id, new Student(id, name, dept));
//         }
//         // System.out.println("\n\n STUDENT DETAILS");
//         // for (Student s : data.values()) {
//         //     s.display();
//         // }
//         System.out.print("\n\n Enter  student ID: ");
//         String J = sc.nextLine();
//         int rid = Integer.parseInt(J);
//         Student s = data.get(rid);
//         s.display();
//         sc.close();
//     }
// }
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
//         System.out.println("------------------------");
//     }
// }
// public class Studentdatabase {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//          ArrayList<Student> students = new ArrayList<>();
//         HashMap<Integer, Student> data = new HashMap<>();
//         System.out.print("Enter number of students: ");
//         String I = sc.nextLine();
//         int n = Integer.parseInt(I);
//         for (int i = 0; i < n; i++) {
//             System.out.println("\nEnter details of Student " + (i + 1));
//             System.out.print("Student ID: ");
//             String Id = sc.nextLine();
//             int id = Integer.parseInt(Id);
//             System.out.print("Student Name: ");
//             String name = sc.nextLine();
//             System.out.print("Department: ");
//             String dept = sc.nextLine();
//              students.add(new Student(id, name, dept));
//             data.put(id, new Student(id, name, dept));
//         }
//         System.out.println("\n\n STUDENT DETAILS");
//         for (Student s : data.values()) {
//             s.display();
//         }
//         System.out.print("\n\n Enter  student ID: ");
//         String J = sc.nextLine();
//         int rid = Integer.parseInt(J);
//         Student s = data.get(rid);
//         s.display();
//         sc.close();
//     }

    
// }
