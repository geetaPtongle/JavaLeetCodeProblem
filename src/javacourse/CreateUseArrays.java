package javacourse;

public class CreateUseArrays {
    public static void main(String[] args) {
        /*
        DECLARE ARRAYS
        data-type array-name[];
        data-type[] array-name;
         */
        int a[];
        int[] b;

        /*
        MEMORY ALLOCATION
        array-name = new data-type[size];
         */
        a = new int[5];

        /*
        INITIALIZE ARRAY
        array-name[index] = value;
         */
        a[0] = 10;
        a[1] = 20;
        a[2] = 50;
        a[3] = 40;
        a[4] = 80;

        for (int i = 0; i < a.length; i++) {
            System.out.println("Value of a[" + i + "]: " + a[i]);
        }

        System.out.println(a.length);

        // COMBINE DECLARATION AND MEMORY
        int c[] = new int[5];

        // COMBINE ALL 3
        int d[] = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        int e[] = {10, 20, 30, 50, 60};

    }
}
