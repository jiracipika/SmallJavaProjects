import java.util.Scanner;

public class Fractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt to enter numerator and denominator
        System.out.print("Enter a numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("Enter a denominator: ");
        int denominator = scanner.nextInt();

        // Close scanner
        scanner.close();

        // Check for 0 in the denominator
        if (denominator == 0) {
            System.out.println("The denominator cannot be zero.");
            return;
        }

        // Check if fraction is proper or improper
        if (Math.abs(numerator) < Math.abs(denominator)) {
            System.out.println(numerator + " / " + denominator + " is a proper fraction.");
        } else {
            // Calculate and print mixed fraction if necessary
            int wholePart = numerator / denominator;
            int remainingNumerator = Math.abs(numerator % denominator);

            if (remainingNumerator == 0) {
                System.out.println(numerator + " / " + denominator + " is an improper fraction and it can be reduced to " + wholePart);
            } else {
                // Reduce remaining fraction if possible
                int gcd = gcd(remainingNumerator, Math.abs(denominator));
                remainingNumerator /= gcd;
                int remainingDenominator = Math.abs(denominator) / gcd;

                System.out.println(numerator + " / " + denominator + " is an improper fraction and its mixed fraction is " + wholePart + " + " + remainingNumerator + " / " + remainingDenominator);
            }
        }
    }

    // Function to find greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
