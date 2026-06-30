package Demo;

// public class Exceptionhandling {
//     public static void main(String[] args) {
//         try{
//         int sal=-10000;
//         if(sal<=0){
//             System.out.print(10/0);
//         }
//        }
//        catch(ArithmeticException e){
//         System.out.println("invalid");
//        }
//        System.out.println("data added.....");
//     }
// }
//     public static void main(String[] args) {
//         try {
//             int salary = Integer.parseInt("ABC");
//             int arr[] = new int[3];
//             System.out.println(arr[5]);
//         } catch (NumberFormatException e) {
//             System.out.println("Invalid Salary Format");
//         } catch (ArrayIndexOutOfBoundsException e) {
//             System.out.println("Invalid Array Index");
//         }
//     }
// }
class InvalidSalaryException extends Exception {

    InvalidSalaryException(String message) {
        super(message);
    }
}

public class Exceptionhandling {

    static void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 10000) {
            throw new InvalidSalaryException("Salary must be at least 10000");
        }
    }

    public static void main(String[] args) {
        double salary = 8000;

        try {
            validateSalary(salary);
            System.out.println("Valid Salary");
        } catch (InvalidSalaryException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
