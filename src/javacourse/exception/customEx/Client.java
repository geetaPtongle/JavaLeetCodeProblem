package javacourse.exception.customEx;

public class Client {
    public static void main(String[] args) throws BookNotFoundException {
        Library library = new Library();
        /*try {
            library.getBook("A","B");
        } catch (BookNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }*/

        library.getBook("A","B");
    }
}
