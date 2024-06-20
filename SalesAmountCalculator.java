import java.util.Scanner;

public class SalesAmountCalculator {
    public static void main(String[] args) {
        // Create a Scanner to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the sales commission
        System.out.println("Enter the sales Commission");
        double commission = scanner.nextDouble();

        // Close the scanner to release resources
        scanner.close();

        // Declare and initialize sales and remaining commission
        double salesAmount = 0.0;
        double remainingCommission = commission;

        /*
         * Calculate sales amount needed to earn given commission.
         * We work backwards through the commission tiers.
         */
        
        // For commissions from sales over 10,000
        if (remainingCommission > 1200) {
            salesAmount += (remainingCommission - 1200) / 0.12;
            remainingCommission = 1200;
        }

        // For commissions from sales between 5001 and 10,000
        if (remainingCommission > 500) {
            salesAmount += (remainingCommission - 500) / 0.10;
            remainingCommission = 500;
        }

        // For commissions from sales between 1 and 5000
        if (remainingCommission > 0) {
            salesAmount += remainingCommission / 0.08;
        }

        // Output calculated sales amount
        System.out.printf("The sales amount $%.2f is needed to make a commission of $%.2f%n", salesAmount, commission);
    }
}
