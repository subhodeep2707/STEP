import java.util.Scanner;

public class CharFrequencyNested {
    public static void frequency(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            freq[i] = 1;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0';
                }
            }
        }

        System.out.println("Character Frequencies:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0' && arr[i] != ' ') {
                System.out.println(arr[i] + " : " + freq[i]);
            }
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