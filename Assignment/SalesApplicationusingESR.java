package Assignment;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class SalesApplicationusingESR {

    static class SalesRecord {

        private String product;
        private double amount;

        public SalesRecord(String product, double amount) {
            this.product = product;
            this.amount = amount;
        }

        public String getProduct() {
            return product;
        }

        public double getAmount() {
            return amount;
        }
    }

    static class FileProcessor {

        public List<SalesRecord> readFile(String fileName) {
            List<SalesRecord> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    String[] data = line.split(",");
                    String product = data[0].trim();
                    double amount = Double.parseDouble(data[1].trim());
                    records.add(new SalesRecord(product, amount));
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error processing " + fileName);
            }
            return records;
        }
    }

    static class SalesCalculationTask implements Runnable {

        private String fileName;
        private FileProcessor fileProcessor;
        private List<String> results;

        public SalesCalculationTask(String fileName, FileProcessor fileProcessor, List<String> results) {
            this.fileName = fileName;
            this.fileProcessor = fileProcessor;
            this.results = results;
        }

        @Override
        public void run() {
            System.out.println("Processing " + fileName + "...");
            List<SalesRecord> records = fileProcessor.readFile(fileName);
            if (records.isEmpty()) {
                synchronized (results) {
                    results.add(fileName + " : No records");
                }
                return;
            }
            int numberOfRecords = records.size();
            double totalSales = 0;
            double highestSale = Double.MIN_VALUE;
            double lowestSale = Double.MAX_VALUE;
            for (SalesRecord record : records) {
                double amount = record.getAmount();
                totalSales += amount;
                if (amount > highestSale) {
                    highestSale = amount;
                }
                if (amount < lowestSale) {
                    lowestSale = amount;
                }
            }
            double averageSale = totalSales / numberOfRecords;
            String result
                    = fileName
                    + " | Records : " + numberOfRecords
                    + " | Total : ₹" + totalSales
                    + " | Highest : ₹" + highestSale
                    + " | Lowest : ₹" + lowestSale
                    + " | Average : ₹" + averageSale;
            synchronized (results) {
                results.add(result);
            }
        }
    }

    static class ReportGenerator {

        public void generateReport(List<String> results) {
            double grandTotal = 0;
            System.out.println();
            System.out.println("MONTHLY SALES REPORT");
            for (String result : results) {
                System.out.println(result);
                String[] parts = result.split("\\|");
                if (parts.length > 2) {
                    String totalPart = parts[2].trim();
                    String totalValue = totalPart.replace("Total : ₹", "").trim();
                    try {
                        grandTotal += Double.parseDouble(totalValue);
                    } catch (NumberFormatException e) {
                    }
                }
            }
            System.out.println("Grand Total : ₹" + grandTotal);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        FileProcessor fileProcessor = new FileProcessor();
        List<String> results = Collections.synchronizedList(new ArrayList<>());
        String[] files = {
            "Assignment/sales_january.txt",
            "Assignment/sales_february.txt",
            "Assignment/sales_march.txt",
            "Assignment/sales_april.txt",
            "Assignment/sales_may.txt"
        };
        for (String file : files) {
            executor.submit(new SalesCalculationTask(file, fileProcessor, results));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(results);
    }
}
