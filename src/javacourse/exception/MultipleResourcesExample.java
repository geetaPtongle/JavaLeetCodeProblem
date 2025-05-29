package javacourse.exception;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultipleResourcesExample {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("input.txt");
                FileWriter writer = new FileWriter("output.txt")
        ) {
            // reader = new FileReader("x.txt");
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
            e.printStackTrace();
        }
    }
}

