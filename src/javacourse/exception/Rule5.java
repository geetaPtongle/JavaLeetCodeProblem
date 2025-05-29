package javacourse.exception;

import java.io.FileWriter;
import java.io.IOException;

/*
Inherited exceptions: If a method might throw a type of
exception, it's also acceptable for it to declare that
it throws one of the exception's superclasses.
 */
public class Rule5 {
    public void writeToFile(String text, String filename) throws Exception {
        // Some code that might throw an IOException
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(text);
        fileWriter.close();
    }

}
