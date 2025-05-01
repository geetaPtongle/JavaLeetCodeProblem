package array;

import java.util.ArrayList;
import java.util.Arrays;

class maximizeSumWithK {
    public static int maximizeSum(int[] nums, int k) {
        int n =nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int sum =0;
        while(--k >= 0){
            sum += max;
            max++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        maximizeSum(nums, 3);
    }

    public static class MinimumOperationsToMakeArrayIncreasing {
        public int minOperations(int[] nums) {
            int operations = 0;

            for (int i = 1; i < nums.length; i++) {
                // If the current number is not greater than the previous one
                if (nums[i] <= nums[i - 1]) {
                    // Calculate how much we need to increase it
                    int increase = nums[i - 1] - nums[i] + 1;
                    operations += increase;
                    nums[i] = nums[i - 1] + 1; // Apply the increase
                }
            }

            return operations;
        }

        public static void main(String[] args) {
            MinimumOperationsToMakeArrayIncreasing solution = new MinimumOperationsToMakeArrayIncreasing();
            int[] nums = {1,5,2,4,1};
            System.out.println("Minimum operations: " + solution.minOperations(nums)); // Output: 3
        }
    }

    static class MinimumPairRemoval {
        public static int minimumPairRemoval(int[] nums) {
            ArrayList<Integer> newNums = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                newNums.add(nums[i]);
            }
            int countOps = 0;

            while(!isSorted(newNums)) {
                int minSum = newNums.get(0) + newNums.get(1);
                int idx1 = 0;
                for(int i=2 ; i<newNums.size(); i++) {
                    if(newNums.get(i-1)+newNums.get(i) < minSum) {
                        minSum = newNums.get(i-1) + newNums.get(i);
                        idx1 = i-1;
                    }
                }
                newNums.remove(idx1);
                newNums.remove(idx1);
                newNums.add(idx1, minSum);
                countOps++;
            }

            return countOps;
        }

        public static boolean isSorted(ArrayList<Integer> nums) {
            for(int i=1; i<nums.size(); i++) {
                if(nums.get(i-1) > nums.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public void printArr(ArrayList<Integer> nums) {
            for(int i=0; i<nums.size(); i++) {
                System.out.print(nums.get(i));
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] numbers = {5, 2, 3, 1};
           System.out.println(minimumPairRemoval(numbers));
        }
    }
}