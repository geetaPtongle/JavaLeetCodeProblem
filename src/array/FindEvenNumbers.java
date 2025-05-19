package array;

import java.util.*;

public class FindEvenNumbers {
    public int[] findEvenNumbers1(int[] digits) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (num >= 100 && num % 2 == 0) {
                            resultSet.add(num);
                        }
                    }
                }
            }
        }
        int[] result = resultSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--;

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0)
                    continue;
                freq[j]--;

                for (int k = 0; k <= 8; k += 2) { // Only even digits
                    if (freq[k] == 0)
                        continue;
                    freq[k]--;

                    int num = i * 100 + j * 10 + k;
                    result.add(num);

                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }

        Collections.sort(result);
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {
        FindEvenNumbers fe = new FindEvenNumbers();
        int[] nums = {2,2,8,8,2};
        System.out.println(Arrays.toString(fe.findEvenNumbers(nums)));
    }
}
