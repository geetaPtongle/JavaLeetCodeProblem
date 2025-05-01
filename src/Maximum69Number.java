public class Maximum69Number {
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray();
        System.out.println(digits[digits.length-1]);
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // Only change the first 6
            }
        }

        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        Maximum69Number m = new Maximum69Number();
        System.out.println(m.maximum69Number(9669));
    }
}
