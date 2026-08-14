
import java.lang.reflect.Method;

class EmployeeStatus {

    public String getEmployeeStatus() {

        return "Active";

    }

}

public class Reflectionreturnvalue {

    public static void main(String[] args) throws Exception {

        EmployeeStatus employee = new EmployeeStatus();

        Method method
                = EmployeeStatus.class.getDeclaredMethod("getEmployeeStatus");

        String status = (String) method.invoke(employee);

        System.out.println("Employee Status: " + status);

    }

}
