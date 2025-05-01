package sorting;

import java.util.Arrays;

public class TransformArrayByParity {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};  // Sample input array
        transformByParity(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void transformByParity(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (arr[left] % 2 == 0) {
                left++;
            } else if (arr[right] % 2 != 0) {
                right--;
            } else {
                // Swap even and odd elements
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
