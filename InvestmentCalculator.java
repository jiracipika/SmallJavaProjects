import java.util.Scanner;

public class InvestmentCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the initial investment value: ");
        double investment = scanner.nextDouble();
        
        System.out.println("Enter the interest rate (e.g., 0.05 for 5%): ");
        double interestRate = scanner.nextDouble();
        
        // Print the table headers
        System.out.printf("%-10s %-10s %-10s%n", "Year", "Interest", "Value");
        System.out.println("-------------------------------");
        
        for(int i = 1; i <= 5; i++) {
            double interest = investment * interestRate;
            investment += interest;
            
            System.out.printf("%-10d $%-9.2f $%-9.2f%n", i, interest, investment);
        }
        
        scanner.close();
    }
}
