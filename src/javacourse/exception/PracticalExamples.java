package javacourse.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PracticalExamples {
    public static void main(String[] args) {
        // Reading and Writing Files
        try (FileReader reader = new FileReader("input.txt")) {
            // Reading the file
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }

        //b. Connecting to a Database

        try (Connection conn = DriverManager.getConnection("DB_URL", "USER", "PASS")) {
            // Working with the database
        } catch (SQLException e) {
            System.out.println("A database error occurred: " + e.getMessage());
        }

        // c. Parsing User Input or Configuration Files
        String input = "123abc";
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer");
        }


        // Networking

        try {
            Socket socket = new Socket("www.example.com", 80);
            // Working with the socket
        } catch (UnknownHostException e) {
            System.out.println("Host not found");
        } catch (IOException e) {
            System.out.println("An I/O error occurred");
        }

        // Working with Dates

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2023-06-03");
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }

        // Multithreading

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted");
        }

    }


}
