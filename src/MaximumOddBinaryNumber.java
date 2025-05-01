public class MaximumOddBinaryNumber {

    public static String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        StringBuilder sb = new StringBuilder();

        // Place all 1's except the last one (for making it odd)
        for (int i = 0; i < ones - 1; i++) {
            sb.append('1');
        }

        // Place all 0's
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        // Place last '1' to make number odd
        sb.append('1');

        return sb.toString();
    }

    public static void main(String[] args) {
       System.out.println(maximumOddBinaryNumber("0101"));
    }

}
