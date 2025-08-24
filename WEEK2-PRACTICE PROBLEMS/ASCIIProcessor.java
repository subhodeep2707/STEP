import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int ascii = (int) ch;
            System.out.print(ch + " -> " + ascii);
            System.out.print(" | Type: " + classifyCharacter(ch));
            if (Character.isLetter(ch)) {
                char toggled = toggleCase(ch);
                System.out.print(" | ToggleCase: " + toggled);
            }
            System.out.println();
        }
        System.out.println("\nCaesar Cipher (+3): " + caesarCipher(text, 3));
        System.out.println("\nASCII Table (65-90):");
        displayASCIITable(65, 90);
        scanner.close();
    }
    public static String classifyCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') return "Uppercase Letter";
        if (ch >= 'a' && ch <= 'z') return "Lowercase Letter";
        if (ch >= '0' && ch <= '9') return "Digit";
        return "Special Character";
    }
    public static char toggleCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') return (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') return (char) (ch - 32);
        return ch;
    }
    public static String caesarCipher(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result += ch;
        }
        return result;
    }
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) System.out.println(i + " -> " + (char) i);
    }
}
