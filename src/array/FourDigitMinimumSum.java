package array;

import java.util.Arrays;

public class FourDigitMinimumSum {
    public static int minimumSum(int num) {
        // Convert the number to a char array and sort it
        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);

        // Initialize two numbers to form
        int num1 = 0, num2 = 0;

        // Distribute digits in alternating manner
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (digits[i] - '0');
                System.out.println(digits[i] -'0');
                System.out.println(num1);
            } else {
                num2 = num2 * 10 + (digits[i] - '0');
                System.out.println(digits[i] -'0');
                System.out.println(num2);
            }
        }

        // Return the sum of the two numbers
        return num1 + num2;
    }

    public static void main(String[] args) {
       System.out.println(minimumSum(2932));
    }
}
