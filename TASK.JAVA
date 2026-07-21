package Test;

class Employee {

    int empId;
    String empName;
    String department;
    String designation;
    double salary;

    Employee(int empId,
             String empName,
             String department,
             String designation,
             double salary) {

        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
}
class DBConnection {

    static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abctechnology",
                    "root",
                    "root");

            System.out.println("Database Connected Successfully");

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL JDBC Driver Not Found");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}
class EmployeeDAO {

    // Register Employee
    void registerEmployee(Employee emp) {

        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Unable to connect to database.");
            return;
        }

        try {

            String query = "INSERT INTO employee (empId, empName, department, designation, salary) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, emp.empId);
            ps.setString(2, emp.empName);
            ps.setString(3, emp.department);
            ps.setString(4, emp.designation);
            ps.setDouble(5, emp.salary);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Employee Registered Successfully");
            } else {
                System.out.println("Registration Failed");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // View All Employees
    void viewEmployees() {

        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Unable to connect to database.");
            return;
        }

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------");
                System.out.println("Employee ID   : " + rs.getInt("empId"));
                System.out.println("Employee Name : " + rs.getString("empName"));
                System.out.println("Department    : " + rs.getString("department"));
                System.out.println("Designation   : " + rs.getString("designation"));
                System.out.println("Salary        : " + rs.getDouble("salary"));
            }

            if (!found) {
                System.out.println("No Employee Records Found");
            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // Search Employee
    void searchEmployee(int id) {

        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Unable to connect to database.");
            return;
        }

        try {

            String query = "SELECT * FROM employee WHERE empId=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nEmployee Found");
                System.out.println("--------------------------");
                System.out.println("Employee ID   : " + rs.getInt("empId"));
                System.out.println("Employee Name : " + rs.getString("empName"));
                System.out.println("Department    : " + rs.getString("department"));
                System.out.println("Designation   : " + rs.getString("designation"));
                System.out.println("Salary        : " + rs.getDouble("salary"));

            } else {

                System.out.println("Employee Not Found");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
// Update Salary
void updateSalary(int id, double salary) {

    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Unable to connect to database.");
        return;
    }

    try {

        String query = "UPDATE employee SET salary=? WHERE empId=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int result = ps.executeUpdate();

        if (result > 0)
            System.out.println("Salary Updated Successfully");
        else
            System.out.println("Employee Not Found");

        ps.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error : " + e.getMessage());
    }
}


// Delete Employee
void deleteEmployee(int id) {

    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Unable to connect to database.");
        return;
    }

    try {

        String query = "DELETE FROM employee WHERE empId=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        int result = ps.executeUpdate();

        if (result > 0)
            System.out.println("Employee Deleted Successfully");
        else
            System.out.println("Employee Not Found");

        ps.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error : " + e.getMessage());
    }
}


void sortByName() {

    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Unable to connect to database.");
        return;
    }

    try {

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM employee ORDER BY empName ASC");

        while (rs.next()) {

            System.out.println("--------------------------------");
            System.out.println("Employee ID   : " + rs.getInt("empId"));
            System.out.println("Employee Name : " + rs.getString("empName"));
            System.out.println("Salary        : " + rs.getDouble("salary"));
        }

        rs.close();
        st.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error : " + e.getMessage());
    }
}


// Sort by Salary
void sortBySalary() {

    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Unable to connect to database.");
        return;
    }

    try {

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM employee ORDER BY salary DESC");

        while (rs.next()) {

            System.out.println("--------------------------------");
            System.out.println("Employee ID   : " + rs.getInt("empId"));
            System.out.println("Employee Name : " + rs.getString("empName"));
            System.out.println("Salary        : " + rs.getDouble("salary"));
        }

        rs.close();
        st.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error : " + e.getMessage());
    }
}
// Export Employee Details to File
void exportToFile() {

    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Unable to connect to database.");
        return;
    }

    try {

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM employee");

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("employee.txt"));

        while (rs.next()) {

            bw.write("Employee ID   : " + rs.getInt("empId"));
            bw.newLine();

            bw.write("Employee Name : " + rs.getString("empName"));
            bw.newLine();

            bw.write("Department    : " + rs.getString("department"));
            bw.newLine();

            bw.write("Designation   : " + rs.getString("designation"));
            bw.newLine();

            bw.write("Salary        : " + rs.getDouble("salary"));
            bw.newLine();

            bw.write("-----------------------------------------");
            bw.newLine();
        }

        bw.close();
        rs.close();
        st.close();
        con.close();

        System.out.println("Employee data exported successfully.");
        System.out.println("File created: employee.txt");

    } catch (Exception e) {
        System.out.println("Error : " + e.getMessage());
    }
}