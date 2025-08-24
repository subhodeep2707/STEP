import java.util.*;

public class TextProcessor {

    // Clean and validate input
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Analyze text (without HashMap)
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        String[] sentences = text.split("[.!?]");
        int sentenceCount = 0;
        for (String s : sentences) {
            if (!s.trim().isEmpty()) sentenceCount++;
        }

        int charCount = text.replaceAll(" ", "").length();

        // Find longest word
        String longestWord = "";
        for (String w : words) {
            if (w.length() > longestWord.length()) {
                longestWord = w;
            }
        }

        // Most common character using array
        int[] freq = new int[256];
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) freq[c]++;
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostCommonChar = (char) i;
            }
        }

        System.out.println("\n--- TEXT ANALYSIS ---");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Character Count (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar + " (" + maxFreq + " times)");
    }

    // Get sorted words
    public static String[] getWordsSorted(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = cleaned.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleanedText = cleanInput(input);

        analyzeText(cleanedText);

        String[] sortedWords = getWordsSorted(cleanedText);
        System.out.println("\n--- SORTED WORDS ---");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine();
        boolean found = false;
        for (String word : sortedWords) {
            if (word.equalsIgnoreCase(searchWord)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The word \"" + searchWord + "\" is present in the text.");
        } else {
            System.out.println("The word \"" + searchWord + "\" was NOT found.");
        }

        scanner.close();
    }
}
