package javacourse;

import java.util.Arrays;
import java.util.Scanner;

public class InitializeArrays {
    public static void main(String[] args) {
//          Initializing using assignment using subscript or index
        int[] a1 = new int[5];
        a1[0] = 10;

//          Initializing in one statement during creation
        int[] a2 = new int[]{1, 2, 3, 4, 5};

//          Initializing using Arrays.fill
        Arrays.fill(a2, 5);
        for (int j : a2) {
            System.out.println(j);
        }

//          Initializing using for loop
        int[] a3 = new int[10];
        for (int i = 0; i < a3.length; i++) {
            a3[i] = i + 1;
        }


//          Initializing by taking user input
        int[] a4 = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 5 integers.");
        for (int i = 0; i < a4.length; i++) {
            a4[i] = scanner.nextInt();
        }

        for (int j : a4) {
            System.out.println(j);
        }

    }
}
