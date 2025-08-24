import java.util.Scanner;

public class FindReplaceSubstring {

    public static int[] findPositions(String text, String find) {
        int[] temp = new int[text.length()];
        int count = 0, index = text.indexOf(find);
        while (index != -1) {
            temp[count++] = index;
            index = text.indexOf(find, index + find.length());
        }
        int[] positions = new int[count];
        for (int i = 0; i < count; i++) positions[i] = temp[i];
        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String original, String find, String replace) {
        return original.replace(find, replace).equals(manualReplace(original, find, replace));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter main text: ");
            String text = sc.nextLine();
            System.out.print("Enter substring to find: ");
            String find = sc.nextLine();
            System.out.print("Enter replacement substring: ");
            String replace = sc.nextLine();

            String manual = manualReplace(text, find, replace);
            System.out.println("\nManual Replacement: " + manual);
            System.out.println("Built-in Replacement: " + text.replace(find, replace));
            System.out.println("Comparison Result: " + compareWithBuiltIn(text, find, replace));
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        sc.close();
    }
}
