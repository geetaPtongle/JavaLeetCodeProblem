package array;

import java.util.Arrays;

public class BitwiseOrAdcent {
    public static void main(String[] args) {
        int nums[] ={1,3,7,15};
        BitwiseOrAdcent b = new BitwiseOrAdcent();
        int[] ans = b.orArray(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    public int[] orArray(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            answer[i] = nums[i] | nums[i + 1];
        }
        return answer;
    }
}
