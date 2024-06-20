import java.util.*;

public class SquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of columns in a square matrix:");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        Random random = new Random();
        
        // Fill the matrix with random values and print them in a grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(1000) + 1;
                System.out.print(matrix[i][j] + "\t"); // Print value and tab
            }
            System.out.println(); // Print a new line at the end of each row
        }

        scanner.close();

        System.out.println("The average of all values in the matrix is: " + average(matrix));
        System.out.println("The sum of all values in the matrix is: " + sum(matrix));
        System.out.println("The largest value in the matrix is: " + max(matrix));
        System.out.println("The smallest value in the matrix is: " + min(matrix));
        System.out.println("The mode of the matrix is: " + mode(matrix));
    }

    public static double average(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
                count++;
            }
        }
        return (double) sum / count;
    }

    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    public static int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int val : row) {
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }

    public static int min(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < min) {
                    min = val;
                }
            }
        }
        return min;
    }

    public static int mode(int[][] matrix) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int[] row : matrix) {
            for (int val : row) {
                frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
            }
        }
        int mode = -1;
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                mode = key;
            }
        }
        return mode;
    }
}
