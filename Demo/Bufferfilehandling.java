package Demo;

import java.io.*;

public class Bufferfilehandling {

    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileHandling/employee.txt"));
            for (int i = 0; i < 5; i++) {
                bw.write("\nEmployee Id   : 10" + i + "\nEmployee Name : Employee" + i + "\nDesignation   : Software Engineer\nSalary        : Rs. 50000");
            }
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("FileHandling/employee.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
