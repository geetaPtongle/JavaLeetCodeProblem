package array;

import java.util.Arrays;

public class CountSubArrays {
    public long countSubarrays(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;
        int i = 0, j = 0;

        long result = 0;
        int countMax = 0;

        while (j < n) {
            if (nums[j] == maxE) {
                countMax++;
            }

            while (countMax >= k) {
                result += n - j;

                if (nums[i] == maxE) {
                    countMax--;
                }
                i++;
            }
            j++;
        }

        return result;
    }
public static void main(String[] args) {
        CountSubArrays countSubArrays = new CountSubArrays();
        int[] nums = {1,3,2,3,3};
        System.out.println(countSubArrays.countSubarrays(nums, 2));
}
}
