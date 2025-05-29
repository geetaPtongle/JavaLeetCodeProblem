package hashtable;

import java.util.HashMap;

public class TwoSum {
    //Two pointer only wors with sorted arrays
    public int[] twoSumTowPointer(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1}; // 1-based indexing
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // num -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // 0-based index
            }

            map.put(nums[i], i);
        }

        return null;
    }
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[]{3,2,4}, 6);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
