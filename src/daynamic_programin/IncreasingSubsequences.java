package daynamic_programin;

import java.util.*;

public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() > 1) {
            result.add(new ArrayList<>(curr));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];

            if (used.contains(num)) {
                continue;
            }
            if ((curr.isEmpty() || num >= curr.get(curr.size() - 1)) ) {
                used.add(num);
                curr.add(num);
                backtrack(nums, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences obj = new IncreasingSubsequences();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> result = obj.findSubsequences(nums);
        for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }
}
