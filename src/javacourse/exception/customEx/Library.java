package javacourse.exception.customEx;

public class Library {
    public Book getBook(String isbn, String title)
            throws BookNotFoundException {
        Book book = findBookInCatalog(isbn, title);
        if (book == null) {
            throw new BookNotFoundException("Book with isbn: "+ isbn + " and title: "
            + "not found");
        }
        return book;
    }

    private Book findBookInCatalog(String isbn, String title) {
        // Search logic for the book
        return null;
    }
}
