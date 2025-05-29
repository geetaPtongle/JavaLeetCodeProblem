package contest;

import java.util.*;

public class UniqueStartEndSubstring {

    public static void main(String[] args) {
        String input = "abcdeafdef";

        int count = countDistinctStartEndSubstrings(input);
        System.out.println("Output: " + count);
    }

    public static int countDistinctStartEndSubstrings(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        Map<Character, Integer> lastIndex = new HashMap<>();

        // Record first and last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            firstIndex.putIfAbsent(ch, i); // first occurrence
            lastIndex.put(ch, i);          // last occurrence (keeps updating)
        }

        Set<String> uniqueSubstrings = new HashSet<>();

        for (char ch : firstIndex.keySet()) {
            int start = firstIndex.get(ch);
            int end = lastIndex.get(ch);
            if (end > start) {
                String sub = s.substring(start, end + 1);
                uniqueSubstrings.add(sub);
            }
        }

        return uniqueSubstrings.size();
    }
}
