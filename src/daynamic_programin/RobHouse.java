package daynamic_programin;

import java.util.Arrays;

public class RobHouse {
    //recursive + memoization approach
    public int rob(int[] nums) {
        int[] memo =new int [nums.length];
        Arrays.fill(memo, -1);
        return solve(nums, 0, memo);
    }
    public int solve(int[] nums, int index, int[] memo){
        if(index >= nums.length) return 0;
        if(memo[index] !=-1) return memo[index];
        int steal =nums[index] + solve(nums, index+2, memo);
        int skip = solve(nums, index+1, memo);
        return memo[index]=Math.max(steal, skip);
    };

    //Tabulation approach
    public int rob1(int[] nums) {
        int n =nums.length ;
        int t[] =new int[n+1];
        t[0] =0;
        t[1] =nums[0];
        for(int i =2; i<= n; i++){
            int steal=nums[i-1] + t[i-2];
            int skip=t[i-1];
            t[i] =Math.max(steal, skip);
        }
        return t[n];
    }
    public static void main(String[] args) {
        RobHouse rob = new RobHouse();
        int[] nums = {2,7,9,3,1};
        int result = rob.rob(nums);
        System.out.println("Result: " + result);
        int[] nums1 = {1,2,3,1};
        int result1 = rob.rob(nums1);
        System.out.println("Result: " + result1);
        int[] nums2 = {1,2,3,1,2,3,1};
        int result2 = rob.rob(nums2);
        System.out.println("Result: " + result2);
    }
}
