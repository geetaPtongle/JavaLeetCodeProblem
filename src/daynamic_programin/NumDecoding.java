package daynamic_programin;

import java.util.Arrays;

public class NumDecoding {
    int[] dp;
    int[] memo;

    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[101];
        Arrays.fill(memo, -1);
//       return tabulation(s);
//       return otherWaysToSolve(0, s, n); //using recursion
//       return otherWaysToSolveWithMemo(0, s, n); //using recursion + memo
        return otherWaysOftabulation(s, n);

    }

    public int otherWaysOftabulation(String s, int n) {
        int[] t = new int[n + 1];
        ////t[i] = ways to decode string from index i to n
        Arrays.fill(t, 0);
        t[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                return 0;
            } else {
                t[i] = t[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    t[i] += t[i + 2];
                }
            }
        }
        return t[0];
    }

    public int otherWaysToSolve(int index, String s, int n) {

        if (index == n) return 1;
        if (s.charAt(index) == '0') return 0;

        int result = otherWaysToSolve(index + 1, s, n);
        if (index + 1 < n) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit <= 26) {
//        if(s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <='6'){
                result += otherWaysToSolve(index + 2, s, n);
            }
        }
        return result;

    }

    public int otherWaysToSolveWithMemo(int index, String s, int n) {
        if (memo[index] != -1) {
            return memo[index];
        }
        if (index == n) {
            return memo[index] = 1;
        }
        if (s.charAt(index) == '0') {
            return memo[index] = 0;
        }

        int result = otherWaysToSolveWithMemo(index + 1, s, n);

        if (index + 1 < n) {
            if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
                result += otherWaysToSolveWithMemo(index + 2, s, n);
            }
        }
        return memo[index] = result;
    }

    private int tabulation(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        dp = new int[n + 1];

        dp[0] = 1;  // Base case for empty string
        dp[1] = 1;
        ;  // Base case for the first character

        for (int i = 2; i <= n; i++) {
            char chi = s.charAt(i - 1);
            char chim1 = s.charAt(i - 2);
            String st = s.substring(i - 2, i);

            if (chi != '0') {
                dp[i] = dp[i - 1];
            }

            if (chim1 != '0' && Integer.parseInt(st) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        NumDecoding sol = new NumDecoding();
        System.out.println(sol.numDecodings("2326"));
    }

    public int solve(int index, String s) {
        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != -1)
            return memo[index];

        int pick1 = solve(index + 1, s);

        int pick2 = 0;

        if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            pick2 = solve(index + 2, s);
        }

        memo[index] = pick1 + pick2;

        return memo[index];
    }


}
