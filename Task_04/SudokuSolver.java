import java.util.Scanner;

public class SudokuSolver {

    private static final int GRID_SIZE = 9; // Size of the Sudoku grid

    public static void main(String[] args) {
        int[][] board = new int[GRID_SIZE][GRID_SIZE];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Sudoku puzzle (use 0 for empty cells):");

        // Get user input for the Sudoku board
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                board[row][col] = scanner.nextInt();
            }
        }

        // Solve the Sudoku board
        if (solveBoard(board)) {
            System.out.println("Sudoku solved successfully!");
        } else {
            System.out.println("This Sudoku puzzle cannot be solved.");
        }

        // Print the solved board
        printBoard(board);
    }

    // Backtracking solver
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                // Look for an empty cell
                if (board[row][col] == 0) {
                    // Try all possible numbers from 1 to 9
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValidPlacement(board, num, row, col)) {
                            board[row][col] = num;

                            // Recursively attempt to solve the next cell
                            if (solveBoard(board)) {
                                return true;
                            } else {
                                // Backtrack if the current number doesn't work
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false; // No valid number found, need to backtrack
                }
            }
        }
        return true; // The board is solved if no empty cells are found
    }

    // Check if placing a number is valid
    private static boolean isValidPlacement(int[][] board, int num, int row, int col) {
        // Check if the number exists in the row
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check if the number exists in the column
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check if the number exists in the 3x3 subgrid
        int localRowStart = row - row % 3;
        int localColStart = col - col % 3;
        for (int i = localRowStart; i < localRowStart + 3; i++) {
            for (int j = localColStart; j < localColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // If no conflicts, placement is valid
    }

    // Print the Sudoku board
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------"); // Horizontal divider after each 3 rows
            }

            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|"); // Vertical divider after each 3 columns
                }

                System.out.print(board[row][col] == 0 ? "." : board[row][col]);
            }
            System.out.println();
        }
    }
}
