import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public boolean isBookAvailable(Book book) {
        return books.contains(book);
    }
}

public class SimpleLibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Test Case 1: Add a book to the library and confirm its availability
        Book mobyDick = new Book("Moby Dick");
        library.addBook(mobyDick);
        if (library.isBookAvailable(mobyDick)) {
            System.out.println("Test Case 1: 'Moby Dick' is available.");
        } else {
            System.out.println("Test Case 1: 'Moby Dick' is currently not available, check back next week.");
        }

        // Test Case 2: Remove the book from the library and confirm its availability
        library.removeBook(mobyDick);
        if (!library.isBookAvailable(mobyDick)) {
            System.out.println("Test Case 2: 'Moby Dick' is currently not available, check back next week.");
        } else {
            System.out.println("Test Case 2: 'Moby Dick' is  available.");
        }
    }
}
