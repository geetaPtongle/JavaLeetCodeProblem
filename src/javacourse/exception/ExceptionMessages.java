package javacourse.exception;

public class ExceptionMessages {
    public static void main(String[] args) {
        try {
            int[] numbers = new int[2];
            // This statement will cause an ArrayIndexOutOfBoundsException
            System.out.println(numbers[3]);
        } catch (Exception e) {
            System.out.println("Using toString:");
            System.out.println(e.toString());

            System.out.println("\nUsing getMessage:");
            System.out.println(e.getMessage());

            System.out.println("\nUsing printStackTrace:");
            e.printStackTrace();
        }
    }

}