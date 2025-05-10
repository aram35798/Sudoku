
import java.util.Scanner;

public class SudokuGame {

    // 9x9 Sudoku board (0 = empty cell)
    static int[][] board = {
        //(Easy difficulty level)
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Main loop runs until the board is completely filled
        while (!isBoardFull()) {
            printBoard();
            //Input handling with basic validation
            System.out.print("Enter row (1-9): ");
            int row = scanner.nextInt() - 1;

            System.out.print("Enter column (1-9): ");
            int col = scanner.nextInt() - 1;

            System.out.print("Enter number (1-9): ");
            int num = scanner.nextInt();

            if (board[row][col] != 0) {
                System.out.println("Cell already filled. Try again.");
            } else if (isValidMove(row, col, num)) {
                board[row][col] = num;
                System.out.println("Move accepted!");
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard();
        System.out.println("Congratulations! You filled the board.");
        scanner.close();
    }

    // Print the current board state
    public static void printBoard() {
        System.out.println("\nCurrent Sudoku Board:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------+-----------+-----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                //clean format
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    // Check if placing Number at board[row][col] is valid
    public static boolean isValidMove(int row, int col, int num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // everything passed
    }

    // Check if the board is completely filled
    public static boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
