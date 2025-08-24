import java.util.Scanner;

public class TextFormatter {

    public static String[] splitWords(String text) {
        int wordCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }
        String[] words = new String[wordCount + 1];
        int index = 0;
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        return words;
    }

    public static void justifyText(String[] words, int width) {
        String line = "";
        int count = 0;
        System.out.println("\nJustified Text:");
        for (int i = 0; i < words.length; i++) {
            if (count + words[i].length() + (line.isEmpty() ? 0 : 1) > width) {
                System.out.println(line);
                line = "";
                count = 0;
            }
            if (!line.isEmpty()) line += " ";
            line += words[i];
            count += words[i].length() + 1;
        }
        if (!line.isEmpty()) System.out.println(line);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter text: ");
            String text = sc.nextLine();
            System.out.print("Enter line width: ");
            int width = sc.nextInt();

            String[] words = splitWords(text);
            justifyText(words, width);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
