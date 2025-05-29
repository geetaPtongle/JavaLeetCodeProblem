package javacourse.exception;

/*
Calling methods that throw exceptions: If your method
calls another method that throws an exception, your
method must either handle the exception (with a try-catch block) or
declare that it throws the exception (or one of its superclasses).
 */

import java.io.IOException;

public class Rule6 {

    public static void myMethod() throws IOException {
        //riskyMethod();  // riskyMethod() throws IOException
    }

    public static void main(String[] args) {
        try {
            myMethod();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

}
