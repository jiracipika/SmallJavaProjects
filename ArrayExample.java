import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); 
        }
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            System.out.println("Enter an index to display the array value (or type 'exit' to quit):");
            
            String userInput = scanner.next();
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                int index = Integer.parseInt(userInput);
                System.out.println("Element value at index " + index + ": " + numbers[index]);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index out of bounds. Please enter a number between 0 and 99.");
            }
        }
        
        // Close the scanner 
        scanner.close();
        System.out.println("Program terminated.");
    }
}
