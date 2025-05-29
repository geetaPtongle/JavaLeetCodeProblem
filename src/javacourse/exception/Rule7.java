package javacourse.exception;

import java.io.IOException;
import java.text.ParseException;

/*
If a method is declared with multiple exceptions, the caller can catch
these exceptions separately.
 */

public class Rule7 {
    public static void processFile(String filename)
            throws IOException, ParseException {
        // Some code that might throw an IOException or a ParseException
    }

    public static void main(String[] args) {
        try {
            processFile("data.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("An error occurred while parsing the file.");
            e.printStackTrace();
        }
    }

}
