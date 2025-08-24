import java.util.Scanner;

public class CharFrequencyUnique {
    public static char[] uniqueChars(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result.toCharArray();
    }

    public static void frequency(String s) {
        char[] unique = uniqueChars(s);
        for (char c : unique) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) count++;
            }
            System.out.println(c + " : " + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        frequency(text);
        sc.close();
    }
}

