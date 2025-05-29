package math;

public class DifferenceOfSums {
    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0)
                num1 += i;
            if (i % m == 0)
                num2 += i;
        }
        return num1 - num2;
    }

    public static void main(String[] args) {
        DifferenceOfSums diff = new DifferenceOfSums();
        System.out.println(diff.differenceOfSums(5, 6));
    }
}
