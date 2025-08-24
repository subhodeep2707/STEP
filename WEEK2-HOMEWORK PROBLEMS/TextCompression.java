import java.util.*;

public class TextCompression {
    static String compress(String text) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= text.length(); i++) {
            if (i < text.length() && text.charAt(i) == text.charAt(i - 1)) {
                count++;
            } else {
                sb.append(text.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    static String decompress(String compressed) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compressed.length(); i += 2) {
            char c = compressed.charAt(i);
            int count = compressed.charAt(i + 1) - '0';
            for (int j = 0; j < count; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();
        String compressed = compress(text);
        String decompressed = decompress(compressed);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}
