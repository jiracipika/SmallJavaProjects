import java.util.Scanner;

public class PyramidDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer from 1 to 15: ");
        int n = scanner.nextInt();

        // Validate input
        while (n < 1 || n > 15) {
            System.out.print("Invalid input. Please enter an integer from 1 to 15: ");
            n = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int spaces = 1; spaces <= n - i; spaces++) {
                System.out.print("  ");
            }

            // Print descending numbers
            for (int left = i; left >= 1; left--) {
                System.out.print(left + " ");
            }

            // Print ascending numbers
            for (int right = 2; right <= i; right++) {
                System.out.print(right + " ");
            }

            // Move to the next line for the next row
            System.out.println();
        }

        scanner.close();
    }
}
