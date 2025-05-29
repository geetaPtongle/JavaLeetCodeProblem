package javacourse.exception;

import java.io.FileWriter;
import java.io.IOException;

/*
If a method doesn't handle a checked exception,
it must declare it in the throws clause.
 */

class ThrowsExample {
    public static void writeToFile(String text, String filename)
            throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(text);
        fileWriter.close();
    }

    public static void checkForFile(String text, String fileName)
            throws IOException {
        writeToFile(text, fileName);
    }

    public static void main(String[] args) {
        try {
            checkForFile("Hello, World!", "output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

}

