
class EmployeeBuilderDemo {

    private String employeeId;
    private String name;
    private String department;
    private double salary;

    private EmployeeBuilderDemo(EBuilder builder) {
        employeeId = builder.employeeId;
        name = builder.name;
        department = builder.department;
        salary = builder.salary;
    }

    public void display() {
        System.out.println(employeeId + " - " + name + " - " + department + " - " + salary);
    }

    static class EBuilder {

        private String employeeId;
        private String name;
        private String department;
        private double salary;

        public EBuilder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public EBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilderDemo build() {
            return new EmployeeBuilderDemo(this);
        }
    }
}

public class HRMSEmployeeBuilderDemo {

    public static void main(String[] args) {
        EmployeeBuilderDemo employee = new EmployeeBuilderDemo.EBuilder()
                .setEmployeeId("EMP1001")
                .setName("Raja")
                .setDepartment("IT")
                .setSalary(100000)
                .build();
        employee.display();
    }
}
