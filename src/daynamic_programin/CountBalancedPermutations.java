package daynamic_programin;

import java.util.Arrays;

public class CountBalancedPermutations {
    public int countBalancedPermutations(String num) {
        char[] chars = num.toCharArray();
        Arrays.sort(chars); // sort to start from the smallest permutation

        int count = 0;
        do {
            int evenSum = 0;
            int oddSum = 0;

            for (int i = 0; i < chars.length; i++) {
                int digit = chars[i] - '0'; // convert char to int

                if (i % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }

            if (evenSum == oddSum) {
                count++;
            }
        } while (nextPermutation(chars));

        return count;
    }

    // Helper method to generate the next lexicographical permutation
    private boolean nextPermutation(char[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i < 0) return false;

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) j--;

        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
        return true;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(char[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        CountBalancedPermutations solution = new CountBalancedPermutations();
        String num = "123";
        System.out.println(solution.countBalancedPermutations(num)); // Output: depends on permutations
    }
}
