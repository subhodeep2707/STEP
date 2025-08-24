import java.util.Scanner;

public class CaesarCipher {

    public static String encryptText(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char base = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                encrypted.append((char)((c - base + shift) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static String decryptText(String text, int shift) {
        return encryptText(text, 26 - shift % 26);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter text: ");
            String text = sc.nextLine();
            System.out.print("Enter shift value: ");
            int shift = sc.nextInt();

            String encrypted = encryptText(text, shift);
            String decrypted = decryptText(encrypted, shift);

            System.out.println("\nOriginal: " + text);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println("Decryption Valid: " + text.equals(decrypted));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
