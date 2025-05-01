package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public static int getLagest(int number[]){
        int largest= Integer.MIN_VALUE;
        int smalllest = Integer.MAX_VALUE;
        for(int i=0;i<number.length;i++){
            if(number[i] > largest){
                largest =number[i];
            }
            if(number[i] < smalllest){
                smalllest = number[i];
            }
        }
        System.out.println("print smallest number: " +smalllest);
        return largest;
    }

    public static void main(String[] args) {
    int arr[]={1,2,6,5,8,3};
    System.out.println("get lagest number" +getLagest(arr));
    }

    public static class TrappingRainwater {

        public static void main(String[] args) {
            int numbers[] ={4,2,0,6,3,2,5};
            System.out.println(trappingRainwater(numbers));
        }
        public static int trappingRainwater(int height[]){
            int n= height.length;
            //calculate leftMax boundary -array
            int leftMax[]= new int[n];
            leftMax[0] = height[0];
            for(int i=1;i<n;i++){
                leftMax[i] =Math.max(height[i], leftMax[i-1]);
            }
            //calculate leftMax boundary -array
            int rightMax[] =new int[n];
            rightMax[n-1]=height[n-1];
            for(int i=n-2; i>=0; i--){
                rightMax[i]=Math.max(height[i], rightMax[i + 1]);
            }
            int trappedWater =0;
            //loop
                for(int i=0; i< n;i++){
                    //waterLevel = min(leftMax boundary, rightMax boundary);
                    //trapped Water =waterLevel -height[i]
                    int waterLevel =Math.min(leftMax[i], rightMax[i]);
                    trappedWater +=waterLevel -height[i];
                }
                return trappedWater;
        }
    }

    public static class MinDiffKScores {

        public static int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums); // Sort the array
            int minDiff = Integer.MAX_VALUE;

            for (int i = 0; i <= nums.length - k; i++) {
                int diff = nums[i + k - 1] - nums[i];
                minDiff = Math.min(minDiff, diff);
            }

            return minDiff;
        }
        public static int minimumDifference1(int[] nums, int k) {
            int n = nums.length;
            if (k == 1) return 0;

            int minDiff = Integer.MAX_VALUE;

            // Generate all possible combinations of k elements
            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(nums, 0, k, new ArrayList<>(), combinations);

            for (List<Integer> comb : combinations) {
                int max = Collections.max(comb);
                int min = Collections.min(comb);
                minDiff = Math.min(minDiff, max - min);
            }

            return minDiff;
        }

        private static void generateCombinations(int[] nums, int start, int k, List<Integer> temp, List<List<Integer>> res) {
            if (temp.size() == k) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                generateCombinations(nums, i + 1, k, temp, res);
                temp.remove(temp.size() - 1);
            }
        }

        public static void main(String[] args) {
            int[] nums = {9,4,1,7};
            int k = 2;
            System.out.println(minimumDifference(nums, k));  // Output: 2
        }
    }
}
