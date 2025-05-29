package array;

import java.util.Arrays;

public class ZeroArrayChecker {

    // brute force approach
    public boolean isZeroArray1(int[] nums, int[][] queries) {
        int n=nums.length;
        int m= queries.length;
        for(int i=0; i<m; i++){
            int start=queries[i][0];
            int end=queries[i][1];

            while(start <= end){
                if(nums[start] !=0)
                    nums[start] -=1;
                start++;
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i] ==0) continue;
            else return false;
        }
        return true;
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int sum=0;
        int n=nums.length;
        int[]diff= new int[n+1];
        Arrays.fill(diff, 0);
        for(int[] q : queries){
            int l=q[0];
            int r=q[1];

            diff[l] +=1;
            diff[r+1] -=1;
        }

        for(int i=0; i<n; i++){
            sum +=diff[i];
            if(sum<nums[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        int[][] queries = {{1,3}, {0, 2}};
        ZeroArrayChecker zac = new ZeroArrayChecker();
        System.out.println(zac.isZeroArray(nums, queries));
    }
}
