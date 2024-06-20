import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FutureInvestmentCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        
        double investmentAmount = 0.0;
        double annualInterestRate = 0.0;
        int numberOfYears = 0;
        
        // Input: Investment Amount
        while (true) {
            try {
                System.out.print("Enter investment amount: ");
                investmentAmount = input.nextDouble();
                
                if (investmentAmount <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
        
        // Input: Annual Interest Rate
        while (true) {
            try {
                System.out.print("Enter annual interest rate: ");
                annualInterestRate = input.nextDouble();
                
                if (annualInterestRate <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
        
        // Input: Number of Years
        while (true) {
            try {
                System.out.print("Enter number of years: ");
                numberOfYears = input.nextInt();
                
                if (numberOfYears <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
        
        // Calculating Future Investment Value
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);
        
        // Output
        System.out.println("Accumulated value is " + df.format(futureInvestmentValue));
        
        // Close the Scanner
        input.close();
    }
}
