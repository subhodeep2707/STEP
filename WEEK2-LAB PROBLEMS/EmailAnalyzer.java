import java.util.Scanner;

public class EmailAnalyzer {

    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return at > 0 && at == lastAt && dot > at + 1 && dot < email.length() - 1;
    }

    public static void analyzeEmails(String[] emails) {
        int valid = 0;
        int totalUsernameLength = 0;

        System.out.println("\nEmail\t\tUsername\tDomain\tValid");
        for (int i = 0; i < emails.length; i++) {
            boolean isValid = isValidEmail(emails[i]);
            String username = "-";
            String domain = "-";

            if (isValid) {
                int at = emails[i].indexOf('@');
                username = emails[i].substring(0, at);
                domain = emails[i].substring(at + 1);
                valid++;
                totalUsernameLength += username.length();
            }

            System.out.println(emails[i] + "\t" + username + "\t" + domain + "\t" + (isValid ? "Yes" : "No"));
        }

        System.out.println("\nValid: " + valid + ", Invalid: " + (emails.length - valid));
        System.out.println("Average username length: " + (valid > 0 ? (totalUsernameLength / valid) : 0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of emails: ");
            int n = sc.nextInt();
            sc.nextLine();
            String[] emails = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter email " + (i + 1) + ": ");
                emails[i] = sc.nextLine();
            }
            analyzeEmails(emails);
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
        sc.close();
    }
}
