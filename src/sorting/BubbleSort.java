package sorting;

public class BubbleSort {


    public static void main(String[] args) {
        int array[]={1,3,2,5,4};
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {
        int n= array.length;
        for(int i=0; i< n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(array[j] > array[j+1]){
                    int temp=array[j];
                    array[j] =array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(array);
    }
}
