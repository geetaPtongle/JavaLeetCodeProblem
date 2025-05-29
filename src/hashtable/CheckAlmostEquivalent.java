package hashtable;

public class CheckAlmostEquivalent {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq[word1.charAt(i) - 'a']++;
            freq[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(freq[i]) > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckAlmostEquivalent sol = new CheckAlmostEquivalent();
        // Sample test cases
        String word1 = "abcde";
        String word2 = "bbcde";
        System.out.println("Are the words almost equivalent? " + sol.checkAlmostEquivalent(word1, word2)); // true

        word1 = "aabbcc";
        word2 = "abbbcc";
        System.out.println("Are the words almost equivalent? " + sol.checkAlmostEquivalent(word1, word2)); // true

        word1 = "aaaab";
        word2 = "bbbbb";
        System.out.println("Are the words almost equivalent? " + sol.checkAlmostEquivalent(word1, word2)); // false
    }
}
