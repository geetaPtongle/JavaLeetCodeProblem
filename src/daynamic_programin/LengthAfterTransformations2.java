package daynamic_programin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthAfterTransformations2 {
    final int mod = 1_000_000_007;
    public int lengthAfterTransformations1(String s, int t, List<Integer> nums) {
        for (int i = 0; i < t; i++) {
            StringBuilder new_s = new StringBuilder();
            for (char c : s.toCharArray()) {
                int count = nums.get(c - 'a');
                for (int j = 1; j <= count; j++) {
                    //c - 'a': Converts the character c to its 0-based index in the alphabet.
                    //
                    //Example: 'a' - 'a' = 0, 'b' - 'a' = 1, ..., 'z' - 'a' = 25
                    //
                    //+ j: Shift the character forward by j positions.
                    //
                    //% 26: Wrap around the alphabet (so after 'z', it goes back to 'a').
                    //
                    //+ 'a': Converts the 0-based index back to a character.
                    char next_char = (char)((c - 'a' + j) % 26 + 'a');
                    new_s.append(next_char);
                }
            }
            s = new_s.toString();
        }
        return  s.length() % mod;
    }

    static final int SIZE = 26;
    static final long MOD = 1_000_000_007;

    public long lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] T = new long[SIZE][SIZE];

        // Build transition matrix
        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                T[i][(i + j) % SIZE]++;
            }
        }

        // Matrix exponentiation
        long[][] T_exp = matrixPower(T, t);

        // Frequency array
        long[] freq = new long[SIZE];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Multiply frequency with T_exp
        long total = 0;
        for (int j = 0; j < SIZE; j++) {
            long sum = 0;
            for (int i = 0; i < SIZE; i++) {
                sum = (sum + freq[i] * T_exp[i][j]) % MOD;
            }
            total = (total + sum) % MOD;
        }

        return total;
    }

    // Matrix exponentiation
    private long[][] matrixPower(long[][] matrix, int power) {
        long[][] result = new long[SIZE][SIZE];

        // Initialize result as identity matrix
        for (int i = 0; i < SIZE; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrix(result, matrix);
            }
            matrix = multiplyMatrix(matrix, matrix);
            power >>= 1;
        }

        return result;
    }

    // Multiply two matrices
    private long[][] multiplyMatrix(long[][] A, long[][] B) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    res[i][j] = (res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LengthAfterTransformations2 l = new LengthAfterTransformations2();
        String s = "abcyy";
        int t = 2;
        List<Integer> nums = new ArrayList<>(Arrays.asList(
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2
        ));
        System.out.println(l.lengthAfterTransformations(s, t, nums));

    }
}
