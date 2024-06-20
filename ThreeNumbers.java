import java.util.Scanner;

public class ThreeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double number3 = scanner.nextDouble();

        scanner.close();

        double maximum = Math.max(Math.max(number1, number2), number3);

        System.out.println("You entered the following numbers:");
        System.out.println("First number: " + number1);
        System.out.println("Second number: " + number2);
        System.out.println("Third number: " + number3);

        System.out.println("The maximum of the three numbers is: " + maximum);
    }
}
