package daynamic_programin;

import java.util.ArrayList;
import java.util.List;

class GetWordsInLongestSubsequence {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       int n = 3;
       String[] words = {"e","a","b"};
       int[] groups = {0,0,1};
        GetWordsInLongestSubsequence ob = new GetWordsInLongestSubsequence();
        System.out.println(ob.getWordsInLongestSubsequence(n,words, groups));
    }
}
