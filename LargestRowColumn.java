import java.util.*;

public class LargestRowColumn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the array size n: ");
        int n = 0;

        // Ensure input is an integer
        if (input.hasNextInt()) {
            n = input.nextInt();
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        // Create matrix with random 0s and 1s
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        // Print matrix
        System.out.println("The random array is");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Find and print rows with the most 1s
        ArrayList<Integer> largestRowIndices = getLargestRowIndices(matrix);
        System.out.print("The largest row index: ");
        for (int index : largestRowIndices) {
            System.out.print(index + " ");
        }
        System.out.println();

        // Find and print columns with the most 1s
        ArrayList<Integer> largestColumnIndices = getLargestColumnIndices(matrix);
        System.out.print("The largest column index: ");
        for (int index : largestColumnIndices) {
            System.out.print(index + " ");
        }
        System.out.println();

        input.close();
    }
    

    // Method to find rows with the most 1s
    private static ArrayList<Integer> getLargestRowIndices(int[][] matrix) {
        int maxRowOnes = 0;
        ArrayList<Integer> rowIndex = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int rowOnes = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowOnes += matrix[i][j];
            }
            if (rowOnes > maxRowOnes) {
                maxRowOnes = rowOnes;
                rowIndex.clear();
                rowIndex.add(i);
            } else if (rowOnes == maxRowOnes) {
                rowIndex.add(i);
            }
        }
        return rowIndex;
    }

    // Method to find columns with the most 1s
    private static ArrayList<Integer> getLargestColumnIndices(int[][] matrix) {
        int maxColumnOnes = 0;
        ArrayList<Integer> columnIndex = new ArrayList<>();

        for (int j = 0; j < matrix[0].length; j++) {
            int columnOnes = 0;
            for (int[] ints : matrix) {
                columnOnes += ints[j];
            }
            if (columnOnes > maxColumnOnes) {
                maxColumnOnes = columnOnes;
                columnIndex.clear();
                columnIndex.add(j);
            } else if (columnOnes == maxColumnOnes) {
                columnIndex.add(j);
            }
        }
        return columnIndex;
    }
}
