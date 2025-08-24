import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);
        String replaced = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced: " + replaced);
        String noDigits = trimmed.replaceAll("[0-9]", "");
        System.out.println("No digits: " + noDigits);
        String[] words = trimmed.split(" ");
        System.out.println("Words:");
        for (String w : words) System.out.println(w);
        String joined = String.join(" | ", words);
        System.out.println("Joined with | : " + joined);
        System.out.println("No punctuation: " + removePunctuation(trimmed));
        System.out.println("Capitalized: " + capitalizeWords(trimmed));
        System.out.println("Reversed order: " + reverseWordOrder(trimmed));
        System.out.println("Word frequency:");
        countWordFrequency(trimmed);
        scanner.close();
    }
    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }
    public static String capitalizeWords(String text) {
        String[] words = text.split(" ");
        String result = "";
        for (String w : words) {
            if (w.length() > 0) result += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        }
        return result.trim();
    }
    public static String reverseWordOrder(String text) {
        String[] words = text.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) result += words[i] + " ";
        return result.trim();
    }
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split(" ");
        boolean[] counted = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        counted[j] = true;
                    }
                }
                System.out.println(words[i] + ": " + count);
            }
        }
    }
}
