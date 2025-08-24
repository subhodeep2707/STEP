import java.util.Scanner;

public class StringUtilityApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Reverse String");
            System.out.println("2. Palindrome Check");
            System.out.println("3. Count Vowels and Consonants");
            System.out.println("4. Word Count");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 5) break;
            System.out.print("Enter a string: ");
            String input = sc.nextLine();
            switch (choice) {
                case 1: System.out.println("Reversed: " + new StringBuilder(input).reverse()); break;
                case 2: System.out.println("Palindrome: " + isPalindrome(input)); break;
                case 3: countVowelsConsonants(input); break;
                case 4: System.out.println("Word Count: " + input.split("\\s+").length); break;
                default: System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("\\s+", "");
        return str.equals(new StringBuilder(str).reverse().toString());
    }
    public static void countVowelsConsonants(String str) {
        int v = 0, c = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) v++;
                else c++;
            }
        }
        System.out.println("Vowels: " + v + ", Consonants: " + c);
    }
}
