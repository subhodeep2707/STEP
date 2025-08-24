import java.util.Scanner;

public class StringPerformanceTest {

    public static long testStringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        return System.currentTimeMillis() - start;
    }

    public static long testStringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        return System.currentTimeMillis() - start;
    }

    public static long testStringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of iterations: ");
            int n = sc.nextInt();

            long timeString = testStringConcat(n);
            long timeBuilder = testStringBuilder(n);
            long timeBuffer = testStringBuffer(n);

            System.out.println("\nMethod\t\tTime(ms)");
            System.out.println("String\t\t" + timeString);
            System.out.println("StringBuilder\t" + timeBuilder);
            System.out.println("StringBuffer\t" + timeBuffer);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        sc.close();
    }
}
