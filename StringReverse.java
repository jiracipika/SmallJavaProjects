import java.util.Scanner;

public class StringReverse {

    
    public static String reverse(String str) {
        // When the string has one character or less
        if (str == null || str.length() <= 1) {
            return str;
        }
        // Last character of string plus reverse of the rest of the string
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt user input
        System.out.print("Enter a string you want to reverse: ");
        String input = scanner.nextLine();
        // Output
        String reversed = reverse(input);
        System.out.println("The Reversed string is: " + reversed);

        scanner.close();
    }
}
