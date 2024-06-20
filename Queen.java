/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Lab 2>
*/

public class Queen {

    final int BOARD_SIZE = 4;

    // Prints the current board configuration
    void displayBoard(int board[][]) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Checks if it's safe to place a queen at board[row][col]
    boolean canPlaceQueen(int board[][], int row, int col) {
        // Check for queen in the same row on the left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < BOARD_SIZE; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve the problem using recursion and backtracking
    boolean placeQueens(int board[][], int col) {
        // Base case: If all queens are placed
        if (col >= BOARD_SIZE) {
            displayBoard(board);
            return true;
        }

        boolean foundSolution = false;
        // Try placing a queen in each row of this column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (canPlaceQueen(board, i, col)) {
                board[i][col] = 1; // Place a queen

                // Recur to place rest of the queens
                foundSolution = placeQueens(board, col + 1) || foundSolution;

                board[i][col] = 0; // Backtrack if placing queen here doesn't lead to a solution
            }
        }

        return foundSolution;
    }

    // Initializes the board and starts the queen placement process
    void solveFourQueens() {
        int board[][] = new int[BOARD_SIZE][BOARD_SIZE];

        if (!placeQueens(board, 0)) {
            System.out.println("No solutions exist");
        }
    }

    public static void main(String args[]) {
        Queen solver = new Queen();
        solver.solveFourQueens();
    }
}
