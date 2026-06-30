package Demo;

import java.util.*;

class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }
}

class Studentdatacollection {

    String name;
    int age;

    void setDetails(String studentName, int studentAge) throws InvalidAgeException {
        if (studentAge < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        name = studentName;
        age = studentAge;
    }

    void displayDetails() {
        System.out.println("Student Name : " + name);
        System.out.println("Student Age  : " + age);
    }
}

public class Studentadmissionsystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Studentdatacollection s = new Studentdatacollection();
        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Student Age: ");
            int age = sc.nextInt();
            s.setDetails(name, age);
            System.out.println("\nAdmission Successful");
            s.displayDetails();
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        sc.close();
    }
}
