
// public class MethodOverriding {

//     public static void main(String[] args) {

//         Emp1 e1 = new Emp1(10, "kiruba", 50000);
//         e1.display();

//         System.out.println();

//         Developer dev = new Developer(11, "kannan", 10000, "Java");
//         dev.display();
//     }
// }

// class Emp1 {

//     int id;
//     String name;
//     double salary;

//     Emp1(int id, String name, double salary) {
//         this.id = id;
//         this.name = name;
//         this.salary = salary;
//     }

//     void display() {
//         System.out.println("Employee ID      : " + id);
//         System.out.println("Employee Name    : " + name);
//         System.out.println("Employee Salary  : Rs. " + salary);
//     }
// }

// class Developer extends Emp1 {

//     String programmingLanguage;

//     Developer(int id, String name, double salary, String programmingLanguage) {
//         super(id, name, salary);
//         this.programmingLanguage = programmingLanguage;
//     }

//     @Override
//     void display() {
//         System.out.println("Employee ID      : " + id);
//         System.out.println("Employee Name    : " + name);
//         System.out.println("Employee Salary  : Rs. " + salary);
//         System.out.println("Programming Language : " + programmingLanguage);
//     }
// }
