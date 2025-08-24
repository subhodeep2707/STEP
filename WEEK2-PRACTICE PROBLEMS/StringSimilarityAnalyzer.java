import java.util.Scanner;

public class StringSimilarityAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        System.out.println("Hamming Distance: " + hammingDistance(str1, str2));
        System.out.println("Levenshtein Distance: " + levenshteinDistance(str1, str2));
        System.out.println("Longest Common Substring: " + longestCommonSubstring(str1, str2));
        sc.close();
    }
    public static int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) if (s1.charAt(i) != s2.charAt(i)) dist++;
        return dist;
    }
    public static int levenshteinDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[m][n];
    }
    public static String longestCommonSubstring(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0, end = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s1.substring(end - maxLen, end);
    }
}
