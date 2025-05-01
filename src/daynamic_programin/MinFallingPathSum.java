package daynamic_programin;

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] dp = new int[m][m];

        for (int col = 0; col < m; col++) {
            dp[0][col] = matrix[0][col];
        }
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < m; col++) {

                int top = dp[row - 1][col];
                int left = (col > 0) ? dp[row - 1][col - 1] : Integer.MAX_VALUE;
                int right = (col < m - 1) ? dp[row - 1][col + 1] : Integer.MAX_VALUE;


                dp[row][col] = matrix[row][col] + Math.min(top, Math.min(left, right));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < m; col++) {
            min = Math.min(min, dp[m - 1][col]);
        }
        return min;
    }
    public static void main(String[] args) {
        MinFallingPathSum mfp = new MinFallingPathSum();
        System.out.println(mfp.minFallingPathSum1(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }

    int[][] memo;
    int m;
    int n;
    public int minFallingPathSum1(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        memo = new int[101][101];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int minValue = Integer.MAX_VALUE;
        int row = 0;
        for (int col = 0; col < n; col++) {
            minValue = Math.min(minValue, solve(matrix, row, col));
        }
        return minValue;
    }

    public int solve(int[][] matrix, int row, int col) {
        if (row == m - 1) {
            return matrix[row][col];
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        int minSum = Integer.MAX_VALUE;
        int sum = matrix[row][col];

        if (row + 1 < n && col - 1 >= 0)
            minSum = Math.min(minSum, sum + solve(matrix, row + 1, col - 1));

        minSum = Math.min(minSum, sum + solve(matrix, row + 1, col));

        if (row + 1 < n && col + 1 < n)
            minSum = Math.min(minSum, sum + solve(matrix, row + 1, col + 1));

        memo[row][col] = minSum;

        return minSum;
    }
}
