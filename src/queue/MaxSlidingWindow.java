package queue;

import java.util.Arrays;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        MaxSlidingWindow ms = new MaxSlidingWindow();
        int[] result = ms.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
//    TC: O(n-k)*k = O(kn- k2) = O(n*k) k<<<n
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n= nums.length;
        int max = Integer.MIN_VALUE;
        int[] ans= new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            max=nums[i];
            for(int j=i; j<k+i; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }
            ans[i] = max;
        }
        return ans;
    }
}
