
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeInfo {

    String department();

    String role();
}

@EmployeeInfo(department = "SAP", role = "ABAP Developer")
class Employee_AnnotationDemo {

    String employeeId = "EMP1001";
    String employeeName = "Rama";
}

public class HRMSAnnotation {

    public static void main(String[] args) {

        Class<Employee_AnnotationDemo> employeeClass
                = Employee_AnnotationDemo.class;

        EmployeeInfo info
                = employeeClass.getAnnotation(EmployeeInfo.class);
        System.out.println("Employee ID     : EMP1001");
        System.out.println("Employee Name   : Rama");
        System.out.println("Department      : " + info.department());
        System.out.println("Role            : " + info.role());
    }
}
