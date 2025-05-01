package daynamic_programin;

import java.util.Arrays;

class MaxScoreWords {
    int maxScore = Integer.MIN_VALUE;
    int n;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        n = words.length;
        
        // Calculate frequency of letters
        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        
        // Start the recursion
        solve(0, score, words, 0, freq);
        return maxScore;
    }

    public void solve(int idx, int[] score, String[] words, int currScore, int[] freq) {
        maxScore = Math.max(maxScore, currScore);
        if (idx >= n)
            return;

        int i = 0;
        int tempScore = 0;
        int[] tempFreq = Arrays.copyOf(freq, freq.length);

        while (i < words[idx].length()) {
            char ch = words[idx].charAt(i);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            i++;
        }

        if (i == words[idx].length())
            solve(idx + 1, score, words, currScore + tempScore, tempFreq);

        solve(idx + 1, score, words, currScore, freq);
    }

    public static void main(String[] args) {
        MaxScoreWords solution = new MaxScoreWords();
        
        // Example test case
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // Calling the maxScoreWords method
        int result = solution.maxScoreWords(words, letters, score);
        
        // Print the result
        System.out.println("Maximum Score: " + result);
    }
}
