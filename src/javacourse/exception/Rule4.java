package javacourse.exception;

import java.io.IOException;

public class Rule4 {
    /*
    A throws clause does not mean an exception will
    actually be thrown. It simply states that the method
    has the potential to throw the specified exception.
    Whether the exception is actually thrown depends on
    the method's implementation.
     */

    public void writeToFile(String text, String filename) throws IOException {
        // No actual exception thrown here
    }

}
