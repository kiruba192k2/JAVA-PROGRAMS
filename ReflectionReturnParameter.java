
import java.lang.reflect.Method;

class Employee_MethodWithParameter {

    private String department = "SAP";

    public void updateDepartment(String department) {

        this.department = department;

        System.out.println("Department Updated : " + this.department);

    }

}

public class ReflectionReturnParameter {

    public static void main(String[] args) throws Exception {

        Employee_MethodWithParameter employee
                = new Employee_MethodWithParameter();

        Method method = Employee_MethodWithParameter.class
                .getDeclaredMethod("updateDepartment", String.class);

        method.invoke(employee, "Finance");

    }

}
