
interface EmployeeF {

    void work();
}

class FullTimeEmployee implements EmployeeF {

    public void work() {
        System.out.println("Full-Time Employee is working.");
    }
}

class ContractEmployee implements EmployeeF {

    public void work() {
        System.out.println("Contract Employee is working.");
    }
}

class InternEmployee implements EmployeeF {

    public void work() {
        System.out.println("Intern Employee is learning and working.");
    }
}

class EmployeeFactory {

    public EmployeeF createEmployee(String type) {
        if ("FULLTIME".equalsIgnoreCase(type)) {
            return new FullTimeEmployee();
        } else if ("CONTRACT".equalsIgnoreCase(type)) {
            return new ContractEmployee();
        } else if ("INTERN".equalsIgnoreCase(type)) {
            return new InternEmployee();
        }

        throw new IllegalArgumentException("Invalid employee type: " + type);
    }
}

public class EmployeeManagementforFactory {

    public static void main(String[] args) {
        EmployeeFactory factory = new EmployeeFactory();
        EmployeeF employee1 = factory.createEmployee("FULLTIME");
        employee1.work();
        EmployeeF employee2 = factory.createEmployee("CONTRACT");
        employee2.work();
        EmployeeF employee3 = factory.createEmployee("INTERN");
        employee3.work();
    }
}
