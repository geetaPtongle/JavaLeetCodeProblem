package javacourse;

import java.util.Arrays;
import java.util.Scanner;

//
public class Variables {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str= sc.nextLine();
        System.out.println("You entered : " + str);

        int[] a = {1,2,3};
        for(int x: a) {
            x=x*2;
//            System.out.print(x);
        }
        int n1= 100;
        int n2, n3;
        n2 = ++n1;
        n3 =n1++ + --n2;

//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);
        for(int i=0; i<a.length; ++i) {
//            System.out.println(i);
            a[i]=a[i] +1;
//            System.out.println(a[i]);
        }
//        System.out.println(Arrays.toString(a));
    }
}
