package daynamic_programin;

import java.util.*;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> result = new ArrayList<>();
        partition(0, input, new ArrayList<>(), result);

        // Print the result
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }

    public static void partition(int index, String s, List<String> path, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partition(i + 1, s, path, ans);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
