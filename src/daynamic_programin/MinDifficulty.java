package daynamic_programin;

import java.util.Arrays;

class MinDifficulty {
    private int[][] t;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d)
            return -1;

        t = new int[n][d + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(jobDifficulty, n, 0, d);
    }

    public int solve(int[] jobDifficulty, int n, int index, int d) {

        if (d == 1) {
            int maxD = jobDifficulty[index];
            for (int i = index; i < n; i++) {
                maxD = Math.max(maxD, jobDifficulty[i]);
            }
            return maxD;
        }

        if (t[index][d] != -1)
            return t[index][d];

        int maxDifficulty = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = index; i <= n - d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            result = Math.min(result, maxDifficulty + solve(jobDifficulty, n, i + 1, d - 1));
        }

        return t[index][d] = result;
    }
    public static void main(String[] args) {
        MinDifficulty md = new MinDifficulty();
        System.out.println(md.minDifficulty(new int[]{6,5,4,3,2,1}, 2));
    }
}