package javacourse.exception;

import java.io.FileWriter;
import java.io.IOException;

/*
Methods are not required to declare unchecked
exceptions.
 */
public class Rule3 {
    public void writeToFile(String text) {
        throw new NullPointerException(); // No need to declare in throws clause
    }

    public void writeToFile(String text, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(text);
        fileWriter.close();
    }

}
