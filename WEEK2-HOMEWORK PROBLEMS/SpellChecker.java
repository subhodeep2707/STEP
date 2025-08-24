import java.util.Scanner;

public class SpellChecker {
    static String[] dictionary = {"hello", "world", "java", "programming", "spell", "checker"};

    static String[] splitSentence(String sentence) {
        String[] words = new String[100];
        int index = 0, start = 0, count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
                if (start < i) {
                    words[count++] = sentence.substring(start, i);
                }
                start = i + 1;
            }
        }
        if (start < sentence.length()) {
            words[count++] = sentence.substring(start);
        }
        String[] result = new String[count];
        System.arraycopy(words, 0, result, 0, count);
        return result;
    }

    static int stringDistance(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        int diff = Math.abs(len1 - len2);
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }

    static String getClosestWord(String word) {
        String closest = word;
        int minDist = Integer.MAX_VALUE;
        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                closest = dictWord;
            }
        }
        return minDist <= 2 ? closest : word;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();
        String[] words = splitSentence(sentence);
        System.out.printf("%-15s %-15s %-10s %-15s\n", "Word", "Suggestion", "Distance", "Status");
        for (String word : words) {
            String suggestion = getClosestWord(word);
            int dist = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = dist == 0 ? "Correct" : "Misspelled";
            System.out.printf("%-15s %-15s %-10d %-15s\n", word, suggestion, dist, status);
        }
    }
}
