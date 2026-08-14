
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employeee {

    private String empId = "EMP1001";
    private String empName = "Rama";
    private String dept = "SAP";
    private String desg = "Developer";

    public void displayEmployee() {
        System.out.println("Employee Details");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Department    : " + dept);
        System.out.println("Designation   : " + desg);
    }

    public void updateDepartment(String newDept) {
        dept = newDept;
    }

    public void updateDesignation(String newDesg) {
        desg = newDesg;
    }
}

public class HRMSdatadynamicupdate {

    public static void main(String[] args) throws Exception {
        Employeee empObj = new Employeee();
        System.out.println("HRMS Employee Processing");
        Field deptField
                = Employeee.class.getDeclaredField("dept");
        deptField.setAccessible(true);
        System.out.println("Original Department : "
                + deptField.get(empObj));
        deptField.set(empObj, "Finance");
        System.out.println("Updated Department  : "
                + deptField.get(empObj));
        Method displayMethod
                = Employeee.class.getDeclaredMethod("displayEmployee");

        System.out.println("\nInvoking displayEmployee()...");
        displayMethod.invoke(empObj);

        Method desgMethod
                = Employeee.class.getDeclaredMethod(
                        "updateDesignation",
                        String.class
                );

        desgMethod.invoke(
                empObj,
                "Senior Consultant"
        );

        System.out.println("\nFinal Employee Details:");
        displayMethod.invoke(empObj);
    }
}
