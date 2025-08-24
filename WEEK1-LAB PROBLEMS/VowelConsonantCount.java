import java.util.Scanner;

public class VowelConsonantCount {
    public static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32); // Convert to lowercase
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            String type = checkChar(s.charAt(i));
            if (type.equals("Vowel")) v++;
            else if (type.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int[] counts = countVowelsConsonants(input);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}
