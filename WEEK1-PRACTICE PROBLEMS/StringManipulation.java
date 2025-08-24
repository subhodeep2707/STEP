import java.util.*;
public class StringManipulation {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = new String("Java Programming");
        char[] charArray = {'J','a','v','a',' ','P','r','o','g','r','a','m','m','i','n','g'};
        String str3 = new String(charArray);
        
        System.out.println("String 1 (literal): " + str1);
        System.out.println("String 2 (constructor): " + str2);
        System.out.println("String 3 (char array): " + str3);

       
        System.out.println("\nComparisons using == :");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str2 == str3: " + (str2 == str3));

      
        System.out.println("\nComparisons using .equals() :");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str2.equals(str3): " + str2.equals(str3));

        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);
    }
}
