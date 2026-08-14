
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeStatusAnnotation {

    String status();
}

@EmployeeStatusAnnotation(status = "Active")
class EmployeeStatusAnnotationDemo {

    String employeeId = "EMP1001";
    String employeeName = "Rama";
}

public class EmployeeStatuswithAnnotation {

    public static void main(String[] args) {
        Class<EmployeeStatusAnnotationDemo> employeeClass
                = EmployeeStatusAnnotationDemo.class;
        EmployeeStatusAnnotation status
                = employeeClass.getAnnotation(EmployeeStatusAnnotation.class);
        System.out.println("Employee ID     : EMP1001");
        System.out.println("Employee Name   : Rama");
        System.out.println("Employee Status : " + status.status());
    }
}
