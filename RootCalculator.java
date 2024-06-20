import java.util.Scanner;

/**
 * This program calculates the square root and cube root of five user inputed integers.
 * It prints the integers along with their square roots and cube roots in the format exmplified.
 */
public class RootCalculator {
    public static void main(String[] args) {
        // Input Section
        Scanner scanner = new Scanner(System.in);  // Initialize scanner for user input
        
        // Prompt user for input
        System.out.println("Enter five integers separated by a space"); 
        
        // Read five integers
        int num1 = scanner.nextInt();  
        int num2 = scanner.nextInt();  
        int num3 = scanner.nextInt();  
        int num4 = scanner.nextInt();  
        int num5 = scanner.nextInt();  
        
        // Processing Section
        // Calculate square root and cube root with Math.sqrt and Math.cbrt
        double sqrt1 = Math.sqrt(num1);
        double sqrt2 = Math.sqrt(num2);
        double sqrt3 = Math.sqrt(num3);
        double sqrt4 = Math.sqrt(num4);
        double sqrt5 = Math.sqrt(num5);
        
        double cbrt1 = Math.cbrt(num1);
        double cbrt2 = Math.cbrt(num2);
        double cbrt3 = Math.cbrt(num3);
        double cbrt4 = Math.cbrt(num4);
        double cbrt5 = Math.cbrt(num5);
        
        // Output Section
        // Print the table headers
        System.out.println("\nNumber\t\tSquare Roots\t\tCube Roots");
        
        // Display the integers and their square roots and cube roots
        System.out.printf("%d\t\t%.3f\t\t\t%.3f%n", num1, sqrt1, cbrt1);
        System.out.printf("%d\t\t%.3f\t\t\t%.3f%n", num2, sqrt2, cbrt2);
        System.out.printf("%d\t\t%.3f\t\t\t%.3f%n", num3, sqrt3, cbrt3);
        System.out.printf("%d\t\t%.3f\t\t\t%.3f%n", num4, sqrt4, cbrt4);
        System.out.printf("%d\t\t%.3f\t\t\t%.3f%n", num5, sqrt5, cbrt5);
        
        // Close scanner to free resources (garbage collector)
        scanner.close();
    }
}
