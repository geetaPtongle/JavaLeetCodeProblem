package array;

import java.util.Arrays;

public class BuildArray {

    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0; i<n;i++){
            ans[i] =nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        BuildArray ba=new BuildArray();
        int[] ans=ba.buildArray(new int[]{5,0,1,2,3,4});
        System.out.println(Arrays.toString(ans));
    }
}
