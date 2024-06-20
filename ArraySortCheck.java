import java.util.Scanner;

public class ArraySortCheck {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Enter list of 10 integers:");

        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        if (isSorted(numbers)) {
            System.out.println("List is sorted!");
        } else {
            System.out.println("List is not sorted!");
        }

        scanner.close();
    }

    // Method to check if array of integers is sorted
    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
