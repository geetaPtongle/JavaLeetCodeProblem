package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int arr [] = {5,4,1,2,3};
        obj.selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private void selectionSort(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) {
            int minPos=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos=j;
                }
            }
            int temp = arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
}
