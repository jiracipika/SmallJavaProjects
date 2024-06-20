public class FibonacciPatterns {

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void printUp(int n) {
        if (n > 0) {
            printUp(n - 1);
            printLineOfStars(n);
        }
    }

    public static void printDown(int n) {
        if (n > 0) {
            printLineOfStars(n);
            printDown(n - 1);
        }
    }

    private static void printLineOfStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the value of n for Fibonacci: ");
        int n = scanner.nextInt();

        System.out.println("The " + n + "th Fibonacci number is: " + fib(n));

        System.out.print("Enter the number of rows for patterns: ");
        int rows = scanner.nextInt();

        System.out.println("\nPattern going up:");
        printUp(rows);

        System.out.println("\nPattern going down:");
        printDown(rows);

        scanner.close();
    }
}
