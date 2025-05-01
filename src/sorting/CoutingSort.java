package sorting;

import java.util.List;

public class CoutingSort {
    public static void main(String[] args) {
        CoutingSort coutingSort = new CoutingSort();
        int[] arr={1,3,2,8,3,6,9,5,6,103};
        int[] sorted = coutingSort.countSorting(arr);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
    public static int[] countSorting(int[] nums) {
        int length = nums.length;
        int largest = 0;
        for (int i = 1; i < length; i++) {
            largest=Math.max(largest, nums[i]);
        }
        int[] counts = new int[largest +1];
    for(int i=0;i< length;i++){
        counts[nums[i]]++;
    }
    int j =0;
    for(int i=0;i < counts.length;i++){
        while(counts[i] > 0){
            nums[j]= i;
            j++;
            counts[i]--;
        }
    }
    return nums;
    }
}
