package javacourse;

import java.util.Arrays;

public class forloop {
    public static void main(String[] args) {

//        int j;
//        for ( j = 0; j < 5; )
//        {
//            System.out.print( j + " " );
//            j++ ;
//        }

//        for (int i = 0; i <= 10; i = i+2) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int []A = {1,2,4,5,5,6,7};

        for (int i = 0; i <A.length; i++) {
            A[i] = A[i]+1;
          System.out.println(A[i]);
        }
        System.out.println(Arrays.toString(A));


        for(int x: A){
            x=x+1;
            System.out.println(x);
        }
        System.out.println(Arrays.toString(A)   );
    }
}
