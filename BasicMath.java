import java.util.Scanner;

public class BasicMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer value: ");
        int int1 = scanner.nextInt();

        System.out.print("Enter the second integer value: ");
        int int2 = scanner.nextInt();

        System.out.println("Sum of the values: " + (int1 + int2));
        System.out.println("Difference of the values: " + (int1 - int2));
        System.out.println("Product of the values: " + (int1 * int2));
        if (int2 != 0) {
            System.out.println("Quotient of the values: " + ((double) int1 / int2));
        } else {
            System.out.println("Division by zero is not allowed.");
        }

        System.out.print("\nEnter first doubl value: ");
        double double1 = scanner.nextDouble();

        System.out.print("Enter second double value: ");
        double double2 = scanner.nextDouble();

        scanner.close();

        System.out.println("Sum of the values: " + (double1 + double2));
        System.out.println("Difference of the values: " + (double1 - double2));
        System.out.println("Product of the values: " + (double1 * double2));
        if (double2 != 0) {
            System.out.println("Quotient of the values: " + (double1 / double2));
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }
}
