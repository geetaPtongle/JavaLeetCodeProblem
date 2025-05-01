package sorting;

import java.util.*;

public class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int leftBound = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int rightBound = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (rightBound - leftBound + 1);
        }
        return count;
    }

    // First index where nums[index] >= target
    private int lowerBound(int[] nums, int left, int right, int target) {
        int res = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    // Last index where nums[index] <= target
    private int upperBound(int[] nums, int left, int right, int target) {
        int res = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountFairPairs obj = new CountFairPairs();
        int[] nums = {1, 3, 5, 7};
        int lower = 8, upper = 12;
        System.out.println(obj.countFairPairs(nums, lower, upper));  // Output: 3
    }
}
