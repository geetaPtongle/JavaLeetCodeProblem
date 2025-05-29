package javacourse.exception.customEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class LibraryDatabase {
    public Book findBookInDatabase(String isbn, String title)
            throws LibraryDataAccessException {
        try {
            // Code to access database and find book.
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "username";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new LibraryDataAccessException("Error accessing database " +
                    "for ISBN: " + isbn ,e);
        }
        return null;
    }
}

