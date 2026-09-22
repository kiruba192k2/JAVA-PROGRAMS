
import java.io.*;

public class Write {

    public static void main(String[] args) {
        try {

            FileWriter fw = new FileWriter("Data.txt");
            FileReader fr = new FileReader("Data.txt");

            // fw.write("java");
            fw.write("101,John,50000\n");
            fw.write("102,Alice,60000\n");
            fw.write("103,Bob,55000\n");
            fw.close();
            int x;
            while ((x = fr.read()) != -1) {
                System.out.print((char) x);

            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
