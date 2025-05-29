package javacourse.exception;

import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            // Code that uses the reader
        } catch (IOException e) {
            // Exception handling
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Exception handling for close() method
                }
            }
        }

        try (FileReader reader1 = new FileReader("file.txt")) {
            // Code that uses the resource
        } catch (IOException e) {
            // Exception handling
        }
        // The resource is automatically closed here


    }
}
