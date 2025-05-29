package javacourse.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThrowsExampleIntro {
    public static void main(String[] args) throws IOException {
        String filename = "abc.txt";
        String text = "Hey there, what's up?";
//        FileWriter fileWriter = new FileWriter(filename);
//        fileWriter.write(text);
//        fileWriter.close();

        writeToFile(text, filename);
    }

    public static void writeToFile(String text, String filename)
            throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(text);
        fileWriter.close();
    }
}
    /*
    SYNTAX:
    public returnType methodName(parameters)
            throws ExceptionType1, ExceptionType2, ...
    {
        // Method code
    }
    */


class CSVReader {
    public List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        return data;
    }
}
