package daynamic_programin;

import java.util.Arrays;

public class UniquePaths {
    //TC: O(m*n)
    //SC: dp O(m*n) + recurtion O(m-1) + O(n-1) which is nothing but path size m-1 -> and n-1 ->0
    public int uniquePaths(int m, int n) {
        int memo[][] = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        //traveling form 0 to n cell
        // return solve(0, 0, m, n, memo);

        //traveling form 0 to n cell
        return solve(m - 1, n - 1, memo);
    }

    //traveling form 0 to n cell
    public int solve1(int i, int j, int m, int n, int[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }


        int right = solve1(i, j + 1, m, n, memo);
        int down = solve1(i + 1, j, m, n, memo);

        return memo[i][j] = right + down;
    }

    //traveling form n to 0 cell
    public int solve(int i, int j,int[][] memo) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int up = solve(i - 1, j, memo);
        int left = solve(i, j - 1, memo);

        return memo[i][j] = up + left;
    }

    //Tabulation approach
    public int uniquePaths1(int m, int n ){
        int[][] dp = new int[m][n];
        dp[0][0] =1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(i ==0 && j ==0){
                    dp[i][j]= 1;
                    continue;
                }
                int up=0;
                int left=0;

                if (i - 1 >= 0) up = dp[i - 1][j];
                if (j - 1 >= 0) left = dp[i][j - 1];

                dp[i][j] = up +left;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 3));
    }

}
