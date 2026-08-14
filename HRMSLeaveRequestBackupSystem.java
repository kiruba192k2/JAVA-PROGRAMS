
import java.io.*;
import java.util.*;

class LeaveRequest implements Serializable {

    private String Requestid;
    private String Employeeid;
    private String Employeename;
    private String Leavetype;
    private int Nodays;
    private transient String Status;
    // private  String Status;

    LeaveRequest(String Requestid, String Employeeid, String Employeename,
            String Leavetype, int Nodays, String Status) {
        this.Requestid = Requestid;
        this.Employeeid = Employeeid;
        this.Employeename = Employeename;
        this.Leavetype = Leavetype;
        this.Nodays = Nodays;
        this.Status = Status;
    }

    public void displayLeaveRequest() {
        System.out.println("Request ID     : " + Requestid);
        System.out.println("Employee ID    : " + Employeeid);
        System.out.println("Employee Name  : " + Employeename);
        System.out.println("Leave Type     : " + Leavetype);
        System.out.println("Number of Days : " + Nodays);
        System.out.println("Status         : " + Status);
    }
}

public class HRMSLeaveRequestBackupSystem {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of leave requests: ");
        int n = sc.nextInt();
        sc.nextLine();
        LeaveRequest[] requests = new LeaveRequest[n];
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Enter details for Leave Request " + (i + 1));
            System.out.print("Request ID: ");
            String Requestid = sc.nextLine();
            System.out.print("Employee ID: ");
            String Employeeid = sc.nextLine();
            System.out.print("Employee Name: ");
            String Employeename = sc.nextLine();
            System.out.print("Leave Type: ");
            String Leavetype = sc.nextLine();
            System.out.print("Number of Days: ");
            int Nodays = sc.nextInt();
            sc.nextLine();
            System.out.print("Status: ");
            String Status = sc.nextLine();
            requests[i] = new LeaveRequest(
                    Requestid,
                    Employeeid,
                    Employeename,
                    Leavetype,
                    Nodays,
                    Status
            );
        }
        ObjectOutputStream output
                = new ObjectOutputStream(
                        new FileOutputStream("leaverequests.ser")
                );
        for (LeaveRequest request : requests) {
            output.writeObject(request);
        }
        output.close();
        System.out.println();
        System.out.println("Leave requests saved.");
        ObjectInputStream input
                = new ObjectInputStream(
                        new FileInputStream("leaverequests.ser")
                );

        System.out.println();
        System.out.println(" Leave Requests ");

        for (int i = 0; i < n; i++) {

            LeaveRequest savedRequest
                    = (LeaveRequest) input.readObject();

            System.out.println();
            savedRequest.displayLeaveRequest();
        }

        input.close();
        sc.close();

        System.out.println();
    }
}
