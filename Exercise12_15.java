import java.io.*;
import java.util.*;

public class Exercise12_15 {
    public static void main(String[] args) {
        String filename = "Exercise 12_15.txt";

        // Write
        try (PrintWriter writer = new PrintWriter(filename)) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                writer.print(random.nextInt(100) + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to create file.");
            e.printStackTrace();
        }

        // Read
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to read file.");
            e.printStackTrace();
        }

        // Sort 
        Collections.sort(numbers);

        // Display 
        System.out.println("Original numbers:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n\nSorted numbers:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
