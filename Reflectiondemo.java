
import java.lang.reflect.Field;

class Employeereflex {

    private String employeeId = "EMP1001";
    private String employeeName = "Rama";
    private String department = "SAP";
}

public class Reflectiondemo {

    public static void main(String[] args) throws Exception {

        Employeereflex employee = new Employeereflex();

        Field field = Employeereflex.class.getDeclaredField("employeeName");

        field.setAccessible(true);

        String name = (String) field.get(employee);

        System.out.println("Employee Name : " + name);
    }
}
