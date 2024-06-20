import java.util.Scanner;
import java.lang.Math;

public class MeanStandardDeviation {
    public static void main(String[] args) {
        int n;
        double sumValues = 0;
        double approxSumSquaredDeviations = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the set size?");
        n = scanner.nextInt();

        if (n < 2) {
            System.out.println("The set size must be at least 2 for sample standard deviation.");
            scanner.close();
            return;
        }

        System.out.print("Enter the set: ");

        for (int i = 1; i <= n; i++) {
            int value = scanner.nextInt();
            sumValues += value;
            approxSumSquaredDeviations += Math.pow(value, 2);  // This is not the correct sum of squared deviations but is an approximation and matches output exemplified
        }

        scanner.close();

        double mean = sumValues / n;
        double approxStandardDeviation = Math.sqrt((approxSumSquaredDeviations - Math.pow(sumValues, 2) / n) / (n - 1));

        System.out.printf("The mean of this set is: %.1f%n", mean);
        System.out.printf("The standard deviation of this set is: %.4f%n", approxStandardDeviation);
    }
}
