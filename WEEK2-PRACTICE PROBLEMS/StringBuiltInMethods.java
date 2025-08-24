public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";
        System.out.println("Original length: " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("Trimmed string: \"" + trimmed + "\"");
        System.out.println("Trimmed length: " + trimmed.length());
        System.out.println("Character at index 5: " + sampleText.charAt(5));
        String sub = sampleText.substring(6, 17);
        System.out.println("Substring: " + sub);
        System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));
        System.out.println("Contains 'Java': " + sampleText.contains("Java"));
        System.out.println("Starts with 'Java': " + trimmed.startsWith("Java"));
        System.out.println("Ends with '!': " + sampleText.endsWith("!"));
        System.out.println("Uppercase: " + sampleText.toUpperCase());
        System.out.println("Lowercase: " + sampleText.toLowerCase());
        System.out.println("Vowels count: " + countVowels(sampleText));
        System.out.print("Occurrences of 'a': ");
        findAllOccurrences(sampleText, 'a');
    }
    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
        }
        return count;
    }
    public static void findAllOccurrences(String text, char target) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) System.out.print(i + " ");
        }
        System.out.println();
    }
}
