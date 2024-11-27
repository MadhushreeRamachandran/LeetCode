import java.util.Scanner;

public class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
      
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter the Sudoku board row by row:");
        System.out.println("Use '.' for empty cells and digits (1-9) for filled cells.");

        // Take input for the board
        for (int i = 0; i < 9; i++) {
            String row;
            do {
                System.out.printf("Row %d (9 characters): ", i + 1);
                row = scanner.nextLine();
            } while (row.length() != 9); // Ensure 9 characters for each row

            board[i] = row.toCharArray();
        }

        Solution solver = new Solution();
        solver.solveSudoku(board);

        System.out.println("\nSolved Sudoku board:");
        // Print solved board
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
