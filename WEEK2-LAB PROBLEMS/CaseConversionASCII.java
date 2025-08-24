import java.util.Scanner;

public class CaseConversionASCII {

    public static char toUpperCaseASCII(char c) {
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c;
    }

    public static char toLowerCaseASCII(char c) {
        return (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
    }

    public static String toTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                newWord = true;
                result.append(c);
            } else if (newWord) {
                result.append(toUpperCaseASCII(c));
                newWord = false;
            } else {
                result.append(toLowerCaseASCII(c));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            String upper = "";
            String lower = "";
            for (int i = 0; i < text.length(); i++) {
                upper += toUpperCaseASCII(text.charAt(i));
                lower += toLowerCaseASCII(text.charAt(i));
            }

            String title = toTitleCase(text);

            System.out.println("\nManual Uppercase: " + upper);
            System.out.println("Manual Lowercase: " + lower);
            System.out.println("Manual Titlecase: " + title);
            System.out.println("\nBuilt-in Uppercase: " + text.toUpperCase());
            System.out.println("Built-in Lowercase: " + text.toLowerCase());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
