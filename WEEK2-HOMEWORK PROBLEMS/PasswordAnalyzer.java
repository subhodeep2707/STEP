import java.util.*;

public class PasswordAnalyzer {
    static int[] analyzePassword(String password) {
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 65 && c <= 90) upper++;
            else if (c >= 97 && c <= 122) lower++;
            else if (c >= 48 && c <= 57) digit++;
            else special++;
        }
        return new int[]{upper, lower, digit, special};
    }

    static int calculateScore(String password, int[] counts) {
        int score = 0;
        if (password.length() > 8) score += (password.length() - 8) * 2;
        if (counts[0] > 0) score += 10;
        if (counts[1] > 0) score += 10;
        if (counts[2] > 0) score += 10;
        if (counts[3] > 0) score += 10;
        if (password.contains("123") || password.contains("abc") || password.toLowerCase().contains("qwerty"))
            score -= 10;
        return score;
    }

    static String strengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()";
        String all = upper + lower + digits + special;
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        sb.append(upper.charAt(r.nextInt(upper.length())));
        sb.append(lower.charAt(r.nextInt(lower.length())));
        sb.append(digits.charAt(r.nextInt(digits.length())));
        sb.append(special.charAt(r.nextInt(special.length())));
        for (int i = 4; i < length; i++) {
            sb.append(all.charAt(r.nextInt(all.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of passwords to analyze:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter password " + (i + 1) + ":");
            passwords[i] = sc.nextLine();
        }
        System.out.printf("%-15s %-8s %-8s %-8s %-8s %-8s %-8s %-10s\n",
                "Password", "Length", "Upper", "Lower", "Digits", "Special", "Score", "Strength");
        for (String pass : passwords) {
            int[] counts = analyzePassword(pass);
            int score = calculateScore(pass, counts);
            String strength = strengthLevel(score);
            System.out.printf("%-15s %-8d %-8d %-8d %-8d %-8d %-8d %-10s\n",
                    pass, pass.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
        }
        System.out.println("Generated Strong Password: " + generatePassword(12));
    }
}
