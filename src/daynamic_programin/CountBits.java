package daynamic_programin;

import java.util.Arrays;

class CountBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0; // Base case

        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i + ", i >> 1 = " + (i >> 1) + ", (i & 1) = " + (i & 1));
            ans[i] = ans[i >> 1] + (i & 1);

        }

        return ans;
    }
    public static void main(String[] args) {
        CountBits cb = new CountBits();
        int[] result = cb.countBits(5);
        System.out.println("Result: " + Arrays.toString(result));
    }
}
