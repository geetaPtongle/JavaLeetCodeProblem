package daynamic_programin;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int memo[][] = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        //travlng form 0 to n cell
        return solve(m - 1, n - 1, memo, obstacleGrid);
    }

    public int solve(int i, int j,int[][] memo, int[][] obstacleGrid) {
        if (i < 0 || j < 0) return 0;

        // Obstacle in current cell
        if (obstacleGrid[i][j] == 1) return 0;

        // Start point
        if (i == 0 && j == 0) return 1;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int up = solve(i - 1, j, memo, obstacleGrid);
        int left = solve(i, j - 1, memo, obstacleGrid);

        return memo[i][j] = up + left;
    }
    public static void main(String[] args) {
        UniquePathsWithObstacles up = new UniquePathsWithObstacles();
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
    }
}
