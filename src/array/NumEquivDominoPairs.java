package array;

import java.util.HashMap;

public class NumEquivDominoPairs {

    public int numEquivDominoPairs1(int[][] dominoes) {
        int count =0;

        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                // Check if domino i and domino j are equivalent
                int[] d1 = dominoes[i];
                int[] d2 = dominoes[j];

                if ((d1[0] == d2[0] && d1[1] == d2[1]) || (d1[0] == d2[1] && d1[1] == d2[0])) {
                    count++;
                }
            }
        }

        return count;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            // Sort the domino to handle [a, b] and [b, a] equivalence
            int a = domino[0];
            int b = domino[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            // Create a key for the sorted domino
            String key = a + "," + b;

            // If the key already exists, we can form pairs with the previous occurrences
            if (map.containsKey(key)) {
                count += map.get(key);
            }

            // Increment the count of this domino
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        NumEquivDominoPairs n = new NumEquivDominoPairs();
        System.out.println(n.numEquivDominoPairs(dominoes));
    }
}
