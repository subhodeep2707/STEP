import java.util.Scanner;

public class StringLength {
    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count); // Will throw exception at end
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int customLength = findLength(input);
        System.out.println("Custom Length: " + customLength);
        System.out.println("Built-in Length: " + input.length());
    }
}

