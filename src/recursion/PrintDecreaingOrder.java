package recursion;

public class PrintDecreaingOrder {
    public static void main(String[] args) {
        PrintDecreaingOrder obj = new PrintDecreaingOrder();
        int n=5;
//        pringDecreasingOrder(n);
        pringIncreasing(n);
    }

    public static void pringDecreasingOrder(int n) {
        if(n==1) {
            System.out.print(n);
            return;
        };
        System.out.print(n +" ");
         pringDecreasingOrder(n-1);
    }

    public static void pringIncreasing(int n) {
        if(n==1) {
            System.out.print(n + " ");
            return;
        };
        pringIncreasing(n-1);
        System.out.print(n + " ");
    }
}
