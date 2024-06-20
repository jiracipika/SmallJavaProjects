import java.util.Scanner;

public class CommissionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the sales amount
        System.out.println("Enter sales amount:");
        double salesAmount = scanner.nextDouble();

        // Initialize commission variable
        double commission = 0;

        //Close scanner to free resources
        scanner.close();

        // Calculate commission based on sales amount
        if (salesAmount >= 1 && salesAmount <= 5000) {
            commission = salesAmount * 0.08;  // 8%
        } else if (salesAmount > 5000 && salesAmount <= 10000) {
            commission = 5000 * 0.08 + (salesAmount - 5000) * 0.10;  // 10%
        } else if (salesAmount > 10000) {
            commission = 5000 * 0.08 + 5000 * 0.10 + (salesAmount - 10000) * 0.12;  // 12%
        } else {
            System.out.println("Invalid sales amount.");
            return;
        }

        // Display the calculated commission
        System.out.printf("The commission is %.2f for sales amount of %.2f%n", commission, salesAmount);
    }
}
