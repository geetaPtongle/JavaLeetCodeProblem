package daynamic_programin;

import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m =grid.length;
        int n =grid[0].length;

        // int result =Integer.MAX_VALUE;
        int memo[][] = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        //travlng form 0 to n cell
        return solve(m - 1, n - 1, memo, grid);

    }

    public int solve(int i, int j,int[][] memo, int [][] grid) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        int up =solve(i - 1, j, memo, grid);
        int left = solve(i, j - 1, memo, grid);


        int minUp = up != Integer.MAX_VALUE ? up + grid[i][j] : Integer.MAX_VALUE;
        int minLeft = left != Integer.MAX_VALUE ? left + grid[i][j] : Integer.MAX_VALUE;

        return memo[i][j] = Math.min(minUp , minLeft);
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0)
                        up = grid[i][j] + dp[i - 1][j];
                    if (j > 0)
                        left = grid[i][j] + dp[i][j - 1];
                    dp[i][j] = Math.min(up, left);
                }

            }
        }
        return dp[m - 1][n - 1];

    }
    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(mps.minPathSum(grid));
    }
}
