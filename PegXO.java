/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 1>
*/

import java.util.ArrayList;
import java.util.List;

public class PegXO {

    private static final int SIZE = 7;
    private static final char PEG = 'X';
    private static final char EMPTY = 'O';
    private char[][] board;
    private List<String> moves;

    // Constructor
    public PegXO() {
        this.board = new char[SIZE][SIZE];
        this.moves = new ArrayList<>();
        initializeBoard();
    }

    // Initialize the board with pegs and one empty space in the middle
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i < 2 || i > 4) && (j < 2 || j > 4)) {
                    this.board[i][j] = ' ';
                } else {
                    this.board[i][j] = PEG;
                }
            }
        }
        this.board[3][3] = EMPTY;
    }

    // Print the current state of the board
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // The recursive backtracking algorithm
    public boolean findSolution(int move) {
        if (isSolved()) {
            System.out.println("Final Board:");
            printBoard();
            return true;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == PEG) {
                    // Check all four directions
                    if (canJump(i, j, i, j + 1, i, j + 2)) {
                        makeMove(i, j, i, j + 2);
                        moves.add("Move " + move + ": (" + i + "," + j + ") -> (" + i + "," + (j + 2) + ")");
                        if (findSolution(move + 1)) return true;
                        undoMove(i, j, i, j + 2);
                        moves.remove(moves.size() - 1);
                    }
                    if (canJump(i, j, i, j - 1, i, j - 2)) {
                        makeMove(i, j, i, j - 2);
                        moves.add("Move " + move + ": (" + i + "," + j + ") -> (" + i + "," + (j - 2) + ")");
                        if (findSolution(move + 1)) return true;
                        undoMove(i, j, i, j - 2);
                        moves.remove(moves.size() - 1);
                    }
                    if (canJump(i, j, i + 1, j, i + 2, j)) {
                        makeMove(i, j, i + 2, j);
                        moves.add("Move " + move + ": (" + i + "," + j + ") -> (" + (i + 2) + "," + j + ")");
                        if (findSolution(move + 1)) return true;
                        undoMove(i, j, i + 2, j);
                        moves.remove(moves.size() - 1);
                    }
                    if (canJump(i, j, i - 1, j, i - 2, j)) {
                        makeMove(i, j, i - 2, j);
                        moves.add("Move " + move + ": (" + i + "," + j + ") -> (" + (i - 2) + "," + j + ")");
                        if (findSolution(move + 1)) return true;
                        undoMove(i, j, i - 2, j);
                        moves.remove(moves.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private boolean isSolved() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == PEG) {
                    count++;
                }
            }
        }
        return count == 1 && board[3][3] == PEG;
    }

    private boolean canJump(int fromX, int fromY, int overX, int overY, int toX, int toY) {
        if (toX < 0 || toX >= SIZE || toY < 0 || toY >= SIZE || board[fromX][fromY] != PEG || board[overX][overY] != PEG || board[toX][toY] != EMPTY) {
            return false;
        }
        return true;
    }

    private void makeMove(int fromX, int fromY, int toX, int toY) {
        board[fromX][fromY] = EMPTY;
        board[(fromX + toX) / 2][(fromY + toY) / 2] = EMPTY;
        board[toX][toY] = PEG;
    }

    private void undoMove(int fromX, int fromY, int toX, int toY) {
        board[fromX][fromY] = PEG;
        board[(fromX + toX) / 2][(fromY + toY) / 2] = PEG;
        board[toX][toY] = EMPTY;
    }

    public void printMoves() {
        System.out.println("List of Moves:");
        for (String move : moves) {
            System.out.println(move);
        }
    }

    public static void main(String[] args) {
        PegXO game = new PegXO();
        System.out.println("Initial Board:");
        game.printBoard();

        if (game.findSolution(1)) {
            game.printMoves();
        } else {
            System.out.println("No solution found.");
        }
    }
}
