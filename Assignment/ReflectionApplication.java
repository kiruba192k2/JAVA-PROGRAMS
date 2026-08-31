package Assignment;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionApplication {

    static class Employee {

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee() {
        }

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void displayDetails() {
            System.out.println("ID         : " + id);
            System.out.println("Name       : " + name);
            System.out.println("Department : " + department);
            System.out.println("Salary     : ₹" + salary);
        }
    }

    static class ReflectionInspector {

        public void inspect(Class<?> clazz) {

            System.out.println("CLASS INFORMATION");
            System.out.println("------------------");
            System.out.println("Class Name : " + clazz.getSimpleName());

            System.out.println("\nFIELDS");
            System.out.println("------");

            for (Field field : clazz.getDeclaredFields()) {
                System.out.printf(
                        "%-12s : %s%n",
                        field.getName(),
                        field.getType().getSimpleName()
                );
            }

            System.out.println("\nCONSTRUCTORS");
            System.out.println("------------");

            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {

                System.out.print(clazz.getSimpleName() + "(");

                Class<?>[] parameters = constructor.getParameterTypes();

                for (int i = 0; i < parameters.length; i++) {

                    System.out.print(parameters[i].getSimpleName());

                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println(")");
            }

            System.out.println("\nMETHODS");
            System.out.println("-------");

            for (Method method : clazz.getDeclaredMethods()) {

                System.out.println(
                        method.getName() + "() : "
                        + method.getReturnType().getSimpleName()
                );
            }
        }

        public void modifyPrivateField(
                Object object,
                String fieldName,
                Object value) throws Exception {

            Field field
                    = object.getClass().getDeclaredField(fieldName);

            field.setAccessible(true);

            field.set(object, value);
        }

        public Object invokeMethod(
                Object object,
                String methodName) throws Exception {

            Method method
                    = object.getClass().getDeclaredMethod(methodName);

            method.setAccessible(true);

            return method.invoke(object);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ENTER EMPLOYEE DETAILS =====");

        System.out.print("Enter ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Department : ");
        String department = sc.nextLine();

        System.out.print("Enter Salary : ");
        double salary = sc.nextDouble();

        Employee employee
                = new Employee(id, name, department, salary);

        ReflectionInspector inspector
                = new ReflectionInspector();

        inspector.inspect(Employee.class);

        System.out.println("\n===== MODIFY PRIVATE FIELD =====");

        System.out.print("Enter new name : ");
        sc.nextLine();
        String newName = sc.nextLine();

        inspector.modifyPrivateField(
                employee,
                "name",
                newName
        );

        Object nameUsingReflection
                = inspector.invokeMethod(
                        employee,
                        "getName"
                );

        Object salaryUsingReflection
                = inspector.invokeMethod(
                        employee,
                        "getSalary"
                );

        System.out.println(
                "Name using Reflection : "
                + nameUsingReflection
        );

        System.out.println(
                "Salary using Reflection : ₹"
                + salaryUsingReflection
        );

        System.out.println("\n===== FINAL EMPLOYEE DETAILS =====");

        inspector.invokeMethod(
                employee,
                "displayDetails"
        );

        sc.close();
    }
}
