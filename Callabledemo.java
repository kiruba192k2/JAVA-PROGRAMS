import java.util.concurrent.*;

class EmployeeReportTask implements Callable<String> {

    @Override
    public String call() throws Exception {

        Thread.sleep(2000);

        return """
                ------------------------------------
                Employee Report
                ------------------------------------
                Employee ID   : EMP1001
                Employee Name : Rama
                Department    : SAP
                Status        : Active
                ------------------------------------
                """;
    }
}

public class Callabledemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> report = executor.submit(new EmployeeReportTask());
        System.out.println("Generating Report...");
        System.out.println(report.get());
        executor.shutdown();
    }
}

