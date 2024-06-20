import java.util.Scanner;

public class Investment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = scanner.nextDouble();

        System.out.print("Enter monthly interest rate: ");
        double monthlyInterestRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        scanner.close();

        // Calculate future value using the given formula
        double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years);

        System.out.println("Future value is: $" + futureValue);
    }
}
