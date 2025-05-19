package daynamic_programin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneratePermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};;
        List<int[]> res = new ArrayList<>();
        GeneratePermutation gp = new GeneratePermutation();
        gp.generatePermutation(res, arr, 0);
        Collections.sort(res, Arrays::compare);
        for (int i = 0; i < res.size(); i++) {

            // Found a match
            if (Arrays.equals(res.get(i), arr)) {

                // Store the next in arr
                if (i < res.size() - 1) {
                    int[] nextPerm = res.get(i + 1);
                    for(int j = 0; j < arr.length; j++)
                        arr[j] = nextPerm[j];
                }

                // If the given permutation is the last
                if (i == res.size() - 1) {
                    int[] nextPerm = res.get(0);
                    for(int j = 0; j < arr.length; j++)
                        arr[j] = nextPerm[j];
                }

                break;
            }
        }
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public void generatePermutation(List<int[]> res, int[] arr, int index  ) {
        if(index == arr.length) {
            res.add(arr.clone());
            return;
        }
        for(int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            generatePermutation(res, arr, index+1);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
