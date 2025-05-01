package daynamic_programin;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> mp = new HashMap<>();

    public int twoEggDrop(int n) {
        return findFloor(2, n);
    }

    public int findFloor(int k, int n) {
        if (n == 1)
            return 1;
        if (n < 1)
            return 0;
        if (k == 1)
            return n;

        String temp = findString(k, n);
        if (mp.containsKey(temp))
            return mp.get(temp);

        int minSteps = Integer.MAX_VALUE;
        for (int ite = 1; ite <= n; ite++) {
            // 2 options
            int op1 = findFloor(k - 1, ite - 1);
            int op2 = findFloor(k, n - ite);
            int steps = 1 + Math.max(op1, op2);
            minSteps = Math.min(minSteps, steps);
        }

        mp.put(temp, minSteps);
        return minSteps;
    }

    public String findString(int k, int i) {
        return k + " " + i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4; // Example test case
        System.out.println(sol.twoEggDrop(n));
    }
}
