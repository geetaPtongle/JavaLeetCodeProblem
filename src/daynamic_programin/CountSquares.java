package daynamic_programin;

public class CountSquares {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int totalSquares = 0;

        // Fill the first row and first column of dp matrix
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            totalSquares += dp[i][0];
        }
        for (int j = 1; j < n; j++) { // start from j = 1 to avoid double count of (0,0)
            dp[0][j] = matrix[0][j];
            totalSquares += dp[0][j];
        }

        // Fill the rest of the dp matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                                  Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    totalSquares += dp[i][j];
                }
            }
        }

        return totalSquares;
    }

    // Main method to test
    public static void main(String[] args) {
        CountSquares sol = new CountSquares();

        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        int result = sol.countSquares(matrix);
        System.out.println("Total number of square submatrices with all 1s: " + result);
    }
}
