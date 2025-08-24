import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Ask user for their full name (first and last name)
        System.out.print("Enter your full name (first and last): ");
        String fullName = scanner.nextLine();

        // 2. Ask user for their favorite programming language
        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        // 3. Ask user for a sentence about their programming experience
        System.out.print("Write a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        // ----------------- PROCESSING -----------------

        // Extract first and last name separately
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = (nameParts.length > 1) ? nameParts[1] : "";

        // Count total characters in the sentence (excluding spaces)
        String noSpaces = experience.replaceAll(" ", "");
        int charCount = noSpaces.length();

        // Convert programming language to uppercase
        String langUpper = language.toUpperCase();

        // Display a formatted summary
        System.out.println("\n----- SUMMARY -----");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + langUpper);
        System.out.println("Characters in Experience Sentence (excluding spaces): " + charCount);
        System.out.println("Your Experience: " + experience);

        scanner.close();
    }
}
