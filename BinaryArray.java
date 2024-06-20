import java.util.Random;
import java.util.Scanner;

public class BinaryArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];
        Random random = new Random();

        scanner.close();
        
        // Fill array and count zeros and ones
        int[] rowZeros = new int[rows];
        int[] rowOnes = new int[rows];
        int[] colZeros = new int[cols];
        int[] colOnes = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(2);
                if (array[i][j] == 0) {
                    rowZeros[i]++;
                    colZeros[j]++;
                } else {
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }

        // Report count of zeros and ones in each row
        for (int i = 0; i < rows; i++) {
            System.out.println("The number of 1's in row " + (i + 1) + " is " + rowOnes[i]);
            System.out.println("The number of 0's in row " + (i + 1) + " is " + rowZeros[i]);
        }

        // Report count of zeros and ones in each column
        for (int j = 0; j < cols; j++) {
            System.out.println("The number of 1's in column " + (j + 1) + " is " + colOnes[j]);
            System.out.println("The number of 0's in column " + (j + 1) + " is " + colZeros[j]);
        }

        // Print array
        System.out.println("The array is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
