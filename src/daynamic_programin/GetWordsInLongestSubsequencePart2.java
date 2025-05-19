package daynamic_programin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetWordsInLongestSubsequencePart2 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp   = new int[n];
        int[] prev = new int[n];

        // 1) Initialize
        Arrays.fill(dp,   1);   // every word can at least form length-1 subsequence
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        // 2) Build dp[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ( check(words[i], words[j])     // differ by exactly one char
                        && groups[i] != groups[j]        // different group
                        && dp[j] + 1 > dp[i] ) {         // improves the length

                    dp[i]   = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // 3) Reconstruct the longest subsequence
        List<String> result = new ArrayList<>();
        for (int at = maxIndex; at != -1; at = prev[at]) {
            result.add(words[at]);
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 1) return false;
            }
        }
        return diff == 1;  // exactly one character must differ
    }
    public static void main(String[] args) {
        GetWordsInLongestSubsequencePart2 gwlsp = new GetWordsInLongestSubsequencePart2();
        String[] words = {"bab","dab","cab"};
        int[] groups = {1, 2, 2};
        System.out.println(gwlsp.getWordsInLongestSubsequence(words, groups));
    }
}
