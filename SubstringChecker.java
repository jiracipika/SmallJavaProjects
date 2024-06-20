import java.util.Scanner;

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt to enter the first String
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();
        
        // Prompt to enter the second String
        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();
        
        // Check if secondString is a substring of firstString
        String result = firstString.contains(secondString) ? "is a substring of" : "is not a substring of";
        
        // Print the result
        System.out.println(secondString + " " + result + " " + firstString + ".");
        
        scanner.close();
    }
}
