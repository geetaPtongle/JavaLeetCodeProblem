package hashtable;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort fs = new FrequencySort();
        int[] sorted = fs.frequencySort1(new int[]{2,3,1,3,2});
        System.out.println(Arrays.toString(sorted));
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort numbers by frequency using a list
        List<Integer> sortedList = new ArrayList<>(frequencyMap.keySet());
        sortedList.sort((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // increasing frequency
            } else {
                return b - a; // decreasing value
            }
        });

        // Step 3: Build result array
        List<Integer> resultList = new ArrayList<>();
        for (int num : sortedList) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                resultList.add(num);
            }
        }

        // Step 4: Convert list to array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public int[] frequencySort1(int[] nums) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert entrySet to array
        Map.Entry<Integer, Integer>[] entryArray = frequencyMap.entrySet().toArray(new Map.Entry[0]);

        // Step 3: Sort the array by frequency in descending order
        Arrays.sort(entryArray, (a, b) -> b.getValue() - a.getValue());

        // Step 4: Build result array
        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entryArray) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result[index++] = num;
            }
        }

        return result;
    }

}
