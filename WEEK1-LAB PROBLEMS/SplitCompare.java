import java.util.Scanner;

public class SplitCompare {
    public static String[] customSplit(String s) {
        int wordCount = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ') wordCount++;

        String[] words = new String[wordCount + 1];
        int start = 0, index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words[index++] = s.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = s.substring(start);
        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] customWords = customSplit(input);
        String[] builtInWords = input.split(" ");

        System.out.println("Custom Split:");
        for (String w : customWords) System.out.println(w);

        System.out.println("Built-in Split:");
        for (String w : builtInWords) System.out.println(w);

        System.out.println("Are both equal? " + compareArrays(customWords, builtInWords));
    }
}

