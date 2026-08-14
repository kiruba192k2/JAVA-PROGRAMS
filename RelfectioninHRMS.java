
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee_AdReflectionDemo {

    private String employeeId = "EMP1001";
    private String employeeName = "Rama";
    private String department = "SAP";

    public void displayEmployee() {
        System.out.println("Employee Details");
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Department    : " + department);
    }

    public void updateDepartment(String department) {
        this.department = department;
    }
}

public class RelfectioninHRMS {

    public static void main(String[] args) throws Exception {

        Employee_AdReflectionDemo employee
                = new Employee_AdReflectionDemo();

        System.out.println("-----------------------------");
        System.out.println("HRMS Employee Processing");
        System.out.println("-----------------------------");
        Field field
                = Employee_AdReflectionDemo.class
                        .getDeclaredField("department");

        field.setAccessible(true);

        System.out.println("Original Department : "
                + field.get(employee));

        field.set(employee, "Finance");

        System.out.println("Updated Department  : "
                + field.get(employee));

        System.out.println("-----------------------------");

        Method method
                = Employee_AdReflectionDemo.class
                        .getDeclaredMethod("displayEmployee");

        System.out.println("Invoking Employee Method...");
        method.invoke(employee);

        System.out.println("-----------------------------");
    }
}
