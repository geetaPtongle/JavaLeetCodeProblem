package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CountPairs {
    public static int countPairs(List<Integer> nums, int target) {
        // Create a mutable list by converting the immutable list to an ArrayList
        List<Integer> numsList = new ArrayList<>(nums);

        // Sort the list to use two-pointer technique
        Collections.sort(numsList);

        int count = 0;
        int left = 0;
        int right = numsList.size() - 1;

        // Use two pointers to find the valid pairs
        while (left < right) {
            if (numsList.get(left) + numsList.get(right) < target) {
                // If sum is less than target, count all valid pairs between left and right
//                for (int i = left + 1; i <= right; i++) {
//                    count++; // Increment count for each valid pair
//                }
                count += (right - left);
                left++; // Move left pointer to the right
            } else {
                // If sum is >= target, move right pointer to the left
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(-6,2,5,-2,-7,-1,3); // Immutable list
        int target = -2;
        System.out.println(countPairs(nums, target));  // Output should be the count of valid pairs
    }
}
