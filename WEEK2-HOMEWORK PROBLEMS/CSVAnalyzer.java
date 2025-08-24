import java.io.*;
import java.util.*;

public class CSVAnalyzer {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV file path:");
        String filePath = sc.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int rowCount = 0;
        int colCount = 0;
        while ((line = br.readLine()) != null) {
            rowCount++;
            String[] values = line.split(",");
            colCount = Math.max(colCount, values.length);
        }
        br.close();
        System.out.println("Rows: " + rowCount);
        System.out.println("Columns: " + colCount);
    }
}
