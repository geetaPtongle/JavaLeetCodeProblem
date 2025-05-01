package daynamic_programin;

import java.util.Arrays;

public class CountVowelStrings {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

//        public int countVowelStrings(int n) {
//            int ans = 0;
//            for (char ch : vowels) {
//                ans += solve(n - 1, ch);
//            }
//            return ans;
//        }
//
//        public int solve(int n, int last) {
//            if (n == 0) {
//                return 1;
//            }
//            int temp = 0;
//            for (char ch : vowels) {
//                if (last >= ch) {
//                    temp += solve(n - 1, ch);
//                }
//            }
//            return temp;
//        }

    public int countVowelStrings(int n) {
        // An array to represent the counts of vowel strings for each vowel ending
        // f[0] for 'a', f[1] for 'e', f[2] for 'i', f[3] for 'o', f[4] for 'u'
        int[] vowelCounts = {1, 1, 1, 1, 1};

        // Loop over the length n times, first length is already initialized, so we start from 0 to n-2
        for (int i = 0; i < n - 1; i++) {
            // A temporary variable to keep track of the cumulative sum
            int cumulativeSum = 0;
            // This loop calculates the new counts by adding up counts from all previous vowels
            for (int j = 0; j < 5; ++j) {
                // Update cumulative sum with the current vowel count
                cumulativeSum += vowelCounts[j];
                // Update the count for the current vowel with the new cumulative sum
                vowelCounts[j] = cumulativeSum;
            }
        }
        // Sum up all the counts and return the result
        return Arrays.stream(vowelCounts).sum();
    }

    public static void main(String[] args) {
        CountVowelStrings sol = new CountVowelStrings();
        System.out.println(sol.countVowelStrings(2)); // Example call
    }
}
