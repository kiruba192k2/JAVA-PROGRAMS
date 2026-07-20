
import java.io.*;
import java.sql.*;
import java.util.*;

public class PayrollSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/payroll", "root", "root");
            while (true) {
                System.out.println("\n==============================");
                System.out.println("EMPLOYEE PAYROLL SYSTEM");
                System.out.println("==============================");
                System.out.println("1. Register Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Update Salary");
                System.out.println("5. Delete Employee");
                System.out.println("6. Sort by Name");
                System.out.println("7. Sort by Salary");
                System.out.println("8. Export to File");
                System.out.println("9. Exit");
                System.out.print("Enter Choice : ");
                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid Choice.");
                    continue;
                }
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("How many employees do you want to register? : ");
                            int count = Integer.parseInt(sc.nextLine());
                            if (count <= 0) {
                                System.out.println("Registeration value must be greater than 0.");
                                break;
                            }
                            String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";
                            PreparedStatement ps = con.prepareStatement(sql);
                            for (int i = 1; i <= count; i++) {
                                System.out.println("\n========== Employee " + i + " ==========");
                                try {
                                    // Employee ID
                                    System.out.print("Employee ID : ");
                                    int id = Integer.parseInt(sc.nextLine());
                                    if (id <= 0) {
                                        System.out.println("Employee ID cannot be zero or negative.");
                                        continue;
                                    }
                                    System.out.print("Employee Name : ");
                                    String name = sc.nextLine();
                                    if (!name.matches("[A-Za-z ]+")) {
                                        System.out.println("Name should be only  in alphabets.");
                                        continue;
                                    }
                                    System.out.println("\nSelect Department");
                                    System.out.println("1. Development");
                                    System.out.println("2. Human Resources");
                                    System.out.println("3. Finance");
                                    System.out.println("4. Sales");
                                    System.out.println("5. Marketing");
                                    System.out.println("6. Quality Assurance");
                                    System.out.print("Enter Choice : ");
                                    int deptChoice = Integer.parseInt(sc.nextLine());
                                    String dept = "";
                                    String des = "";
                                    switch (deptChoice) {
                                        case 1:
                                            dept = "Engineering";
                                            System.out.println("\nSelect Position");
                                            System.out.println("1. Software Engineer");
                                            System.out.println("2. Senior Software Engineer");
                                            System.out.println("3. Technical Lead");
                                            System.out.println("4. Manager");
                                            System.out.print("Enter Choice : ");
                                            int eng = Integer.parseInt(sc.nextLine());
                                            switch (eng) {
                                                case 1:
                                                    des = "Software Engineer";
                                                    break;
                                                case 2:
                                                    des = "Senior Software Engineer";
                                                    break;
                                                case 3:
                                                    des = "Technical Lead";
                                                    break;
                                                case 4:
                                                    des = " Manager";
                                                    break;
                                                default:
                                                    System.out.println("Invalid Position.");
                                                    continue;
                                            }
                                            break;
                                        case 2:
                                            dept = "Human Resources";
                                            System.out.println("\nSelect Position");
                                            System.out.println("1. HR Executive");
                                            System.out.println("2. HR Manager");
                                            System.out.println("3. Recruiter");
                                            System.out.print("Enter Choice : ");
                                            int hr = Integer.parseInt(sc.nextLine());
                                            switch (hr) {
                                                case 1:
                                                    des = "HR Executive";
                                                    break;
                                                case 2:
                                                    des = "HR Manager";
                                                    break;
                                                case 3:
                                                    des = "Recruiter";
                                                    break;
                                                default:
                                                    System.out.println("Invalid Position.");
                                                    continue;
                                            }
                                            break;
                                        case 3:
                                            dept = "Finance";
                                            System.out.println("\nSelect Position");
                                            System.out.println("1. Accountant");
                                            System.out.println("2. Finance Executive");
                                            System.out.println("3. Finance Manager");
                                            System.out.print("Enter Choice : ");
                                            int fin = Integer.parseInt(sc.nextLine());
                                            switch (fin) {
                                                case 1:
                                                    des = "Accountant";
                                                    break;
                                                case 2:
                                                    des = "Finance Executive";
                                                    break;
                                                case 3:
                                                    des = "Finance Manager";
                                                    break;
                                                default:
                                                    System.out.println("Invalid Position.");
                                                    continue;
                                            }
                                            break;
                                        case 4:
                                            dept = "Sales";
                                            System.out.println("\nSelect Position");
                                            System.out.println("1. Sales Executive");
                                            System.out.println("2. Business Development Executive");
                                            System.out.println("3. Sales Manager");
                                            System.out.print("Enter Choice : ");
                                            int sales = Integer.parseInt(sc.nextLine());
                                            switch (sales) {
                                                case 1:
                                                    des = "Sales Executive";
                                                    break;
                                                case 2:
                                                    des = "Business Development Executive";
                                                    break;
                                                case 3:
                                                    des = "Sales Manager";
                                                    break;
                                                default:
                                                    System.out.println("Invalid Position.");
                                                    continue;
                                            }
                                            break;
                                        case 5:
                                            dept = "Marketing";
                                            System.out.println("\nSelect Position");
                                            System.out.println("1. Digital Marketing Executive");
                                            System.out.println("2. Content Writer");
                                            System.out.println("3. Marketing Manager");
                                            System.out.print("Enter Choice : ");
                                            int mark = Integer.parseInt(sc.nextLine());
                                            switch (mark) {
                                                case 1:
                                                    des = "Digital Marketing Executive";
                                                    break;
                                                case 2:
                                                    des = "Content Writer";
                                                    break;
                                                case 3:
                                                    des = "Marketing Manager";
                                                    break;
                                                default:
                                                    System.out.println("Invalid Position.");
                                                    continue;
                                            }
                                            break;
                                        case 6:
                                            dept = "Quality Assurance";
                                            System.out.println("\nSelect Position");
                                            System.out.println("1. QA Engineer");
                                            System.out.println("2. Senior QA Engineer");
                                            System.out.println("3. QA Lead");
                                            System.out.print("Enter Choice : ");
                                            int qa = Integer.parseInt(sc.nextLine());
                                            switch (qa) {
                                                case 1:
                                                    des = "QA Engineer";
                                                    break;
                                                case 2:
                                                    des = "Senior QA Engineer";
                                                    break;
                                                case 3:
                                                    des = "QA Lead";
                                                    break;
                                                default:
                                                    System.out.println("Invalid Position.");
                                                    continue;
                                            }
                                            break;
                                        default:
                                            System.out.println("Invalid Department.");
                                            continue;
                                    }
                                    System.out.print("\nSalary : ");
                                    double salary = Double.parseDouble(sc.nextLine());
                                    if (salary <= 0) {
                                        System.out.println("Salary must be greater than 0.");
                                        continue;
                                    }
                                    ps.setInt(1, id);
                                    ps.setString(2, name);
                                    ps.setString(3, dept);
                                    ps.setString(4, des);
                                    ps.setDouble(5, salary);
                                    int rows = ps.executeUpdate();
                                    if (rows > 0) {
                                        System.out.println("Employee Registered Successfully.");
                                    }
                                } catch (SQLIntegrityConstraintViolationException e) {
                                    System.out.println("Duplicate Employee ID.");
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid Numeric Input.");
                                }
                            }
                            ps.close();
                        } catch (SQLException e) {
                            System.out.println("Database Error : " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid Count.");
                        }
                        break;
                    case 2:
                        Statement st = con.createStatement();
                        ResultSet rs
                                = st.executeQuery("SELECT * FROM employee");
                        System.out.println();
                        if (rs.next()) {
                            do {
                                System.out.println("--------------------------------------");
                                System.out.println("Employee ID      : " + rs.getInt("empid"));
                                System.out.println("Employee Name    : " + rs.getString("empname"));
                                System.out.println("Department       : " + rs.getString("department"));
                                System.out.println("Designation      : " + rs.getString("designation"));
                                System.out.println("Employee Salary  : " + rs.getDouble("salary"));
                            } while (rs.next());
                        } else {
                            System.out.println("No Employees Found.");
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter Employee ID : ");
                            int id = Integer.parseInt(sc.nextLine());
                            String sql = "SELECT * FROM employee WHERE empid=?";
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.setInt(1, id);
                            ResultSet rs1 = ps.executeQuery();
                            if (rs1.next()) {
                                System.out.println("\nEmployee Found");
                                System.out.println("Employee ID : " + rs1.getInt("empid"));
                                System.out.println("Employee Name : " + rs1.getString("empname"));
                                System.out.println("Department : " + rs1.getString("department"));
                                System.out.println("Designation : " + rs1.getString("designation"));
                                System.out.println("Salary : " + rs1.getDouble("salary"));
                            } else {
                                System.out.println("Employee Not Found");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Input");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Enter Employee ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter New Salary: ");
                            double salary = Double.parseDouble(sc.nextLine());
                            if (salary <= 0) {
                                System.out.println("Salary must be greater than 0.");
                                break;
                            }
                            String sql = "UPDATE employee SET salary = ? WHERE empid = ?";
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.setDouble(1, salary);
                            ps.setInt(2, id);
                            int rows = ps.executeUpdate();
                            if (rows > 0) {
                                System.out.println("Salary Updated Successfully.");
                            } else {
                                System.out.println("Employee Not Found.");
                            }
                            ps.close();
                        } catch (NumberFormatException e) {
                            System.out.println("Employee ID and Salary must be numeric.");
                        } catch (SQLException e) {
                            System.out.println("Database Error: " + e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            System.out.print("Enter Employee ID : ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Are you sure (Y/N)? ");
                            String ch = sc.nextLine();
                            if (ch.equalsIgnoreCase("Y")) {
                                String sql = "DELETE FROM employee WHERE empid=?";
                                PreparedStatement ps = con.prepareStatement(sql);
                                ps.setInt(1, id);
                                int rows = ps.executeUpdate();
                                if (rows > 0) {
                                    System.out.println("Employee Deleted Successfully");
                                } else {
                                    System.out.println("Employee Not Found");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Input");
                        }
                        break;
                    case 6:
                        try {
                            System.out.println("Enter your choice: ");
                            System.out.println("1. Ascending");
                            System.out.println("2. Descending");
                            int sortChoice = Integer.parseInt(sc.nextLine());
                            String sql;
                            if (sortChoice == 1) {
                                sql = "SELECT * FROM employee ORDER BY empname ASC";
                            } else if (sortChoice == 2) {
                                sql = "SELECT * FROM employee ORDER BY empname DESC";
                            } else {
                                System.out.println("Invalid Choice");
                                break;
                            }
                            Statement st2 = con.createStatement();
                            ResultSet rs3 = st2.executeQuery(sql);
                            System.out.println("----------------------------------------------------------");
                            while (rs3.next()) {
                                System.out.println("Employee ID : " + rs3.getInt("empid"));
                                System.out.println("Employee Name : " + rs3.getString("empname"));
                                System.out.println("Department : " + rs3.getString("department"));
                                System.out.println("Designation : " + rs3.getString("designation"));
                                System.out.println("Salary : " + rs3.getDouble("salary"));
                                System.out.println("----------------------------------------------------------");
                            }
                        } catch (Exception e) {
                            System.out.println("Error sorting by Name.");
                        }
                        break;
                    case 7:
                        try {
                            System.out.println("Enter your choice to Sort: ");
                            System.out.println("1. Ascending");
                            System.out.println("2. Descending");
                            int sortChoice = Integer.parseInt(sc.nextLine());
                            String sql;
                            if (sortChoice == 1) {
                                sql = "SELECT * FROM employee ORDER BY salary ASC";
                            } else if (sortChoice == 2) {
                                sql = "SELECT * FROM employee ORDER BY salary DESC";
                            } else {
                                System.out.println("Invalid Choice");
                                break;
                            }
                            Statement st1 = con.createStatement();
                            ResultSet rs2 = st1.executeQuery(sql);
                            System.out.println("--------------------------------------------------------------");
                            while (rs2.next()) {
                                System.out.println("Employee ID : " + rs2.getInt("empid"));
                                System.out.println("Employee Name : " + rs2.getString("empname"));
                                System.out.println("Department : " + rs2.getString("department"));
                                System.out.println("Designation : " + rs2.getString("designation"));
                                System.out.println("Salary : " + rs2.getDouble("salary"));
                                System.out.println("--------------------------------------------------------------");
                            }
                        } catch (Exception e) {
                            System.out.println("Error sorting by salary.");
                        }
                        break;
                    case 8:
                        FileWriter fw = new FileWriter("employee.txt");
                        Statement st3 = con.createStatement();
                        ResultSet rs4 = st3.executeQuery("SELECT * FROM employee");
                        fw.write("******** EMPLOYEE DETAILS ********\n\n");
                        fw.write("+--------------------------------------+\n");
                        fw.write("|         EMPLOYEE DETAILS             |\n");
                        fw.write("+--------------------------------------+\n");
                        while (rs4.next()) {
                            while (rs4.next()) {
                                fw.write("Employee ID : " + rs4.getInt("empid") + "\n");
                                fw.write("Employee Name : " + rs4.getString("empname") + "\n");
                                fw.write("Department : " + rs4.getString("department") + "\n");
                                fw.write("Designation : " + rs4.getString("designation") + "\n");
                                fw.write("Salary : " + rs4.getDouble("salary") + "\n");
                                fw.write("----------------------------------------\n");
                            }
                        }
                        fw.close();
                        System.out.println("Employee Details Exported Successfully");
                        break;
                    case 9:
                        System.out.println("Thank You");
                        con.close();
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Menu Choice");
                }
            }
        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }
}
