package recursion;

public class CalculatSum {
    public static void main(String[] args) {
            CalculatSum obj = new CalculatSum();
            int n=5;
            System.out.println(obj.calculateSum(n));
    }

    private int calculateSum(int n) {
        if(n==1) {
            return 1;
        }
       int  sum1 =calculateSum(n-1);
       int sum =n + sum1;
       System.out.println(sum);
       return sum;
    }
}
