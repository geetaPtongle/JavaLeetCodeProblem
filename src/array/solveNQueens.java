package array;

import java.util.ArrayList;
import java.util.List;

class solveNQueens {

    private boolean isSafe(int row, int col, int n, char[][] board) {
        // Check the column for any queen
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the top-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the top-right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solve(int row, int n, char[][] board, List<List<String>> result) {
        // If all queens are placed, add the board configuration to the result
        if (row == n) {
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String curr = ""; // Initialize an empty string for the current row
                for (int j = 0; j < board[i].length; j++) {
                    curr += board[i][j]; // Append each character in the row to the string
                }
                currentBoard.add(curr); // Add the constructed row to the list
            }
            result.add(currentBoard);
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q'; // Place queen
                solve(row + 1, n, board, result); // Recur for the next row
                board[row][col] = '.'; // Backtrack and remove the queen
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start solving from the first row
        solve(0, n, board, result);

        return result;
    }

    public static void main(String[] args) {
        solveNQueens solveNQueens = new solveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}