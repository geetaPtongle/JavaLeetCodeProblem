package greedy;

import java.util.HashMap;
import java.util.Map;

public class PalindromeLength {
    public static int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        int len = 0;
        boolean centre = false;

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();
            String rev = new StringBuilder(word).reverse().toString();

            if (word.equals(rev)) { // self-palindromic
                int pairs = freq / 2;
                len += pairs * 4;
                if (freq % 2 == 1) {
                    centre = true;
                }
            } else if (count.containsKey(rev)) {
                int pairs = Math.min(freq, count.get(rev));
                len += pairs * 4;
                count.put(rev, 0);
                count.put(word, 0);
            }
        }

        if (centre) {
            len += 2;
        }

        return len;
    }

    public static void main(String[] args) {
        String[] words = {"ab", "ty", "yt", "lc", "cl", "ab", "gg"};
        System.out.println(longestPalindrome(words)); // Example usage
    }
}