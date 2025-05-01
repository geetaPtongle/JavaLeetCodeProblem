package sorting;

public class InsertSort {
    public static void main(String[] args) {
        InsertSort obj = new InsertSort();
        int[] nums = {5,4,1,2,3};
        obj.inserSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private void inserSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr=nums[i];
            int prev =i -1;

            while (prev >=0 && nums[prev] > curr) {
                nums[prev+1]=nums[prev];
                prev--;
            }
            nums[prev+1]=curr;
        }
    }
}
