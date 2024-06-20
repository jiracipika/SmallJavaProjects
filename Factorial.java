/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Final Exam: Question 9
Any and all work in this file is my own.
*/ 

public class Factorial {

    // Iterative method
    public static int factorialIterative(int n) {
        // Initialize the result as 1
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Factorial of 5 is " + factorialIterative(5));

        System.out.println("Factorial of 7 is " + factorialIterative(7));
    }
}
